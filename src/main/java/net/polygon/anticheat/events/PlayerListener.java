package net.polygon.anticheat.events;

import net.polygon.anticheat.Anticheat;
import net.polygon.anticheat.checks.CheckResult;
import net.polygon.anticheat.checks.CheckType;
import net.polygon.anticheat.checks.Level;
import net.polygon.anticheat.checks.player.FastUse;
import net.polygon.anticheat.util.Settings;
import net.polygon.anticheat.util.User;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        User u = Anticheat.USERS.get(event.getPlayer().getUniqueId());
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand() != null) {
                if (Settings.FOODS.contains(event.getPlayer().getItemInHand().getType())) {
                    u.setFoodStarting();
                    u.resetInvalidFoodEatableCount();
                }

                if (event.getPlayer().getItemInHand().getType() == Material.BOW && event.getPlayer().getInventory().contains(Material.ARROW)) {
                    u.setBowStart(System.currentTimeMillis());
                    u.setBow(true);
                }
            }
        }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        User u = Anticheat.USERS.get(event.getEntity().getUniqueId());
        if (u.getPlayer().getItemInHand() != null && Settings.FOODS.contains(u.getPlayer().getItemInHand().getType())) {
            if (u.getInvalidFoodEatableCount() != 0) {
                event.setCancelled(true);
                u.getPlayer().teleport(u.getFoodStartLocation());
                Anticheat.log(new CheckResult(Level.DEFINITELY,"tried to move faster while eating, " + u.getInvalidFoodEatableCount() + " times in a row", CheckType.NOSLOW), u);
            }
        }

        CheckResult result = FastUse.runFood(u);
        if (result.failed()) {
            event.setCancelled(true);
            Anticheat.log(result, u);
        }
    }

    @EventHandler
    public void onShoot(ProjectileLaunchEvent event) {
        User u = Anticheat.USERS.get(event.getEntity().getUniqueId());
        CheckResult result = FastUse.runBow(u);
        if (result.failed()) {
            event.setCancelled(true);
            Anticheat.log(result, u);
        }
    }
}
