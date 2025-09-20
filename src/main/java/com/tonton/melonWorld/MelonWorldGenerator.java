package com.tonton.melonWorld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import org.bukkit.util.noise.SimplexOctaveGenerator;

public class MelonWorldGenerator extends ChunkGenerator {

	public MelonWorldGenerator() {
		// TODO Auto-generated constructor stub
	}
	 @Override
	 public void generateCaves(WorldInfo worldInfo,  Random random, int chunkX, int chunkZ,  ChunkGenerator.ChunkData chunkData)
	 {
SimplexOctaveGenerator generator = new SimplexOctaveGenerator(new Random(worldInfo.getSeed()), 8);
		 
		 generator.setScale(0.05);
		 for (int X = 0; X < 16; X++)
	            for (int Z = 0; Z < 16; Z++) {
	            for(int Y=1;Y<256;Y++) {
	            	if(chunkData.getBlockData(X, Y, Z).getMaterial()==Material.AIR)
	            		continue;
	            	 double currentHeight = generator.noise(chunkX*16+X,Y, chunkZ*16+Z, 0.5D, 0.5D);
	            	 if(currentHeight>0.5)
	            		 chunkData.setBlock(X, Y, Z, Material.AIR);
	            	 
	            }
	            }
	 }
	 @Override
	 public List<BlockPopulator> getDefaultPopulators(World world) {
	     return Arrays.asList((BlockPopulator)new MelonBlockPopulator(),(BlockPopulator)new TreeMelonBlockPopulator());
	 }
	 @Override
	 public void generateNoise(WorldInfo worldInfo,  Random random, int chunkX, int chunkZ,  ChunkGenerator.ChunkData chunkData)
	 {
		 SimplexOctaveGenerator generator = new SimplexOctaveGenerator(new Random(worldInfo.getSeed()), 8);
		 
		 generator.setScale(0.005);

	        for (int X = 0; X < 16; X++)
	            for (int Z = 0; Z < 16; Z++) {
	               int currentHeight = (int) (generator.noise(chunkX*16+X, chunkZ*16+Z, 0.5D, 0.5D)*15D+128D);
	               chunkData.setBlock(X, currentHeight, Z, Material.LEGACY_MELON_BLOCK);
	               chunkData.setBlock(X, currentHeight-1, Z, Material.STONE);
	                for (int i = currentHeight-2; i > 0; i--)
	                	chunkData.setBlock(X, i, Z, Material.STONE);
	                chunkData.setBlock(X, 0, Z, Material.BEDROCK);
	            }
	 }
	 

}
