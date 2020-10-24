package me.github.wert.bitcosmetics.items;

import me.github.wert.bitcosmetics.enums.TrailEnum;
import org.bukkit.inventory.ItemStack;

import static me.github.wert.bitcosmetics.utils.Common.format;
import static me.github.wert.bitcosmetics.utils.ItemBuilder.create;

public class Trails {

    public static ItemStack Clear() {
        return create(TrailEnum.CLEAR.getMat(),format(TrailEnum.CLEAR.getTextCol()), null);
    }

    public static ItemStack Dying(Boolean active) {
        return active ? create(TrailEnum.DEAD.getMat(),format(TrailEnum.DEAD.getTextCol()), "Active") : create(TrailEnum.DEAD.getMat(),format(TrailEnum.DEAD.getTextCol()),null);
    }

    public static ItemStack Magic(Boolean active) {
        return active ? create(TrailEnum.MAGIC.getMat(),format(TrailEnum.MAGIC.getTextCol()), "Active") : create(TrailEnum.MAGIC.getMat(),format(TrailEnum.MAGIC.getTextCol()), null);
    }

}