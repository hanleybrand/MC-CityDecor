package com.tzaranthony.citydecor.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

public class CDStairs extends StairsBlock {
    public CDStairs(String name, BlockState state, AbstractBlock block) {
        super(state, AbstractBlock.Properties.copy(block));
        this.setRegistryName(name);
    }
}
