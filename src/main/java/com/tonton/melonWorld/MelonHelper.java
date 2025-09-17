package com.tonton.melonWorld;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;

public class MelonHelper {

	public MelonHelper() {
		// TODO Auto-generated constructor stub
	}
	public static boolean EntityInMelonWorld(Entity entity) {
		
		if(entity.getWorld()!=null&&WorldIsMelonWorld(entity.getWorld()))
			return true;
		return false;
	}
	public static boolean WorldIsMelonWorld(World world) {
	return 	world.getName().equals("melon_world");
	}
	public static World GetMelonWorld() {
		return Bukkit.getWorld("melon_world");
	}
}

