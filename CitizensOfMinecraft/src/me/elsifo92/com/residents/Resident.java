package me.elsifo92.com.residents;

import java.util.UUID;

import me.elsifo92.com.politicals.City;

import org.bukkit.Location;

public class Resident 
{
	private UUID player;
	private Location sel1;
	private Location sel2;
	private City city;
	public Resident(UUID player)
	{
		this.player=player;
		sel1=null;
		sel2=null;
	}
	public UUID getPlayer()
	{
		return player;
	}
	public void setSelection1(Location sel1)
	{
		this.sel1=sel1;
	}
	public void setSelection2(Location sel2)
	{
		this.sel2=sel2;
	}
	public Location getSelection1()
	{
		return sel1;
	}
	public Location getSelection2()
	{
		return sel2;
	}
	public boolean hasSelections() 
	{
		return sel1!=null && sel2!=null;
	}
	public void setCity(City c)
	{
		this.city=c;
	}
	public City getCity()
	{
		return city;
	}
}
