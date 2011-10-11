/**
 * 
 */
package org.eclipse.mylyn.docs.epub.tests.api;

import java.io.File;
import java.util.List;
import java.util.Locale;

import org.eclipse.emf.common.util.EList;
import org.eclipse.mylyn.docs.epub.core.EPUB;
import org.eclipse.mylyn.docs.epub.core.OPS2Publication;
import org.eclipse.mylyn.docs.epub.core.OPSPublication;
import org.eclipse.mylyn.docs.epub.dc.Coverage;
import org.eclipse.mylyn.docs.epub.dc.Date;
import org.eclipse.mylyn.docs.epub.dc.Description;
import org.eclipse.mylyn.docs.epub.dc.Identifier;
import org.eclipse.mylyn.docs.epub.dc.Publisher;
import org.eclipse.mylyn.docs.epub.dc.Relation;
import org.eclipse.mylyn.docs.epub.dc.Rights;
import org.eclipse.mylyn.docs.epub.dc.Source;
import org.eclipse.mylyn.docs.epub.dc.Subject;
import org.eclipse.mylyn.docs.epub.dc.Title;
import org.eclipse.mylyn.docs.epub.dc.impl.DCTypeImpl;
import org.eclipse.mylyn.docs.epub.opf.Item;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.adobe.epubcheck.api.EpubCheck;

/**
 * @author Torkild U. Resheim
 * 
 */
public class TestOPSPublication extends AbstractTest {

	OPSPublication oebps;

