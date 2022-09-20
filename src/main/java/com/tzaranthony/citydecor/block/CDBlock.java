package com.tzaranthony.citydecor.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CDBlock extends Block {
    public CDBlock(String name, BlockBehaviour.Properties properties) {
        super(properties);
        this.setRegistryName(name);
    }
}