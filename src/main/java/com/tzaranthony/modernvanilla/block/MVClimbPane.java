package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class MVClimbPane extends PaneBlock {
    public MVClimbPane(String name) {
        super(MVBlockProperties.ChainFence());
        this.setRegistryName(name);
    }

    @Override
    public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, net.minecraft.entity.LivingEntity entity) {
        return true;
    }
}
