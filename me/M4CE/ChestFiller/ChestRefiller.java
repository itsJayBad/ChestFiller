package me.M4CE.ChestFiller;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class ChestRefiller extends JavaPlugin {
	
	public static ArrayList<Location> refilledChests = new ArrayList<Location>();
	public static ArrayList<Material> refillMaterial = new ArrayList<Material>();
	
	@Override
	public void onEnable() {
		
		ConfigYML.create();
		ConfigYML.load();
		
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN +">> "+ChatColor.BOLD+ "ChestRefiller " + ChatColor.YELLOW +ChatColor.BOLD+ getDescription().getVersion() + ChatColor.GREEN + " <<");
		
	}

	@Override
	public void onDisable() {
		
		
		
	}

	public boolean onCommand(final CommandSender sender, Command cmd,
			String cmdLabel, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("refillchests")) {
			
			refilledChests.clear();
			ChestRefiller.fill(((Player)sender).getWorld().getName());
			sender.sendMessage(ChatColor.GREEN + "All chests in loaded chunks have been refilled.");
			
			return true;
		}
		
		return false;
	}
	
	public static void fill(String world)
	  {
	    World w = Bukkit.getWorld(world);
	    for (Chunk c : w.getLoadedChunks()) {
	      for (BlockState block : c.getTileEntities()) {
	        if ((block instanceof Chest))
	        {
	        	if (!ChestRefiller.refilledChests.contains(block.getLocation())) {
	        		Chest chest = (Chest)block;
	        		chest.getBlockInventory().clear();
	  	          	fillChest(chest);
	        	}
	        }
	      }
	    }
	  }
	
	public static void fillChest (Chest c) {
		
		for (int i = 0; i < 5; i++) {
			c.getBlockInventory().setItem((int)(c.getBlockInventory().getSize()*Math.random()), new ItemStack(refillMaterial.get((int)(refillMaterial.size()*Math.random()))));
		}
		
	}
	
	
}