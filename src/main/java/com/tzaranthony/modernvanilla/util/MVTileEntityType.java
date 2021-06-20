package com.tzaranthony.modernvanilla.util;

import com.tzaranthony.modernvanilla.ModernVanilla;
import com.tzaranthony.modernvanilla.tileentity.BoxTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.lang.reflect.Field;

public class MVTileEntityType {
    public static final TileEntityType<BoxTileEntity> BOX = register("box", TileEntityType.Builder.of(BoxTileEntity::new, MVBlocks.CARDBOARD_BOX, MVBlocks.SHIPPING_PALLET));

    public static <T extends TileEntity> TileEntityType<T> register(String name, TileEntityType.Builder<T> builder) {
        ResourceLocation nameLoc = new ResourceLocation(ModernVanilla.MOD_ID, name);
        return (TileEntityType) builder.build(null).setRegistryName(nameLoc);
    }

    @SubscribeEvent
    public static void registerTileEntities(final RegistryEvent.Register<TileEntityType<?>> regTile) {
        try {
            for (Field f : MVTileEntityType.class.getDeclaredFields()) {
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
