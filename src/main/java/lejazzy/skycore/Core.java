package lejazzy.skycore;


import co.aikar.commands.PaperCommandManager;
import lejazzy.skycore.commands.TESTCommand;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.print.Paper;

public class Core extends JavaPlugin {

    @Override
    public void onEnable() {


        PaperCommandManager manager = new PaperCommandManager(this);
 
        System.out.println(ChatColor.GREEN + "Le plugin a bien ete chargee");

    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.RED + "Le plugin a bien ete decharge");
    }
}
