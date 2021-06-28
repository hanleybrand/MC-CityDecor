package com.tzaranthony.citydecor.util;

import com.tzaranthony.citydecor.CityDecor;
import com.tzaranthony.citydecor.tileentity.BoxTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber(modid = CityDecor.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CDTileEntityType {
    public static final TileEntityType<BoxTileEntity> BOX = register("box", TileEntityType.Builder.of(BoxTileEntity::new, CDBlocks.CARDBOARD_BOX, CDBlocks.SHIPPING_PALLET));

    public static <T extends TileEntity> TileEntityType<T> register(String name, TileEntityType.Builder<T> builder) {
        ResourceLocation nameLoc = new ResourceLocation(CityDecor.MOD_ID, name);
        return (TileEntityType) builder.build(null).setRegistryName(nameLoc);
    }

    @SubscribeEvent
    public static void registerTileEntities(final RegistryEvent.Register<TileEntityType<?>> regTile) {
        try {
            for (Field f : CDTileEntityType.class.getDeclaredFields()) {
                Object obj = f.get(null);
                if (obj instanceof TileEntityType) {
                    regTile.getRegistry().register((TileEntityType) obj);
                } else if (obj instanceof TileEntityType[]) {
                    for (TileEntityType te : (TileEntityType[]) obj) {
                        regTile.getRegistry().register(te);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}