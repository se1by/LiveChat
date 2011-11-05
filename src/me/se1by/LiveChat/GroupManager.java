package me.se1by.LiveChat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
public class GroupManager {
	YamlConfiguration group = new YamlConfiguration();
	Player player;
	String prefix;
	String suffix;
	LiveChat plugin;

	public GroupManager(Player player, LiveChat LiveChat){
		this.player = player;
		this.plugin = LiveChat;
	}
	public String getName(){
		createFiles();
		checkGroups();
		return name();
	}
	
	public void checkGroups(){
		try {
			group.load("plugins/LiveChat/groups.yml");
		} catch (FileNotFoundException e) {
			System.out.println("[LiveChat] File groups.yml not found!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[LiveChat] IOException with file groups.yml!");
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			System.out.println("[LiveChat] Invalid Configuration (File: groups.yml)!");
			e.printStackTrace();
		}
		Set<String> groups = group.getKeys(false);
		for (String Group : groups){
			if (plugin.permissionHandler.has(player, "LiveChat." + Group)) {
			      
			  
				if (!((group.getString( Group + ".Prefix")) == null)){
					if(!(this.prefix == null)){
						this.prefix = prefix + group.getString(Group + ".Prefix");
					}
					else{
						this.prefix = group.getString(Group + ".Prefix");
					}
				}
				if (!((group.getString( Group + ".Suffix")) == null)){
					if (!(this.suffix == null)){
						this.suffix = suffix + group.getString(Group + ".Suffix");
					}
					else{
						this.suffix =  group.getString(Group + ".Suffix");
					}
				}
			}
		}
	}
	
	public String name(){
		String name;
		name =  prefix + ChatColor.GRAY + player.getName() + suffix;
		name = name.replace("null", "");
		return name;
	}
	
	public void createFiles(){
		boolean exists = (new File("plugins/LiveChat/groups.yml")).exists();
		if(!exists)
		{
			group.set("Miner.Prefix", "[Miner]");
			group.set("Miner.Suffix", null);
			try {
				group.save("plugins/LiveChat/groups.yml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean isNull (String string){
		if(string == null){
			return true;
		}
		else{
			return false;
		}
	}

}
