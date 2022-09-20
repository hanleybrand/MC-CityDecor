package com.tzaranthony.citydecor.block;

import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class IronScaffolding extends CDScaffolding {
    public static final IntegerProperty DISTANCE = CDBlockStateProperties.DISTANCE_0_11;

    public IronScaffolding(String name) {
        super();
        this.setRegistryName(name);
        this.stateDefinition.any()
                .setValue(DISTANCE, Integer.valueOf(11))
                .setValue(WATERLOGGED, Boolean.valueOf(false))
                .setValue(BOTTOM, Boolean.valueOf(false));
    }
}