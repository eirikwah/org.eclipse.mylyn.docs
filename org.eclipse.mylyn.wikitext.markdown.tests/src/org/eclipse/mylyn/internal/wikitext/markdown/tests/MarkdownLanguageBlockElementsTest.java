/*******************************************************************************
 * Copyright (c) 2012, 2013 Stefan Seelmann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Stefan Seelmann - initial API and implementation
 *******************************************************************************/

package org.eclipse.mylyn.internal.wikitext.markdown.tests;


/**
 * Tests for Markdown block elements. Follows specification at
 * <a>http://daringfireball.net/projects/markdown/syntax#block</a>.
 * 
 * @author Stefan Seelmann
 */
public class MarkdownLanguageBlockElementsTest extends MarkdownLanguageTestBase {

	/*
	 * Paragraphs and Line Breaks. A paragraph is simply one or more consecutive lines of text, separated by one or more
	 * blank lines. (A blank line is any line that looks like a blank line â€” a line containing nothing but spaces or
	 * tabs is considered blank.) Normal paragraphs should not be indented with spaces or tabs.
	 */
	public void testParagraphWithOneLine() {
		String markup = "a paragraph";
		String expectedHtml = "<p>a paragraph</p>\n";
		parseAndAssert(markup, expectedHtml);
	}

	public void testParagraphWithMulitpleLines() {
		String markup = "a paragraph\nwith multiple\nlines";
		String expectedHtml = "<p>a paragraph\nwith multiple\nlines</p>\n";
		parseAndAssert(markup, expectedHtml);
	}

	public void testParagraphsSeparatedBySingleBlankLine() {
		String markup = "a paragraph\n\nanother paragraph\n\n";
		String expectedHtml = "<p>a paragraph</p>\n<p>another paragraph</p>\n";
		parseAndAssert(markup, expectedHtml);
	}

	public void testParagraphsSeparatedByMulitpleBlankLines() {
		String markup = "a paragraph\n\n\nanother paragraph\n\n\n";
		String expectedHtml = "<p>a paragraph</p>\n<p>another paragraph</p>\n";
		parseAndAssert(markup, expectedHtml);
	}

	public void testParagraphsSeparatedByMulitpleBlankLinesWithSpacesAndTabs() {
		String markup = "a paragraph\n \n\t\nanother paragraph";
		String expectedHtml = "<p>a paragraph</p>\n<p>another paragraph</p>\n";
		parseAndAssert(markup, expectedHtml);
	}

	/*
	 * When you do want to insert a <br />
	 * break tag using Markdown, you end a line with two or more spaces, then type return.
	 */
	public void testLineBreakInParagraph() {
		String markup = "line  1  \nline  2    \nline  3";
		String expectedHtml = "<p>line  1<br/>\nline  2<br/>\nline  3</p>\n";
		parseAndAssert(markup, expectedHtml);
	}

	/*
	 * Headers. Atx-style headers use 1-6 hash characters at the start of the line, corresponding to header levels 1-6.
	 */
	public void testAtxStyleHeaderH1() {
		String markup = "# This is an H1";
		String expectedHtml = "<h1>This is an H1</h1>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testAtxStyleHeaderH2() {
		String markup = "## This is an H2";
		String expectedHtml = "<h2>This is an H2</h2>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testAtxStyleHeaderH3() {
		String markup = "### This is an H3";
		String expectedHtml = "<h3>This is an H3</h3>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testAtxStyleHeaderH4() {
		String markup = "#### This is an H4";
		String expectedHtml = "<h4>This is an H4</h4>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testAtxStyleHeaderH5() {
		String markup = "##### This is an H5";
		String expectedHtml = "<h5>This is an H5</h5>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testAtxStyleHeaderH6() {
		String markup = "###### This is an H6";
		String expectedHtml = "<h6>This is an H6</h6>";
		parseAndAssert(markup, expectedHtml);
	}

