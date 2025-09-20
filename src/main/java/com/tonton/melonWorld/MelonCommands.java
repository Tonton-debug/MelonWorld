package com.tonton.melonWorld;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;


public class MelonCommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
		if(!(commandSender instanceof  Player)||!label.equals("melon")||args.length==0) {
			
			return true;
		}
		Player player=(Player)commandSender;
		MelonObject objectMelon;
		if(PlayerHelper.GetTargetedBlock(player)!=null)
			
			switch(args[0]) {
			case "help":
				break;
			case "look":
				if(HasNotMelon(player))
					return true;
				objectMelon=new MelonObject(player,PlayerHelper.GetTargetedBlock(player));
				objectMelon.Look();
				break;
			}
		
		return true;
	}
	private boolean HasNotMelon(Player pl) {
		if(!PlayerHelper.TargetBlockIsMelon(pl)) {
			pl.sendMessage(ChatColor.YELLOW+"Вам не удалось найти арбуз для взаимодействия");
			return true;
		}
		return false;
	}
}
