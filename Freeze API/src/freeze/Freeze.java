package freeze;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Freeze extends JavaPlugin {

	public static Player[] frozen;
	
	public void onEnable() {
		getLogger().info("Freeze API version 1.0 Enabled!");
		getServer().getPluginManager().registerEvents(new Listeners(), this);
	}
	public void onDisable() {
		getLogger().info("Freeze API version 1.0 Disabled!");
	}
	
	public static void freezePlayer(Player p) {
		if (Arrays.asList(Freeze.frozen).contains(p)) {
			return;
		}
		Arrays.asList(Freeze.frozen).add(p);
		Bukkit.getServer().getPluginManager().callEvent(new PlayerFrozen(p));
	}
	public static void unfreezePlayer(Player p) {
		if (!Arrays.asList(Freeze.frozen).contains(p)) {
			return;
		}
		Arrays.asList(Freeze.frozen).remove(p);
		Bukkit.getServer().getPluginManager().callEvent(new PlayerUnfrozen(p));
	}
	
}
