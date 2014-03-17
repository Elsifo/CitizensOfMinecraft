package me.elsifo92.com;

import me.elsifo92.com.commands.CommandHandler;
import me.elsifo92.com.listeners.PlayerListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Citizen extends JavaPlugin 
{
	public void onEnable()
	{
		this.getCommand("com").setExecutor(new CommandHandler());
		PlayerListener ps=new PlayerListener();
		Bukkit.getPluginManager().registerEvents(ps, this);
	}
	public void onDisable()
	{
		Bukkit.getConsoleSender().sendMessage("[Com]Disabled");
	}
}
