package scraper.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import scraper.base.ImageEntry;

public class ImageEntryTests {

	@Test
	public void testConstructor() {
		ImageEntry a = new ImageEntry("page.com", "image.png");
		
		assertEquals("page.com", a.getPageLocation());
		assertEquals("image.png", a.getImgLocation());
	}
	
	@Test
	public void testEquals() {
		ImageEntry a = new ImageEntry("page.com", "image.png");
		ImageEntry b = new ImageEntry("page.com", "image.png");
		ImageEntry c = new ImageEntry("", "");
		
		assertEquals(a.equals(b), true);
		assertEquals(b.equals(a), true);
		assertEquals(a.equals(c), false);
		assertEquals(c.equals(b), false);
	}
	
	@Test
	public void testToString() {
		ImageEntry a = new ImageEntry("page.com", "image.png");
		
		assertEquals("image.png", a.toString());
	}

}
