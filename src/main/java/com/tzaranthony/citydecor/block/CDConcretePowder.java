package com.tzaranthony.citydecor.block;

import net.minecraft.block.Block;
import net.minecraft.block.ConcretePowderBlock;
import net.minecraft.block.material.MaterialColor;

public class CDConcretePowder extends ConcretePowderBlock {
    public CDConcretePowder(String name, Block block, MaterialColor color) {
        super(block, CDBlockProperties.ConcretePowder(color));
        this.setRegistryName(name);
    }
}
