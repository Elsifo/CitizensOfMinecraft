package me.elsifo92.com.listeners;

import me.elsifo92.com.terrain.Area;
import me.elsifo92.com.terrain.AreaManager;

import org.bukkit.entity.Player;
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
		if(e.getFrom().equals(e.getTo())) return;
		Player p=e.getPlayer();
		Area a=AreaManager.getRelativeArea(e.getFrom());
		Area b=AreaManager.getRelativeArea(e.getTo());
		if(b!=null)
		{
			if(a==null || !(a.equals(b))) p.sendMessage(b.getID().toString());
			return;
		}
		if(a!=null && b==null)
		{
			p.sendMessage("Wilderness");
			return;
		}
	}
	
}
