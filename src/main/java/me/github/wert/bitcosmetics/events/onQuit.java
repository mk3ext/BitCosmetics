package me.github.wert.bitcosmetics.events;

import me.github.wert.bitcosmetics.models.ParticleData;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onQuit implements Listener {

    public void Quit(PlayerQuitEvent e) {
        ParticleData p = new ParticleData(e.getPlayer().getUniqueId());
        if(p.hasID()) {
            p.endTask();
        }
    }
}
