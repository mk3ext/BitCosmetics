package me.github.wert.bitcosmetics.gui;

import me.github.wert.bitcosmetics.utils.Common;
import me.github.wert.bitcosmetics.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;

import static me.github.wert.bitcosmetics.utils.Common.format;

public class MenuGUI {

    private static Inventory inv;

    public void register() {
        Inventory INV = Bukkit.createInventory(null, 9, format(Common.MenuTitle));

        INV.setItem(0, new ItemBuilder(Material.DIAMOND_HELMET).displayname("&eHats").addItemFlags(ItemFlag.HIDE_ENCHANTS).addItemFlags(ItemFlag.HIDE_ATTRIBUTES).build());
        INV.setItem(1, new ItemBuilder(Material.CAMPFIRE).displayname("&eTrails").addItemFlags(ItemFlag.HIDE_ENCHANTS).addItemFlags(ItemFlag.HIDE_ATTRIBUTES).build());

        setInv(INV);
    }

    public Inventory getInv() {
        return inv;
    }

    private void setInv(Inventory in) {
        inv = in;
    }

    public void openInv(Player p) {
        p.openInventory(inv);
    }
}
