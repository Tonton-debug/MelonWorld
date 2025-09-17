package com.tonton.melonWorld;

import java.util.logging.Level;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.PluginManager;
import com.tonton.melonWorld.CoderDojoCommand;
import com.tonton.melonWorld.EventsListener;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
		//Register Event Listeners
		getServer().getPluginManager().registerEvents(new EventsListener(), this);
		
		//Register Command Executors
		//this.getCommand("CoderDojo").setExecutor(new CoderDojoCommand());
    	GenerateMelonWorld();
    }
    private void GenerateMelonWorld() {
    	  WorldCreator creator = new WorldCreator("melon_world");
    	  creator.biomeProvider(new MelonBiomeProvider());
    	  creator.generator(new MelonWorldGenerator());
    	  creator.createWorld();
    }

}
