package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.Block;
import net.minecraft.block.ConcretePowderBlock;
import net.minecraft.block.material.MaterialColor;

public class MVConcretePowder extends ConcretePowderBlock {
    public MVConcretePowder(String name, Block block, MaterialColor color) {
        super(block, MVBlockProperties.ConcretePowder(color));
        this.setRegistryName(name);
    }
}
