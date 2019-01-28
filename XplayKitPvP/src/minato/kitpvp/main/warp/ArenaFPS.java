package minato.kitpvp.main.warp;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class ArenaFPS extends Warp{
	
	public ArenaFPS() {
		super("ArenaFPS", new Location(Bukkit.getWorld("ArenaFPS"), 11.491, 72, -1.404, (float) -89.3, (float) 0.6));
	}
	
	public static ArenaFPS getAPI() {
		return new ArenaFPS();
	}
	
	public void teleportar(Player p) {
		p.teleport(super.getLoc());
	}
	
	public Location getLoc() {
		return super.getLoc();
	}
	
}
