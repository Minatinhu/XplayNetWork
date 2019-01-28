package minato.kitpvp.main.eventos;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import minato.kitpvp.main.Main;
import minato.kitpvp.main.kitmain.KitMain;
import minato.kitpvp.main.scoreboard.Score;
import minato.kitpvp.main.warp.ArenaFPS;

public class JoinLeave extends KitMain implements Listener {

	@EventHandler
	public void Join(PlayerJoinEvent e) {
		e.setJoinMessage(null);
		Player p = e.getPlayer();
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		sequencia.put(p, 0);
		Score.build(p);
		Location l = new Location(Bukkit.getWorld("kitpvp"), 2.416, 20, 9.429, -179, 5);
		p.teleport(l);
		nomedokit.put(p, "§fNenhum");
		ItemStack i = new ItemStack(Material.ENDER_CHEST);
		ItemMeta meta = i.getItemMeta();
		meta.setDisplayName("§bKit§cSelector");
		i.setItemMeta(meta);
		p.getInventory().setItem(1, i);
		ItemStack i2 = new ItemStack(Material.CHEST);
		ItemMeta meta2 = i2.getItemMeta();
		meta2.setDisplayName("§4Loja");
		i2.setItemMeta(meta2);
		p.getInventory().setItem(4, i2);
		ItemStack i3 = new ItemStack(Material.BEACON);
		ItemMeta meta3 = i3.getItemMeta();
		meta3.setDisplayName("§2Warps");
		i3.setItemMeta(meta3);
		p.getInventory().setItem(7, i3);
	}

	@EventHandler
	public void Leave(PlayerQuitEvent e) {
		e.setQuitMessage(null);
		if (hasKit(e.getPlayer())) {
			kitpvp.remove(e.getPlayer());
		}
		if (nomedokit.containsKey(e.getPlayer())) {
			nomedokit.remove(e.getPlayer());
		}
	}

	@EventHandler
	public void DeathEvent(PlayerDeathEvent e) {
		e.setDeathMessage(null);
		Player p = e.getEntity();
		p.spigot().respawn();
		sequencia.put(p, 0);
		sequencia.put(p.getKiller(), sequencia.get(p.getKiller()) + 1);
		if (sequencia.get(p.getKiller()) >= 3) {
			Bukkit.broadcastMessage("O player " + p.getName() + " esta com sequencia de "
					+ sequencia.get(p.getKiller()));
		}
			
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void RespownEvent(PlayerRespawnEvent e) {
		Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), new Runnable() {
			public void run() {
				Player p = e.getPlayer();
				Location l = new Location(Bukkit.getWorld("kitpvp"), 2.416, 20, 9.429, -179, 5);
				if(estaFPS.contains(p)) {
					e.setRespawnLocation(ArenaFPS.getAPI().getLoc());
				}
				if(!estaFPS.contains(p)) {
					e.setRespawnLocation(l);
				}
				nomedokit.put(p, "§fNenhum");
				ItemStack i = new ItemStack(Material.ENDER_CHEST);
				ItemMeta meta = i.getItemMeta();
				meta.setDisplayName("§bKit§cSelector");
				i.setItemMeta(meta);
				p.getInventory().setItem(1, i);
				ItemStack i2 = new ItemStack(Material.CHEST);
				ItemMeta meta2 = i2.getItemMeta();
				meta2.setDisplayName("§4Loja");
				i2.setItemMeta(meta2);
				p.getInventory().setItem(4, i2);
				ItemStack i3 = new ItemStack(Material.BEACON);
				ItemMeta meta3 = i3.getItemMeta();
				meta3.setDisplayName("§2Warps");
				i3.setItemMeta(meta3);
				p.getInventory().setItem(7, i3);
			}
		});
	}

}
