package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

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
        return (boolean) false;
    }

    private static boolean never(BlockState p_235436_0_, IBlockReader p_235436_1_, BlockPos p_235436_2_) {
        return false;
    }

    protected void playSound(@Nullable PlayerEntity p_185731_1_, World p_185731_2_, BlockPos p_185731_3_, boolean p_185731_4_) {
        if (p_185731_4_) {
            int i = 1037;
            p_185731_2_.levelEvent(p_185731_1_, i, p_185731_3_, 0);
        } else {
            int j = 1036;
            p_185731_2_.levelEvent(p_185731_1_, j, p_185731_3_, 0);
        }

    }
}
