package net.vexio.startedycji.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.vexio.startedycji.Main;
import net.vexio.startedycji.settings.Config;
import net.vexio.startedycji.tasks.TimeLeftTask;

public class StartCommand implements CommandExecutor {
	
	public static int i = 1;

	@Override
	public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
		if (!s.hasPermission("start.use")) {
			s.sendMessage(" §8» §7Nie posiadasz dostepu do tej komendy §8(§cstart.use§8");
			return false;
		}
		if (args.length < 1) {
			s.sendMessage(" ");
			s.sendMessage(" §8» §7Plugin §cNStartEdycji");
			s.sendMessage(" §8» §7Autor: §6vNaski");
			s.sendMessage(" ");
			s.sendMessage(" §8» §7Poprawne uzycie: §6/start <enabled/reload>");
			s.sendMessage(" ");
			return false;
		}
		if (args[0].equalsIgnoreCase("reload")) {
			Config.getInst().load();
			Main.getPlugin().saveDefaultConfig();
			Main.getPlugin().reloadConfig();
			s.sendMessage(" ");
			s.sendMessage(" §8» §7Plugin §cNStartEdycji");
			s.sendMessage(" §8» §7Autor: §6vNaski");
			s.sendMessage(" ");
			s.sendMessage(" §8» §7Plugin zostal przeladowany: §apomyslnie§7!");
			s.sendMessage(" ");
		}
		if (args[0].equalsIgnoreCase("enabled")) {
			Config.getInst().load();
			Main.getPlugin().saveDefaultConfig();
			Main.getPlugin().reloadConfig();
			s.sendMessage(" ");
			s.sendMessage(" §8» §7Plugin §cNStartEdycji");
			s.sendMessage(" §8» §7Autor: §6vNaski");
			s.sendMessage(" ");
			if (i == 1) {
				s.sendMessage(" §8» §7Title zostalo: §cWylaczone§7!");
				s.sendMessage(" ");
				i = 0;
				TimeLeftTask.task.cancel();
				return false;
			}else {
				s.sendMessage(" §8» §7Title zostalo: §aWlaczone§7!");
				s.sendMessage(" ");
				i = 1;
				new TimeLeftTask().runTaskTimer(Main.getPlugin(), 40, 20);
				return false;
			}
		}
		return false;
	}

}
