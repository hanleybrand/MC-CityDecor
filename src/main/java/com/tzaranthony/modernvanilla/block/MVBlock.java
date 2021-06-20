package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.Block;

public class MVBlock extends Block {
    public MVBlock(String name, Properties properties) {
        super(properties);
        this.setRegistryName(name);
    }
}
