package net.polygon.anticheat.events;

import net.polygon.anticheat.Anticheat;
import net.polygon.anticheat.checks.CheckResult;
import net.polygon.anticheat.checks.Level;
import net.polygon.anticheat.checks.movement.NoSlowDown;
import net.polygon.anticheat.checks.movement.SpeedCheck;
import net.polygon.anticheat.util.Distance;
import net.polygon.anticheat.util.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener implements Listener {
    @EventHandler
    public static void onMove(PlayerMoveEvent event) {
        User user = Anticheat.USERS.get(event.getPlayer().getUniqueId());
        Distance distance = new Distance(event);
        CheckResult speed = SpeedCheck.runCheck(distance, user);
        CheckResult noslow = NoSlowDown.runCheck(distance, user);
        NoSlowDown.registerMove(distance, user);

        if (speed.failed()) {
            if (speed.getLevel() == Level.DEFINITELY) {
                event.setTo(event.getFrom());
            }
            Anticheat.log(speed, user);
        }

        if (noslow.failed()) {
            event.setTo(event.getFrom());
            Anticheat.log(noslow, user);
        }
    }
}
