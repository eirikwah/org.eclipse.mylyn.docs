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

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.Task;
import org.eclipse.mylyn.docs.epub.EPUB2;
import org.eclipse.mylyn.docs.epub.opf.Role;
import org.eclipse.mylyn.docs.epub.opf.Scheme;
import org.eclipse.mylyn.docs.epub.opf.Type;
import org.xml.sax.SAXException;

/**
 * Assemble a new EPUB.
 * 
 * @author Torkild U. Resheim
 * @ant.task name="html-to-epub" category="control"
 */
public class HtmlToEpubTask extends Task {

	EPUB2 epub = new EPUB2();
	Toc toc = null;

	private File workingFolder;

	public HtmlToEpubTask() {
	}

	public void addConfiguredContributor(Contributor item) {
		if (item.role == null) {
			epub.addContributor(item.id, item.lang, item.name, null,
					item.fileAs);
		} else {
			epub.addContributor(item.id, item.lang, item.name,
					Role.get(item.role), item.fileAs);
		}
	}

	public void addConfiguredCreator(Creator item) {
		if (item.role == null) {
			epub.addCreator(item.id, item.lang, item.name, null, item.fileAs);
		} else {
			epub.addCreator(item.id, item.lang, item.name, Role.get(item.role),
					item.fileAs);
		}
	}

	public void addConfiguredDate(Date item) {
		epub.addDate(item.id, item.date, item.event);
	}

	/**
	 * The FileSet sub-element is used to add EPUB artifacts that are not a part
	 * of the main text. This can be graphical items and styling (CSS).
	 * 
	 * @param set
	 */
	public void addConfiguredFileSet(FileSet fs) {
		DirectoryScanner ds = fs.getDirectoryScanner(getProject()); // 3
		String[] includedFiles = ds.getIncludedFiles();
		for (int i = 0; i < includedFiles.length; i++) {
			String filename = includedFiles[i].replace('\\', '/'); // 4
			filename = filename.substring(filename.lastIndexOf("/") + 1);
			File base = ds.getBasedir(); // 5
			File found = new File(base, includedFiles[i]);
			epub.addItem(null, fs.lang, found, fs.dest, null, false, false);
		}
	}

	/**
	 * @ant.required
	 */
	public void addConfiguredIdentifier(Identifier identifier) {
		epub.addIdentifier(identifier.id, Scheme.getByName(identifier.scheme),
				identifier.value);
	}

	/**
	 * @ant.required
	 */
	public void addConfiguredItem(Item item) {
		epub.addItem(item.id, item.lang, item.file, item.dest, item.type,
				item.spine, item.noToc);
	}

	/**
	 * @ant.required
	 */
	public void addConfiguredLanguage(Language language) {
		epub.addLanguage(language.id, language.code);
	}

	public void addConfiguredPublisher(Publisher publisher) {
		epub.addPublisher(publisher.id, publisher.lang, publisher.text);
	}

	public void addConfiguredReference(Reference reference) {
		epub.addReference(reference.href, reference.title,
				Type.get(reference.type));
	}

	public void addConfiguredSubject(Subject subject) {
		epub.addSubject(subject.id, subject.lang, subject.text);
	}

	/**
	 * @ant.required
	 */
	public void addConfiguredTitle(Title title) {
		epub.addTitle(title.id, title.lang, title.text);
	}

	public void addConfiguredToc(Toc toc) {
		if (this.toc != null) {
			throw new BuildException(
					"Only one table of contents (toc) declaration is allowed.");
		}
		this.toc = toc;
	}

	public void addConfiguredType(org.eclipse.mylyn.docs.epub.ant.Type type) {
		epub.addType(type.id, type.text);
	}

	public void addConfiguredFormat(Format format) {
		epub.addFormat(format.id, format.text);
	}

	public void addConfiguredSource(Source source) {
		epub.setSource(source.id, source.lang, source.text);
	}

	public void addConfiguredRights(Rights rights) {
		epub.setRights(rights.id, rights.lang, rights.text);
	}

	@Override
	public void execute() throws BuildException {
		validate();
		if (toc != null) {
			if (toc.generate) {
				epub.setGenerateToc(true);
			} else if (toc.file != null) {
				epub.setTocFile(toc.file);
			}
		}
		try {
			if (workingFolder == null) {
				epub.assemble();
			} else {
				epub.assemble(workingFolder);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 
	 * @param file
	 *            path to the generated EPUB file.
	 */
	public void setFile(String file) {
		epub.setFile(file);
	}

	public void setIdentifierId(String identifierId) {
		epub.setIdentifierId(identifierId);
	}

	public void setWorkingFolder(File workingFolder) {
		this.workingFolder = workingFolder;
	}

	private void validate() {
	}

}
