package me.elsifo92.com.listeners;

import me.elsifo92.com.terrain.Area;
import me.elsifo92.com.terrain.AreaManager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerListener implements Listener
{
	public PlayerListener()
	{
		
	}
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e)
	{
		Area a=AreaManager.getRelativeArea(e.getFrom());
		Area b=AreaManager.getRelativeArea(e.getTo());
		if(a!=null && b!=null)
		{
			if(!a.equals(b)) e.getPlayer().sendMessage(b.getID().toString());
		}
		if(a!=null && b==null)
		{
			e.getPlayer().sendMessage("Wilderness");
		}
	}
	
}
