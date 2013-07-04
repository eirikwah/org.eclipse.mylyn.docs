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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author Torkild U. Resheim
 */
public class MarkupToHtmlTaskExtensionTest extends AbstractTestAntTask {

	protected MarkupToHtmlTask task;

	protected File createSimpleTextileMarkup() throws IOException {
		StringWriter out = new StringWriter();
		PrintWriter writer = new PrintWriter(out);
		try {
			writer.println("h1. First Heading");
			writer.println();
			writer.println("some content");
			writer.println();
			writer.println("h1. Second Heading");
			writer.println();
			writer.println("some more content");
		} finally {
			writer.close();
		}
		return createTextileMarkupFile(out.toString());
	}

	protected MarkupToHtmlTask createTask() {
		return new MarkupToHtmlTask();
	}

	protected File createTextileMarkupFile(String content) throws IOException {
		File markupFile = new File(tempFolder, "markup.textile");
		Writer writer = new FileWriter(markupFile);
		try {
			writer.write(content);
		} finally {
			writer.close();
		}
		return markupFile;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		task = createTask();
		task.setFormatOutput(true);
		task.setMarkupLanguage(languageName);
		BuilderExtension be = new BuilderExtension();
		be.setName(TestMarkupToHtmlTaskTestExtension.class.getName());
		task.addConfiguredBuilderExtension(be);
	}

	/**
	 * Tests whether or not the JavaScript file that is part of the extension has been copied to the destination folder
	 * and that the correct path is used when referencing this file.
	 * 
	 * @throws IOException
	 */
	public void testFileCopiedAndReferenced() throws IOException {
		File markup = createSimpleTextileMarkup();
		task.setFile(markup);
		task.execute();
		// The HTML file must be generated
		File htmlFile = new File(markup.getParentFile(), "markup.html");
		assertTrue(htmlFile.exists() && htmlFile.isFile());
		String content = getContent(htmlFile);
		// URL to copied javascript
		assertTrue(content.contains(tempFolder.toURI().toURL().toExternalForm() + "builder-extension/extension.js"));
		// Make sure that the extension javascript has been copied
		File js = new File(tempFolder, "builder-extension/extension.js");
		System.out.println(js.getAbsolutePath());
		assertTrue(js.exists());
	}
}
