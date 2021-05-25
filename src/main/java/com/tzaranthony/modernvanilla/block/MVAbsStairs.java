package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

public class MVAbsStairs extends StairsBlock {
    public MVAbsStairs(String name, BlockState state, AbstractBlock block) {
        super(state, AbstractBlock.Properties.from(block));
        this.setRegistryName(name);
    }
}
