/*******************************************************************************
 * Copyright (c) 2011 Torkild U. Resheim.
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Torkild U. Resheim - initial API and implementation
 *******************************************************************************/
package org.eclipse.mylyn.docs.epub.tests;

import java.io.File;

import junit.framework.Assert;

import org.apache.tools.ant.BuildFileTest;

import com.adobe.epubcheck.api.EpubCheck;

/**
 * Tests for the <b>epub</b> ANT task.
 * 
 * @author Torkild U. Resheim
 */
public class TestAntTask extends BuildFileTest {

	static ClassLoader classLoader;

	private static final String SIMPLE_FILE_PATH = "test/ant/simple.epub";

	private static final String DOC_FILE_PATH = "../org.eclipse.mylyn.docs.epub.ui/Building_EPUBs.epub";

	public TestAntTask(String s) {
		super(s);
		classLoader = getClass().getClassLoader();
	}

	private void assertEpub(String file) {
		EpubCheck checker = new EpubCheck(getFile(file));
		Assert.assertTrue(checker.validate());
	}

	private File getFile(String file) {
		return new File(getProjectDir().getAbsolutePath() + File.separator + file);
	}

	@Override
	public void setUp() {
		configureProject("ant-test.xml");
		project.setCoreLoader(this.getClass().getClassLoader());
	}

	/**
	 * Creates a simple book using the Ant task and tests it using the epub
	 * validator.
	 */
	public void testSimplePublication() {
		executeTarget("init");
		executeTarget("test.publication");
		assertEpub(SIMPLE_FILE_PATH);
	}

	/**
	 * Tests the "Building EPUBs" book (generated using the Ant task) using the
	 * epub validator. This book is assembled by building the
	 * "org.eclipse.mylyn.docs.epub.ui" bundle. The book contents is converted
	 * from Textile markup to HTML using WikiText.
	 */
	public void testDocumentationBook() {
		assertEpub(DOC_FILE_PATH);
	}
}
