package me.elsifo92.com.terrain;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Area 
{
	private UUID id;
	private Location angle1;
	private Location angle2;
	public Area(UUID id, Location angle1, Location angle2)
	{
		this.id=id;
		this.angle1=angle1;
		this.angle2=angle2;
	}
	public Area(Location angle1, Location angle2)
	{
		this.id=UUID.randomUUID();
		this.angle1=angle1;
		this.angle2=angle2;
	}
	public boolean isInArea(Location l)
	{
		Bukkit.getConsoleSender().sendMessage("Checking");
		boolean ris=false;
		if(angle1.getBlockX()<angle2.getBlockX()) ris=(l.getBlockX()>angle1.getBlockX() && l.getBlockX()<angle2.getBlockX())?true:false;
		else ris=(l.getBlockX()<angle1.getBlockX() && l.getBlockX()>angle2.getBlockX())?true:false;
		if(ris==false) return false;
		if(angle1.getBlockY()<angle2.getBlockY()) ris=(l.getBlockY()>angle1.getBlockY() && l.getBlockY()<angle2.getBlockY())?true:false;
		else ris=(l.getBlockY()<angle1.getBlockY() && l.getBlockY()>angle2.getBlockY())?true:false;
		if(ris==false) return false;
		if(angle1.getBlockZ()<angle2.getBlockZ()) ris=(l.getBlockZ()>angle1.getBlockZ() && l.getBlockZ()<angle2.getBlockZ())?true:false;
		else ris=(l.getBlockZ()<angle1.getBlockZ() && l.getBlockZ()>angle2.getBlockZ())?true:false;
		return true;
	}
	public UUID getID()
	{
		return id;
	}
}
