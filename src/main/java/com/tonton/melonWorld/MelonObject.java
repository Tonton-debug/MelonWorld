package com.tonton.melonWorld;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.damage.DamageSource;
import org.bukkit.damage.DamageType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;

public class MelonObject {
	private Player _pl;
	private Block _melon;
	private World _world;
	private Random _random;
	private Material[] _loots;
	private PotionEffectType[] _types;
	public MelonObject(Player pl,Block melon) {
		_pl=pl;
		_random=new Random();
		_melon=melon;
		_world=_melon.getWorld();
		_loots=new Material[] {Material.GOLD_INGOT,Material.POPPY,Material.IRON_INGOT,Material.CAKE};
		_types=new PotionEffectType[] {PotionEffectType.REGENERATION,PotionEffectType.FIRE_RESISTANCE,PotionEffectType.HASTE,PotionEffectType.SPEED,PotionEffectType.JUMP_BOOST};
	}
	private void Boom() {
		_world.createExplosion(_melon.getLocation(), _random.nextInt(2,4));
		_pl.sendMessage(ChatColor.YELLOW+"АРБУЗ ВЗОРВАЛСЯ!!!!!!!!!!");
	}
	private void BoomWithLoot(Material loot,int count) {
		Boom();
		_world.dropItem(_melon.getLocation(), new ItemStack(loot,count));
		
	}
	private void BoomWithRandomLoot() {
		Material randomLoot=_loots[_random.nextInt(0,_loots.length)];
		int count=_random.nextInt(1,20);
		BoomWithLoot(randomLoot,count);
	}
	public void Look() {
		int randomValue=_random.nextInt(0,100);
		if(MelonHelper.EntityInMelonWorld(_pl)) {
			if(randomValue<5) {
				MelonHelper.TeleportPlayerFromMelon(_pl);
			}else if(randomValue>=5&&randomValue<=50) {
				_pl.sendMessage(ChatColor.YELLOW+"АРБУЗ УНИЧТОЖИЛ ВАС В ГЛЯДЕЛКАХ");
				_pl.setHealth(0);
			} else if(randomValue>50) {
				_pl.sendMessage(ChatColor.YELLOW+"ВЫ УНИЧТОЖИЛИ АРБУЗ СВОИМ ЗРЕНИЕМ");
				_melon.setType(Material.BEDROCK);
			}
			return;
		}
		if(randomValue>50) {
			PotionEffectType randomType=_types[_random.nextInt(0,_types.length)];
			int level=_random.nextInt(0,5);
			int time=_random.nextInt(60,60*5)*20;
			_pl.addPotionEffect(new PotionEffect(randomType,time,level));
			_pl.sendMessage(ChatColor.YELLOW+"АРБУЗ ОСВЯТИЛ ВАС СВОЕЙ МЯКОСТЬЮ И УМЕР");
			_melon.setType(Material.AIR);
			return;
		}
		if(randomValue<50&&randomValue>30) {
			MelonHelper.TeleportPlayerFromMelon(_pl);
			return;
		}
		
		if(randomValue>20&&randomValue<30) {
			BoomWithRandomLoot();
			return;
		}
		if(randomValue<20) {
			Boom();
			return;
		}
	}

}
