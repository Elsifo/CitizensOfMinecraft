package me.elsifo92.com.politicals;

import java.util.ArrayList;
import java.util.UUID;

import me.elsifo92.com.residents.Resident;

public class City 
{
	private UUID id;
	private String name;
	private ArrayList<Resident> residents;
	private ArrayList<Resident> assistants;
	private Resident mayor;
	private boolean isVillage;
	public City(UUID id, String name, ArrayList<Resident> residents, ArrayList<Resident> assistants, Resident mayor)
	{
		this.id=id;
		this.name=name;
		this.residents=residents;
		this.assistants=assistants;
		this.mayor=mayor;
		this.isVillage=true;
	}
	public City(String name, Resident mayor)
	{
		this.id=UUID.randomUUID();
		this.name=name;
		this.residents=new ArrayList<>();
		this.assistants=new ArrayList<>();
		this.mayor=mayor;
		this.isVillage=true;
	}
	public UUID getID()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public boolean isResident(Resident r)
	{
		return residents.contains(r);
	}
	public boolean isAssistant(Resident r)
	{
		return assistants.contains(r);
	}
	public boolean isMayor(Resident r)
	{
		return mayor.equals(r);
	}
	public ArrayList<String> getResidentNames()
	{
		ArrayList<String> ris=new ArrayList<>();
		for(Resident r:residents)
		{
			ris.add(r.getPlayer().getName());
		}
		return ris;
	}
	public ArrayList<String> getAssistantsNames()
	{
		ArrayList<String> ris=new ArrayList<>();
		{
			for(Resident r:residents)
			{
				ris.add(r.getPlayer().getName());
			}
		}
		return ris;
	}
	public void addResident(Resident r)
	{
		this.residents.add(r);
	}
	public void removeResident(Resident r)
	{
		this.residents.remove(r);
	}
	public void addAssistant(Resident r)
	{
		this.assistants.add(r);
	}
	public void removeAssistant(Resident r)
	{
		this.assistants.remove(r);
	}
	public void setMayor(Resident r)
	{
		this.mayor=r;
	}	
	public boolean isVillage()
	{
		return isVillage;
	}	
	public void setCity()
	{
		isVillage=false;
	}
	public void downgradeVillage()
	{
		isVillage=true;
	}
	public Resident getMayor() 
	{
		return mayor;
	}
	
}
