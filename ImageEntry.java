// COURSE: CSCI1620
// TERM: Fall 2019
//
// NAME: Michelle Julsen & Augusto F. Zorrilla Mendez
// RESOURCES: Lab slides, book, TA, lab partners and previous assignments.


package scraper.base;

/**
 * This class stores information about each image found while crawling
 * pages. Image URLs are saved along with the URL for the page on which
 * the image appears.
 * 
 * @author Augusto F. Zorrilla Mendez and Michelle Julsen
 *
 */
public class ImageEntry extends java.lang.Object
{
	// INSTANCE VARIABLES
	
	private String pageAddressIn;
	private String imgAddressIn;
	
	
	// CONSTRUCTOR
	
	/**
	 * Creates a new ImageEntry storing an image URL alongside the
	 * source page URL.
	 * 
	 * @param pageAddress - the URL for the page where the image was found
	 * @param imgAddress - the full URL of the image itself
	 */
	public ImageEntry(String pageAddress, String imgAddress)
	{
		this.pageAddressIn = pageAddress;
		this.imgAddressIn = imgAddress;
	}
	
	
	// METHODS
	
	/**
	 * Retrieves the source page URL.
	 * 
	 * @return The web page where the image of this ImageEntry can be found.
	 */
	public String getPageLocation()
	{
		return this.pageAddressIn;
	}
	
	/**
	 * Retrieves the direct image URL.
	 * 
	 * @return The full URL of image file itself.
	 */
	public String getImgLocation()
	{
		return this.imgAddressIn;
	}
	
	/**
	 * Compares this ImageEntry to another object for equality based on
	 * the URL of the image file.Two ImageEntries with the same image URL
	 * but different page URLs will be considered equivalent.
	 */
	
	public boolean equals(Object other)
	{
		if (this.getImgLocation().equals( ((ImageEntry)other).getImgLocation() ))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * Retrieves a String version of this ImageEntry. The returned
	 * string should only contain the URL for the image file.
	 */
	public String toString()
	{
		String returnString = "" + this.imgAddressIn;
		return returnString;
		
	}
}