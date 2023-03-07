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
    public void offRain(WeatherChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void offHunger(FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void clickInventory(InventoryClickEvent event) {
        if (event.getCurrentItem().getType() == Material.AIR) {
            return;
        }
        event.setCancelled(true);
    }

    @EventHandler
    public void dropInventoryItems(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void noMobSpawn(EntitySpawnEvent event) {
        if (event.getEntityType().isAlive()) {
            event.setCancelled(true);
        }
    }
}