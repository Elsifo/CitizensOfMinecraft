package me.elsifo92.com.residents;

import java.util.HashMap;
import java.util.UUID;

import me.elsifo92.com.politicals.City;

public class ResidentManager 
{
	private static HashMap<Resident,City> residents=new HashMap<>();
	/*public static void newResident(Player p,City c)
	{
		residents.put(new Resident(p), c);
	}*/
	public static Resident getResident(UUID p)
	{
		for(Resident r:residents.keySet())
		{
			if(r.getPlayer().equals(p)) return r;
		}
		return null;
	}
	public static Resident spawnResident(UUID p, City c) 
	{
		Resident r=new Resident(p);
		r.setCity(c);
		residents.put(new Resident(p), c);
		return r;
	}
	public static boolean isMayor(Resident mayor) 
	{
		City c=residents.get(mayor);
		if(c==null) return false;
		return (c.getMayor().equals(mayor));
	}
}
