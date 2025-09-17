package com.tonton.melonWorld;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class MelonBlockPopulator extends BlockPopulator {

	public MelonBlockPopulator() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void populate(World world, Random random, Chunk chunk) {
		int X, Y, Z;
		boolean isStone;
		Material OreMaterial = null;
		
		
		int countOre=random.nextInt(100,1000);
		for (int i = 1; i < countOre; i++) {  // Number of tries
			X = random.nextInt(15)*chunk.getX();
			Z = random.nextInt(15)*chunk.getZ();
			Y = random.nextInt(108)+20;  // Get randomized coordinates
			if (world.getBlockAt(X, Y, Z).getBlockData().getMaterial() == Material.STONE) {
			if(random.nextInt(100) < 60)
				OreMaterial=Material.GOLD_ORE;
			else if(random.nextInt(100) < 40)
				OreMaterial=Material.IRON_ORE;
			else if(random.nextInt(100) < 20)
				OreMaterial=Material.DIAMOND_ORE;
			else if(random.nextInt(100) < 10)
				OreMaterial=Material.ANCIENT_DEBRIS;
			else 
				OreMaterial=Material.COAL_ORE;
			
			
			
				isStone = true;
				//System.out.println("SPAWN IN:"+X+" "+Y+" "+Z);
				while (isStone) {
					world.getBlockAt(X, Y, Z).setType(OreMaterial);
					if (random.nextInt(100) < 50)  {   // The chance of continuing the vein
						switch (random.nextInt(6)) {  // The direction chooser
						case 0: X++; break;
						case 1: Y++; break;
						case 2: Z++; break;
						case 3: X--; break;
						case 4: Y--; break;
						case 5: Z--; break;
						}
						isStone = (world.getBlockAt(X, Y, Z).getBlockData().getMaterial() == Material.STONE) && (world.getBlockAt(X, Y, Z).getBlockData().getMaterial() != OreMaterial);
					} else isStone = false;
				}
			}
		    
		}
	}

}
