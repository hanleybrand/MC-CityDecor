package com.tzaranthony.citydecor.util;

import com.tzaranthony.citydecor.CityDecor;
import com.tzaranthony.citydecor.item.CDItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber(modid = CityDecor.MOD_ID, bus = Bus.MOD)
public class CDItems {
    public static final Item STEEL_INGOT = new CDItemBase("steel_ingot");
    public static final Item STEEL_NUGGET = new CDItemBase("steel_nugget");
    public static final Item BARBED_WIRE = new CDItemBase("barbed_wire");
    public static final Item CARDBOARD = new CDItemBase("cardboard");


    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> regItems) {
        try {
            for (Field f : CDItems.class.getDeclaredFields()) {
                Object obj = f.get(null);
                if (obj instanceof Item) {
                    regItems.getRegistry().register((Item) obj);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
