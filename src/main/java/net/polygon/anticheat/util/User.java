package net.polygon.anticheat.util;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class User {
    private Player player;
    private Long foodStart;
    private Location foodStartLocation;
    private int invalidFoodEatableCount = 0;

    public User(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setFoodStarting() {
        this.foodStart = System.currentTimeMillis();
        this.foodStartLocation = player.getLocation();
    }

    public Long getFoodStarting() {
        return foodStart;
    }

    public boolean isFoodStarted() {
        return foodStart != null;
    }

    public void addInvalidFoodEatableCount() {
        this.invalidFoodEatableCount++;
    }

    public int getInvalidFoodEatableCount() {
        return this.invalidFoodEatableCount;
    }

    public Location getFoodStartLocation() {
        return foodStartLocation;
    }

    public void resetInvalidFoodEatableCount() {
        this.invalidFoodEatableCount = 0;
    }
}
