package com.tzaranthony.citydecor.item;

import com.tzaranthony.citydecor.CityDecor;
import net.minecraft.world.item.Item;

public class CDItemBase extends Item {

    public CDItemBase(String name) {
        super(new Item.Properties().tab(CityDecor.TAB));
        this.setRegistryName(name);
    }
}