package me.se1by.LiveChat;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;
import org.bukkit.plugin.Plugin;

public class LiveChat extends JavaPlugin{
	public PermissionHandler permissionHandler;
	public static YamlConfiguration config = new YamlConfiguration();
	private final pListener playerListener = new pListener(this);

	@Override
	public void onDisable() {
		System.out.println("[LiveChat] disabled");
		
	}

	@Override
	public void onEnable() {
		  setupPermissions();
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_CHAT, this.playerListener, Event.Priority.Normal, this);
		System.out.println("[LiveChat] enabled");		
	}
	
	private void setupPermissions() {
	    if (permissionHandler != null) {
	        return;
	    }
	    
	    Plugin permissionsPlugin = this.getServer().getPluginManager().getPlugin("Permissions");
	    
	    if (permissionsPlugin == null) {
	        System.out.println("Permission system not detected, defaulting to OP");
	        return;
	    }
	    
	    permissionHandler = ((Permissions) permissionsPlugin).getHandler();
	    System.out.println("Found and will use plugin "+((Permissions)permissionsPlugin).getDescription().getFullName());
	}

}
