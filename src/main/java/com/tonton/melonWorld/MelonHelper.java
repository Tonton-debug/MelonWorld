package com.tonton.melonWorld;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Barrel;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import net.md_5.bungee.api.ChatColor;

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
	private static void ClonePlayerInventoryToChest(Player pl) {
		PlayerInventory inventory=pl.getInventory();
		ItemStack[] one=inventory.getContents();
		//ItemStack[] two=inventory.getArmorContents();
			pl.getLocation().getBlock().setType(Material.BARREL);
			Barrel chest=(Barrel) pl.getLocation().getBlock().getState();
			int startI=0;
			int y=1;
			for(int i=0;i<one.length;i+=1) {
				if(i-startI==9*3) {
					pl.getLocation().add(0,y,0).getBlock().setType(Material.BARREL);
				 chest=(Barrel) pl.getLocation().add(0,y,0).getBlock().getState();
				 y+=1;
				 startI=i;
				}
				if(one[i]!=null)
					chest.getInventory().addItem(one[i]);
			}
			
	}
		
	
	public static void TeleportPlayerFromMelon(Player pl) {
	
		ClonePlayerInventoryToChest(pl);
		pl.getInventory().clear();
		if(EntityInMelonWorld(pl)) {
			pl.sendMessage(ChatColor.RED+"Арбуз вернул вас обратно. Ваши вещи сохранены в арбузном мире на координатах:"+pl.getLocation().getBlockX()+" "+pl.getLocation().getBlockY()+" "+pl.getLocation().getBlockZ());
			pl.teleport(new Location(Bukkit.getWorld("world"),0,Bukkit.getWorld("world").getHighestBlockAt(0, 0).getY()+1,0));
		}  else {
			pl.sendMessage(ChatColor.RED+"Арбуз телепортировал вас в арбузный мир. Ваши вещи сохранены в обычном мире на координатах:"+pl.getLocation().getBlockX()+" "+pl.getLocation().getBlockY()+" "+pl.getLocation().getBlockZ());
			pl.teleport(new Location(GetMelonWorld(),0,GetMelonWorld().getHighestBlockAt(0, 0).getY()+1,0));
		}
	}
}

