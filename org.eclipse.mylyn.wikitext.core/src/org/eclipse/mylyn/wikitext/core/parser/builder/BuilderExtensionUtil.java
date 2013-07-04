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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Utilities for {@link DocumentBuilderExtension}.
 * 
 * @author Torkild U. Resheim
 * @since 1.9
 */
public class BuilderExtensionUtil {

	/**
	 * Recursively copies the source file or folder to the destination.
	 * 
	 * @param src
	 *            source file or folder
	 * @param dest
	 *            destination
	 * @throws IOException
	 */
	public static void copy(File src, File dest) throws IOException {
		if (src.isDirectory()) {
			if (!dest.exists()) {
				dest.mkdirs();
			}
			String files[] = src.list();
			for (String file : files) {
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				copy(srcFile, destFile);
			}
		} else {
			FileInputStream from = null;
			FileOutputStream to = null;
			try {
				from = new FileInputStream(src);
				to = new FileOutputStream(dest);
				byte[] buffer = new byte[4096];
				int bytesRead;

				while ((bytesRead = from.read(buffer)) != -1) {
					to.write(buffer, 0, bytesRead);
				}
			} finally {
				if (from != null) {
					try {
						from.close();
					} catch (IOException e) {
					}
				}
				if (to != null) {
					try {
						to.close();
					} catch (IOException e) {
					}
				}
			}
		}
	}

}
