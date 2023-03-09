package ru.cristalix.by.mr.block.gungame.base;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import start.game.StartTimer;
import start.game.KillerGetItem;

public final class GunGame extends JavaPlugin {

    public void onEnable() {
        PluginManager pluginManager = getServer().getPluginManager();

        pluginManager.registerEvents(new StartTimer(), this);
        pluginManager.registerEvents(new Lobby(), this);
        pluginManager.registerEvents(new Events(), this);
        pluginManager.registerEvents(new KillerGetItem(), this);
    }
}