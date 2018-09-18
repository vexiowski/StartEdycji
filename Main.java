package net.vexio.startedycji;

import org.bukkit.plugin.java.JavaPlugin;

import net.vexio.startedycji.commands.StartCommand;
import net.vexio.startedycji.settings.Config;
import net.vexio.startedycji.tasks.TimeLeftTask;

public class Main extends JavaPlugin {
	
	private static Main plugin;
	
	public static Main getPlugin() {
        return Main.plugin;
    }
	
	public void onEnable() {
        plugin = this;
        Config.getInst().load();
	    saveDefaultConfig();
        if (Main.getPlugin().getConfig().getBoolean("start.enabled")) {
        	new TimeLeftTask().runTaskTimer(this, 40, 20);
        	System.out.println("[NStartEdycji] Title: Wlaczony");
        }else {
        	System.out.println("[NStartEdycji] Title: Wylaczony");
        }
        getCommand("start").setExecutor(new StartCommand());
    }

}
