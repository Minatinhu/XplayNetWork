package minato.kitpvp.main.warp;

import org.bukkit.Location;

public class Warp {
	
	private String name;
	private Location loc;
	
	
	public Warp(String name, Location loc) {
		setName(name);
		setLoc(loc);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Location getLoc() {
		return loc;
	}


	public void setLoc(Location loc) {
		this.loc = loc;
	}

}
