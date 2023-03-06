package ru.cristalix.by.mr.block.gungame.gungame;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class GunGame extends JavaPlugin {

    public static Plugin plugin;

    public void onEnable() {
            plugin = this;
            getServer().getPluginManager().registerEvents(new StartGunGame(), this);
            getServer().getPluginManager().registerEvents(new Lobby(), this);
            getServer().getPluginManager().registerEvents(new Events(), this);
            getServer().getPluginManager().registerEvents(new Killed(), this);
        }

    public void onDisable() {
    }
}
