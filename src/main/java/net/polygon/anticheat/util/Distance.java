package net.polygon.anticheat.util;

import org.bukkit.Location;
import org.bukkit.event.player.PlayerMoveEvent;

public class Distance {
    private Location from, to;

    private Double xDiff, yDiff, zDiff;

    public Distance(PlayerMoveEvent event) {
        this.from = event.getFrom();
        this.to = event.getTo();

        this.xDiff = (Math.max(from.getX(), to.getX())) - (Math.min(from.getX(), to.getX()));
        this.yDiff = (Math.max(from.getY(), to.getY())) - (Math.min(from.getY(), to.getY()));
        this.zDiff = (Math.max(from.getZ(), to.getZ())) - (Math.min(from.getZ(), to.getZ()));
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    public Double getxDiff() {
        return xDiff;
    }

    public Double getyDiff() {
        return yDiff;
    }

    public Double getzDiff() {
        return zDiff;
    }
}
