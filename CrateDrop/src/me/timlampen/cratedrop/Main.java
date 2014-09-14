package me.timlampen.cratedrop;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	public static Plugin plugin;
	@Override
	public void onEnable(){
		plugin = this;
		Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
	}
	
	@Override
	public void onDisable(){
		saveDefaultConfig();
		plugin = null;
	}
	public static Plugin getPlugin(){
		return plugin;
	}
}
