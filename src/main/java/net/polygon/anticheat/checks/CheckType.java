package net.polygon.anticheat.checks;

import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;

public enum CheckType {
    SPEED("Speed", new Permission("polygonac.bypass.speed")),
    NOSLOW("NoSlowDown", new Permission("polygonac.bypass.noslow")),
    FASTUSE("FastUse", new Permission("polygonac.bypass.fastuse"));
    private String name;
    private Permission permission;

    private CheckType(String name, Permission permission) {
        this.name = name;
        this.permission = permission;
        Bukkit.getPluginManager().addPermission(permission);
    }

    public String getName() {
        return name;
    }

    public Permission getPermission() {
        return permission;
    }
}
