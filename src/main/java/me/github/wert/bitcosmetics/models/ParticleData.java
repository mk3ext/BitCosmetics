package me.github.wert.bitcosmetics.models;

import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParticleData {

    private static Map<UUID, Integer> Trails = new HashMap<UUID, Integer>();
    private final UUID uuid;


    public ParticleData(UUID uuid) {
        this.uuid = uuid;
    }

    public void setID(int id) {
        Trails.put(uuid, id);
    }

    public int getID() {
        return Trails.get(uuid);
    }

    public boolean hasID() {
        return Trails.containsKey(uuid);
    }

    public void removeID() {
        Trails.remove(uuid);
    }

    public void endTask() {
        int id = getID();
        if(id == 1) { return; }
        Bukkit.getScheduler().cancelTask(id);
    }

    public static boolean hasFakeID(UUID uuid) {
        if(Trails.containsKey(uuid)) {
            return Trails.get(uuid) == 1;
        }
        return false;
    }
}
