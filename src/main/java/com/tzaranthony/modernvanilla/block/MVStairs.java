package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

public class MVStairs extends StairsBlock {
    public MVStairs(String name, BlockState state, Block block) {
        super(state, Block.Properties.from(block));
        this.setRegistryName(name);
    }
}
