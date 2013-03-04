/*******************************************************************************
 * Copyright (c) 2013 Torkild U. Resheim and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Torkild U. Resheim - initial API and implementation
 *******************************************************************************/

package org.eclipse.mylyn.wikitext.core.parser.builder;

import org.eclipse.mylyn.wikitext.core.util.XmlStreamWriter;

/**
 * Defines methods that the {@link HtmlDocumentBuilder} will call to add content to generated HTML documents.
 * 
 * @since 1.9
 * @author Torkild U. Resheim
 */
public abstract class HtmlDocumentBuilderExtension extends DocumentBuilderExtension {

	public HtmlDocumentBuilderExtension() {
		super();
		setBuilder(HtmlDocumentBuilder.class.getName());
	}

	/**
	 * Implement to add content to the HTML document's <b>body</b> element.
	 * 
	 * @param writer
	 *            the document builder's writer
	 */
	public void appendToDocumentBody(XmlStreamWriter writer) {
		// Does nothing by default
	}

	/**
	 * Implement to add content to the HTML document's <b>head</b> element.
	 * 
	 * @param writer
	 *            the document builder's writer
	 */
	public void appendToDocumentHead(XmlStreamWriter writer) {
		// Does nothing by default
	}

	/**
	 * Implement to prepend content to the HTML document's <b>body</b> element.
	 * 
	 * @param writer
	 *            the document builder's writer
	 */
	public void prependToDocumentBody(XmlStreamWriter writer) {
		// Does nothing by default
	}

}
