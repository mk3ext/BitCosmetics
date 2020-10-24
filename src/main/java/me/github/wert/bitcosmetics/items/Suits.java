package me.github.wert.bitcosmetics.items;

import me.github.wert.bitcosmetics.enums.SuitEnum;
import org.bukkit.inventory.ItemStack;

import static me.github.wert.bitcosmetics.utils.Common.format;
import static me.github.wert.bitcosmetics.utils.ItemBuilder.createSkull;

public class Suits {


    public static ItemStack Astronaut(Boolean active) {
        return active ? createSkull(SuitEnum.ASTRONAUT.getTexture(), format(SuitEnum.ASTRONAUT.getTextCol()),"Active") : createSkull(SuitEnum.ASTRONAUT.getTexture(), format(SuitEnum.ASTRONAUT.getTextCol()),null);
    }

    public static ItemStack Snowman(Boolean active) {
        return active ? createSkull(SuitEnum.SNOWMAN.getTexture(), format(SuitEnum.SNOWMAN.getTextCol()),"Active") : createSkull(SuitEnum.SNOWMAN.getTexture(), format(SuitEnum.SNOWMAN.getTextCol()),null);
    }

}
