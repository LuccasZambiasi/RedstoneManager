package br.com.battlehost.redstonemanager;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class redstone implements CommandExecutor{


	
	@SuppressWarnings({ })
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cApenas jogadores podem executar esse comando");
			return true;
		}
		final Player p = (Player) sender;
	
		if(cmd.getName().equalsIgnoreCase("redstone")) {
		        if (!p.hasPermission("battlehost.redstonemanager"))
		        {
		          p.sendMessage(Main.getPlugin().getConfig().getString("Mensagens.NaoPode").replace("&", "§"));
		          return true;
		        }
		        if(args.length == 0) {
			sender.sendMessage(Main.getPlugin().getConfig().getString("Sintaxes.Redstone").replace("&", "§"));
			}
			if(args.length > 0) {
			if(args[0].equalsIgnoreCase("on")) {
			Main.plugin.getConfig().set("Redstone.Desabilitar", false);
			Main.plugin.saveConfig();
			sender.sendMessage(Main.getPlugin().getConfig().getString("RedstoneMSG.Habilitou").replace("&", "§"));
		    if (Main.plugin.getConfig().getBoolean("Redstone.MsgGlobalON")) {
		        for (String m : Main.plugin.getConfig().getStringList("GlobalRedstoneON")) {
		            Bukkit.broadcastMessage(m.replace("&", "§").replace("{jogador}", p.getName()));
		          }
		    }
		
			}
		
			if(args.length > 0) {
			if(args[0].equalsIgnoreCase("off")) {
			Main.plugin.getConfig().set("Redstone.Desabilitar", true);
			Main.plugin.saveConfig();
			sender.sendMessage(Main.getPlugin().getConfig().getString("RedstoneMSG.Desabilitou").replace("&", "§"));
		    if (Main.plugin.getConfig().getBoolean("Redstone.MsgGlobalOFF")) {
		        for (String m2 : Main.plugin.getConfig().getStringList("GlobalRedstoneOFF")) {
		            Bukkit.broadcastMessage(m2.replace("&", "§").replace("{jogador}", p.getName()));
		          }
		    }

			}

	

	return false;
	}

		    }
			}
			
		
		return false;
	}
}

