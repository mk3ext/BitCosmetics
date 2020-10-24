package me.github.wert.bitcosmetics.enums;

import org.bukkit.ChatColor;

public enum SuitEnum {

    ASTRONAUT("Astronaut",ChatColor.AQUA,"M2U4YWFkNjczMTU3YzkyMzE3YTg4YjFmODZmNTI3MWYxY2Q3Mzk3ZDdmYzhlYzMyODFmNzMzZjc1MTYzNCJ9fX0="),
    SNOWMAN("Snowman",ChatColor.WHITE,"OThlMzM0ZTRiZWUwNDI2NDc1OWE3NjZiYzE5NTVjZmFmM2Y1NjIwMTQyOGZhZmVjOGQ0YmYxYmIzNmFlNiJ9fX0=");

    private String name;
    private ChatColor textCol;
    private String texture;

    SuitEnum(String name, ChatColor textCol, String texture) {
        this.name = name;
        this.textCol = textCol;
        this.texture = texture;
    }

    public String getTextCol() {
        return textCol + name;
    }

    public String getName() {
        return name;
    }

    public String getTexture() {
        return "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv"+texture;
    }

}

