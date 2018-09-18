package net.vexio.startedycji.settings;

import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;

import net.vexio.startedycji.Main;

public class Config
{
    private static Config inst;
    @SuppressWarnings("unused")
	private FileConfiguration cfg;
    private static File mainDir;
    private static File cfgFile;
    
    static {
        Config.mainDir = Main.getPlugin().getDataFolder();
        Config.cfgFile = new File(Config.mainDir, "config.yml");
    }
    
    private Config() {
        this.cfg = Main.getPlugin().getConfig();
        Config.inst = this;
    }
    
    public void load() {
    }
    
    public static Config getInst() {
        if (Config.inst == null) {
            return new Config();
        }
        return Config.inst;
    }
    
    public static void check() {
        if (!Config.mainDir.exists()) {
            Config.mainDir.mkdir();
        }
        if (!Config.cfgFile.exists()) {
            Main.getPlugin().saveDefaultConfig();
        }
    }
}
