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

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;

import junit.framework.Assert;

import org.eclipse.emf.common.util.EList;
import org.eclipse.mylyn.docs.epub.core.internal.TOCGenerator;
import org.eclipse.mylyn.docs.epub.ncx.NCXFactory;
import org.eclipse.mylyn.docs.epub.ncx.NavMap;
import org.eclipse.mylyn.docs.epub.ncx.NavPoint;
import org.eclipse.mylyn.docs.epub.ncx.Ncx;
import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Tests for the table of contents generator.
 * 
 * @author Torkild U. Resheim
 */
public class TestTOCGenerator {

	@Test
	public void testNormal() throws ParserConfigurationException, SAXException,
			IOException {
		String html = "<body>" +
				"<h1 id='h1-1'>test</h1>" +
				"<h2 id='h2-1'>test</h2>" +
				"<h2 id='h2-2'>test</h2>" +
				"<h3 id='h3-1'>test</h3>" +
				"<h1 id='h1-2'>test</h1>" +
				"</body>";
		Ncx ncx = createNcx();
		TOCGenerator.parse(new InputSource(new StringReader(html)), "test.html",
				ncx,0);
		EList<NavPoint> points = ncx.getNavMap().getNavPoints();
		Assert.assertEquals(2,points.size());
		Assert.assertEquals(2, points.get(0).getNavPoints().size());
		Assert.assertEquals(1, points.get(0).getNavPoints().get(1).getNavPoints().size());
	}
	
	@Test
	public void testMissingIdentifier() throws ParserConfigurationException, SAXException, IOException{
		String html = "<body>" +
				"<h1 id='h1-1'>test</h1>" +
				"<h2>test</h2>" +
				"<h1 id='h1-2'>test</h1>" +
				"</body>";
		Ncx ncx = createNcx();
		TOCGenerator.parse(new InputSource(new StringReader(html)), "test.html",
				ncx,0);
		EList<NavPoint> points = ncx.getNavMap().getNavPoints();
		Assert.assertEquals(2,points.size());
		Assert.assertEquals(0, points.get(0).getNavPoints().size());
	}
	
	/**
	 * All items should be placed at the root.
	 *  
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	@Test
	public void testCrazyStructure() throws ParserConfigurationException, SAXException, IOException{
		String html = "<body>" +
				"<h3 id='h3-1'>test</h3>" +
				"<h2 id='h2-1'>test</h2>" +
				"<h1 id='h1-1'>test</h1>" +
				"</body>";
		Ncx ncx = createNcx();
		TOCGenerator.parse(new InputSource(new StringReader(html)), "test.html",
				ncx,0);
		EList<NavPoint> points = ncx.getNavMap().getNavPoints();
		for (NavPoint navPoint : points) {
			System.out.println(navPoint);
		}
		Assert.assertEquals(3,points.size());
	}
	
	@Test
	public void testMissingParent() throws ParserConfigurationException,
			SAXException, IOException {
		String html = "<body>" + 
			"<h1 id='h1-1'>test</h1>" + 
			"<h3 id='h3-1'>test</h3>" + 
			"<h1 id='h1-2'>test</h1>" + 
			"</body>";
		Ncx ncx = createNcx();
		TOCGenerator.parse(new InputSource(new StringReader(html)), "test.html",
				ncx,0);
		EList<NavPoint> points = ncx.getNavMap().getNavPoints();
		Assert.assertEquals(2,points.size());
		Assert.assertEquals(1, points.get(0).getNavPoints().size());
	}
	

	private Ncx createNcx() {
		Ncx ncx = NCXFactory.eINSTANCE.createNcx();
		NavMap navMap = NCXFactory.eINSTANCE.createNavMap();
		ncx.setNavMap(navMap);
		return ncx;
	}
}
