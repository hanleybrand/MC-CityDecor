package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.TrapDoorBlock;

public class MetalTrapdoor extends TrapDoorBlock {
    public MetalTrapdoor(String name) {
        super(MVBlockProperties.MetalTrapdoor());
        this.setRegistryName(name);
    }
}
