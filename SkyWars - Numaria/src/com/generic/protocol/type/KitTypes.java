package com.generic.protocol.type;

import com.generic.modules.builder.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collection;

public enum KitTypes {

    ASSASSIN(0), TANK(1), ENTERHAKEN(2), GRABBLER(3), ENDERMAN(4), HEXEN(5), SANITAER(6);

    private int kitIndex;

    private Collection<ItemStack> itemStackCollection;

    public KitTypes valueOF(int kitIndex) {
        switch (kitIndex) {
            case 0: return ASSASSIN;
            case 1: return TANK;
            case 2: return ENTERHAKEN;
            case 3: return GRABBLER;
            case 4: return ENDERMAN;
            case 5: return HEXEN;
            case 6: return SANITAER;
        }
        return null;
    }

    public Collection<ItemStack> getItemStackCollection() {
        return itemStackCollection;
    }

    public void setItemStackCollection(Collection<ItemStack> itemStackCollection) {
        this.itemStackCollection = itemStackCollection;
    }

    KitTypes(int kitIndex) {
        this.kitIndex = kitIndex;
        init();
    }

    public void init() {
        ItemStack sword = ItemBuilder.createItem(Material.DIAMOND_SWORD, "");
        new ItemBuilder().addEnchantment(sword, Enchantment.DAMAGE_ALL, 1);
        ItemStack boots = ItemBuilder.createItem(Material.DIAMOND_BOOTS, "");
        new ItemBuilder().addEnchantment(boots, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        KitTypes.ASSASSIN.itemStackCollection.add(sword);
        KitTypes.ASSASSIN.itemStackCollection.add(boots);

        ItemStack Thelemt = ItemBuilder.createItem(Material.IRON_HELMET, "");
        new ItemBuilder().addEnchantment(Thelemt, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        ItemStack TChest = ItemBuilder.createItem(Material.DIAMOND_CHESTPLATE, "");
        new ItemBuilder().addEnchantment(TChest, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        ItemStack TLeggings = ItemBuilder.createItem(Material.IRON_LEGGINGS, "");
        new ItemBuilder().addEnchantment(TLeggings, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        ItemStack TBoots = ItemBuilder.createItem(Material.IRON_BOOTS, "");
        new ItemBuilder().addEnchantment(TBoots, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        KitTypes.TANK.itemStackCollection.add(Thelemt);
        KitTypes.TANK.itemStackCollection.add(TChest);
        KitTypes.TANK.itemStackCollection.add(TLeggings);
        KitTypes.TANK.itemStackCollection.add(TBoots);
        KitTypes.TANK.itemStackCollection.add(new ItemBuilder().createItem(Material.POTION, 1, 8227, ""));

        KitTypes.ENTERHAKEN.itemStackCollection.add(new ItemBuilder().createItem(Material.FISHING_ROD, ""));

        KitTypes.GRABBLER.itemStackCollection.add(new ItemBuilder().createItem(Material.FISHING_ROD, ""));

        KitTypes.ENDERMAN.itemStackCollection.add(new ItemBuilder().createItem(Material.ENDER_PEARL, ""));

        KitTypes.HEXEN.itemStackCollection.add(new ItemBuilder().createItem(Material.POTION, 1, 16388,""));
        KitTypes.HEXEN.itemStackCollection.add(new ItemBuilder().createItem(Material.POTION, 2, 16385,""));
        KitTypes.HEXEN.itemStackCollection.add(new ItemBuilder().createItem(Material.POTION, 1, 16393,""));

        KitTypes.SANITAER.itemStackCollection.add(new ItemBuilder().createItem(Material.POTION, 6, 16453,""));

    }

    public int getKitIndex() {
        return kitIndex;
    }
}
