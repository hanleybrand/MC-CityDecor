package com.tzaranthony.citydecor.block;

import net.minecraft.world.level.block.SlabBlock;

public class CDSlab extends SlabBlock {
    public CDSlab(String name, Properties properties) {
        super(properties);
        this.setRegistryName(name);
    }
}