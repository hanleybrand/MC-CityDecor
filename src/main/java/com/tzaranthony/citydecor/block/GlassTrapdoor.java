package com.tzaranthony.citydecor.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.material.MaterialColor;

import javax.annotation.Nullable;

public class GlassTrapdoor extends TrapDoorBlock {
    public GlassTrapdoor(MaterialColor color) {
        super(CDBlockProperties.GlassTrapdoor(color));
    }

    protected void playSound(@Nullable Player p_185731_1_, Level p_185731_2_, BlockPos p_185731_3_, boolean p_185731_4_) {
        if (p_185731_4_) {
            int i = 1037;
            p_185731_2_.levelEvent(p_185731_1_, i, p_185731_3_, 0);
        } else {
            int j = 1036;
            p_185731_2_.levelEvent(p_185731_1_, j, p_185731_3_, 0);
        }
    }
}