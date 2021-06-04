package com.tzaranthony.modernvanilla.item;

import com.tzaranthony.modernvanilla.ModernVanilla;
import net.minecraft.item.Item;

public class MVItemBase extends Item {

    public MVItemBase(String name) {
        super(new Item.Properties().tab(ModernVanilla.TAB));
        this.setRegistryName(name);
    }
}
