package freeze;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Freeze extends JavaPlugin {

	public static Player[] frozen;
	
	public void onEnable() {
		getLogger().info("Freeze API version 0.1 Enabled!");
		getCommand("freeze").setExecutor(new FreezeCommandExecuter());
		getCommand("unfreeze").setExecutor(new FreezeCommandExecuter());
		getServer().getPluginManager().registerEvents(new Listeners(), this);
	}
	public void onDisable() {
		getLogger().info("Freeze API version 0.1 Disabled!");
	}
	
}
