package freeze;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class Listeners implements Listener {

	@SuppressWarnings("static-access")
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		if (!Arrays.asList(Freeze.frozen).contains(e.getPlayer())) {
			return;
		}
		if (Arrays.asList(Freeze.frozen).contains(e.getPlayer())) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(ChatColor.DARK_AQUA + "You can't move! Your" + ChatColor.WHITE.ITALIC + "frozen!");
		}
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		if (Arrays.asList(Freeze.frozen).contains(e.getPlayer())) {
			Arrays.asList(Freeze.frozen).remove(e.getPlayer());
			Bukkit.getServer().getPluginManager().callEvent(new PlayerUnfrozenEvent(e.getPlayer()));
		}
	}
	@SuppressWarnings("static-access")
	public void onPlayerTeleport(PlayerTeleportEvent e) {
		if (!Arrays.asList(Freeze.frozen).contains(e.getPlayer())) {
			return;
		}
		if (Arrays.asList(Freeze.frozen).contains(e.getPlayer())) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(ChatColor.DARK_AQUA + "You can't teleport! Your" + ChatColor.WHITE.ITALIC + "frozen!");
		}
	}
}
