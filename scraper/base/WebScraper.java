// COURSE: CSCI1620
// TERM: Fall 2019
//
// NAME: Michelle Julsen & Augusto F. Zorrilla Mendez
// RESOURCES: Lab slides, book, TA, lab partners and previous assignments.
package scraper.base;

public class WebScraper 
{
	
	//VARIABLES
	private String url;
	private int depth;
	private String pageHistory;
	
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
			url = urlIn;
		}
	}
	
	public String getURL()
	{
		return url;
	}
	
	public scraper.utils.ResultSet getImages()
	{
		return
	}
	
	public scraper.utils.ResultSet crawlPAge()
	{
		
	}
	
	public scraper.utils.PageHistory getPageHistory()
	{
		return pageHistory;
	}
}
