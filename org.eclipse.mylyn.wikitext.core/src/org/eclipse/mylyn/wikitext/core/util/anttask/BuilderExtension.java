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

import org.eclipse.mylyn.wikitext.core.parser.builder.DocumentBuilderExtension;

/**
 * Use to add sub-types of {@link DocumentBuilderExtension} to the document builder.
 * 
 * @author Torkild U. Resheim
 * @since 1.9
 */
public class BuilderExtension {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
