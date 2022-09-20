package com.tzaranthony.citydecor.block;

import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class CDStairs extends StairBlock {
    public CDStairs(String name, BlockState state, BlockBehaviour block) {
        super(state, BlockBehaviour.Properties.copy(block));
        this.setRegistryName(name);
    }
}