package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.RotatedPillarBlock;

public class MVRotateableBlock extends RotatedPillarBlock {
    public MVRotateableBlock(String name, Properties properties) {
        super(properties);
        this.setRegistryName(name);
    }
}
