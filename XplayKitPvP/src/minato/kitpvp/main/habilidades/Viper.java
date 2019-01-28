package minato.kitpvp.main.habilidades;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import minato.kitpvp.main.kitmain.KitMain;
import minato.kitpvp.main.kittype.KitType;

public class Viper extends KitMain implements Listener {

	@EventHandler
	public void ViperEvent(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		if(hasKit(p, KitType.VIPER) && hasKit((Player) e.getRightClicked())) {
			
		}
	}

}
