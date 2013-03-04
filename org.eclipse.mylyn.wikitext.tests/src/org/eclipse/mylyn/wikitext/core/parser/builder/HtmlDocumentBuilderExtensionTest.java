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
package org.eclipse.mylyn.wikitext.core.parser.builder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.mylyn.wikitext.core.parser.MarkupParser;
import org.eclipse.mylyn.wikitext.core.util.ServiceLocator;
import org.eclipse.mylyn.wikitext.textile.core.TextileLanguage;

/**
 * Tests a basic {@link HtmlDocumentBuilderExtension}.
 * 
 * @author Torkild U. Resheim
 */
public class HtmlDocumentBuilderExtensionTest extends TestCase {

	private MarkupParser parser;

	private StringWriter out;

	private HtmlDocumentBuilder builder;

	private final Map<File, URL> fileToUrl = new HashMap<File, URL>();

	@Override
	public void setUp() {

		parser = new MarkupParser();
		parser.setMarkupLanguage(new TextileLanguage());
		out = new StringWriter();
		builder = new HtmlDocumentBuilder(out) {
			@Override
			protected void checkFileReadable(File file) {
				if (!fileToUrl.containsKey(file)) {
					super.checkFileReadable(file);
				}
			}

			@Override
			protected Reader getReader(File inputFile) throws FileNotFoundException {
				URL url = fileToUrl.get(inputFile);
				if (url != null) {
					try {
						return new InputStreamReader(url.openStream());
					} catch (IOException e) {
						throw new FileNotFoundException(String.format("%s (%s)", inputFile, url));
					}
				}
				return super.getReader(inputFile);
			}
		};
		parser.setBuilder(builder);
		// Register the document builder extension so that the extra HTML code can be produced.
		ServiceLocator sl = ServiceLocator.getInstance(getClass().getClassLoader());
		DocumentBuilderExtension extension = sl.getDocumentBuilderExtension(TestHtmlDocumentBuilderExtension.class.getName());
		builder.activateExtension(extension);
	}

	/**
	 * Tests that content has been appended to the <b>head</b> of the HTML document.
	 */
	public void testAppendToDocumentHead() {
		parser.parse("content");
		String html = out.toString();
		assertTrue(html.contains("<!-- appended head --></head>"));
	}

	/**
	 * Tests that content has been appended to the <b>body</b> of the HTML document.
	 */
	public void testAppendToDocumentBody() {
		parser.parse("content");
		String html = out.toString();
		assertTrue(html.contains("<!-- appended body --></body>"));
	}

	/**
	 * Tests that content has been prepended to the <b>body</b> of the HTML document.
	 */
	public void testAppendPrependToDocumentBody() {
		parser.parse("content");
		String html = out.toString();
		assertTrue(html.contains("<body><!-- prepended body -->"));
	}

}
