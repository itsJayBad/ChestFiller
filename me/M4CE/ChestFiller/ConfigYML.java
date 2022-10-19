package me.M4CE.ChestFiller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigYML {
	
	public static void load() {
		FileConfiguration fc = Bukkit.getPluginManager().getPlugin("ChestRefiller").getConfig();
		for (String s : fc.getStringList("ChestRefiller.ItemTypes")) {
			ChestRefiller.refillMaterial.add(Material.valueOf(s));
		}
	}
	
	public static void create() {
		
		try {
			
			File f = new File("plugins/ChestRefiller/");
			f.mkdirs();
			
			f = new File("plugins/ChestRefiller/config.yml");
			if (!f.exists()) {
				f.createNewFile();
			
				FileWriter fw = new FileWriter(f);
				
				fw.write("# ChestRefiller Configuration File\n");
				fw.write("ChestRefiller:\n");
				fw.write("  # With which Item Types should the chests be refilled?\n");
				fw.write("  ItemTypes:\n");
				fw.write("    - LEATHER_HELMET\n");
				fw.write("    - LEATHER_CHESTPLATE\n");
				fw.write("    - LEATHER_LEGGINGS\n");
				fw.write("    - LEATHER_BOOTS\n");
				fw.write("    - GOLD_HELMET\n");
				fw.write("    - GOLD_CHESTPLATE\n");
				fw.write("    - GOLD_LEGGINGS\n");
				fw.write("    - GOLD_BOOTS\n");
				fw.write("    - CHAINMAIL_HELMET\n");
				fw.write("    - CHAINMAIL_CHESTPLATE\n");
				fw.write("    - CHAINMAIL_LEGGINGS\n");
				fw.write("    - CHAINMAIL_BOOTS\n");
				fw.write("    - IRON_HELMET\n");
				fw.write("    - IRON_CHESTPLATE\n");
				fw.write("    - IRON_LEGGINGS\n");
				fw.write("    - IRON_BOOTS\n");
				fw.write("    - DIAMOND_HELMET\n");
				fw.write("    - DIAMOND_CHESTPLATE\n");
				fw.write("    - DIAMOND_LEGGINGS\n");
				fw.write("    - DIAMOND_BOOTS\n");
				fw.write("    - WOODEN_SWORD\n");
				fw.write("    - STONE_SWORD\n");
				fw.write("    - GOLD_SWORD\n");
				fw.write("    - IRON_SWORD\n");
				fw.write("    - DIAMOND_SWORD\n");
				fw.write("    - WOODEN_AXE\n");
				fw.write("    - STONE_AXE\n");
				fw.write("    - SHEILD\n");
				fw.write("    - GOLDEN_APPLE\n");
				fw.write("    - FISHING_ROD\n");
				fw.write("    - BOW\n");
				fw.write("    - ARROW\n");
				fw.write("    - ARROW\n");
				fw.write("    - ARROW\n");
				fw.write("    - ARROW\n");
				fw.write("    - ARROW\n");
				fw.write("    - COOKED_BEEF\n");
				fw.write("    - COOKED_PORKCHOP\n");
				fw.write("    - COOKED_MUTTON\n");
				fw.write("    - BAKED_POTATO\n");
				fw.write("    - GOLDEN_CARROT\n");
				fw.write("    - BOTTLE_O'_ENCHANTING\n");
				fw.write("    - BOTTLE_O'_ENCHANTING\n");
				fw.write("    - BOTTLE_O'_ENCHANTING\n");
				fw.write("    - BOTTLE_O'_ENCHANTING\n");
				fw.write("    - BOTTLE_O'_ENCHANTING\n");
				fw.write("    - DIAMOND\n");
				fw.write("    - IRON_INGOT\n");
				fw.write("    - LAPIS_LAZULI\n");
				fw.write("    - STICK\n");
				fw.write("    - WATER_BUCKET\n");
				
				fw.flush();
				fw.close();
				
				Bukkit.getPluginManager().getPlugin("ChestRefiller").saveDefaultConfig();
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
