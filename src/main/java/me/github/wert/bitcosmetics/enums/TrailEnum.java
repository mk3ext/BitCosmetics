package me.github.wert.bitcosmetics.enums;

import me.github.wert.bitcosmetics.utils.BCMaterial;
import org.bukkit.ChatColor;

public enum TrailEnum {

    CLEAR("Clear Trail",ChatColor.RED, BCMaterial.BARRIER),
    DEAD("Dying",ChatColor.AQUA, BCMaterial.TOTEM_OF_UNDYING),
    MAGIC("Magic",ChatColor.WHITE,BCMaterial.SPLASH_POTION);

    private String name;
    private ChatColor textCol;
    private BCMaterial mat;

    TrailEnum(String name, ChatColor textCol, BCMaterial mat) {
        this.name = name;
        this.textCol = textCol;
        this.mat = mat;
    }

    public String getTextCol() {
        return textCol + name;
    }

    public String getName() {
        return name;
    }

    public BCMaterial getMat() { return mat; }

}

