package com.tzaranthony.modernvanilla.item;

import com.tzaranthony.modernvanilla.ModernVanilla;
import net.minecraft.item.Item;

public class UnburnableItem extends Item {

    public UnburnableItem(String name) {
        super(new Item.Properties().tab(ModernVanilla.TAB).fireResistant());
        this.setRegistryName(name);
    }
}

