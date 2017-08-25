package br.com.battlehost.redstonemanager;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public static Main getInstance() {
		return instance;
	}
	  public static Plugin getPlugin()
	  {
	    return plugin;
	  }
    public static Main instance;	public static Plugin plugin;

    public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new DisableAPI(this), this);
		getCommand("redstone").setExecutor(new redstone());
		getCommand("tnt").setExecutor(new tnt());
	    plugin = this;
	    instance = this;
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§8§aBattleRedstoneManager§8 §7Plugin §aativado §7com sucesso.");
		Bukkit.getConsoleSender().sendMessage("§a§owww.battlehost.com.br");
		Bukkit.getConsoleSender().sendMessage("");

	    File config = new File(getDataFolder(), "config.yml");
	    if (!config.exists())
	    {
	      getConfig().options().copyDefaults(true);
	      saveConfig();
	    }
    }
    
    public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§8§aBattleRedstoneManager§8 §7Plugin §adesativado §7com sucesso.");
		Bukkit.getConsoleSender().sendMessage("§a§owww.battlehost.com.br");
		Bukkit.getConsoleSender().sendMessage("");
    }

}
