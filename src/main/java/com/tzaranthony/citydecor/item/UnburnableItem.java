package com.tzaranthony.citydecor.item;

import com.tzaranthony.citydecor.CityDecor;
import net.minecraft.world.item.Item;

public class UnburnableItem extends Item {

    public UnburnableItem(String name) {
        super(new Item.Properties().tab(CityDecor.TAB).fireResistant());
        this.setRegistryName(name);
    }
}