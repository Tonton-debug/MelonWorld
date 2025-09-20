package com.tonton.melonWorld;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class TreeMelonBlockPopulator extends BlockPopulator {

	public TreeMelonBlockPopulator() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void populate(World world, Random random, Chunk chunk) {
		if(random.nextInt(0,100)>80) {
			int X = random.nextInt(15)*chunk.getX();
			int Z = random.nextInt(15)*chunk.getZ();
			int Y = world.getHighestBlockYAt(X, Z)+1;
			TreeType treeType=TreeType.values()[random.nextInt(0,TreeType.values().length)];
			Location loc=new Location(world,X,Y,Z);
			if(loc.add(0,-1,0).getBlock().getType()!=Material.MELON) {
				return;
			}
			world.generateTree(new Location(world,X,Y,Z),treeType );
		}
		
	}
}
