package minato.kitpvp.main.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import minato.kitpvp.main.Main;
import minato.kitpvp.main.kitmain.KitMain;
import minato.xcoins.api.XcoinsAPI;
import ru.tehkode.permissions.bukkit.PermissionsEx;
public class Score extends KitMain{
	
	public static void run() {
		new BukkitRunnable() {
			
			@Override
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()) {
					update(p.getScoreboard(), p);
				}
				
			}
		}.runTaskTimer(Main.getInstance(), 0, 3);
	}
	
	@SuppressWarnings("deprecation")
	public static void build(Player p) {
		Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = s.registerNewObjective("score", "dummy");
		obj.setDisplayName("     §bKit§cPvP    ");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		//Line 15
		obj.getScore(Bukkit.getOfflinePlayer("    §7@XplayNetWork   ")).setScore(15);
		// Line 14
		obj.getScore(Bukkit.getOfflinePlayer("§4")).setScore(14);
		// Line 13
		obj.getScore(Bukkit.getOfflinePlayer("§fNick:§b ")).setScore(13);
		Team t1 = s.registerNewTeam("nick");
		t1.addPlayer(Bukkit.getOfflinePlayer("§fNick:§b "));
		// Line 12
		obj.getScore(Bukkit.getOfflinePlayer("§fGrupo: ")).setScore(12);
		Team t2 = s.registerNewTeam("grupo");
		t2.addPlayer(Bukkit.getOfflinePlayer("§fGrupo: "));
		// Line 11
		obj.getScore(Bukkit.getOfflinePlayer("§fXCoins:§b ")).setScore(11);;
		Team t8 = s.registerNewTeam("xcoins");
		t8.addPlayer(Bukkit.getOfflinePlayer("§fXCoins:§b "));
		// Line 10
		obj.getScore(Bukkit.getOfflinePlayer("§f")).setScore(10);
		// Line 9
		obj.getScore(Bukkit.getOfflinePlayer("§fOnline:§b ")).setScore(9);
		Team t3 = s.registerNewTeam("online");
		t3.addPlayer(Bukkit.getOfflinePlayer("§fOnline:§b "));
		// Line 8
		obj.getScore(Bukkit.getOfflinePlayer("§fSeu Kit: ")).setScore(8);
		Team t4 = s.registerNewTeam("kit");
		t4.addPlayer(Bukkit.getOfflinePlayer("§fSeu Kit: "));
		// Line 7
		obj.getScore(Bukkit.getOfflinePlayer("§fMatou:§b ")).setScore(7);
		Team t5 = s.registerNewTeam("matou");
		t5.addPlayer(Bukkit.getOfflinePlayer("§fMatou:§b "));
		// Line 6
		obj.getScore(Bukkit.getOfflinePlayer("§fMortes:§b ")).setScore(6);
		Team t6 = s.registerNewTeam("mortes");
		t6.addPlayer(Bukkit.getOfflinePlayer("§fMortes:§b "));
		// Line 5
		obj.getScore(Bukkit.getOfflinePlayer("§fSequencia:§b ")).setScore(5);
		Team t7 = s.registerNewTeam("sequencia");
		t7.addPlayer(Bukkit.getOfflinePlayer("§fSequencia:§b "));
		// Line 4
		obj.getScore(Bukkit.getOfflinePlayer("§2")).setScore(4);
		// Line 3
		obj.getScore(Bukkit.getOfflinePlayer("§bmc.xplaynet.tk")).setScore(3);
		// Set Scoreboard
		p.setScoreboard(s);
	}
	
	public static void update(final Scoreboard s, Player p) {
		Thread th = new Thread(new Runnable() {
			public void run() {
				Team t1 = s.getTeam("nick");
				t1.setSuffix(p.getName());
				Team t2 = s.getTeam("online");
				t2.setSuffix(Bukkit.getServer().getOnlinePlayers().size() + "/" + Bukkit.getServer().getMaxPlayers());
			    Team t3 = s.getTeam("kit");
			    t3.setSuffix(nomedokit.get(p));
			    Team t4 = s.getTeam("matou");
			    t4.setSuffix(p.getStatistic(Statistic.PLAYER_KILLS) + "");
			    Team t5 = s.getTeam("mortes");
			    t5.setSuffix(p.getStatistic(Statistic.DEATHS) + "");
			    Team t6 = s.getTeam("sequencia");
			    t6.setSuffix(sequencia.get(p) + "");
			    Team t7 = s.getTeam("grupo");
			    t7.setSuffix(ChatColor.translateAlternateColorCodes('&', PermissionsEx.getUser(p).getPrefix()));
			    Team t8 = s.getTeam("xcoins");
			    t8.setSuffix(XcoinsAPI.getXCoins(p) + "");
			}
		});
		th.start();
	}
}
