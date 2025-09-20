package com.tonton.melonWorld;

import java.util.Vector;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.EnderChest;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityCreatePortalEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerRespawnEvent;


@SuppressWarnings("deprecation")
public final class EventsListener implements Listener {
 
	@EventHandler
	public void OnCreatePortal(PlayerPortalEvent event) {
		LivingEntity entity = event.getPlayer(); 
		
		if(MelonHelper.EntityInMelonWorld(entity)) {
			entity.getWorld().spawnEntity(entity.getLocation(), EntityType.LIGHTNING_BOLT);
			entity.sendMessage(ChatColor.RED+"Вам не сбежать отсюда.");
			for(int x=-1;x<=1;x+=1) {
				for(int z=-1;z<=1;z+=1) {
					
					if(entity.getWorld().getType(entity.getLocation().add(x,0,z))==Material.NETHER_PORTAL)
						entity.getWorld().setType(entity.getLocation().add(x,0,z),Material.AIR);
				}
			}
			
			event.setCanCreatePortal(true);
			event.setCancelled(true);
		}
	}
	@EventHandler
	public void OnOpenChest(PlayerInteractEvent event) {
		
		Player entity=event.getPlayer();
		if(MelonHelper.EntityInMelonWorld(event.getPlayer())) {
				Block block=event.getClickedBlock();
				if(block!=null&&block.getType()==Material.ENDER_CHEST) {
					event.setCancelled(true);
					 block.setType(Material.BEDROCK);
					entity.getWorld().spawnEntity(entity.getLocation(), EntityType.LIGHTNING_BOLT);
					entity.sendMessage(ChatColor.RED+"Вам не сбежать отсюда.");
					entity.closeInventory();
				}
			
		}
		
	}
	@EventHandler
	public void OnRespawn(PlayerRespawnEvent event) {
		Player entity = event.getPlayer();
		
		if(MelonHelper.WorldIsMelonWorld(entity.getLastDeathLocation().getWorld())) {
			
			Location fin=new Location(MelonHelper.GetMelonWorld(),0,MelonHelper.GetMelonWorld().getHighestBlockYAt(0, 0)+1,0);
			
			Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), () -> entity.teleport(fin), 1L);
			entity.sendMessage(ChatColor.RED+"Вам не сбежать отсюда.");
		}
	}
	
	@EventHandler
	public void OnSpawn(CreatureSpawnEvent event) {
		LivingEntity entity =event.getEntity();
		if(MelonHelper.EntityInMelonWorld(entity)) {
			new MelonEntityCreator(entity).GenerateNewEntity();
		}
	}
}
