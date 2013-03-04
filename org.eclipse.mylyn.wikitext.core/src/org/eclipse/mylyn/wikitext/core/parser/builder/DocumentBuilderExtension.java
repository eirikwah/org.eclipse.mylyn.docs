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

import java.io.File;

import org.eclipse.mylyn.wikitext.core.parser.DocumentBuilder;

/**
 * Use to add features to a document builder. Typically instances of this type will generate headers, footers, cover
 * pages and such for the various document builders.
 * 
 * @author Torkild U. Resheim
 * @since 1.9
 */
public abstract class DocumentBuilderExtension {

	private String builder = null;

	private String name = null;

	protected File destination = null;

	public DocumentBuilderExtension() {
		name = null;
	}

	/**
	 * Returns the fully qualified name (FQN) of the {@link DocumentBuilder} this type extends.
	 * 
	 * @return FQN of the extended builder
	 */
	public final String getBuilder() {
		return builder;
	}

	/**
	 * Returns the name of the document builder extension.
	 * 
	 * @return the document builder name.
	 */
	public final String getName() {
		return name;
	}

	/**
	 * Implement to handle any processing that must be done <i>after</i> the document has been built.
	 */
	public void postBuild() {
		// nothing is done per default
	}

	/**
	 * Implement to handle any processing that must be done <i>before</i> the document has been built. This also sets
	 * the destination folder of the document builder. This is used when the builder is producing files in addition to
	 * the actual content.
	 * 
	 * @param destination
	 *            the destination folder or <code>null</code>
	 */
	public void preBuild(File destination) {
		this.destination = destination;
		// nothing is done per default
	}

	/**
	 * Sets the fully qualified name (FQN) of the {@link DocumentBuilder} this type extends.
	 * 
	 * @param builder
	 *            FQN of the extended builder
	 */
	public final void setBuilder(String builder) {
		this.builder = builder;
	}

	/**
	 * Sets the name of the builder extension. This must be unique as it can be used to reference and obtain an
	 * instance.
	 * 
	 * @param name
	 *            the unique extension name
	 */
	public final void setName(String name) {
		this.name = name;
	}
}
