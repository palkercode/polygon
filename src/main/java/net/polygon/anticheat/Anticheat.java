package net.polygon.anticheat;

import net.polygon.anticheat.checks.CheckResult;
import net.polygon.anticheat.events.JoinLeaveListener;
import net.polygon.anticheat.events.MoveListener;
import net.polygon.anticheat.events.PlayerListener;
import net.polygon.anticheat.util.Settings;
import net.polygon.anticheat.util.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

import static org.bukkit.ChatColor.*;

public final class Anticheat extends JavaPlugin {
    public static HashMap<UUID, User> USERS = new HashMap<>();

    @Override
    public void onEnable() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinLeaveListener(), this);
        pm.registerEvents(new MoveListener(), this);
        pm.registerEvents(new PlayerListener(), this);

        for (Player p : Bukkit.getOnlinePlayers()) {
            USERS.put(p.getUniqueId(), new User(p));
        }
    }

    public static void log(CheckResult result, User user) {
        String message = AQUA.toString() + "[POLYGON] " + GRAY.toString() + "Player " + DARK_RED.toString() + user.getPlayer().getName() + " " + GRAY.toString() + result.getLevel().toString().toLowerCase() + " failed " + DARK_PURPLE.toString() + result.getType() + GRAY.toString() + " check.";
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.hasPermission(Settings.NOTIFY)) {
                p.sendMessage(message);
            }
        }
        Bukkit.getConsoleSender().sendMessage(message);
    }

    @Override
    public void onDisable() {

    }
}
