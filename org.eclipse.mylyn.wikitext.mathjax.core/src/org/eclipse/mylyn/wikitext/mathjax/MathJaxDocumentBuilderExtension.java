/*******************************************************************************
 * Copyright (c) 2013 Torkild U. Resheim.
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *     Torkild U. Resheim - initial API and implementation
 *******************************************************************************/
package org.eclipse.mylyn.wikitext.mathjax;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.mylyn.wikitext.core.parser.builder.BuilderExtensionUtil;
import org.eclipse.mylyn.wikitext.core.parser.builder.HtmlDocumentBuilderExtension;
import org.eclipse.mylyn.wikitext.core.util.XmlStreamWriter;
import org.osgi.framework.Bundle;

/**
 * A document builder extension that adds MathJax support to the generated HTML
 * documents.
 * 
 * @author Torkild U. Resheim
 */
public class MathJaxDocumentBuilderExtension extends HtmlDocumentBuilderExtension {

	public enum Configuration {
		/**
		 * For sites that only use AsciiMath format for their mathematics. It
		 * will use MathML output in browsers where that is supported well, and
		 * HTML-CSS output otherwise.
		 */
		AM_HTMLorMML("AM_HTMLorMML"),
		/**
		 * For sites that only use MathML format for their mathematics. It will
		 * use MathML output in browsers where that is supported well, and
		 * HTML-CSS output otherwise.
		 */
		MML_HTMLorMML("MML_HTMLorMML"),
		/**
		 * For sites that only use TeX format for their mathematics, and that
		 * want the output to be as close to TeX output as possible. This uses
		 * the HTML-CSS output jax (even when the user’s browser understands
		 * MathML).
		 */
		TeX_AMS_HTML("TeX-AMS_HTML"),
		/**
		 * Loads all the main MathJax components, including the TeX and MathML
		 * preprocessors and input processors, the AMSmath, AMSsymbols,
		 * noErrors, and noUndefined TeX extensions, both the native MathML and
		 * HTML-with-CSS output processor definitions, and the MathMenu and
		 * MathZoom extensions.
		 */
		TeX_AMS_MML_HTMLorMML("TeX-AMS-MML_HTMLorMML"),
		/**
		 * As
		 * TeX-AMS-MML_HTMLorMML except that the SVG output renderer is used
		 * rather than the NativeMML or HTML-CSS ones. It loads all the main
		 * MathJax components, including the TeX and MathML preprocessors and
		 * input processors, the AMSmath, AMSsymbols, noErrors, and noUndefined
		 * TeX extensions, the SVG output processor definitions, and the
		 * MathMenu and MathZoom extensions.
		 */
		TeX_AMS_MML_SVG("TeX-AMS-MML_SVG"),
		/**
		 * Loads all the main MathJax components, including the TeX, MathML, and
		 * AsciiMath preprocessors and input processors, the AMSmath,
		 * AMSsymbols, noErrors, and noUndefined TeX extensions, both the native
		 * MathML and HTML-with-CSS output processor definitions, and the
		 * MathMenu and MathZoom extensions.
		 */
		TeX_MML_AM_HTMLorMML("TeX-MML-AM_HTMLorMML");

		private final String name;

		private Configuration(String s) {
			name = s;
		}

		public boolean equalsName(String otherName) {
			return (otherName == null) ? false : name.equals(otherName);
		}

		public String toString() {
			return name;
		}
	}

	/**
	 * Output configuration to use
	 * http://docs.mathjax.org/en/latest/config-files.html
	 */
	private final Configuration configuration;

	/** Root folder of this bundle */
	private File source;

	public MathJaxDocumentBuilderExtension() {
		super();
		try {
			Bundle bundle = Platform.getBundle("org.eclipse.mylyn.wikitext.mathjax.core");
			// We cannot obtain the bundle of this plug-in we're probably not
			// running under Eclipse.
			if (bundle == null) {
				URL url = MathJaxDocumentBuilderExtension.class.getResource("../../../../../");
				try {
					source = new File(url.toURI()).getAbsoluteFile();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			} else {
				source = new File(FileLocator.toFileURL(bundle.getEntry("/")).toExternalForm());								
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		setName("MathJax");
		// The default configuration is to enable everything
		configuration = Configuration.TeX_MML_AM_HTMLorMML;
	}

	@Override
	public void appendToDocumentHead(XmlStreamWriter writer) {
		writer.writeStartElement("script");
		writer.writeAttribute("type", "text/x-mathjax-config");
		writer.writeCharacters("MathJax.Hub.Config({tex2jax: {inlineMath: [[\"$\",\"$\"],[\"\\\\(\",\"\\\\)\"]]}});");
		writer.writeEndElement();
		writer.writeStartElement("script");
		writer.writeAttribute("type", "text/javascript");

		try {
			if (destination == null) {
				// Path to MathJax must be using the plug-in
				Bundle bundle = Platform.getBundle("org.eclipse.mylyn.wikitext.mathjax.core");
				URL fileURL = FileLocator.toFileURL(bundle.getEntry("/mathjax/MathJax.js"));
				writer.writeAttribute("src", fileURL.toURI().toString() + "?config=" + configuration.name);
			} else {
				// Must be relative path
				writer.writeAttribute("src", "mathjax/MathJax.js?config=" + configuration.name);
			}
		} catch (MalformedURLException e) {
			writer.writeComment("Exception:" + e.getMessage());
		} catch (IOException e) {
			writer.writeComment("Exception:" + e.getMessage());
		} catch (URISyntaxException e) {
			writer.writeComment("Exception:" + e.getMessage());
		}
		writer.writeEndElement();
	}
	
	@Override
	public void postBuild() {
		// Copy MathJax files to the destination location
		// But only if there is a destination URL. Typically this value will be
		// null if the document builder is used in the WikiText editor preview.
		if (destination != null) {
			try {
				File sourceFolder = new File(source, "mathjax");
				BuilderExtensionUtil.copy(sourceFolder, new File(destination, sourceFolder.getName()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
