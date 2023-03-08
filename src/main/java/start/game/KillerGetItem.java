package start.game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class KillerGetItem implements Listener {

    @EventHandler
    public void playerKilledEntity(EntityDeathEvent event) {
        Entity killedE = event.getEntity();
        if (killedE instanceof Player) {
            Player killed = (Player) killedE;
            String dead = killed.getDisplayName();
            String killer = killed.getKiller().getDisplayName();
            Bukkit.broadcastMessage(ChatColor.GOLD + dead + " " + ChatColor.RED + "Был убит " + ChatColor.GOLD + killer);
        }
    }
    @EventHandler
    public void addItemsKilled(EntityDeathEvent event) {
        Inventory inventory = event.getEntity().getKiller().getInventory();
        Player player = event.getEntity().getKiller();
        PlayerInventory playerInventory = player.getInventory();
        switch (playerInventory.getItem(0).getType()) {
            case WOOD_SWORD:
                player.getInventory().clear();
                inventory.setItem(0, new ItemStack(Material.STONE_PICKAXE));
                inventory.setItem(36, new ItemStack(Material.LEATHER_BOOTS));
                inventory.setItem(38, new ItemStack(Material.LEATHER_CHESTPLATE));
                inventory.setItem(39, new ItemStack(Material.CHAINMAIL_HELMET));
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 150, 1));
                break;
            case STONE_PICKAXE:
                player.getInventory().clear();
                inventory.setItem(0, new ItemStack(Material.STONE_SWORD));
                inventory.setItem(36, new ItemStack(Material.LEATHER_BOOTS));
                inventory.setItem(38, new ItemStack(Material.LEATHER_CHESTPLATE));
                inventory.setItem(39, new ItemStack(Material.CHAINMAIL_HELMET));
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 150, 1));
                break;
            case STONE_SWORD:
                player.getInventory().clear();
                inventory.setItem(0, new ItemStack(Material.GOLD_AXE));
                inventory.setItem(36, new ItemStack(Material.LEATHER_BOOTS));
                inventory.setItem(38, new ItemStack(Material.LEATHER_CHESTPLATE));
                inventory.setItem(39, new ItemStack(Material.CHAINMAIL_HELMET));
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 150, 1));
                break;
            case GOLD_AXE:
                player.getInventory().clear();
                inventory.setItem(0, new ItemStack(Material.GOLD_SWORD));
                inventory.setItem(1, new ItemStack(Material.GOLDEN_APPLE));
                inventory.setItem(36, new ItemStack(Material.GOLD_BOOTS));
                inventory.setItem(38, new ItemStack(Material.GOLD_CHESTPLATE));
                inventory.setItem(39, new ItemStack(Material.CHAINMAIL_HELMET));
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 150, 1));
            case GOLD_SWORD:
                player.getInventory().clear();
                inventory.setItem(0, new ItemStack(Material.IRON_AXE));
                inventory.setItem(36, new ItemStack(Material.GOLD_BOOTS));
                inventory.setItem(38, new ItemStack(Material.GOLD_CHESTPLATE));
                inventory.setItem(39, new ItemStack(Material.CHAINMAIL_HELMET));
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 150, 1));
                break;
            case IRON_AXE:
                player.getInventory().clear();
                inventory.setItem(0, new ItemStack(Material.IRON_SWORD));
                inventory.setItem(36, new ItemStack(Material.IRON_BOOTS));
                inventory.setItem(38, new ItemStack(Material.GOLD_CHESTPLATE));
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 150, 1));
                break;
            case IRON_SWORD:
                player.getInventory().clear();
                inventory.setItem(0, new ItemStack(Material.DIAMOND_PICKAXE));
                inventory.setItem(1, new ItemStack(Material.GOLDEN_APPLE));
                inventory.setItem(36, new ItemStack(Material.IRON_BOOTS));
                inventory.setItem(38, new ItemStack(Material.GOLD_CHESTPLATE));
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 150, 1));
                break;
            case DIAMOND_AXE:
                player.getInventory().clear();
                inventory.setItem(0, new ItemStack(Material.DIAMOND_AXE));
                inventory.setItem(36, new ItemStack(Material.IRON_BOOTS));
                inventory.setItem(38, new ItemStack(Material.GOLD_CHESTPLATE));
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 150, 1));
            case DIAMOND_PICKAXE:
                player.getInventory().clear();
                inventory.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
                inventory.setItem(36, new ItemStack(Material.DIAMOND_BOOTS));
                inventory.setItem(37, new ItemStack(Material.IRON_LEGGINGS));
                inventory.setItem(38, new ItemStack(Material.DIAMOND_CHESTPLATE));
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 150, 1));
            default:
                inventory.setItem(39, new ItemStack(Material.IRON_HELMET));
                inventory.setItem(37, new ItemStack(Material.CHAINMAIL_LEGGINGS));
        }
    }
}