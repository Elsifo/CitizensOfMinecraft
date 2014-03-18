package me.elsifo92.com.politicals;

import me.elsifo92.com.residents.Resident;
import me.elsifo92.com.residents.ResidentManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

import org.bukkit.entity.Player;

public class PoliticalManager 
{
	private static ArrayList<Nation> nations=new ArrayList<>();
	private static HashMap<City,Nation> cities=new HashMap<>();
	private static HashMap<String,City> search=new HashMap<>();
	public static void createCity(String name, Player p, Nation n)
	{
		City c=new City(name,null);
		Resident r=ResidentManager.spawnResident(p, c);
		c.setMayor(r);
		c.addResident(r);
		if(!cities.containsKey(c)) 
		{
			cities.put(c,n);
			search.put(name,c);
		}
	}
	public static void loadCity(UUID id, String name, ArrayList<Resident> residents, ArrayList<Resident> assistants, Resident mayor, Nation n)
	{
		City c=new City(id,name,residents,assistants,mayor);
		cities.put(c, n);
		search.put(name, c);
	}
	public static void createNation(String name)
	{
		Nation n=new Nation(name);
		if(!nations.contains(n))
		{
			nations.add(n);
		}
	}
	public static Nation getNation(String c) 
	{
		Iterator<Nation> i=nations.iterator();
		while(i.hasNext())
		{
			Nation n=i.next();
			if(n.getName().equals(c)) return n;
		}
		return null;
	}
	public static ArrayList<String> getNationsList() 
	{
		ArrayList<String> s=new ArrayList<>();
		for(Nation n:nations)
		{
			s.add(n.getName());
		}
		return s;
	}
	public static ArrayList<String> getCitiesList() 
	{
		ArrayList<String> s=new ArrayList<>();
		for(City c:cities.keySet())
		{
			s.add(c.getName());
		}
		return s;
	}
	public static City getCity(String string)
	{
		return search.get(string);
	}
	public static Nation getNation(City c) 
	{
		return cities.get(c);
	}
	public static void addAssistant(Resident mayor, Resident resident) 
	{
		if(ResidentManager.isMayor(mayor)) mayor.getCity().removeAssistant(resident);	
	}
	public static void removeAssistant(Resident mayor, Resident resident) 
	{
		if(ResidentManager.isMayor(mayor)) mayor.getCity().removeAssistant(resident);		
	}
}