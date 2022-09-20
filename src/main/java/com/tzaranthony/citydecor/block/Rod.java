package com.tzaranthony.citydecor.block;

import net.minecraft.world.level.block.*;

public class Rod extends RodBlock {
    public Rod(String name, Properties properties) {
        super(properties);
        this.setRegistryName(name);
    }
}