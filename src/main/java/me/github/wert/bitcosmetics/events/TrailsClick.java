package me.github.wert.bitcosmetics.events;

import me.github.wert.bitcosmetics.models.Effects;
import me.github.wert.bitcosmetics.models.ParticleData;
import me.github.wert.bitcosmetics.gui.TrailGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class TrailsClick implements Listener {

    private final TrailGUI trails;
    public TrailsClick() {
        trails = new TrailGUI();
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(!e.getInventory().equals(trails.getInv())) {return;}

        Player p = (Player) e.getWhoClicked();

        e.setCancelled(true);

        if(e.getView().getType() == InventoryType.PLAYER) {return;}

        ParticleData pdata = new ParticleData(p.getUniqueId());

        if(pdata.hasID()) {
            pdata.endTask();
            pdata.removeID();
        }

        Effects effect = new Effects(p);

        switch(e.getSlot()) {
            case 20:
                effect.startTotem();
                p.closeInventory();
                p.updateInventory();
                break;
            case 21:
                effect.startEnder();
                p.closeInventory();
                p.updateInventory();
                break;
            case 49:
                pdata.endTask();
                p.closeInventory();
                break;
            default:
                break;
        }



    }
}
