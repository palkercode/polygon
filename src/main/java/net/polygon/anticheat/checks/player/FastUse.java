package net.polygon.anticheat.checks.player;

import net.polygon.anticheat.checks.CheckResult;
import net.polygon.anticheat.checks.CheckType;
import net.polygon.anticheat.checks.Level;
import net.polygon.anticheat.util.Settings;
import net.polygon.anticheat.util.User;

public class FastUse {
    private static final CheckResult PASS = new CheckResult(Level.PASSED, null, CheckType.FASTUSE);

    public static CheckResult runBow(User user) {
        long now = System.currentTimeMillis();
        if (user.getBowStart() != null && now - user.getBowStart() < Settings.BOW_MIN) {
            return new CheckResult(Level.DEFINITELY, "tried to shoot too fast", CheckType.FASTUSE);
        }
        return PASS;
    }

    public static CheckResult runFood(User user) {
        long now = System.currentTimeMillis();
        if (user.getFoodStarting() != null && now - user.getFoodStarting() < Settings.FOOD_MIN) {
            return new CheckResult(Level.DEFINITELY, "tried to eat too fast", CheckType.FASTUSE);
        }
        return PASS;
    }
}
