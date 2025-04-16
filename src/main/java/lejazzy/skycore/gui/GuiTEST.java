package lejazzy.skycore.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GuiTEST {

    public Inventory createInventory() {
        Inventory inventory = Bukkit.createInventory(null, 27, "Test Menu");

        ItemStack item = new ItemStack(Material.ANVIL);
        inventory.setItem(13, item);

        return inventory;
    }
}
