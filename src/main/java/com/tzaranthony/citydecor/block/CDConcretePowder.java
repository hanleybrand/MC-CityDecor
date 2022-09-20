package com.tzaranthony.citydecor.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ConcretePowderBlock;
import net.minecraft.world.level.material.MaterialColor;

public class CDConcretePowder extends ConcretePowderBlock {
    public CDConcretePowder(String name, Block block, MaterialColor color) {
        super(block, CDBlockProperties.ConcretePowder(color));
        this.setRegistryName(name);
    }
}