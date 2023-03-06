package ru.cristalix.by.mr.block.gungame.gungame;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Events implements Listener {

    @EventHandler
    public void offWater(WeatherChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void offFood(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void clickInventory(InventoryClickEvent e) {
        if (e.getCurrentItem().getType() == Material.AIR) {
            return;
        }
        e.setCancelled(true);
    }

    @EventHandler
    public void dropInventoryItems(PlayerDropItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void noMobSpawn(EntitySpawnEvent e) {
        if (e.getEntityType().isAlive()) {
            e.setCancelled(true);
        }
    }
}