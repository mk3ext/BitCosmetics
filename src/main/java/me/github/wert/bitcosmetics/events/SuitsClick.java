package me.github.wert.bitcosmetics.events;

import me.github.wert.bitcosmetics.gui.SuitGUI;
import me.github.wert.bitcosmetics.items.Suits;
import me.github.wert.bitcosmetics.models.Effects;
import me.github.wert.bitcosmetics.models.ParticleData;
import me.github.wert.bitcosmetics.gui.TrailGUI;
import me.github.wert.bitcosmetics.utils.ItemBuilder;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class SuitsClick implements Listener {

    private SuitGUI suits;
    public SuitsClick() {
        suits = new SuitGUI();
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(!e.getInventory().equals(suits.getInv())) {return;}

        Player p = (Player) e.getWhoClicked();

        e.setCancelled(true);

        if(e.getView().getType() == InventoryType.PLAYER) {return;}

        final ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
        final String stripped = ChatColor.stripColor(clickedItem.getItemMeta().getDisplayName());

        if(p.getInventory().getHelmet() != null) {
            p.getInventory().setHelmet(null);
            p.getInventory().setChestplate(null);
            p.getInventory().setLeggings(null);
            p.getInventory().setBoots(null);
        }
        ItemStack chest;
        ItemStack leggings;
        ItemStack boots;
        switch (stripped) {
            case "Snowman": {
                p.getInventory().setHelmet(Suits.Snowman(false));
                chest = ItemBuilder.leather(Color.WHITE, Material.LEATHER_CHESTPLATE);;
                leggings = ItemBuilder.leather(Color.WHITE,Material.LEATHER_LEGGINGS);
                boots = ItemBuilder.leather(Color.WHITE,Material.LEATHER_BOOTS);
                break;
            }
            case "Astronaut": {
                p.getInventory().setHelmet(Suits.Astronaut(false));
                chest = ItemBuilder.leather(Color.BLACK,Material.LEATHER_CHESTPLATE);;
                leggings = ItemBuilder.leather(Color.BLACK,Material.LEATHER_LEGGINGS);
                boots = ItemBuilder.leather(Color.BLACK,Material.LEATHER_BOOTS);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + stripped);
        }

        p.getInventory().setChestplate(chest);
        p.getInventory().setLeggings(leggings);
        p.getInventory().setBoots(boots);
        p.closeInventory();
    }



}