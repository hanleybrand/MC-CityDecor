package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.SlabBlock;

public class MVSlab extends SlabBlock {
    public MVSlab(String name, Properties properties) {
        super(properties);
        this.setRegistryName(name);
    }
}
