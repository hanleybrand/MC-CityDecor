package com.tzaranthony.citydecor.util;

import com.tzaranthony.citydecor.CityDecor;
import com.tzaranthony.citydecor.tileentity.BoxTileEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber(modid = CityDecor.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CDTileEntityType {
    public static final BlockEntityType<BoxTileEntity> BOX = register("box", BlockEntityType.Builder.of(BoxTileEntity::new, CDBlocks.CARDBOARD_BOX, CDBlocks.SHIPPING_PALLET));

    public static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType.Builder<T> builder) {
        ResourceLocation nameLoc = new ResourceLocation(CityDecor.MOD_ID, name);
        return (BlockEntityType) builder.build(null).setRegistryName(nameLoc);
    }

    @SubscribeEvent
    public static void registerTileEntities(final RegistryEvent.Register<BlockEntityType<?>> regTile) {
        try {
            for (Field f : CDTileEntityType.class.getDeclaredFields()) {
                Object obj = f.get(null);
                if (obj instanceof BlockEntityType) {
                    regTile.getRegistry().register((BlockEntityType) obj);
                } else if (obj instanceof BlockEntityType[]) {
                    for (BlockEntityType te : (BlockEntityType[]) obj) {
                        regTile.getRegistry().register(te);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}