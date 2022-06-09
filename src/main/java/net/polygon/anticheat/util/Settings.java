package net.polygon.anticheat.util;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class Settings {
    public static final Double MAX_XZ_SPEED = 0.66D;
    public static final Double MAX_XZ_EATING_SPEED = 0.10177D;
    public static final double MAX_XZ_BLOCKING_SPEED = 0.12D;
    public static final String NOTIFY = "polygonac.notify";

    public static final List<Material> FOODS;

    static {
        FOODS = new ArrayList<Material>();
        FOODS.add(Material.LEGACY_RAW_CHICKEN);
        FOODS.add(Material.LEGACY_RAW_BEEF);
        FOODS.add(Material.LEGACY_RAW_FISH);

        FOODS.add(Material.COOKED_BEEF);
        FOODS.add(Material.COOKED_CHICKEN);
        FOODS.add(Material.LEGACY_COOKED_FISH);
        FOODS.add(Material.COOKED_PORKCHOP);
        FOODS.add(Material.COOKED_RABBIT);
        FOODS.add(Material.COOKED_MUTTON);

        FOODS.add(Material.GOLDEN_APPLE);
        FOODS.add(Material.GOLDEN_CARROT);
    }
}
