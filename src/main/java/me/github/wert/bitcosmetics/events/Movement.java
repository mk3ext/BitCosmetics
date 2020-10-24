package me.github.wert.bitcosmetics.events;

import me.github.wert.bitcosmetics.models.ParticleData;
import org.bukkit.Particle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Random;

public class Movement implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if(!ParticleData.hasFakeID(e.getPlayer().getUniqueId())) {return;};

        Random r = new Random();
        for (int i=0; i< 5; i++) {
            e.getPlayer().getWorld().spawnParticle(Particle.CRIT_MAGIC, e.getPlayer().getLocation().add(r.nextDouble() * 0.5, r.nextDouble() * 0.5, r.nextDouble() * 0.5), 0);
        }

        for (int i=0; i< 5; i++) {
            e.getPlayer().getWorld().spawnParticle(Particle.CRIT_MAGIC, e.getPlayer().getLocation().add(-1*(r.nextDouble() * 0.5), r.nextDouble() * 0.5, (r.nextDouble() * 0.5) *-1), 0);
        }
    }
}
