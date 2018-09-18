package net.vexio.startedycji.utils;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;

public class TitleApi {
	
	public static void sendTitle(Player p, String up, String down) {
		IChatBaseComponent chatTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + up + "\",color:" + ChatColor.GRAY.name() + "}");
		IChatBaseComponent chatSubTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + down + "\",color:" + ChatColor.GRAY.name() + "}");
		PacketPlayOutTitle title = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, chatTitle);
		PacketPlayOutTitle subtitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, chatSubTitle);
		PacketPlayOutTitle length = new PacketPlayOutTitle(5, 20, 5);
    
		((CraftPlayer)p).getHandle().playerConnection.sendPacket(title);
		((CraftPlayer)p).getHandle().playerConnection.sendPacket(subtitle);
		((CraftPlayer)p).getHandle().playerConnection.sendPacket(length);
	}

}
