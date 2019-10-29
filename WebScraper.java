// COURSE: CSCI1620
// TERM: Fall 2019
//
// NAME: Michelle Julsen & Augusto F. Zorrilla Mendez
// RESOURCES: Lab slides, book, TA, lab partners and previous assignments.
package scraper.base;
import scraper.utils.*;

/**
 * This class provides a simple mechanism to crawl a series of webpages
 * recursively and extract all of the images that are found on the
 * pages visited.
 * 
 * @author Augusto F. Zorrilla Mendez and Michelle Julsen
 */
public class WebScraper 
{
	// INSTANCE VARIABLES
	
	private String url;
	private int depth;
	private PageHistory pageHistory;
	
	
	// CONSTRUCTORS
	
	/**
	 * Builds a new WebScraper that should start at the provided URL
	 * and will by default explore that page at a depth of 0. This
	 * allows extracting just the details from this page and nothing
	 * else.
	 * 
	 * @param urlIn - The URL to explore for images.
	 */
	public WebScraper(String urlIn)
	{
		this.url = urlIn;
	}
	
	/**
	 * Builds a new WebScraper that should start at the provided URL
	 * and will explore recursively to a specified depth.
	 * 
	 * @param urlIn - The URL to begin exploring for images.
	 * @param depthIn - The recursive depth to explore, must be >= 0.
	 * 					Negative values will be treated as equivalent to 0.
	 */
	public WebScraper ( String urlIn, int depthIn)
	{
		this.depth = depthIn;
		this.url = urlIn;
		
	}
	
	
	// METHODS
	
	/**
	 * Updates this WebScraper to explore to a newdepth.
	 * 
	 * @param depthIn - The recursive depth to explore, must be >= 0.
	 * 					Negative values will be treated as equivalent to 0.
	 */
	public void setDepth(int depthIn)
	{
		if(depthIn >= 0)
		{
			this.depth = depthIn;
		}
		else
		{
			this.depth = 0 ;
		}
	}
	
	/**
	 * Retrieves the exploration depth of this WebScraper.
	 * 
	 * @return The depth stored in this WebScraper.
	 */
	public int getDepth()
	{
		return depth;
	}
	
	/**
	 * Updates the base URL to explore for this WebScraper.
	 * 
	 * @param url - The new URL to explore. The WebScraper url is only
	 * 				changed if the url value is valid (not null or empty).
	 */
	public void setURL(String url)
	{
		
		if (url != null && !url.isEmpty())
		{
			this.url = url;
		}
	}
	
	/**
	 * Retrieves the base url for exploration by this WebScraper.
	 * 
	 * @return The base url.
	 */
	public String getURL()
	{
		return url;
	}
	
	/**
	 * Retrieves the set of images found directly at the initial base
	 * URL for this WebScraper. This method will not explore any links
	 * found at the base page. Image information should be stored in
	 * the order in which their corresponding <img> tags appear in the
	 * source HTML code. If an image appears more than once in a page,
	 * only one entry should appear in the ResultSet.
	 * 
	 * @return A collection of ImageEntry objects for the images found at the base url location.
	 */
	public scraper.utils.ResultSet getImages()
	{
		return this.getImagesHelper(url);
		
	}
	
	/**
	 * This method will recursively explore pages starting at the base
	 * url defined for this WebScraper to the depth for which the
	 * scraper is configured.
	 * 
	 * The ResultSet will contain all images discovered along the way,
	 * with images from a page being explored stored in the ResultSet
	 * prior to any images found on linked pages. ImageEntries will
	 * always appear in the ResultSetin the order in which the
	 * corresponding <img> tags are given in the HTML files. Only the
	 * first occurrence of a particular image (by absolute URL) is
	 * stored in the ResultSet.
	 * 
	 * Links on a page will be explored in the sequential order in
	 * which their corresponding <a> tags appear in the HTML file. The
	 * same URLshould never be crawled more than once, even if it is
	 * linked from itself or another later page.
	 * 
	 * @return The set of ImageEntry objects resulting from this recursive crawl.
	 */
	public scraper.utils.ResultSet crawlPage()
	{
		return this.crawlPageHelper(depth, url);
	}
	
	/**
	 * Retrieves the historical trail of pages visited during the last
	 * top-level call to crawlPage.
	 * 
	 * @return The most recent collection of pages visited. If the
	 * crawlPage method has not been previously called, the PageHistory
	 * object will be empty.
	 */
	public scraper.utils.PageHistory getPageHistory()
	{
		return pageHistory;
	}
	
	/**
	 * 
	 * 
	 * @return The set of ImageEntry objects resulting from this recursive crawl.
	 */
	private ResultSet crawlPageHelper(int depthIn, String urlIn) {
		if (depthIn == 0) {
			return this.getImagesHelper(urlIn);
		}
		else {
			ResultSet myResult = this.getImagesHelper(urlIn);
			Document page = new Document();
			page.loadPageFromURL(urlIn);
			if (page.loadPageFromURL(urlIn))
			{
				Elements a = page.getElementsByTag("a");
				
				while (a.hasNextElement())
				{
					String myEntry = a.getNextElement().getAttributeValue("href");
					myResult = myResult.merge(crawlPageHelper(depthIn - 1, myEntry));
					
				}	
			}
			
			return myResult;
		}
	}
	
	/**
	 * 
	 * 
	 * @param urlIn - The base URL.
	 * @return  A collection of ImageEntry objects for the images found at the base url location.
	 */
	private ResultSet getImagesHelper(String urlIn) {
		ResultSet myResult = new ResultSet();
		Document page = new Document();
		page.loadPageFromURL(urlIn);
		if (page.loadPageFromURL(urlIn)) {
			Elements img = page.getElementsByTag("img");
			
			while (img.hasNextElement())
			{

				ImageEntry myEntry = new ImageEntry(urlIn, img.getNextElement().getAttributeValue("src"));
				myResult.addResult(myEntry);
				 
			}
		}
		
		return myResult;
	}
}