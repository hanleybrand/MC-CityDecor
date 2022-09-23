package com.tzaranthony.citydecor.util;

import com.tzaranthony.citydecor.CityDecor;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = CityDecor.MOD_ID, bus = Bus.MOD)
public class CDItems {
    public static final DeferredRegister<Item> reg = DeferredRegister.create(ForgeRegistries.ITEMS, CityDecor.MOD_ID);

    public static final RegistryObject<Item> STEEL_INGOT = reg.register("steel_ingot", () -> new Item(new Item.Properties().tab(CityDecor.TAB)));
    public static final RegistryObject<Item> STEEL_NUGGET = reg.register("steel_nugget", () -> new Item(new Item.Properties().tab(CityDecor.TAB)));
    public static final RegistryObject<Item> BARBED_WIRE = reg.register("barbed_wire", () -> new Item(new Item.Properties().tab(CityDecor.TAB)));
    public static final RegistryObject<Item> CARDBOARD = reg.register("cardboard", () -> new Item(new Item.Properties().tab(CityDecor.TAB)));
}