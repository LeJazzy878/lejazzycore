package lejazzy.skycore.api;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class commandRegister {

    private final JavaPlugin plugin;

    public commandRegister(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void register(String name, CommandExecutor executor) {
        if (plugin.getCommand(name) != null) {
            plugin.getCommand(name).setExecutor(executor);
        } else {
            plugin.getLogger().warning("La commande '" + name + "' est introuvable dans plugin.yml !");
        }
    }
}