package me.elsifo92.com.terrain;

import java.util.HashMap;

import org.bukkit.Location;

import me.elsifo92.com.politicals.City;

public class AreaManager 
{
	private static HashMap<Area,City> geography=new HashMap<>();
	public static void newArea(Location l1, Location l2, City c)
	{
		Area a=new Area(l1, l2);
		geography.put(a, c);
	}
	public static Area getRelativeArea(Location l) 
	{
		for(Area a:geography.keySet())
		{
			if(a.isInArea(l)) return a;
		}
		return null;
	}
	public static int getDim() 
	{
		return geography.size();
	}
}