// COURSE: CSCI1620
// TERM: Fall 2019
//
// NAME: Michelle Julsen & Augusto F. Zorrilla Mendez
// RESOURCES: Lab slides, book, TA, lab partners and previous assignments.
package scraper.base;
import scraper.utils.*;

public class WebScraper 
{
	
	//VARIABLES
	private String url;
	private int depth;
	private PageHistory pageHistory;
	
	//CONSTRUCTOR
	
	public WebScraper(String urlIn)
	{
		this.url = urlIn;
	}
	
	public WebScraper ( String urlIn, int depthIn)
	{
		this.depth = depthIn;
		this.url = urlIn;
		
	}
	
	//METHOD
	
	public void setDepth(int depthIn)
	{
		if(depth >= 0)
		{
			this.depth = depthIn;
		}
		else 
		{
			depthIn = 0 ;
		}
	}
	
	public int getDepth()
	{
		return depth;
	}
	
	public void setURL(String url)
	{
		
		if (url != null && !url.isEmpty())
		{
			this.url = url;
		}
	}
	
	public String getURL()
	{
		return url;
	}
	
	public scraper.utils.ResultSet getImages()
	{
		ResultSet myResult = new ResultSet();
		Document page = new Document();
		page.loadPageFromURL(url);
		Elements img = page.getElementsByTag("img");
		
		while (img.hasNextElement())
		{

			ImageEntry myEntry = new ImageEntry(url, img.getNextElement().getAttributeValue("src"));
			myResult.addResult(myEntry);
			 
		}

		return myResult;
		
	}
	public scraper.utils.ResultSet crawlPage()
	{
		
	}
	
	public scraper.utils.PageHistory getPageHistory()
	{
		return pageHistory;
	}
}
