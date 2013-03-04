/*******************************************************************************
 * Copyright (c) 2007, 2013 David Green and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     David Green - initial API and implementation
 *     Torkild U. Resheim - Added support for document builder extensions
 *******************************************************************************/
package org.eclipse.mylyn.internal.wikitext.core.util;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.mylyn.internal.wikitext.core.WikiTextPlugin;
import org.eclipse.mylyn.wikitext.core.parser.DocumentBuilder;
import org.eclipse.mylyn.wikitext.core.parser.builder.DocumentBuilderExtension;
import org.eclipse.mylyn.wikitext.core.parser.markup.MarkupLanguage;
import org.eclipse.mylyn.wikitext.core.util.ServiceLocator;

/**
 * A service locator that uses the {@link WikiTextPlugin} to resolve markup languages and document builder extensions.
 * 
 * @author David Green
 * @author Torkild U. Resheim
 */
public class EclipseServiceLocator extends ServiceLocator {

	public EclipseServiceLocator(ClassLoader classLoader) {
		super(classLoader);
	}

	@Override
	public MarkupLanguage getMarkupLanguage(String languageName) throws IllegalArgumentException {
		if (languageName == null) {
			throw new IllegalArgumentException();
		}
		MarkupLanguage markupLanguage = WikiTextPlugin.getDefault().getMarkupLanguage(languageName);
		if (markupLanguage == null) {
			try {
				// dispatch to super in case we've been given a fully qualified class name
				markupLanguage = super.getMarkupLanguage(languageName);
			} catch (IllegalArgumentException e) {
				// specified language not found.
				// create a useful error message
				StringBuilder buf = new StringBuilder();
				for (String name : new TreeSet<String>(WikiTextPlugin.getDefault().getMarkupLanguageNames())) {
					if (buf.length() != 0) {
						buf.append(", "); //$NON-NLS-1$
					}
					buf.append('\'');
					buf.append(name);
					buf.append('\'');
				}
				throw new IllegalArgumentException(MessageFormat.format(Messages.getString("EclipseServiceLocator.1"), //$NON-NLS-1$
						languageName, buf.length() == 0 ? Messages.getString("EclipseServiceLocator.2") //$NON-NLS-1$
								: MessageFormat.format(Messages.getString("EclipseServiceLocator.3"), buf))); //$NON-NLS-1$
			}
		}
		return markupLanguage;
	}

	@Override
	public DocumentBuilderExtension getDocumentBuilderExtension(String name) throws IllegalArgumentException {
		if (name == null) {
			throw new IllegalArgumentException();
		}
		DocumentBuilderExtension extension = WikiTextPlugin.getDefault().getDocumentBuilderExtension(name);
		if (extension == null) {
			try {
				// dispatch to super in case we've been given a fully qualified class name
				extension = super.getDocumentBuilderExtension(name);
			} catch (IllegalArgumentException e) {
				// specified language not found.
				// create a useful error message
				StringBuilder buf = new StringBuilder();
				for (String n : new TreeSet<String>(WikiTextPlugin.getDefault().getDocumentBuilderExtensionNames())) {
					if (buf.length() != 0) {
						buf.append(", "); //$NON-NLS-1$
					}
					buf.append('\'');
					buf.append(n);
					buf.append('\'');
				}
				throw new IllegalArgumentException(MessageFormat.format(Messages.getString("EclipseServiceLocator.4"), //$NON-NLS-1$
						name, buf.length() == 0 ? Messages.getString("EclipseServiceLocator.5") //$NON-NLS-1$
								: MessageFormat.format(Messages.getString("EclipseServiceLocator.6"), buf))); //$NON-NLS-1$
			}
		}
		return extension;
	}

	@Override
	public Set<MarkupLanguage> getAllMarkupLanguages() {
		Set<MarkupLanguage> markupLanguages = new HashSet<MarkupLanguage>();

		for (String languageName : WikiTextPlugin.getDefault().getMarkupLanguageNames()) {
			MarkupLanguage markupLanguage = getMarkupLanguage(languageName);
			if (markupLanguage != null) {
				markupLanguages.add(markupLanguage);
			}
		}

		return markupLanguages;
	}

	@Override
	public Set<DocumentBuilderExtension> getAllDocumentBuilderExtensions() {
		Set<DocumentBuilderExtension> extensions = new HashSet<DocumentBuilderExtension>();

		for (String extensionName : WikiTextPlugin.getDefault().getDocumentBuilderExtensionNames()) {
			DocumentBuilderExtension extension = getDocumentBuilderExtension(extensionName);
			if (extension != null) {
				extensions.add(extension);
			}
		}
		return extensions;
	}

	@Override
	public Set<DocumentBuilderExtension> getDocumentBuilderExtensions(final DocumentBuilder documentBuilder) {
		final Set<DocumentBuilderExtension> extensions = new HashSet<DocumentBuilderExtension>();
		Set<String> documentBuilderExtensionNames = WikiTextPlugin.getDefault().getDocumentBuilderExtensionNames();
		for (String extensionName : documentBuilderExtensionNames) {
			DocumentBuilderExtension extension = WikiTextPlugin.getDefault().getDocumentBuilderExtension(extensionName);
			try {
				String builder = extension.getBuilder();
				Class<?> clazz = Class.forName(builder, true, classLoader);
				Class<? extends DocumentBuilder> clazz2 = documentBuilder.getClass();
				if (clazz.isAssignableFrom(clazz2)) {
					extensions.add(extension);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return extensions;
	}
}
