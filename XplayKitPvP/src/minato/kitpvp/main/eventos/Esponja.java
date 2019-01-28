package minato.kitpvp.main.eventos;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class Esponja implements Listener{
	
	@EventHandler
	public void upSponge(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SPONGE) {
				p.setVelocity(new Vector(0, 3, 0));
		}
	}

}