	/*
	 * Optionally, you may "close" atx-style headers. This is purely cosmetic - you can use this if you think it looks
	 * better. The closing hashes don't even need to match the number of hashes used to open the header. (The number of
	 * opening hashes determines the header level.)
	 */
	public void testClosedAtxStyleHeaderH1() {
		String markup = "# This is an H1 #";
		String expectedHtml = "<h1>This is an H1</h1>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testClosedAtxStyleHeaderH2() {
		String markup = "## This is an H2 ##";
		String expectedHtml = "<h2>This is an H2</h2>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testClosedAtxStyleHeaderH3() {
		String markup = "### This is an H3 ###";
		String expectedHtml = "<h3>This is an H3</h3>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testClosedAtxStyleHeaderH4() {
		String markup = "#### This is an H4 ####";
		String expectedHtml = "<h4>This is an H4</h4>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testClosedAtxStyleHeaderH5() {
		String markup = "##### This is an H5 #####";
		String expectedHtml = "<h5>This is an H5</h5>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testClosedAtxStyleHeaderH6() {
		String markup = "###### This is an H6 ######";
		String expectedHtml = "<h6>This is an H6</h6>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testClosedAtxStyleHeaderWithMoreClosingHashes() {
		String markup = "# This is an H1 ################################";
		String expectedHtml = "<h1>This is an H1</h1>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testClosedAtxStyleHeaderWithLessCosingHashes() {
		String markup = "###### This is an H6 #";
		String expectedHtml = "<h6>This is an H6</h6>";
		parseAndAssert(markup, expectedHtml);
	}

	/*
	 * Setext-style headers are "underlined" using equal signs (for first-level headers) and dashes (for second-level
	 * headers). Any number of underlining ='s or -'s will work.
	 */
	public void testUnderlinedHeaderH1() {
		String markup = "This is an H1\n============";
		String expectedHtml = "<h1>This is an H1</h1>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testUnderlinedHeaderH2() {
		String markup = "This is an H2\n------------";
		String expectedHtml = "<h2>This is an H2</h2>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testSingleCharUnderlinedHeaderH1() {
		String markup = "This is an H1\n= ";
		String expectedHtml = "<h1>This is an H1</h1>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testSingleCharUnderlinedHeaderH2() {
		String markup = "This is an H2\n- ";
		String expectedHtml = "<h2>This is an H2</h2>";
		parseAndAssert(markup, expectedHtml);
	}

	/*
	 * Blockquotes. Markdown uses email-style > characters for blockquoting. It looks best if you hard wrap the text and
	 * put a > before every line.
	 */
	public void testBlockquoteWithQuoteCharInEachLine() {
		String markup = "> Lorem ipsum dolor sit amet, \n> consetetur adipisici elit.\n";
		String expectedHtml = "<blockquote><p>Lorem ipsum dolor sit amet, \nconsetetur adipisici elit.</p>\n</blockquote>";
		parseAndAssert(markup, expectedHtml);
	}

	/*
	 * Markdown allows you to be lazy and only put the > before the first line of a hard-wrapped paragraph.
	 */
	public void testBlockquoteWithSingleQuoteChar() {
		String markup = "> Lorem ipsum dolor sit amet, \nconsetetur adipisici elit.\n";
		String expectedHtml = "<blockquote><p>Lorem ipsum dolor sit amet, \nconsetetur adipisici elit.</p>\n</blockquote>";
		parseAndAssert(markup, expectedHtml);
	}

	/*
	 * Blockquotes can be nested (i.e. a blockquote-in-a-blockquote) by adding additional levels of >.
	 */
	public void testNestedBlockquotesTwoLevels() {
		String markup = "> A1\n>\n> > B1\n> > B2\n>\n> A2\n";
		String expectedHtml = "<blockquote><p>A1</p>\n<blockquote><p>B1\nB2</p>\n</blockquote><p>A2</p>\n</blockquote>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testNestedBlockquotesThreeLevels() {
		String markup = "> A1\n>\n> > B1\n> >\n> > > C1\n>\n> A2\n";
		String expectedHtml = "<blockquote><p>A1</p>\n<blockquote><p>B1</p>\n<blockquote><p>C1</p>\n</blockquote></blockquote><p>A2</p>\n</blockquote>";
		parseAndAssert(markup, expectedHtml);
	}

