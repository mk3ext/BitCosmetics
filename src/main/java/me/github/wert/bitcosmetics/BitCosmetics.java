package me.github.wert.bitcosmetics;

import me.github.wert.bitcosmetics.commands.test;
import me.github.wert.bitcosmetics.events.*;
import me.github.wert.bitcosmetics.gui.MenuGUI;
import me.github.wert.bitcosmetics.gui.SuitGUI;
import me.github.wert.bitcosmetics.gui.TrailGUI;
import me.github.wert.bitcosmetics.utils.serverVersion;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class BitCosmetics extends JavaPlugin {

    private static BitCosmetics instance;
    public static BitCosmetics getInstance() { return instance;}
    public static serverVersion version;


    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage("Plugin has been enabled. Version " + getDescription().getVersion() + " has been detected.");


        TrailGUI t = new TrailGUI();
        t.register();

        SuitGUI s = new SuitGUI();
        s.register();

        MenuGUI m = new MenuGUI();
        m.register();

        instance = this;
        version = serverVersion.v1_15_R1;


        getCommand("test").setExecutor(new test());
        getServer().getPluginManager().registerEvents(new onQuit(), this);
        getServer().getPluginManager().registerEvents(new Movement(), this);
        getServer().getPluginManager().registerEvents(new MenuClick(), this);
        getServer().getPluginManager().registerEvents(new TrailsClick(), this);
        getServer().getPluginManager().registerEvents(new SuitsClick(), this);


    }

    @Override
    public void onDisable() {
        instance = null;
        // Plugin shutdown logic
    }

}
