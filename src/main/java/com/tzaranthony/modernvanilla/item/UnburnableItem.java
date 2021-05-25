package com.tzaranthony.modernvanilla.item;

import com.tzaranthony.modernvanilla.ModernVanilla;
import net.minecraft.item.Item;

public class UnburnableItem extends Item {

    public UnburnableItem(String name) {
        super(new Item.Properties().group(ModernVanilla.TAB).func_234689_a_());
        this.setRegistryName(name);
    }
}

