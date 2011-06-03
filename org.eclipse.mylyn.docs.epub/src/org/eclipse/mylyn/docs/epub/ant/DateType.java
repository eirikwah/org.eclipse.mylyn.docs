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
package org.eclipse.mylyn.docs.epub.ant;

/**
 * @ant.type name="date" category="epub"
 */
public class DateType {

	String date;
	String event;
	String id;

	/**
	 * @ant.required
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @ant.not-required
	 */
	public void setEvent(String event) {
		this.event = event;
	}

	/**
	 * @ant.not-required
	 */
	public void setId(String id) {
		this.id = id;
	}

}
