package minato.kitpvp.main.eventos;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import minato.kitpvp.main.kitmain.KitMain;
import minato.kitpvp.main.kittype.KitType;
import minato.kitpvp.main.warp.ArenaFPS;

public class InteractOpen extends KitMain implements Listener {

	@EventHandler
	public void Interact(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK
				| e.getAction() == Action.LEFT_CLICK_AIR | e.getAction() == Action.LEFT_CLICK_BLOCK) {
			Player p = e.getPlayer();
			if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2Warps")) {
				e.setCancelled(true);
				Inventory inv = Bukkit.createInventory(null, 3 * 9, "§bWarps");
				ItemStack i = new ItemStack(Material.GRASS);
				ItemMeta meta = i.getItemMeta();
				meta.setDisplayName("§cBiomas-KitPvP");
				i.setItemMeta(meta);
				ItemStack i2 = new ItemStack(Material.GLASS);
				ItemMeta meta2 = i2.getItemMeta();
				meta2.setDisplayName("§bArena-FPS");
				i2.setItemMeta(meta2);
				inv.setItem(12, i);
				inv.setItem(14, i2);
				p.openInventory(inv);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1f, 1f);
			}
			if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bKit§cSelector")) {
				e.setCancelled(true);
				Inventory inv = Bukkit.createInventory(null, 4 * 9, "§2Seus Kits");
				for (KitType kit : KitType.values()) {
					switch (kit) {
					case ARCHER:
						ItemStack i2 = new ItemStack(Material.BOW);
						ItemMeta meta2 = i2.getItemMeta();
						meta2.setDisplayName("§2Archer");
						String[] lore2 = {
								"§bO kit §2archer possui um arque flecha com 50 flechas e uma espada de pedra" };
						meta2.setLore(Arrays.asList(lore2));
						i2.setItemMeta(meta2);
						inv.setItem(1, i2);
						break;
					case CAMEL:
						ItemStack i7 = new ItemStack(Material.SAND);
						ItemMeta meta7 = i7.getItemMeta();
						meta7.setDisplayName("§eCamel");
						String[] lore7 = { "§bQuando você esta em cima da areia você ganha speed 3" };
						meta7.setLore(Arrays.asList(lore7));
						i7.setItemMeta(meta7);
						inv.setItem(3, i7);
						break;
					case DEFAULT:
						ItemStack i = new ItemStack(Material.STONE_SWORD);
						ItemMeta meta = i.getItemMeta();
						meta.setDisplayName("§7Default");
						String[] lore = { "§2O kit §7default§2 você vai ganhar uma espada de pedra" };
						meta.setLore(Arrays.asList(lore));
						i.setItemMeta(meta);
						inv.setItem(0, i);
						break;
					case STOMPER:
						ItemStack i3 = new ItemStack(Material.IRON_BOOTS);
						ItemMeta meta3 = i3.getItemMeta();
						meta3.setDisplayName("§cStomper");
						String[] lore3 = { "§4Um kit feito para você pissar os incetos." };
						meta3.setLore(Arrays.asList(lore3));
						i3.setItemMeta(meta3);
						inv.setItem(2, i3);
						break;
					case NINJA:
						ItemStack i5 = new ItemStack(Material.POTION);
						ItemMeta meta5 = i5.getItemMeta();
						meta5.setDisplayName("§3§lNinja");
						String[] lore6 = { "§6Com o kit ninja você ganha velociadade 4" };
						meta5.setLore(Arrays.asList(lore6));
						i5.setItemMeta(meta5);
						inv.setItem(4, i5);
						break;
					case VIPER:
						ItemStack i6 = new ItemStack(Material.SPIDER_EYE);
						ItemMeta meta6 = i6.getItemMeta();
						meta6.setDisplayName("§6§lViper");
						String[] lore8 = {"§6Quando você usa sua habilidade no seu inimigo ele recebe veneno 3 "};
						meta6.setLore(Arrays.asList(lore8));
						i6.setItemMeta(meta6);
						inv.setItem(5, i6);
						break;
					default:
						break;

					}
				}
				p.openInventory(inv);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1f, 1f);
			}
		}
		;
	}

	@EventHandler
	public void KitSelector(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getClickedInventory().getTitle().equalsIgnoreCase("§bWarps")) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBiomas-KitPvP")) {
				p.teleport(new Location(Bukkit.getWorld("kitpvp"), 2.416, 20, 9.429, -179, 5));
				if (estaFPS.contains(p)) {
					estaFPS.remove(p);
				}
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bArena-FPS")) {
				ArenaFPS a = new ArenaFPS();
				if (!estaFPS.contains(p)) {
					estaFPS.add(p);
				}
				a.teleportar(p);
			}
			e.setCancelled(true);
			p.closeInventory();
		}
		if (e.getClickedInventory().getType() == InventoryType.PLAYER) {
			if (!kitpvp.containsKey(p)) {
				e.setCancelled(true);
			}
			if (p.hasPermission("xkitpvp.inv")) {
				e.setCancelled(false);
			}
		}
		if (e.getClickedInventory().getTitle().equalsIgnoreCase("§2Seus Kits")) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Default")) {
				addKit(p, KitType.DEFAULT);
				p.closeInventory();
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2Archer")) {
				addKit(p, KitType.ARCHER);
				p.closeInventory();
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cStomper")) {
				addKit(p, KitType.STOMPER);
				p.closeInventory();
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eCamel")) {
				addKit(p, KitType.CAMEL);
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§lNinja")) {
				addKit(p, KitType.NINJA);
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lViper")) {
				addKit(p, KitType.VIPER);
			}
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage(ChatColor.GREEN + "Você escolheu o kit " + nomedokit.get(p));
		}
	}
}
