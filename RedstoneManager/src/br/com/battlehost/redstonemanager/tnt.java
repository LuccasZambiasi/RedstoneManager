package br.com.battlehost.redstonemanager;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tnt implements CommandExecutor{


	@SuppressWarnings({ })
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cApenas jogadores podem executar esse comando");
			return true;
		}
		final Player p = (Player) sender;
	
		if(cmd.getName().equalsIgnoreCase("tnt")) {
	        if (!p.hasPermission("battlehost.redstonemanager"))
	        {
	          p.sendMessage(Main.getPlugin().getConfig().getString("Mensagens.NaoPode").replace("&", "§"));
	          return true;
	        }
			if(args.length == 0) {
			sender.sendMessage(Main.getPlugin().getConfig().getString("Sintaxes.TnT").replace("&", "§"));
			}
			if(args.length > 0) {
			if(args[0].equalsIgnoreCase("on")) {
			Main.plugin.getConfig().set("TNT.Ativada", true);
			Main.plugin.saveConfig();
		    if (Main.plugin.getConfig().getBoolean("Variaveis.ActionBar")) {
		    	ActionBar.sendActionBarMessage(p, "§aVocê habilitou o uso da tnt!");
		    }
		    if (Main.plugin.getConfig().getBoolean("Variaveis.ActionBar")) {
				for(Player s : Bukkit.getOnlinePlayers()) {
					if (s.hasPermission("battlehost.redstonemanager")) {
		    	ActionBar.sendActionBarMessage(s, "§a" + p.getName() + " §7habilitou o uso da tnt.");
		    }
			}
			}
			sender.sendMessage(Main.getPlugin().getConfig().getString("TNTMSG.Habilitou").replace("&", "§"));
		    if (Main.plugin.getConfig().getBoolean("TNT.MsgGlobalON")) {
		        for (String m : Main.plugin.getConfig().getStringList("GlobalTnTON")) {
		            Bukkit.broadcastMessage(m.replace("&", "§").replace("{jogador}", p.getName()));
		          }
		    }
		    {
			}
			}
			if(args.length > 0) {
			if(args[0].equalsIgnoreCase("off")) {
			Main.plugin.getConfig().set("TNT.Ativada", false);
			Main.plugin.saveConfig();
		    if (Main.plugin.getConfig().getBoolean("Variaveis.ActionBar")) {
		    	ActionBar.sendActionBarMessage(p, "§aVocê desabilitou o uso da tnt!");
		    }
		    if (Main.plugin.getConfig().getBoolean("Variaveis.ActionBar")) {
				for(Player s : Bukkit.getOnlinePlayers()) {
					if (s.hasPermission("battlehost.redstonemanager")) {
		    	ActionBar.sendActionBarMessage(s, "§a" + p.getName() + " §7desabilitou o uso da tnt.");
		    }
			}
			}
		    
			sender.sendMessage(Main.getPlugin().getConfig().getString("TNTMSG.Desabilitou").replace("&", "§"));
		    if (Main.plugin.getConfig().getBoolean("TNT.MsgGlobalOFF")) {
		        for (String m2 : Main.plugin.getConfig().getStringList("GlobalTnTOFF")) {
		            Bukkit.broadcastMessage(m2.replace("&", "§").replace("{jogador}", p.getName()));
		          }
		    }
			}
			}
			}

	

	return false;
	}
		return false;
	}
}
