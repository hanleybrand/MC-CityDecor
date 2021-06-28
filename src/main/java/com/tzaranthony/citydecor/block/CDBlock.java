package com.tzaranthony.citydecor.block;

import net.minecraft.block.Block;

public class CDBlock extends Block {
    public CDBlock(String name, Properties properties) {
        super(properties);
        this.setRegistryName(name);
    }
}
