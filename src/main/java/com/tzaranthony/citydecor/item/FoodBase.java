package com.tzaranthony.citydecor.item;

import com.tzaranthony.citydecor.CityDecor;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class FoodBase extends Item {

    public FoodBase(String name, int hunger, float saturation) {
        super(new Item.Properties()
                .tab(CityDecor.TAB)
                .food(new Food.Builder()
                        .nutrition(hunger)
                        .saturationMod(saturation)
                        .build())
        );
        this.setRegistryName(name);
    }
}
