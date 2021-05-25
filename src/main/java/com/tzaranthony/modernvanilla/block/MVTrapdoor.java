package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class MVTrapdoor extends TrapDoorBlock {
    public MVTrapdoor(String name) {
        super(AbstractBlock.Properties.create(Material.IRON)
                .func_235861_h_()
                .hardnessAndResistance(5.0F)
                .sound(SoundType.METAL)
                .notSolid()
                .func_235827_a_(MVTrapdoor::func_235427_a_));
        this.setRegistryName(name);
    }

    private static Boolean func_235427_a_(BlockState p_235427_0_, IBlockReader p_235427_1_, BlockPos p_235427_2_, EntityType<?> p_235427_3_) {
        return (boolean) false;
    }
}
