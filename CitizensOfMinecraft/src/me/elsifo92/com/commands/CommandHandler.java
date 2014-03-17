package me.elsifo92.com.commands;

import me.elsifo92.com.politicals.City;
import me.elsifo92.com.politicals.Nation;
import me.elsifo92.com.politicals.PoliticalManager;
import me.elsifo92.com.residents.Resident;
import me.elsifo92.com.residents.ResidentManager;
import me.elsifo92.com.terrain.AreaManager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor
{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(sender instanceof Player)
		{
			Player p=(Player) sender;
			if(cmd.getName().equals("com"))
			{
				switch(args[0])
				{
					case "sel1": 
					{
						Resident r=ResidentManager.getResident(p);
						if(r==null) return true;
						r.setSelection1(p.getLocation());
					}break;
					case "sel2": 
					{
						Resident r=ResidentManager.getResident(p);
						if(r==null) return true;
						r.setSelection2(p.getLocation());
					}break;
					case "claim": 
					{
						Resident r=ResidentManager.getResident(p);
						if(r==null) return true;
						if(r.hasSelections()) AreaManager.newArea(r.getSelection1(), r.getSelection2(), null);
					}break;
					case "new":
					{
						if(args.length>2)
						{
							switch(args[1])
							{
								case "city":
								{
									if(args.length>3)
									{
										Nation n=PoliticalManager.getNation(args[3]);
										if(n!=null)	
										{
											PoliticalManager.createCity(args[2],p,n);
										}
										else p.sendMessage("Nation not found");
								
									}
								}break;
								case "nation":
								{
									PoliticalManager.createNation(args[2]);
								}break;
							}
						}
					}
					case "list":
					{
						switch(args[1])
						{
							case "nations":
							{
								for(String s:PoliticalManager.getNationsList())
								{
									p.sendMessage(s);
								}
							}break;
							case "cities":
							{
								for(String s:PoliticalManager.getCitiesList())
								{
									p.sendMessage(s);
								}
							}break;
						}
					}break;
					case "city":
					{
						if(args.length>1)
						{
							p.sendMessage(args[1]);
							City c=PoliticalManager.getCity(args[1]);
							if(c!=null)
							{
								p.sendMessage("=========="+c.getName()+"============");
								p.sendMessage("Nation: "+PoliticalManager.getNation(c).getName());
								p.sendMessage("Mayor: "+c.getMayor().getPlayer().getName());
								String s="Assistants: ";
								for(String as:c.getAssistantsNames())
								{
									s=s+as+"; ";
								}
								p.sendMessage(s);
								s="Residents: ";
								for(String rs:c.getResidentNames())
								{
									s=s+rs+"; ";
								}
								p.sendMessage(s);
								p.sendMessage("=====================================");
							}
						}break;
					}
					
				}
			}
		}
		return false;
	}
}
