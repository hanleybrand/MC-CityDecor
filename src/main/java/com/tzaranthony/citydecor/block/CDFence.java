package com.tzaranthony.citydecor.block;

import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CDFence extends FenceBlock {
    public CDFence(String name, BlockBehaviour block) {
        super(BlockBehaviour.Properties.copy(block));
        this.setRegistryName(name);
    }
}