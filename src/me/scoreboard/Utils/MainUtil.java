package me.scoreboard.Utils;

import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;

import me.scoreboard.Main;

public class MainUtil {
	
	/**
	 * Replace all the placeholders in the str string.
	 * 
	 * @param input The input string with a variable as text.
	 * @param value The value which it will be replaced by.
	 * - Player -> Value is a player
	 * - Gamemode -> Value is a gamemode
	 * - World -> Value is a world
	 * - Rank -> Value is a player
	 * @return String
	 */
	
	public static String replacePlaceholders(String input, Object value) {
		if (input.contains("%player%")) {
			Player p = (Player) value;
			input.replaceAll("%player%", p.getName());
		}
		
		if (input.contains("%gamemode%")) {
			GameMode mode = (GameMode) value;
			input.replaceAll("%gamemode%", mode.name());
		}
		
		if (input.contains("%world%")) {
			World world = (World) value;
			input.replaceAll("%world%", world.getName());
		}
		
		if (input.contains("%rank%")) {
			Player p = (Player) value;
			String rang = Main.getInstance().getPermission().getPrimaryGroup(p);
			input.replaceAll("%rank%", rang);
		}
		
		return input;
	}

}
