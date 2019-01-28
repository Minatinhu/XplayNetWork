package minato.kitpvp.main.habilidades;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import minato.kitpvp.main.kitmain.KitMain;
import minato.kitpvp.main.kittype.KitType;

public class Stomper extends KitMain implements Listener {

	@EventHandler
	public void habilidadeStomper(EntityDamageEvent e) {
		Player p = (Player) e.getEntity();
		if (e.getEntity() instanceof Player && e.getCause() == DamageCause.FALL) {
			if(kitpvp.get(p) == KitType.STOMPER) {
			for (Entity c : p.getNearbyEntities(3, 3, 3)) {
				if (c instanceof Player) {
					if (!((Player) c).isSneaking())
						((Player) c).damage(e.getDamage());
				} else if (c instanceof LivingEntity) {
					LivingEntity livingEntity = (LivingEntity) c;
					livingEntity.damage(e.getDamage());
				}
			}
			e.setDamage(e.getDamage() > 2 ? 2 : e.getDamage());
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1, 1);
		}
	}
}
}
