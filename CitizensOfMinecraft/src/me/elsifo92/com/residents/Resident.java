package me.elsifo92.com.residents;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;

public class Resident 
{
	private OfflinePlayer p;
	private Location sel1;
	private Location sel2;
	public Resident(OfflinePlayer p)
	{
		this.p=p;
		sel1=null;
		sel2=null;
	}
	public OfflinePlayer getPlayer()
	{
		return p;
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
}
