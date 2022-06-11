package net.polygon.anticheat.util;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class Settings {
    public static final Double MAX_XZ_SPEED = 0.66D;
    public static final Double MAX_XZ_EATING_SPEED = 0.10255D;
    public static final double MAX_XZ_BLOCKING_SPEED = 0.12D;
    public static final String NOTIFY = "polygonac.notify";

    public static final List<Material> FOODS;
    public static final Integer MAX_WARNINGS = 15;
    public static final Double MAX_XZ_BLOCK_SPEED = 0.614D;
    public static final Long FOOD_MIN = 1000L;
    public static final Long BOW_MIN = 100L;

    static {
        FOODS = new ArrayList<Material>();
        FOODS.add(Material.CHICKEN);
        FOODS.add(Material.BEEF);
        FOODS.add(Material.COD);
        FOODS.add(Material.SALMON);
        FOODS.add(Material.PUFFERFISH);
        FOODS.add(Material.TROPICAL_FISH);
        FOODS.add(Material.MUTTON);

        FOODS.add(Material.COOKED_BEEF);
        FOODS.add(Material.COOKED_CHICKEN);
        FOODS.add(Material.COOKED_COD);
        FOODS.add(Material.COOKED_SALMON);
        FOODS.add(Material.COOKED_PORKCHOP);
        FOODS.add(Material.COOKED_RABBIT);
        FOODS.add(Material.COOKED_MUTTON);

        FOODS.add(Material.GOLDEN_APPLE);
        FOODS.add(Material.ENCHANTED_GOLDEN_APPLE);
        FOODS.add(Material.GOLDEN_CARROT);
    }
}
