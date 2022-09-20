package com.tzaranthony.citydecor.item;

import com.tzaranthony.citydecor.CityDecor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class UnburnableItemRarity extends Item {
    public UnburnableItemRarity(String name, Rarity rare) {
        super(new Item.Properties().tab(CityDecor.TAB).fireResistant().rarity(rare));
        this.setRegistryName(name);
    }
}