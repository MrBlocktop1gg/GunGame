package ru.cristalix.by.mr.block.gungame.gungame;

import org.bukkit.GameMode;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Material.*;

public class Lobby implements Listener {

    @EventHandler
    public void playerJoinItems(PlayerJoinEvent e) {
        e.getPlayer().teleport(new Location(Bukkit.getWorld("world"), -214, 85, 198));
        e.getPlayer().setGameMode(GameMode.ADVENTURE);
        e.getPlayer().getInventory().setItem(0, createInventoryItem(new ItemStack(COMPASS), "§2§lНачать игру", "[ПКМ]"));
        e.getPlayer().getInventory().setItem(1, createInventoryItem(new ItemStack(ENDER_CHEST), "§2§lКосметика", "[ПКМ]"));
        e.getPlayer().getInventory().setItem(2, createInventoryItem(new ItemStack(EMERALD), "§2§lДонат", "[ПКМ]"));
        e.getPlayer().getInventory().setItem(4, createInventoryItem(new ItemStack(ENDER_PORTAL_FRAME), "§2§lBattlePass", "[ПКМ]"));
        e.getPlayer().getInventory().setItem(8, createInventoryItem(new ItemStack(MAGMA_CREAM), "§2§lВыйти в хаб", "[ПКМ]"));
    }

    @EventHandler
    public void playerClickItems(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Material start = (COMPASS);
        if (e.getItem().getType() == COMPASS) {
            player.teleport(new Location(Bukkit.getWorld("world"), -161, 96, 181));
            player.getInventory().clear();
            new StartGunGame().timer();
        }

        Material cosmetic = (ENDER_CHEST);
        if (player.getItemInHand().getType() == ENDER_CHEST) {
            Inventory inventory = Bukkit.createInventory(player, 45, "Косметика");
            inventory.setItem(10, createInventoryItem(new ItemStack(DIAMOND_SWORD), "§7§lСкины на мечи", "Выделяйся из толпы"));
            inventory.setItem(12, createInventoryItem(new ItemStack(BOW), "§7§lСкины на луки", "Выделяйся из толпы"));
            inventory.setItem(14, createInventoryItem(new ItemStack(CYAN_GLAZED_TERRACOTTA), "§2§lА§5§lу§a§lр§c§lы", "будь не как все"));
            inventory.setItem(16, createInventoryItem(new ItemStack(PAPER), "§7§lСообщения", ""));
            inventory.setItem(28, createInventoryItem(new ItemStack(SIGN), "§7§lПреписки", "после вашего ника будет преписка"));
            inventory.setItem(30, createInventoryItem(new ItemStack(GRAY_GLAZED_TERRACOTTA), "§7§lМогилы", "После вашей смерти будет ваша могила"));
            inventory.setItem(32, createInventoryItem(new ItemStack(TIPPED_ARROW), "§7§lЭффект при выстреле", ""));
            inventory.setItem(34, createInventoryItem(new ItemStack(REDSTONE), "§7§lЭффект при убийстве", "Появляется при убийстве игрока"));
            player.openInventory(inventory);
        }

        Material donate = (EMERALD);
        if (player.getItemInHand().getType() == EMERALD) {
            Inventory inventory = Bukkit.createInventory(player, 45, "Донат");
            inventory.setItem(10, createInventoryItem(new ItemStack(DIAMOND_SWORD), "§6§lСкины на мечи", "Выделяйся из толпы"));
            inventory.setItem(12, createInventoryItem(new ItemStack(BOW), "§6§lСкины на луки", "Выделяйся из толпы"));
            inventory.setItem(14, createInventoryItem(new ItemStack(GOLD_INGOT), "§6§lМонеты", "За монеты можно покупать внеигровые ценности"));
            inventory.setItem(16, createInventoryItem(new ItemStack(PAPER), "§6§lСообщения", "После убийства будет писатся сообщение"));
            inventory.setItem(28, createInventoryItem(new ItemStack(SIGN), "§6§lПреписки", "после вашего ника будет преписка"));
            inventory.setItem(30, createInventoryItem(new ItemStack(CYAN_GLAZED_TERRACOTTA), "§6§lА§5§lу§a§lр§c§lы", "будь не как все"));
            inventory.setItem(32, createInventoryItem(new ItemStack(BLAZE_POWDER), "§6§lБустеры", "Сделай себя более прокаченей"));
            inventory.setItem(34, createInventoryItem(new ItemStack(GRAY_GLAZED_TERRACOTTA), "§6§lМогилы", "После вашей смерти будет ваша могила"));
            player.openInventory(inventory);
            return;
        }

        Material battlePass = ENDER_PORTAL_FRAME;
        if (player.getItemInHand().getType() == ENDER_PORTAL_FRAME) {
                Inventory inventory = Bukkit.createInventory(player, 45, "BattlePass");
                inventory.setItem(22, createInventoryItem(new ItemStack(Material.COMMAND), "§4КОГДА-ТО ТУТ БУДЕТ БАТТЛ-ПАСС", "COMING SOON"));
                player.openInventory(inventory);
                return;
            }

            Material hub = (MAGMA_CREAM);
            if (e.getItem().getType() == MAGMA_CREAM) {
                player.kickPlayer("Хаба нет");
            }
        }
    public ItemStack createInventoryItem (ItemStack item, String name, String lore){
        name = "§r" + name;
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(name);
        if (lore != null) {
            List<String> list = new ArrayList<>();
            list.add(lore);
            itemMeta.setLore(list);
        }
        item.setItemMeta(itemMeta);
        return item;
    }
}