package com.tzaranthony.modernvanilla.item;

import com.tzaranthony.modernvanilla.ModernVanilla;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class FoodBase extends Item {

    public FoodBase(String name, int hunger, float saturation) {
        super(new Item.Properties()
                .group(ModernVanilla.TAB)
                .food(new Food.Builder()
                        .hunger(hunger)
                        .saturation(saturation)
                        .build())
        );
        this.setRegistryName(name);
    }
}
