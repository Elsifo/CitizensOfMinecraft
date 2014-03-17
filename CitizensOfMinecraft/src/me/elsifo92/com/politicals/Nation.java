package me.elsifo92.com.politicals;

public class Nation 
{
	private String name;
	private City capital;
	public Nation(String name)
	{
		this.name=name;
		this.capital=null;
	}
	public void setCapital(City capital)
	{
		this.capital=capital;
	}
	public City getCapital()
	{
		return capital;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
}
