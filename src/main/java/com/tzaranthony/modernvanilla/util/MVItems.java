package com.tzaranthony.modernvanilla.util;

import com.tzaranthony.modernvanilla.ModernVanilla;
import com.tzaranthony.modernvanilla.item.MVItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber(modid = ModernVanilla.MOD_ID, bus = Bus.MOD)
public class MVItems {
    public static final Item STEEL_INGOT = new MVItemBase("steel_ingot");
    public static final Item STEEL_NUGGET = new MVItemBase("steel_nugget");
    public static final Item BARBED_WIRE = new MVItemBase("barbed_wire");
    public static final Item CARDBOARD = new MVItemBase("cardboard");


    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> regItems) {
        try {
            for (Field f : MVItems.class.getDeclaredFields()) {
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
