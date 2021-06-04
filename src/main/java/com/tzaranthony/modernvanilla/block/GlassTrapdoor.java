package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.item.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class GlassTrapdoor extends TrapDoorBlock {
    public GlassTrapdoor(String name, DyeColor color) {
        super(AbstractBlock.Properties.of(Material.GLASS, color)
                .strength(0.3F)
                .sound(SoundType.GLASS)
                .noOcclusion()
                .isValidSpawn(GlassTrapdoor::never)
                .isRedstoneConductor(GlassTrapdoor::never)
                .isSuffocating(GlassTrapdoor::never)
                .isViewBlocking(GlassTrapdoor::never));
        this.setRegistryName(name);
    }

    private static Boolean never(BlockState p_235427_0_, IBlockReader p_235427_1_, BlockPos p_235427_2_, EntityType<?> p_235427_3_) {
        return (boolean)false;
    }

    private static boolean never(BlockState p_235436_0_, IBlockReader p_235436_1_, BlockPos p_235436_2_) {
        return false;
    }
}
