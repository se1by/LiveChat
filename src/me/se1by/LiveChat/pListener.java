package me.se1by.LiveChat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerListener;

public class pListener extends PlayerListener{
	public LiveChat plugin;
	String name;
	String city;
	String prefix;
	String suffix;
	
	public  pListener(LiveChat LiveChat){
		plugin = LiveChat;
	}
	
	public void onPlayerChat(PlayerChatEvent event) {
		if (event.isCancelled()){
			return;
		}
	    Player player =event.getPlayer();
	    String msg = event.getMessage();
	    GroupManager gm = new GroupManager(player, plugin);
	    name = gm.getName();
	    name = addColor(name);
	    msg = addColor(msg);
	    event.setFormat( ChatColor.GRAY + name + ChatColor.WHITE + " : " +  msg);
	  }
	
	public String addColor(String msg)
	{
		msg = msg.replace("&red", ChatColor.RED + "");
	    msg = msg.replace("&Red", ChatColor.RED + "");
	    msg = msg.replace("&blue", ChatColor.BLUE + "");
	    msg = msg.replace("&Blue", ChatColor.DARK_BLUE + "");
	    msg = msg.replace("&green", ChatColor.GREEN + "");
	    msg = msg.replace("&Green", ChatColor.DARK_GREEN + "");
	    msg = msg.replace("&yellow", ChatColor.YELLOW + "");
	    msg = msg.replace("&white", ChatColor.WHITE + "");
	    msg = msg.replace("&gold", ChatColor.GOLD + "");
	    msg = msg.replace("&black", ChatColor.BLACK + "");
	    msg = msg.replace("&gray", ChatColor.GRAY + "");
	    msg = msg.replace("&Gray", ChatColor.DARK_GRAY + "");
	    msg = msg.replace("&aqua", ChatColor.AQUA + "");
	    msg = msg.replace("&Aqua", ChatColor.DARK_AQUA + "");
	    msg = msg.replace("&purple", ChatColor.LIGHT_PURPLE + "");
	   return msg = msg.replace("&Purple", ChatColor.DARK_PURPLE + "");
	    
	}
}

