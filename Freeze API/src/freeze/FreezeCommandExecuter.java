package freeze;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreezeCommandExecuter implements CommandExecutor {

	private Freeze plugin;
	 
	public void FreezeCommandExecutor(Freeze plugin) {
		this.plugin = plugin;
	}
 
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("freeze")) {
			if (!(args.length == 1)) {
				sender.sendMessage(ChatColor.RED + "Uh oh! Incorrect usage! /freeze [player]");
				return true;
			}
			Player p = Bukkit.getPlayerExact(args[0]);
			if (!(p.isOnline())) {
				sender.sendMessage(ChatColor.RED + "The specified player is not online! Be sure to type the full name or the first few characters and [tab]");
				return true;
			}
			if (Arrays.asList(Freeze.frozen).contains(p)) {
				sender.sendMessage(ChatColor.RED + "Player is already frozen!");
				return true;
			} else {
				Arrays.asList(Freeze.frozen).add(p);
				Bukkit.getServer().getPluginManager().callEvent(new PlayerFrozenEvent(p));
				return true;
			}
		}
		if (cmd.getName().equalsIgnoreCase("unfreeze")) {
			if (!(args.length == 1)) {
				sender.sendMessage(ChatColor.RED + "Uh oh! Incorrect usage! /unfreeze [player]");
				return true;
			}
			Player p = Bukkit.getPlayerExact(args[0]);
			if (!(p.isOnline())) {
				sender.sendMessage(ChatColor.RED + "The specified player is not online! Be sure to type the full name or the first few characters and [tab]");
				return true;
			}
			if (!Arrays.asList(Freeze.frozen).contains(p)) {
				sender.sendMessage(ChatColor.RED + "Player is not frozen!");
				return true;
			} else {
				Arrays.asList(Freeze.frozen).remove(p);
				Bukkit.getServer().getPluginManager().callEvent(new PlayerUnfrozenEvent(p));
				return true;
			}
		}
		return false;
	}
	
}
