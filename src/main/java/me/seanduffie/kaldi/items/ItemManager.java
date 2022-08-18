package me.seanduffie.kaldi.items;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;
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

        // Shaped Recipe
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("coffee"), item);
        sr.shape("C ",
                 "B ");
        sr.setIngredient('B', Material.BOWL);
        sr.setIngredient('C', Material.COCOA_BEANS);
        Bukkit.getServer().addRecipe(sr);

//        // Shapeless Recipe
//        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("coffee_shapeless"), item);
//        slr.addIngredient(1, Material.BOWL);
//        slr.addIngredient(1, Material.COCOA_BEANS);
//        Bukkit.getServer().addRecipe(slr);

        // Furnace Recipe
        FurnaceRecipe smelt = new FurnaceRecipe(NamespacedKey.minecraft("coffee_brew"), item,
                Material.COCOA_BEANS, 1.0f, 10 * 20);
        Bukkit.getServer().addRecipe(smelt);
    }
}
