package net.polygon.anticheat.checks.movement;

import net.polygon.anticheat.checks.CheckResult;
import net.polygon.anticheat.checks.CheckType;
import net.polygon.anticheat.checks.Level;
import net.polygon.anticheat.util.Distance;
import net.polygon.anticheat.util.Settings;
import net.polygon.anticheat.util.User;

public class NoSlowDown {
    private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.NOSLOW);

    public static void registerMove(Distance distance, User user) {
        double xzDist = (distance.getxDiff() > distance.getzDiff() ? distance.getxDiff() : distance.getzDiff());
        if (xzDist > Settings.MAX_XZ_EATING_SPEED && user.getFoodStarting() != null && System.currentTimeMillis() - user.getFoodStarting() > 1200) {
            user.addInvalidFoodEatableCount();
        }
    }

    public static CheckResult runCheck(Distance distance, User user) {
        double xzDist = (distance.getxDiff() > distance.getzDiff() ? distance.getxDiff() : distance.getzDiff());
        if (user.getPlayer().isBlocking() && xzDist > Settings.MAX_XZ_BLOCKING_SPEED) {
            return new CheckResult(Level.DEFINITELY, "tried to move faster while blocking", CheckType.NOSLOW);
        }
        return PASS;
    }
}
