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

package org.eclipse.mylyn.docs.epub.ui.commands;

import org.eclipse.osgi.util.NLS;

/**
 * @author Torkild U. Resheim
 */
class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.mylyn.docs.epub.ui.commands.messages"; //$NON-NLS-1$

	public static String AbstractMarkupResourceHandler_markupLanguageMappingFailed;

	public static String AbstractMarkupResourceHandler_unexpectedError;

	public static String ConvertMarkupToEPUB_cannotCompleteOperation;

	public static String ConvertMarkupToEPUB_cannotConvert;

	public static String ConvertMarkupToEPUB_detailsFollow;

	public static String ConvertMarkupToEPUB_fileExistsOverwrite;

	public static String ConvertMarkupToEPUB_overwrite;

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
