package me.github.wert.bitcosmetics.gui;

import me.github.wert.bitcosmetics.utils.Common;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import static me.github.wert.bitcosmetics.items.Suits.Astronaut;
import static me.github.wert.bitcosmetics.items.Suits.Snowman;
import static me.github.wert.bitcosmetics.utils.Common.format;
import static me.github.wert.bitcosmetics.utils.ItemBuilder.fillInventory;

public class SuitGUI {

    private static Inventory inv;

    public void register() {
        Inventory INV = Bukkit.createInventory(null, 54, format(Common.SuitsTitle));

        INV.setItem(20, Astronaut(false));
        INV.setItem(21, Snowman(false));

        fillInventory(INV);

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
