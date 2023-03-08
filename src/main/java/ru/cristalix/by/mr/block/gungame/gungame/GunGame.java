package ru.cristalix.by.mr.block.gungame.gungame;

import org.bukkit.plugin.java.JavaPlugin;
import start.game.StartTimer;
import start.game.KillerGetItem;

public final class GunGame extends JavaPlugin {

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new StartTimer(), this);
        getServer().getPluginManager().registerEvents(new Lobby(), this);
        getServer().getPluginManager().registerEvents(new Events(), this);
        getServer().getPluginManager().registerEvents(new KillerGetItem(), this);
    }
}