package com.tonton.melonWorld;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

public class MelonEntityCreator {
	private Entity _entity;
	public MelonEntityCreator(Entity entity) {
		_entity=entity;
	}
	public void GenerateNewEntity() {
		try {
		 if (_entity instanceof LivingEntity) { // Check if it's a LivingEntity
		        LivingEntity livingEntity = (LivingEntity) _entity; // Cast it
		        // Now you can use livingEntity.attack(), livingEntity.addPotionEffect(), etc. [7]
		        livingEntity.getEquipment().setHelmet(new ItemStack(Material.LEGACY_MELON_BLOCK));
		       livingEntity.setCustomName("ДРУГГ");
		       livingEntity.setMaxHealth(100);
		       livingEntity.setHealth(100);
		       livingEntity.getEquipment().setItemInHand(new ItemStack(Material.MELON));
		    } else {
		       
		    }
		}catch(Exception e) {
			System.out.println("ERRROR:"+e.getLocalizedMessage());
		}  
	}

}
