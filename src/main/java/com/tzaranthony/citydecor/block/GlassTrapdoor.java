package com.tzaranthony.citydecor.block;

import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class GlassTrapdoor extends TrapDoorBlock {
    public GlassTrapdoor(String name, MaterialColor color) {
        super(CDBlockProperties.GlassTrapdoor(color));
        this.setRegistryName(name);
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
