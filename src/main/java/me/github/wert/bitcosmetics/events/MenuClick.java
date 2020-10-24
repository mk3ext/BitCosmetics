package me.github.wert.bitcosmetics.events;

import me.github.wert.bitcosmetics.gui.MenuGUI;
import me.github.wert.bitcosmetics.gui.SuitGUI;
import me.github.wert.bitcosmetics.gui.TrailGUI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class MenuClick implements Listener {

    private MenuGUI menu;
    public MenuClick() {
        menu = new MenuGUI();
    }


    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        if(!e.getInventory().equals(menu.getInv())) {return;}

        Player p = (Player) e.getWhoClicked();

        e.setCancelled(true);

        if(e.getView().getType() == InventoryType.PLAYER) {return;}

        final ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        switch (e.getSlot()) {
            case 0: {
                SuitGUI s = new SuitGUI();
                s.openInv(p);
                break;
            }
            case 1: {
                TrailGUI t = new TrailGUI();
                t.openInv(p);
                break;
            }
            default: {
                break;
            }
        }


    }

    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        e.setCancelled(true);
    }

}
