package com.tonton.melonWorld;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.block.Biome;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.WorldInfo;

public class MelonBiomeProvider extends BiomeProvider {

	public MelonBiomeProvider() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Biome getBiome(WorldInfo worldInfo, int x, int y, int z) {
		// TODO Auto-generated method stub
		return Biome.PLAINS;
	}

	@Override
	public List<Biome> getBiomes(WorldInfo worldInfo) {
		// TODO Auto-generated method stub
		ArrayList<Biome> biomes=new ArrayList<Biome>();
		biomes.add(Biome.PLAINS);
		return biomes;
	}

}
