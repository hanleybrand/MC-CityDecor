package com.tzaranthony.modernvanilla.item;

import com.tzaranthony.modernvanilla.ModernVanilla;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class FoodBase extends Item {

    public FoodBase(String name, int hunger, float saturation) {
        super(new Item.Properties()
                .tab(ModernVanilla.TAB)
                .food(new Food.Builder()
                        .nutrition(hunger)
                        .saturationMod(saturation)
                        .build())
        );
        this.setRegistryName(name);
    }
}
