package com.tzaranthony.citydecor.block;

import net.minecraft.world.level.block.IronBarsBlock;

public class CDClimbPane extends IronBarsBlock {
    public CDClimbPane(String name) {
        super(CDBlockProperties.ChainFence());
        this.setRegistryName(name);
    }
}