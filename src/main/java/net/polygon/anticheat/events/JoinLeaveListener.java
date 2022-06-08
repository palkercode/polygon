package net.polygon.anticheat.events;

import net.polygon.anticheat.Anticheat;
import net.polygon.anticheat.util.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        Anticheat.USERS.put(p.getUniqueId(), new User(p));
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        Player p = event.getPlayer();
        Anticheat.USERS.remove(p.getUniqueId());
    }
}
