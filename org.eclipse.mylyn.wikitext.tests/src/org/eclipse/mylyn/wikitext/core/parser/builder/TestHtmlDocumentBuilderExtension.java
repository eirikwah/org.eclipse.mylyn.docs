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

import org.eclipse.mylyn.wikitext.core.util.XmlStreamWriter;

public class TestHtmlDocumentBuilderExtension extends HtmlDocumentBuilderExtension {

	public TestHtmlDocumentBuilderExtension() {
		super();
		setName("TestHtmlDocumentBuilderExtension");
	}

	@Override
	public void appendToDocumentHead(XmlStreamWriter writer) {
		writer.writeComment("appended head");
	}

	@Override
	public void appendToDocumentBody(XmlStreamWriter writer) {
		writer.writeComment("appended body");
	}

	@Override
	public void prependToDocumentBody(XmlStreamWriter writer) {
		writer.writeComment("prepended body");
	}

	@Override
	public void postBuild() {
		// ignore
	}

}
