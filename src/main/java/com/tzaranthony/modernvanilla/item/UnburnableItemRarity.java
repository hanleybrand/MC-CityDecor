package com.tzaranthony.modernvanilla.item;

import com.tzaranthony.modernvanilla.ModernVanilla;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class UnburnableItemRarity extends Item {
    public UnburnableItemRarity(String name, Rarity rare) {
        super(new Item.Properties().group(ModernVanilla.TAB).func_234689_a_().rarity(rare));
        this.setRegistryName(name);
    }
}
