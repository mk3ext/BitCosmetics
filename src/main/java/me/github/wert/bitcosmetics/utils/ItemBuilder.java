package me.github.wert.bitcosmetics.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.MaterialData;

import java.lang.reflect.Field;
import java.util.*;

public class ItemBuilder {

    private ItemMeta meta;
    private ItemStack itemStack;

    public ItemBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.meta = itemStack.getItemMeta();
    }

    public static ItemBuilder copyOf(ItemStack itemStack) {
        return new ItemBuilder(new ItemStack(itemStack));
    }

    public ItemBuilder(Material material) {
        this(new ItemStack(material));
    }

    public ItemBuilder type(Material material) {
        this.itemStack.setType(material);
        return this;
    }

    public ItemBuilder dye(Color color) {
        if(!(meta instanceof LeatherArmorMeta)) return this;
        ((LeatherArmorMeta)meta).setColor(color);
        return this;
    }

    public ItemBuilder setSkullOwner(String name) {
        if(meta instanceof SkullMeta)
        {
            ((SkullMeta)meta).setOwner(name);
        }
        return this;
    }

    public ItemBuilder displayname(String name) {
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        return this;
    }

    public ItemBuilder itemMeta(ItemMeta meta) {
        this.meta = meta;
        return this;
    }

    public ItemBuilder durability(short dura) {
        this.itemStack.setDurability(dura);
        return this;
    }

    public static ItemStack leather(Color color, Material mat) {
        return new ItemBuilder(mat).displayname("").addItemFlags(ItemFlag.HIDE_ATTRIBUTES).dye(color).build();
    };

    public ItemBuilder data(MaterialData data) {
        this.itemStack.setData(data);
        return this;
    }

    public ItemBuilder lore(String... lore) {
        lore(Arrays.asList(lore));
        return this;
    }

    public ItemBuilder addLore(String... lore) {
        addLore(Arrays.asList(lore));
        return this;
    }

    public ItemBuilder setLoreLine(int line, String text) {
        if(!meta.hasLore()) return this;
        if(meta.getLore().size() <= line) return this;
        List<String> lore = meta.getLore();
        lore.set(line, text);
        return this;
    }

    public ItemBuilder lore(List<String> lore) {
        List<String> tempLore = new ArrayList<>();
        for(String str : lore)
        {
            tempLore.add(ChatColor.translateAlternateColorCodes('&', str));
        }
        this.meta.setLore(tempLore);
        return this;
    }

    public ItemBuilder addLore(List<String> lore) {
        List<String> tempLore = this.meta.hasLore()?this.meta.getLore():new ArrayList<>();;
        for(String str : lore)
        {
            tempLore.add(ChatColor.translateAlternateColorCodes('&', str));
        }
        this.meta.setLore(tempLore);
        return this;
    }

    public ItemBuilder enchantments(Map<Enchantment, Integer> enchantments, boolean safe) {
        enchantments.keySet().forEach(enchantment -> meta.addEnchant(enchantment, enchantments.get(enchantment), !safe));
        return this;
    }

    public ItemBuilder enchantment(Enchantment enchantment, int level, boolean safe) {
        meta.addEnchant(enchantment, level, !safe);
        return this;
    }

    public ItemBuilder glow() {
        enchantment(Enchantment.DAMAGE_ALL, 1, false);
        addItemFlags(ItemFlag.HIDE_ENCHANTS);
        return this;
    }

    public ItemBuilder addItemFlags(ItemFlag... flags) {
        this.meta.addItemFlags(flags);
        return this;
    }

    public ItemBuilder amount(int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }

    public ItemStack build() {
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public static ItemStack create(final BCMaterial material, final String displayName, final String... lore) {
        final ItemStack itemStack = material.parseItem();
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        if (lore != null) {
            final List<String> finalLore = itemMeta.hasLore() ? itemMeta.getLore() : new ArrayList<String>();
            for (final String s : lore) {
                if (s != null) {
                    finalLore.add(ChatColor.translateAlternateColorCodes('&', s));
                }
            }
            itemMeta.setLore((List)finalLore);
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack createSkull(final String url, final String name, final String lore) {
        final ItemStack head = create(BCMaterial.PLAYER_HEAD, name, new String[0]);
        if (url.isEmpty()) {
            return head;
        }

        final SkullMeta headMeta = (SkullMeta)head.getItemMeta();

        if(lore != null) {
            ArrayList<String> l_a = new ArrayList<>();
            l_a.add(lore);
            headMeta.setLore(l_a);
        }

        headMeta.setOwner("Notch");
        final GameProfile profile = new GameProfile(UUID.randomUUID(), (String)null);
        profile.getProperties().put("textures", new Property("textures", url));
        try {
            final Field profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);
        }
        catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException ex2) {
            final Exception ex = new Exception();
            final Exception e1;
            e1 = ex;
            e1.printStackTrace();
        }
        head.setItemMeta(headMeta);
        return head;
    }

    public static void fillInventory(Inventory inventory) {
        ItemStack fillerItem = create(BCMaterial.WHITE_STAINED_GLASS_PANE,ChatColor.GRAY + "","");
            for (int i = 0; i < inventory.getSize(); i++) {
                if (inventory.getItem(i) == null || inventory
                        .getItem(i).getType() == Material.AIR)
                    inventory.setItem(i, fillerItem);
            }
        }
    }
