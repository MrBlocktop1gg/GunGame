package ru.cristalix.by.mr.block.gungame.gungame;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class killed implements Listener {

    @EventHandler
    public void playerKilledEntity(EntityDeathEvent e) {
        Entity killedE = e.getEntity();
        if (killedE instanceof Player) {
            Player killed = (Player) killedE;
            String dead = killed.getDisplayName();
            String killer = killed.getKiller().getDisplayName();
            Bukkit.broadcastMessage(ChatColor.GOLD + "" + dead + " " + ChatColor.RED + "Был убит " + ChatColor.GOLD + " " + killer);
        }
    }

    @EventHandler
    public void addItemsKilled(EntityDeathEvent e) {
        Player player = e.getEntity().getKiller();
        PlayerInventory playerInventory = player.getInventory();
        switch (playerInventory.getItem(0).getType()) {
            case WOOD_SWORD:
                e.getEntity().getKiller().getInventory().clear();
                e.getEntity().getKiller().getInventory().setItem(0, new ItemStack(Material.STONE_PICKAXE));
                break;
            case STONE_PICKAXE:
                e.getEntity().getKiller().getInventory().clear();
                e.getEntity().getKiller().getInventory().setItem(0, new ItemStack(Material.STONE_SWORD));
                break;
            case STONE_SWORD:
                e.getEntity().getKiller().getInventory().clear();
                e.getEntity().getKiller().getInventory().setItem(0, new ItemStack(Material.GOLD_AXE));
                break;
            case GOLD_AXE:
                e.getEntity().getKiller().getInventory().clear();
                e.getEntity().getKiller().getInventory().setItem(0, new ItemStack(Material.GOLD_SWORD));
            case GOLD_SWORD:
                e.getEntity().getKiller().getInventory().clear();
                e.getEntity().getKiller().getInventory().setItem(0, new ItemStack(Material.BOW));
                e.getEntity().getKiller().getInventory().setItem(26, new ItemStack(Material.ARROW));
                break;
            case BOW:
                e.getEntity().getKiller().getInventory().clear();
                e.getEntity().getKiller().getInventory().setItem(0, new ItemStack(Material.IRON_AXE));
                break;
            case IRON_AXE:
                e.getEntity().getKiller().getInventory().clear();
                e.getEntity().getKiller().getInventory().setItem(0, new ItemStack(Material.IRON_SWORD));
                break;
            case IRON_SWORD:
                e.getEntity().getKiller().getInventory().clear();
                e.getEntity().getKiller().getInventory().setItem(0, new ItemStack(Material.DIAMOND_PICKAXE));
                break;
            case DIAMOND_PICKAXE:
                e.getEntity().getKiller().getInventory().clear();
                e.getEntity().getKiller().getInventory().setItem(0, new ItemStack(Material.DIAMOND_SWORD));
            default:
        }
    }
}