package start.game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
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

public class killerGetItem implements Listener {

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
    public void addItemsKilled(EntityDeathEvent event) {
        Inventory inventory = event.getEntity().getKiller().getInventory();
        Player player = event.getEntity().getKiller();
        PlayerInventory playerInventory = player.getInventory();
        switch (playerInventory.getItem(0).getType()) {
            case WOOD_SWORD:
                event.getEntity().getKiller().getInventory().clear();
                inventory.setItem(0, new ItemStack(Material.STONE_PICKAXE));
                event.getEntity().getKiller().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 150, 1));
                break;
            case STONE_PICKAXE:
                event.getEntity().getKiller().getInventory().clear();
                inventory.setItem(0, new ItemStack(Material.STONE_SWORD));
                event.getEntity().getKiller().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 150, 1));
                break;
            case STONE_SWORD:
                event.getEntity().getKiller().getInventory().clear();
                inventory.setItem(0, new ItemStack(Material.GOLD_AXE));
                event.getEntity().getKiller().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 150, 1));
                break;
            case GOLD_AXE:
                event.getEntity().getKiller().getInventory().clear();
                inventory.setItem(0, new ItemStack(Material.GOLD_SWORD));
                event.getEntity().getKiller().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 150, 1));
            case GOLD_SWORD:
                event.getEntity().getKiller().getInventory().clear();
                inventory.setItem(0, new ItemStack(Material.IRON_AXE));
                event.getEntity().getKiller().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 150, 1));
                break;
            case IRON_AXE:
                event.getEntity().getKiller().getInventory().clear();
                inventory.setItem(0, new ItemStack(Material.IRON_SWORD));
                event.getEntity().getKiller().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 150, 1));
                break;
            case IRON_SWORD:
                event.getEntity().getKiller().getInventory().clear();
                inventory.setItem(0, new ItemStack(Material.DIAMOND_PICKAXE));
                event.getEntity().getKiller().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 150, 1));
                break;
            case DIAMOND_PICKAXE:
                event.getEntity().getKiller().getInventory().clear();
                inventory.setItem(0, new ItemStack(Material.DIAMOND_SWORD));
                event.getEntity().getKiller().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 150, 1));
            default:
        }
    }
}