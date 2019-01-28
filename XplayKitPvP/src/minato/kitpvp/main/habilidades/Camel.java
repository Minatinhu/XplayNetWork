package minato.kitpvp.main.habilidades;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import minato.kitpvp.main.kitmain.KitMain;
import minato.kitpvp.main.kittype.KitType;

public class Camel extends KitMain implements Listener {

	@EventHandler
	public void a(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (hasKit(p, KitType.CAMEL)) {
			if (p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SAND) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 3));
			} else {
				if(p.hasPotionEffect(PotionEffectType.SPEED)) {
					p.removePotionEffect(PotionEffectType.SPEED);
				}
			}
		}
	}

}
