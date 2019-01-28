package minato.kitpvp.main.eventos;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ChatEvent implements Listener{
	
	@EventHandler
	public void a(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(p.hasPermission("xplayplugin.cor")) {
			e.setFormat(ChatColor.translateAlternateColorCodes('&', PermissionsEx.getUser(p).getPrefix()) + " §f" + p.getName() +  " >> "+ ChatColor.translateAlternateColorCodes('&', e.getMessage()));
		} else {
			e.setFormat(ChatColor.translateAlternateColorCodes('&', PermissionsEx.getUser(p).getPrefix()) + " §f" + p.getName() + " >> " + e.getMessage());
		}
	}

}
