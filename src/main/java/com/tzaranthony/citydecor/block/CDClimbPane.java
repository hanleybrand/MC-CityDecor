package com.tzaranthony.citydecor.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class CDClimbPane extends PaneBlock {
    public CDClimbPane(String name) {
        super(CDBlockProperties.ChainFence());
        this.setRegistryName(name);
    }

    @Override
    public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, net.minecraft.entity.LivingEntity entity) {
        return true;
    }
}
