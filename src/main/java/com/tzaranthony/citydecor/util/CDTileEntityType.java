package com.tzaranthony.citydecor.util;

import com.tzaranthony.citydecor.CityDecor;
import com.tzaranthony.citydecor.tileentity.BoxTileEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CDTileEntityType {
    public static final DeferredRegister<BlockEntityType<?>> reg = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, CityDecor.MOD_ID);

    public static final RegistryObject<BlockEntityType<BoxTileEntity>> BOX = reg.register("box", () -> BlockEntityType.Builder.of(BoxTileEntity::new, CDBlocks.CARDBOARD_BOX.get(), CDBlocks.SHIPPING_PALLET.get()).build(null));
}