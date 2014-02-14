package freeze;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerFrozenEvent extends Event {
	
	Player p;
	
	public PlayerFrozenEvent(Player p) {
		this.p = p;
	}
	
	public Player getPlayer() {
		return p;
	}
	
	private static final HandlerList handlers = new HandlerList();
	 
	public HandlerList getHandlers() {
	    return handlers;
	}
	 
	public static HandlerList getHandlerList() {
	    return handlers;
	}
}
