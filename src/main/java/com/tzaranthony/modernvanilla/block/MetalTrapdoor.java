package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class MetalTrapdoor extends TrapDoorBlock {
    public MetalTrapdoor(String name) {
        super(AbstractBlock.Properties.of(Material.METAL)
                .requiresCorrectToolForDrops()
                .strength(5.0F)
                .sound(SoundType.METAL)
                .noOcclusion()
                .isValidSpawn(MetalTrapdoor::never));
        this.setRegistryName(name);
    }

    private static Boolean never(BlockState p_235427_0_, IBlockReader p_235427_1_, BlockPos p_235427_2_, EntityType<?> p_235427_3_) {
        return (boolean) false;
    }
}