	/*
	 * Blockquotes can contain other Markdown elements, including headers, lists, and code blocks.
	 */
	public void testBlockquotesContainingParagraphs() {
		String markup = ">a\n>b\n>\n>c";
		String expectedHtml = "<blockquote><p>a\nb</p>\n<p>c</p>\n</blockquote>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testBlockquotesContainingHeader() {
		String markup = ">#H1";
		String expectedHtml = "<blockquote><h1>H1</h1></blockquote>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testBlockquotesContainingUnderlinedHeader1() {
		String markup = ">H1\n>===";
		String expectedHtml = "<blockquote><h1>H1</h1></blockquote>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testBlockquotesContainingUnderlinedHeader2() {
		String markup = ">H2\n>---";
		String expectedHtml = "<blockquote><h2>H2</h2></blockquote>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testBlockquotesContainingInlineLink() {
		String markup = ">[Link](http://www.example.com)";
		String expectedHtml = "<blockquote><p><a href=\"http://www.example.com\">Link</a></p>\n</blockquote>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testBlockquotesContainingReferenceLink() {
		String markup = ">[Link][link]\n>\n>[link]: http://www.example.com";
		String expectedHtml = "<blockquote><p><a href=\"http://www.example.com\">Link</a></p>\n</blockquote>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testBlockquotesContainingHorizontalRule() {
		String markup = ">---";
		String expectedHtml = "<blockquote><hr/></blockquote>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testBlockquotesContainingHorizontalRuleIsNotInterpretedAsUnderlinedHeader() {
		String markup = ">No H2.\n>\n>---\n";
		String expectedHtml = "<blockquote><p>No H2.</p>\n<hr/></blockquote>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testBlockquotesContainingCodeBlock() {
		String markup = ">     code\n>     block";
		String expectedHtml = "<blockquote><pre><code>code\nblock</code></pre></blockquote>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testBlockquotesContainingInlineHTML() {
		String markup = "> <input type=\"button\" value=\"Click\"/>";
		String expectedHtml = "<blockquote><input type=\"button\" value=\"Click\"/>\n</blockquote>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testBlockquoteSimple() {
		String markup = "> a\n> b";
		String expectedHtml = "<blockquote><p>a\nb</p>\n</blockquote>";
		parseAndAssert(markup, expectedHtml);
	}

	/*
	 * Markdown wraps a code block in both pre and code tags. To produce a code block in Markdown, simply indent every
	 * line of the block by at least 4 spaces or 1 tab.
	 */
	public void testCodeBlockIndentedByFourSpaces() {
		String markup = "    This is a code block.";
		String expectedHtml = "<pre><code>This is a code block.</code></pre>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testCodeBlockIndentedByOneTab() {
		String markup = "\tThis is a code block.";
		String expectedHtml = "<pre><code>This is a code block.</code></pre>";
		parseAndAssert(markup, expectedHtml);
	}

	/*
	 * One level of indentation - 4 spaces or 1 tab - is removed from each line of the code block.
	 */
	public void testCodeBlockMultiLineIndentedByFourSpaces() {
		String markup = "    aaa\n        bbb\n            ccc\n    \n    continue after empty line";
		String expectedHtml = "<pre><code>aaa\n    bbb\n        ccc\n\ncontinue after empty line</code></pre>";
		parseAndAssert(markup, expectedHtml);
	}

	public void testCodeBlockMultiLineIndentedByOneTab() {
		String markup = "\taaa\n\t\tbbb\n\t\t\tccc\n\t\n\tcontinue after empty line";
		String expectedHtml = "<pre><code>aaa\n    bbb\n        ccc\n\ncontinue after empty line</code></pre>";
		parseAndAssert(markup, expectedHtml);
	}

	/*
	 * Within a code block, ampersands (&) and angle brackets (< and >) are automatically converted into HTML entities.
	 */
	public void testSpecialCharactersAreConvertedInCodeBlock() {
		String markup = "    <div class=\"footer\">\n    &copy; 2004 Foo Bar\n    </div>";
		String expectedHtml = "<pre><code>&lt;div class=\"footer\"&gt;\n&amp;copy; 2004 Foo Bar\n&lt;/div&gt;</code></pre>";
		parseAndAssert(markup, expectedHtml);
	}

	/*
	 * Regular Markdown syntax is not processed within code blocks.
	 */
	public void testNoProcessingInCodeBlock() {
		String markup = "    ### Header 3\n    Lorem *ipsum*";
		String expectedHtml = "<pre><code>### Header 3\nLorem *ipsum*</code></pre>";
		parseAndAssert(markup, expectedHtml);
	}

	/*
	 * Horizontal Rules. You can produce a horizontal rule tag ( hr/ ) by placing three or more hyphens, asterisks, or
	 * underscores on a line by themselves. If you wish, you may use spaces between the hyphens or asterisks.
	 */
	public void testHorizontalRulesWithAsterisksAndSpaces() {
		parseAndAssert("* * *", "<hr/>");
	}

	public void testHorizontalRulesWithAsterisks() {
		parseAndAssert("***", "<hr/>");
	}

	public void testHorizontalRulesWithMoreAsterisks() {
		parseAndAssert("*****", "<hr/>");
	}

	public void testHorizontalRulesWithHyphensAndSpaces() {
		parseAndAssert("- - -", "<hr/>");
	}

	public void testHorizontalRulesWithHyphens() {
		parseAndAssert("---------------------------------------", "<hr/>");
	}

	public void testHorizontalRulesWithUnderscores() {
		parseAndAssert("___", "<hr/>");
	}
}
