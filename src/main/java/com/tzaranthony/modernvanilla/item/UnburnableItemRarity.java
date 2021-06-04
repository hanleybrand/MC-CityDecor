package com.tzaranthony.modernvanilla.item;

import com.tzaranthony.modernvanilla.ModernVanilla;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class UnburnableItemRarity extends Item {
    public UnburnableItemRarity(String name, Rarity rare) {
        super(new Item.Properties().tab(ModernVanilla.TAB).fireResistant().rarity(rare));
        this.setRegistryName(name);
    }
}
