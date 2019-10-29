package scraper.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import scraper.base.WebScraper;

public class WebScraperTests {

	@Test
	public void testDefaultConstructor() {
		WebScraper a = new WebScraper("url.com");
		
		assertEquals("url.com", a.getURL());
	}
	
	@Test
	public void testSpecificConstructor() {
		WebScraper a = new WebScraper("url.com", 3);
		
		assertEquals("url.com", a.getURL());
		assertEquals(3, a.getDepth());
	}
	
	@Test
	public void testSetDepth() {
		WebScraper a = new WebScraper("url.com", 2);
		assertEquals(2, a.getDepth());
		
		a.setDepth(4);
		assertEquals(4, a.getDepth()); // Should have changed
		
		a.setDepth(-7);
		assertEquals(0, a.getDepth()); // Should not change
	}
	
	@Test
	public void testSetURL() {
		WebScraper a = new WebScraper("url.com", 2);
		assertEquals("url.com", a.getURL());
		
		a.setURL("NOTurl.com");
		assertEquals("NOTurl.com", a.getURL()); // Should have changed
		
		a.setURL("");
		assertEquals("NOTurl.com", a.getURL()); // Should not change
		
		a.setURL(null);
		assertEquals("NOTurl.com", a.getURL()); // Should not change
	}
	
	@Test
	public void testGetImages() {
		
	}
	
	@Test
	public void testCrawlPage() {
		
	}
	
	@Test
	public void testGetPageHistory() {
		
		
		assertEquals(, a.getPageHistory());
	}

}
