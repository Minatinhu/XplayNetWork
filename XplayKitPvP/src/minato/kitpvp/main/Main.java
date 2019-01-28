package minato.kitpvp.main;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import minato.kitpvp.main.eventos.ChatEvent;
import minato.kitpvp.main.eventos.Esponja;
import minato.kitpvp.main.eventos.InteractOpen;
import minato.kitpvp.main.eventos.JoinLeave;
import minato.kitpvp.main.eventos.SoupEvent;
import minato.kitpvp.main.habilidades.Camel;
import minato.kitpvp.main.habilidades.Stomper;
import minato.kitpvp.main.scoreboard.Score;

public class Main extends JavaPlugin {

	private static Main instance;

	public void onEnable() {
		setInstance(this);
		getServer().getPluginManager().registerEvents(new JoinLeave(), this);
		getServer().getPluginManager().registerEvents(new InteractOpen(), this);
		getServer().getPluginManager().registerEvents(new SoupEvent(), this);
		getServer().getPluginManager().registerEvents(new Esponja(), this);
		getServer().getPluginManager().registerEvents(new ChatEvent(), this);
		// Kits
		getServer().getPluginManager().registerEvents(new Stomper(), this);
		getServer().getPluginManager().registerEvents(new Camel(), this);
		Score.run();
		new BukkitRunnable() {

			@Override
			public void run() {
				sempreDia();
				semchuva();
			}
		}.runTaskTimer(this, 60L, 1200L);
	}

	void semchuva() {
		World world = Bukkit.getWorld("kitpvp");
		world.setWeatherDuration(0);
	}

	void sempreDia() {
		World world = Bukkit.getWorld("kitpvp");
		if (world.getTime() < 19000 | world.getTime() < 12000) {
			world.setTime(0);
		}
	}

	public static Main getInstance() {
		return instance;
	}

	public static void setInstance(Main instance) {
		Main.instance = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("limparchat")) {
			Player p = (Player) sender;
			if (p.hasPermission("xkitpvp.limparchat")) {
				if (args.length == 0) {
					new BukkitRunnable() {

						@Override
						public void run() {
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage(
									"§f                                                                         §4");
							Bukkit.broadcastMessage("§cChat limpo por " + p.getName());

						}
					}.runTask(this);
				}
			}
		}
		return false;
	}

}
