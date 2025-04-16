package lejazzy.skycore.api;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class ListenerRegister {

    private final JavaPlugin plugin;

    public ListenerRegister(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void register(Listener listener) {
        plugin.getServer().getPluginManager().registerEvents(listener, plugin);
    }
}