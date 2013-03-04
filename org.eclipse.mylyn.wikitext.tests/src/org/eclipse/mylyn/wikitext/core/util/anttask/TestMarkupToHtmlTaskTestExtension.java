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

package org.eclipse.mylyn.wikitext.core.util.anttask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.mylyn.wikitext.core.parser.builder.BuilderExtensionUtil;
import org.eclipse.mylyn.wikitext.core.parser.builder.HtmlDocumentBuilderExtension;
import org.eclipse.mylyn.wikitext.core.util.XmlStreamWriter;

/**
 * Used to test that the document builder extension is able to copy files to destination location and reference these
 * correctly in the HTML <b>head</b> element.
 * 
 * @author Torkild U. Resheim
 */
public class TestMarkupToHtmlTaskTestExtension extends HtmlDocumentBuilderExtension {

	/** location of files to copy */
	private File source;

	public TestMarkupToHtmlTaskTestExtension() {
		super();
		setName("TestMarkupToHtmlTaskTestExtension");
	}

	@Override
	public void preBuild(File destination) {
		this.destination = destination;
		URL url = MarkupToHtmlTaskExtensionTest.class.getResource("resources/builder-extension");
		try {
			// Handle when test is executed from IDE and from Maven build.
			// The latter will execute the test from the built JAR. If so
			// we must extract must place the builder extension JavaScript
			// in a temporary folder or we won't be able to read it.
			if (url.getProtocol().equals("file")) {
				source = new File(url.toURI());
			} else {
				// The the file stream
				InputStream is = MarkupToHtmlTaskExtensionTest.class.getResourceAsStream("resources/builder-extension/extension.js");
				// Make a  space for the temporary file
				source = new File(destination, "resources" + File.separator + "builder-extension");
				source.mkdirs();
				// Copy the resource file
				FileOutputStream fos = new FileOutputStream(new File(source, "extension.js"));
				byte[] buffer = new byte[4096];
				int bytesRead;
				while ((bytesRead = is.read(buffer)) != -1) {
					fos.write(buffer, 0, bytesRead);
				}
				fos.close();
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void appendToDocumentHead(XmlStreamWriter writer) {
		writer.writeStartElement("script");
		writer.writeAttribute("type", "text/javascript");
		try {
			if (destination == null) {
				writer.writeAttribute("src", new File(destination, "extension.js").toURI().toURL().toExternalForm());
			} else {
				writer.writeAttribute("src", destination.toURI().toURL().toExternalForm()
						+ "builder-extension/extension.js");
			}
		} catch (MalformedURLException e) {
		}
		writer.writeEndElement();
	}

	@Override
	public void postBuild() {
		try {
			File dest = new File(destination, source.getName());
			BuilderExtensionUtil.copy(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}