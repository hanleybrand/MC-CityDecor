package com.tzaranthony.citydecor.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FenceBlock;

public class CDFence extends FenceBlock {
    public CDFence(String name, AbstractBlock block) {
        super(AbstractBlock.Properties.copy(block));
        this.setRegistryName(name);
    }
}
