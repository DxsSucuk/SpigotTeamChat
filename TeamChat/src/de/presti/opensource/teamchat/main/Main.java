package de.presti.opensource.teamchat.main;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.presti.opensource.teamchat.cmd.TeamChat;

public class Main extends JavaPlugin {
	public Logger log = Bukkit.getLogger();
	
	public void onEnable() {
		log.info(getName() + " has been Enabled!");
		onRegisterCMD();
	}
	
	public void onDisable() {
		log.info(getName() + " has been Disabled!");
	}
	
	public void onRegisterCMD() {
		getCommand("tc").setExecutor(new TeamChat());
		getCommand("teamchat").setExecutor(new TeamChat());
	}

}
