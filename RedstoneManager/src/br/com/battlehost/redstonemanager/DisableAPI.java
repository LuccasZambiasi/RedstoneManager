package br.com.battlehost.redstonemanager;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;

public class DisableAPI implements Listener
{
	  private Main Redstone;
	  
	  public DisableAPI(Main plugin)
	  {
	    this.Redstone = plugin;
	    
	    plugin.getServer().getPluginManager().registerEvents(this, plugin);
	  }
	  
	  @EventHandler
	  public void onRedStoneTorch(BlockPlaceEvent bpe)
	  {
	    Block placedBlock = bpe.getBlock();
	    Player player = bpe.getPlayer();
	    
	    List<String> disabledBlocks = this.Redstone.getConfig().getStringList("Blocos_Redstone");
	    if (this.Redstone.getConfig().getBoolean("Redstone.Desabilitar"))
	    {
	      if ((!this.Redstone.getConfig().getBoolean("TNT.Ativada")) && 
	        (placedBlock.getType().equals(Material.TNT)))
	      {
	        bpe.setCancelled(true);
	        player.sendMessage(Main.getPlugin().getConfig().getString("TNTMSG.TntOFF").replace("&", "§"));
	      }
	      for (String i : disabledBlocks) {
	        if (Material.getMaterial(i) == placedBlock.getType()) {
	          player.sendMessage(Main.getPlugin().getConfig().getString("RedstoneMSG.RedstoneOFF").replace("&", "§"));
	        bpe.setCancelled(true);
	        }
	      }
	    }
	  }
	  
	  @EventHandler
	  public void onBlockRedstone(BlockRedstoneEvent evt)
	  {
	    if (this.Redstone.getConfig().getBoolean("Redstone.Desabilitar")) {
	      evt.setNewCurrent(0);
	    }
	  }
	}
