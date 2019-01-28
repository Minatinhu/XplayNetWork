package minato.kitpvp.main.eventos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import minato.kitpvp.main.kitmain.KitMain;

public class SoupEvent extends KitMain implements Listener {
	
	@EventHandler
	public void AntPickUP(PlayerPickupItemEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void AntDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if(e.getItemDrop().getItemStack().getType() != Material.BOWL) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void SoupFoodEvent(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getItem().getType() == Material.MUSHROOM_SOUP) {
				e.setCancelled(true);
				if (p.getHealth() != p.getMaxHealth()) {
					p.setHealth(p.getHealth() + 7.0d > p.getMaxHealth() ? p.getMaxHealth() : p.getHealth() + 7.0d);
					e.getItem().setType(Material.BOWL);
				}
			}
		}
	}
	
	
	@EventHandler
	public void placaint(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(e.getClickedBlock().getType() == Material.SIGN_POST || e.getClickedBlock().getType() == Material.WALL_SIGN) {
			Sign placa = (Sign) e.getClickedBlock();
			if(placa.getLine(0) == "§2Kit§cPvP" && placa.getLine(1) == "§bSopa") {
				Inventory inv = Bukkit.createInventory(null, 4*9, "§6Sopa");
				for(ItemStack i : inv.getContents()) {
					if(i == null) {
						inv.addItem(new ItemStack(Material.MUSHROOM_SOUP));
					}
				}
				p.openInventory(inv);
			}
		}
	}

	@EventHandler
	public void SignSoupEvent(SignChangeEvent e) {
		Player p = e.getPlayer();
		if(p.hasPermission("placa.de.sopa") || p.isOp()) {
			if(e.getLine(0).equalsIgnoreCase("sopa") | e.getLine(0).equalsIgnoreCase("Sopa")) {
				e.setLine(0, "§2Kit§cPvP");
				e.setLine(1, "§bSopa");
				((Sign)e.getBlock()).update();
			}
		}
	}

	@EventHandler
	public void antFoodChageEvent(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}

}