	/**
	 * @throws java.lang.Exception
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		oebps = new OPS2Publication();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Override
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		oebps = null;
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#addContributor(java.lang.String, java.util.Locale, java.lang.String, org.eclipse.mylyn.docs.epub.opf.Role, java.lang.String)}
	 * .
	 */
	@Test
	public final void testAddContributor() {
		// TODO
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#addCoverage(java.lang.String, java.util.Locale, java.lang.String)}
	 * .
	 */
	@Test
	public final void testAddCoverage() {
		oebps.addCoverage("Coverage", Locale.CANADA_FRENCH, "My Coverage");
		oebps.addCoverage(null, Locale.CANADA_FRENCH, "My Coverage");
		oebps.addCoverage(null, null, "My Coverage");
		EList<Coverage> Coverages = oebps.getOpfPackage().getMetadata().getCoverages();
		Assert.assertEquals("Coverage", Coverages.get(0).getId());
		Assert.assertEquals("fr_CA", Coverages.get(0).getLang());
		Assert.assertEquals("My Coverage", getText((DCTypeImpl) Coverages.get(0)));
		Assert.assertEquals(null, Coverages.get(1).getId());
		Assert.assertEquals("fr_CA", Coverages.get(1).getLang());
		Assert.assertEquals("My Coverage", getText((DCTypeImpl) Coverages.get(1)));
		Assert.assertEquals(null, Coverages.get(2).getId());
		Assert.assertEquals(null, Coverages.get(2).getLang());
		Assert.assertEquals("My Coverage", getText((DCTypeImpl) Coverages.get(2)));
		try {
			oebps.addCoverage(null, null, null);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#addCreator(java.lang.String, java.util.Locale, java.lang.String, org.eclipse.mylyn.docs.epub.opf.Role, java.lang.String)}
	 * .
	 */
	@Test
	public final void testAddCreator() {
		// TODO
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#addDate(java.lang.String, java.util.Date, java.lang.String)}
	 * .
	 */
	@Test
	public final void testAddDateStringDateString() {
		// TODO
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#addDate(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void testAddDateStringStringString() {
		oebps.addDate(null, "1969", null);
		oebps.addDate(null, "1969-03", null);
		oebps.addDate(null, "1969-03-14", null);
		oebps.addDate(null, "1969-03-14", "event");
		EList<Date> dates = oebps.getOpfPackage().getMetadata().getDates();
		assertEquals("1969", getText((DCTypeImpl) dates.get(0)));
		assertEquals("1969-03", getText((DCTypeImpl) dates.get(1)));
		assertEquals("1969-03-14", getText((DCTypeImpl) dates.get(2)));
		assertEquals("event", dates.get(3).getEvent());
		try {
			oebps.addDate(null, (String) null, null);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#addDescription(java.lang.String, java.util.Locale, java.lang.String)}
	 * .
	 */
	@Test
	public final void testAddDescription() {
		oebps.addDescription("Description", Locale.CANADA_FRENCH, "My Description");
		oebps.addDescription(null, Locale.CANADA_FRENCH, "My Description");
		oebps.addDescription(null, null, "My Description");
		EList<Description> Descriptions = oebps.getOpfPackage().getMetadata().getDescriptions();
		Assert.assertEquals("Description", Descriptions.get(0).getId());
		Assert.assertEquals("fr_CA", Descriptions.get(0).getLang());
		Assert.assertEquals("My Description", getText((DCTypeImpl) Descriptions.get(0)));
		Assert.assertEquals(null, Descriptions.get(1).getId());
		Assert.assertEquals("fr_CA", Descriptions.get(1).getLang());
		Assert.assertEquals("My Description", getText((DCTypeImpl) Descriptions.get(1)));
		Assert.assertEquals(null, Descriptions.get(2).getId());
		Assert.assertEquals(null, Descriptions.get(2).getLang());
		Assert.assertEquals("My Description", getText((DCTypeImpl) Descriptions.get(2)));
		try {
			oebps.addDescription(null, null, null);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#addFormat(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void testAddFormat() {
		oebps.addDescription("Description", Locale.CANADA_FRENCH, "My Description");
		oebps.addDescription(null, Locale.CANADA_FRENCH, "My Description");
		oebps.addDescription(null, null, "My Description");
		EList<Description> Descriptions = oebps.getOpfPackage().getMetadata().getDescriptions();
		Assert.assertEquals("Description", Descriptions.get(0).getId());
		Assert.assertEquals("fr_CA", Descriptions.get(0).getLang());
		Assert.assertEquals("My Description", getText((DCTypeImpl) Descriptions.get(0)));
		Assert.assertEquals(null, Descriptions.get(1).getId());
		Assert.assertEquals("fr_CA", Descriptions.get(1).getLang());
		Assert.assertEquals("My Description", getText((DCTypeImpl) Descriptions.get(1)));
		Assert.assertEquals(null, Descriptions.get(2).getId());
		Assert.assertEquals(null, Descriptions.get(2).getLang());
		Assert.assertEquals("My Description", getText((DCTypeImpl) Descriptions.get(2)));
		try {
			oebps.addDescription(null, null, null);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#addIdentifier(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void testAddIdentifier() {
		oebps.addIdentifier("Identifier", "ID", "My Identifier");
		oebps.addIdentifier(null, "ID", "My Identifier");
		oebps.addIdentifier(null, null, "My Identifier");
		EList<Identifier> Identifiers = oebps.getOpfPackage().getMetadata().getIdentifiers();
		Assert.assertEquals("Identifier", Identifiers.get(0).getId());
		Assert.assertEquals("ID", Identifiers.get(0).getScheme());
		Assert.assertEquals("My Identifier", getText(Identifiers.get(0)));
		Assert.assertEquals(null, Identifiers.get(1).getId());
		Assert.assertEquals("ID", Identifiers.get(1).getScheme());
		Assert.assertEquals("My Identifier", getText(Identifiers.get(1)));
		Assert.assertEquals(null, Identifiers.get(2).getId());
		Assert.assertEquals(null, Identifiers.get(2).getScheme());
		Assert.assertEquals("My Identifier", getText(Identifiers.get(2)));
		try {
			oebps.addIdentifier(null, null, null);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#addItem(java.io.File)}
	 * .
	 */
	@Test
	public final void testAddItemFile() {
		// TODO
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#addItem(java.lang.String, java.util.Locale, java.io.File, java.lang.String, java.lang.String, boolean, boolean, boolean)}
	 * .
	 */
	@Test
	public final void testAddItemStringLocaleFileStringStringBooleanBooleanBoolean() {
		// TODO
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#addLanguage(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void testAddLanguage() {
		oebps.addLanguage(null, "no");
		oebps.addLanguage("id", "no");
		Assert.assertEquals("no", getText((DCTypeImpl) oebps.getOpfPackage().getMetadata().getLanguages().get(0)));
		Assert.assertEquals("id", oebps.getOpfPackage().getMetadata().getLanguages().get(1).getId());
		try {
			oebps.addLanguage(null, null);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#addMeta(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void testAddMeta() {
		oebps.addMeta("name", "value");
		assertEquals("name", oebps.getOpfPackage().getMetadata().getMetas().get(0).getName());
		assertEquals("value", oebps.getOpfPackage().getMetadata().getMetas().get(0).getContent());
		try {
			oebps.addMeta(null, "value");
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			oebps.addMeta("name", null);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#addPublisher(java.lang.String, java.util.Locale, java.lang.String)}
	 * .
	 */
	@Test
	public final void testAddPublisher() {
		oebps.addPublisher("Publisher", Locale.CANADA_FRENCH, "My Publisher");
		oebps.addPublisher(null, Locale.CANADA_FRENCH, "My Publisher");
		oebps.addPublisher(null, null, "My Publisher");
		EList<Publisher> Publishers = oebps.getOpfPackage().getMetadata().getPublishers();
		Assert.assertEquals("Publisher", Publishers.get(0).getId());
		Assert.assertEquals("fr_CA", Publishers.get(0).getLang());
		Assert.assertEquals("My Publisher", getText((DCTypeImpl) Publishers.get(0)));
		Assert.assertEquals(null, Publishers.get(1).getId());
		Assert.assertEquals("fr_CA", Publishers.get(1).getLang());
		Assert.assertEquals("My Publisher", getText((DCTypeImpl) Publishers.get(1)));
		Assert.assertEquals(null, Publishers.get(2).getId());
		Assert.assertEquals(null, Publishers.get(2).getLang());
		Assert.assertEquals("My Publisher", getText((DCTypeImpl) Publishers.get(2)));
		try {
			oebps.addPublisher(null, null, null);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#addReference(java.lang.String, java.lang.String, org.eclipse.mylyn.docs.epub.opf.Type)}
	 * .
	 */
	@Test
	public final void testAddReference() {
		// TODO
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#addRelation(java.lang.String, java.util.Locale, java.lang.String)}
	 * .
	 */
	@Test
	public final void testAddRelation() {
		oebps.addRelation("Relation", Locale.CANADA_FRENCH, "My Relation");
		oebps.addRelation(null, Locale.CANADA_FRENCH, "My Relation");
		oebps.addRelation(null, null, "My Relation");
		EList<Relation> Relations = oebps.getOpfPackage().getMetadata().getRelations();
		Assert.assertEquals("Relation", Relations.get(0).getId());
		Assert.assertEquals("fr_CA", Relations.get(0).getLang());
		Assert.assertEquals("My Relation", getText((DCTypeImpl) Relations.get(0)));
		Assert.assertEquals(null, Relations.get(1).getId());
		Assert.assertEquals("fr_CA", Relations.get(1).getLang());
		Assert.assertEquals("My Relation", getText((DCTypeImpl) Relations.get(1)));
		Assert.assertEquals(null, Relations.get(2).getId());
		Assert.assertEquals(null, Relations.get(2).getLang());
		Assert.assertEquals("My Relation", getText((DCTypeImpl) Relations.get(2)));
		try {
			oebps.addRelation(null, null, null);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#addRights(java.lang.String, java.util.Locale, java.lang.String)}
	 * .
	 */
	@Test
	public final void testAddRights() {
		oebps.addRights("Rights", Locale.CANADA_FRENCH, "My Rights");
		oebps.addRights(null, Locale.CANADA_FRENCH, "My Rights");
		oebps.addRights(null, null, "My Rights");
		EList<Rights> Rightss = oebps.getOpfPackage().getMetadata().getRights();
		Assert.assertEquals("Rights", Rightss.get(0).getId());
		Assert.assertEquals("fr_CA", Rightss.get(0).getLang());
		Assert.assertEquals("My Rights", getText((DCTypeImpl) Rightss.get(0)));
		Assert.assertEquals(null, Rightss.get(1).getId());
		Assert.assertEquals("fr_CA", Rightss.get(1).getLang());
		Assert.assertEquals("My Rights", getText((DCTypeImpl) Rightss.get(1)));
		Assert.assertEquals(null, Rightss.get(2).getId());
		Assert.assertEquals(null, Rightss.get(2).getLang());
		Assert.assertEquals("My Rights", getText((DCTypeImpl) Rightss.get(2)));
		try {
			oebps.addRights(null, null, null);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#addSource(java.lang.String, java.util.Locale, java.lang.String)}
	 * .
	 */
	@Test
	public final void testAddSource() {
		oebps.addSource("Source", Locale.CANADA_FRENCH, "My Source");
		oebps.addSource(null, Locale.CANADA_FRENCH, "My Source");
		oebps.addSource(null, null, "My Source");
		EList<Source> Sources = oebps.getOpfPackage().getMetadata().getSources();
		Assert.assertEquals("Source", Sources.get(0).getId());
		Assert.assertEquals("fr_CA", Sources.get(0).getLang());
		Assert.assertEquals("My Source", getText((DCTypeImpl) Sources.get(0)));
		Assert.assertEquals(null, Sources.get(1).getId());
		Assert.assertEquals("fr_CA", Sources.get(1).getLang());
		Assert.assertEquals("My Source", getText((DCTypeImpl) Sources.get(1)));
		Assert.assertEquals(null, Sources.get(2).getId());
		Assert.assertEquals(null, Sources.get(2).getLang());
		Assert.assertEquals("My Source", getText((DCTypeImpl) Sources.get(2)));
		try {
			oebps.addSource(null, null, null);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#addSubject(java.lang.String, java.util.Locale, java.lang.String)}
	 * .
	 */
	@Test
	public final void testAddSubject() {
		oebps.addSubject("Subject", Locale.CANADA_FRENCH, "My Subject");
		oebps.addSubject(null, Locale.CANADA_FRENCH, "My Subject");
		oebps.addSubject(null, null, "My Subject");
		EList<Subject> subjects = oebps.getOpfPackage().getMetadata().getSubjects();
		Assert.assertEquals("Subject", subjects.get(0).getId());
		Assert.assertEquals("fr_CA", subjects.get(0).getLang());
		Assert.assertEquals("My Subject", getText((DCTypeImpl) subjects.get(0)));
		Assert.assertEquals(null, subjects.get(1).getId());
		Assert.assertEquals("fr_CA", subjects.get(1).getLang());
		Assert.assertEquals("My Subject", getText((DCTypeImpl) subjects.get(1)));
		Assert.assertEquals(null, subjects.get(2).getId());
		Assert.assertEquals(null, subjects.get(2).getLang());
		Assert.assertEquals("My Subject", getText((DCTypeImpl) subjects.get(2)));
		try {
			oebps.addSubject(null, null, null);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#addTitle(java.lang.String, java.util.Locale, java.lang.String)}
	 * .
	 */
	@Test
	public final void testAddTitle() {
		oebps.addTitle("Title", Locale.CANADA_FRENCH, "My Title");
		oebps.addTitle(null, Locale.CANADA_FRENCH, "My Title");
		oebps.addTitle(null, null, "My Title");
		EList<Title> titles = oebps.getOpfPackage().getMetadata().getTitles();
		Assert.assertEquals("Title", titles.get(0).getId());
		Assert.assertEquals("fr_CA", titles.get(0).getLang());
		Assert.assertEquals("My Title", getText((DCTypeImpl) titles.get(0)));
		Assert.assertEquals(null, titles.get(1).getId());
		Assert.assertEquals("fr_CA", titles.get(1).getLang());
		Assert.assertEquals("My Title", getText((DCTypeImpl) titles.get(1)));
		Assert.assertEquals(null, titles.get(2).getId());
		Assert.assertEquals(null, titles.get(2).getLang());
		Assert.assertEquals("My Title", getText((DCTypeImpl) titles.get(2)));
		try {
			oebps.addTitle(null, null, null);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#addType(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void testAddType() {
		oebps.addType("Type", "My Type");
		oebps.addType(null, "My Type");
		EList<org.eclipse.mylyn.docs.epub.dc.Type> Types = oebps.getOpfPackage().getMetadata().getTypes();
		Assert.assertEquals("Type", Types.get(0).getId());
		Assert.assertEquals("My Type", getText((DCTypeImpl) Types.get(0)));
		Assert.assertEquals(null, Types.get(1).getId());
		Assert.assertEquals("My Type", getText((DCTypeImpl) Types.get(1)));
		try {
			oebps.addType(null, null);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#generateTableOfContents()}
	 * .
	 */
	@Test
	public final void testGenerateTableOfContents() {
		// TODO
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#getIdentifier()}.
	 */
	@Test
	public final void testGetIdentifier() {
		// TODO
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#getItemById(java.lang.String)}
	 * .
	 */
	@Test
	public final void testGetItemById() {
		// TODO
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#getItemsByMIMEType(java.lang.String)}
	 * .
	 */
	@Test
	public final void testGetItemsByMIMEType() {
		Item i_in_1 = oebps.addItem(new File("testdata/drawing-100x100.svg"));
		Item i_in_2 = oebps.addItem(new File("testdata/plain-page.xhtml"));
		List<Item> i_out_1 = oebps.getItemsByMIMEType("image/svg+xml");
		assertEquals(1, i_out_1.size());
		assertEquals(i_in_1, i_out_1.get(0));
		List<Item> i_out_2 = oebps.getItemsByMIMEType("application/xhtml+xml");
		assertEquals(1, i_out_2.size());
		assertEquals(i_in_2, i_out_2.get(0));
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#getOpfPackage()}.
	 */
	@Test
	public final void testGetOpfPackage() {
		// TODO
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#getRootFolder()}.
	 */
	@Test
	public final void testGetRootFolder() {
		// TODO
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#getSpine()}.
	 */
	@Test
	public final void testGetSpine() {
		// TODO
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#getTableOfContents()}
	 * .
	 */
	@Test
	public final void testGetTableOfContents() {
		// TODO
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#getValidationMessages()}
	 * .
	 */
	@Test
	public final void testGetValidationMessages() {
		// TODO
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#pack(java.io.File)}
	 * .
	 * <ul>
	 * <li>An EPUB where only a single page has been added shall be packed
	 * without issues</li>
	 * <li>An EPUB with no content shall fail when packed</li>
	 * </ul>
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testPack() throws Exception {
		EPUB epub = new EPUB();
		oebps.addItem(new File("testdata/plain-page.xhtml"));
		epub.add(oebps);
		epub.pack(epubFile);
		oebps.validateMetadata();
		EpubCheck checker = new EpubCheck(epubFile);
		Assert.assertTrue(checker.validate());

		EPUB epub2 = new EPUB();
		epub2.add(new OPS2Publication());
		try {
			epubFile.delete();
			epub2.pack(epubFile);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#readTableOfContents(java.io.File)}
	 * .
	 */
	@Test
	public final void testReadTableOfContents() {
		// TODO
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#setCover(java.io.File, java.lang.String)}
	 * .
	 * <ul>
	 * <li>Cover page SVG shall exist in the unpacked folder</li>
	 * <li>Cover page HTML shall exist in the unpacked folder</li>
	 * </ul>
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testSetCover() throws Exception {
		oebps.setCover(new File("testdata" + File.separator + "drawing-100x100.svg"), "Title");
		oebps.addItem(new File("testdata/plain-page.xhtml"));
		EPUB epub = new EPUB();
		epub.add(oebps);
		epub.pack(epubFile);

		EPUB epub2 = new EPUB();
		epub2.unpack(epubFile, epubFolder);
		oebps = epub2.getOPSPublications().get(0);
		File root = oebps.getRootFolder();
		File svg = new File(root.getAbsolutePath() + File.separator + "drawing-100x100.svg");
		Assert.assertTrue(svg.exists());
		File html = new File(root.getAbsolutePath() + File.separator + "cover-page.xhtml");
		Assert.assertTrue(html.exists());
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#setGenerateToc(boolean)}
	 * .
	 */
	@Test
	public final void testSetGenerateToc() {
		// TODO
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#setIdentifierId(java.lang.String)}
	 * .
	 */
	@Test
	public final void testSetIdentifierId() {
		// TODO
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#setIncludeReferencedResources(boolean)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test
	public final void testSetIncludeReferencedResources() throws Exception {
		EPUB epub = new EPUB();
		oebps.setIncludeReferencedResources(true);
		oebps.addItem(new File("testdata/plain-page_link.xhtml"));
		epub.add(oebps);
		// Included resources will only be added when we pack
		epub.pack(epubFile);

		EPUB epub2 = new EPUB();
		epub2.unpack(epubFile, epubFolder);
		oebps = epub2.getOPSPublications().get(0);
		File root = oebps.getRootFolder();
		File svg = new File(root.getAbsolutePath() + File.separator + "drawing-100x100.svg");
		Assert.assertTrue(svg.exists());
		File html = new File(root.getAbsolutePath() + File.separator + "plain-page_no-header.xhtml");
		Assert.assertTrue(html.exists());

	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#setTableOfContents(java.io.File)}
	 * .
	 * 
	 * @see TestOPS2Publication#testSetTableOfContents()
	 */
	@Test
	public final void testSetTableOfContents() {
		// Handled by subclass test.
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#unpack(java.io.File)}
	 * .
	 */
	@Test
	public final void testUnpack() {
		// TODO
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#validateContents()}
	 * .
	 */
	@Test
	public final void testValidateContents() {
		// TODO
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#validateMetadata()}
	 * .
	 */
	@Test
	public final void testValidateMetadata() {
		// TODO
	}

	/**
	 * Test method for
	 * {@link org.eclipse.mylyn.docs.epub.core.OPSPublication#writeTableOfContents(java.io.File)}
	 * .
	 */
	@Test
	public final void testWriteTableOfContents() {
		// TODO
	}

}
