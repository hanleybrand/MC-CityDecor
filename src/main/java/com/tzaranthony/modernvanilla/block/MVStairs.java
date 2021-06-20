package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

public class MVStairs extends StairsBlock {
    public MVStairs(String name, BlockState state, AbstractBlock block) {
        super(state, AbstractBlock.Properties.copy(block));
        this.setRegistryName(name);
    }
}
