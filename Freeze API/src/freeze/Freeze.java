package freeze;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Freeze extends JavaPlugin {

	public static Player[] frozen;
	
	public void onEnable() {
		getLogger().info("Freeze API version 0.1 Enabled!");
		getServer().getPluginManager().registerEvents(new Listeners(), this);
	}
	public void onDisable() {
		getLogger().info("Freeze API version 0.1 Disabled!");
	}
	
	public static void freezePlayer(Player p) {
		Arrays.asList(Freeze.frozen).add(p);
		Bukkit.getServer().getPluginManager().callEvent(new PlayerFrozenEvent(p));
	}
	public static void unfreezePlayer(Player p) {
		Arrays.asList(Freeze.frozen).remove(p);
		Bukkit.getServer().getPluginManager().callEvent(new PlayerUnfrozenEvent(p));
	}
	
}
