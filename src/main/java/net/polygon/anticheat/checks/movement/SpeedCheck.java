package net.polygon.anticheat.checks.movement;

import net.polygon.anticheat.checks.CheckResult;
import net.polygon.anticheat.checks.CheckType;
import net.polygon.anticheat.checks.Level;
import net.polygon.anticheat.util.Distance;
import net.polygon.anticheat.util.Settings;
import net.polygon.anticheat.util.User;
import org.bukkit.potion.PotionEffectType;

public class SpeedCheck {
    private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.SPEED);

    public static CheckResult runCheck(Distance distance, User user) {
        Double xzSpeed = (distance.getxDiff() > distance.getzDiff() ? distance.getxDiff() : distance.getzDiff());

        if (xzSpeed > Settings.MAX_XZ_SPEED) {
            if (!user.getPlayer().hasPotionEffect(PotionEffectType.SPEED)) {
                return new CheckResult(Level.DEFINITELY, "tried to move faster than normal, speed=(" + xzSpeed + "), max=(" + Settings.MAX_XZ_SPEED + ")", CheckType.SPEED);
            }
        }

        return PASS;
    }
}
