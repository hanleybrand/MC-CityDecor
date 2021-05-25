package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FenceBlock;

public class MVFence extends FenceBlock {
    public MVFence(String name, AbstractBlock block) {
        super(AbstractBlock.Properties.from(block));
        this.setRegistryName(name);
    }
}
