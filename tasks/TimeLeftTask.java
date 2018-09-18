package net.vexio.startedycji.tasks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.vexio.startedycji.Main;
import net.vexio.startedycji.commands.StartCommand;
import net.vexio.startedycji.utils.DataUtil;
import net.vexio.startedycji.utils.TitleApi;

public class TimeLeftTask extends BukkitRunnable {
	
	public static TimeLeftTask task;

	@Override
	public void run() {
		task = this;
		if (StartCommand.i == 1) {
			
			for (Player p : Bukkit.getOnlinePlayers()) {
				TitleApi.sendTitle(p, Main.getPlugin().getConfig().getString("start.title"), Main.getPlugin().getConfig().getString("start.subtitle")
				.replace("{DAY}", new StringBuilder().append(DataUtil.getInt("d")).toString())
				.replace("{HOUR}", new StringBuilder().append(DataUtil.getInt("g")).toString())
				.replace("{MINUTE}", new StringBuilder().append(DataUtil.getInt("m")).toString())
				.replace("{SECOND}", new StringBuilder().append(DataUtil.getInt("s")).toString()));
			}
			
			if (DataUtil.getInt("d") == 0 && DataUtil.getInt("h") == 0 && DataUtil.getInt("m") == 0 && DataUtil.getInt("s") == 0) {
				StartCommand.i = 0;
				for (Player p : Bukkit.getOnlinePlayers()) TitleApi.sendTitle(p, Main.getPlugin().getConfig().getString("start.title"), Main.getPlugin().getConfig().getString("start.start"));
					this.cancel();
			}
			
		}
	}
}
