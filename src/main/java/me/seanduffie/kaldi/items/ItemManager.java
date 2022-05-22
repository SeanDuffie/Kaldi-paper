package me.seanduffie.kaldi.items;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ItemManager {

    public static ItemStack coffee;

    /**
     *
     */
    public static void init() {
        createCoffee();
    }

    /**
     *
     */
    private static void createCoffee() {
        ItemStack item = new ItemStack(Material.HONEY_BOTTLE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.displayName(Component.text("Coffee"));
        List<Component> lore = new ArrayList<>();
        lore.add(Component.text("A regular Cup o' Joe"));
        meta.lore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        coffee = item;
    }
}
