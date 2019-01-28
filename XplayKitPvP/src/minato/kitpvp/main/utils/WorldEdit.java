package minato.kitpvp.main.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

public final class WorldEdit {

	public static WorldEdit getAPI() {
		return new WorldEdit();
	}

	public List<Location> getLocs(Location loc1, Location loc2) {
		double MinX = Math.min(loc1.getX(), loc2.getX());
		double MaxX = Math.max(loc1.getX(), loc2.getX());
		double MinY = Math.min(loc1.getY(), loc2.getY());
		double MaxY = Math.max(loc1.getY(), loc2.getY());
		double MinZ = Math.min(loc1.getZ(), loc2.getZ());
		double MaxZ = Math.max(loc1.getZ(), loc2.getZ());
		List<Location> locs = new ArrayList<>();
		for (int x = (int) MinX; x <= MaxX; x++) {
			for (int y = (int) MinY; y <= MaxY; y++) {
				for (int z = (int) MinZ; z <= MaxZ; z++) {
					locs.add(new Location(loc1.getWorld(), x, y, z));
				}
			}
		}
		return locs;
	}

}
