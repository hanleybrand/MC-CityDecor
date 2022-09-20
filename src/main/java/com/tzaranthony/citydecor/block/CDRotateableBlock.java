package com.tzaranthony.citydecor.block;

import net.minecraft.world.level.block.RotatedPillarBlock;

public class CDRotateableBlock extends RotatedPillarBlock {
    public CDRotateableBlock(String name, Properties properties) {
        super(properties);
        this.setRegistryName(name);
    }
}