package com.tonton.melonWorld;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.RayTraceResult;

public class PlayerHelper {

	public PlayerHelper() {
		
	}
	public static boolean TargetBlockIsMelon(Player pl) {
		Block block=GetTargetedBlock(pl);
		if(block!=null) {
			return block.getType()==Material.MELON;
		}
		return false;
	}
	public static Block GetTargetedBlock(Player player) 
	{
	 return player.getTargetBlock(null, 5);
	    
	}

}
