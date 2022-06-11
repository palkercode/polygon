package net.polygon.anticheat.util;

import net.polygon.anticheat.checks.CheckType;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class User {
    private Player player;
    private Long foodStart;
    private Long bowStart;
    private boolean bow = false;
    private Location foodStartLocation;
    private int invalidFoodEatableCount = 0;
    private HashMap<CheckType, Integer> warnings = new HashMap<>();

    public User(Player player) {
        this.player = player;
    }

    public Player getPlayer() { return player; }

    public void setFoodStarting() {
        this.foodStart = System.currentTimeMillis();
        this.foodStartLocation = player.getLocation();
    }

    public void setBowStart(Long bowStart) {
        this.bowStart = bowStart;
    }

    public Long getFoodStarting() { return foodStart; }

    public Long getBowStart() { return bowStart; }

    public boolean isBow() {
        return bow;
    }

    public void setBow(boolean bow) {
        this.bow = bow;
    }

    public boolean isFoodStarted() { return foodStart != null; }

    public void addInvalidFoodEatableCount() { this.invalidFoodEatableCount++; }

    public int getInvalidFoodEatableCount() { return this.invalidFoodEatableCount; }

    public Location getFoodStartLocation() { return foodStartLocation; }

    public void resetInvalidFoodEatableCount() { this.invalidFoodEatableCount = 0; }

    public boolean isBlockAboveSolid(boolean x, Location loc) {
        return x;
    }

    public boolean isBlockAboveSolid(Location loc) {
        return isBlockAboveSolid(true, loc) || isBlockAboveSolid(false, loc);
    }
    
    public int getWarnings(CheckType type) {
        warnings.putIfAbsent(type, 0);
        return warnings.get(type);
    }

    public void addWarning(CheckType type) {
        getWarnings(type);
        warnings.put(type, warnings.get(type)+1);
    }
}
