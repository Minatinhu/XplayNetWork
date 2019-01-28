package minato.kitpvp.main.kitmain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import minato.kitpvp.main.kittype.KitType;

public abstract class KitMain {
	
	public static Map<Player, KitType> kitpvp = new HashMap<>();
	public static Map<Player, String> nomedokit  = new HashMap<>();
	public static Map<Player, Integer> sequencia = new HashMap<>();
	public static List<Player> estaFPS = new ArrayList<>();
	
	public static void addKit(Player p, KitType kit) {
		p.getInventory().clear();
		switch(kit) {
		case ARCHER:
			p.getInventory().setItem(0, new ItemStack(Material.STONE_SWORD));
			p.getInventory().setItem(1, new ItemStack(Material.BOW));
			p.getInventory().setItem(2, new ItemStack(Material.ARROW, 50));
			nomedokit.put(p, "§2Archer");
			kitpvp.put(p, KitType.ARCHER);
			break;
		case CAMEL:
			p.getInventory().setItem(0, new ItemStack(Material.STONE_SWORD));
			nomedokit.put(p, "§eCamel");
			kitpvp.put(p, KitType.CAMEL);
			break;
		case DEFAULT:
			kitpvp.put(p, KitType.DEFAULT);
			nomedokit.put(p, "§7Default");
			p.getInventory().setItem(0, new ItemStack(Material.STONE_SWORD));
			break;
		case STOMPER:
			p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
			p.getInventory().setItem(0, new ItemStack(Material.STONE_SWORD));
			nomedokit.put(p, "§4Stomper");
			kitpvp.put(p, KitType.STOMPER);
			break;
		case NINJA:
			p.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999, 4));
			nomedokit.put(p, "§3Ninja");
			kitpvp.put(p, KitType.NINJA);
			break;
		case VIPER:
			p.getInventory().setItem(0, new ItemStack(Material.STONE_SWORD));
			ItemStack i = new ItemStack(Material.SPIDER_EYE);
			ItemMeta meta = i.getItemMeta();
			meta.setDisplayName("§6Habilidade");
			i.setItemMeta(meta);
			p.getInventory().setItem(1, i);
			break;
		default:
			break;
		
		}
		for(ItemStack i : p.getInventory().getContents()) {
			if(i == null) {
				p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
			}
		}
	}
	
	public static boolean hasKit(Player p, KitType kit) {
		return kitpvp.get(p) == kit;
	}
	public static boolean hasKit(Player p) {
		return kitpvp.containsKey(p);
	}

}
