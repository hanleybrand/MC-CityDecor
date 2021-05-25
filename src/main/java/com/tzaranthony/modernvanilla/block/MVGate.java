package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FenceGateBlock;

public class MVGate extends FenceGateBlock {
    public MVGate(String name, AbstractBlock block) {
        super(AbstractBlock.Properties.from(block));
        this.setRegistryName(name);
    }
}
