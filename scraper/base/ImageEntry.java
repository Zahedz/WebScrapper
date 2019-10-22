// COURSE: CSCI1620
// TERM: Fall 2019
//
// NAME: Michelle Julsen & Augusto F. Zorrilla Mendez
// RESOURCES: Lab slides, book, TA, lab partners and previous assignments.


package scraper.base;

public class ImageEntry extends java.lang.Object
{
	//VARIABLES 
	private String pageAddressIn;
	private String imgAddressIn;
	
	
	//CONSTRUCTOR
	
	public ImageEntry(String pageAddress, String imgAddress)
	{
		this.pageAddressIn = pageAddress;
		this.imgAddressIn = imgAddress;
	}
	
	//METHOD
	
	public String getPageLocation()
	{
		return this.pageAddressIn;
	}
	
	public String getImgLocation()
	{
		return this.imgAddressIn;
	}
	
	public boolean equals(Object other)
	{
		return false;
		
	}
	
	public String toString()
	{
		return imgAddressIn;
		
	}
}
