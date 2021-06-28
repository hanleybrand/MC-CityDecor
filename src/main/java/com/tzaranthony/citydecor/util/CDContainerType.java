//package com.tzaranthony.modernvanilla.util;
//
//import com.tzaranthony.modernvanilla.ModernVanilla;
//import com.tzaranthony.modernvanilla.container.CardboardContainer;
//import net.minecraft.inventory.container.Container;
//import net.minecraft.inventory.container.ContainerType;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.event.RegistryEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//import java.lang.reflect.Field;
//
//@Mod.EventBusSubscriber(modid = ModernVanilla.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
//public class MVContainerType {
//    public static final ContainerType<CardboardContainer> CARDBOARD_BOX = register("cardboard_box", CardboardContainer::new);
//
//    public static <T extends Container> ContainerType<T> register(String name, ContainerType.IFactory<T> factory) {
//        ResourceLocation nameLoc = new ResourceLocation(ModernVanilla.MOD_ID, name);
//        return (ContainerType<T>) (new ContainerType<>(factory)).setRegistryName(nameLoc);
//    }
//
//    @SubscribeEvent
//    public static void registerTileEntities(final RegistryEvent.Register<ContainerType<?>> regTile) {
//        try {
//            for (Field f : MVContainerType.class.getDeclaredFields()) {
//                Object obj = f.get(null);
//                if (obj instanceof ContainerType) {
//                    regTile.getRegistry().register((ContainerType) obj);
//                } else if (obj instanceof ContainerType[]) {
//                    for (ContainerType ct : (ContainerType[]) obj) {
//                        regTile.getRegistry().register(ct);
//                    }
//                }
//            }
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
