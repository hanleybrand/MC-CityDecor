package com.tzaranthony.citydecor.block;

import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;

public class CDBlockStateProperties extends BlockStateProperties {
    public static final IntegerProperty DISTANCE_0_11 = IntegerProperty.create("distance", 0, 11);
    public static final IntegerProperty DISTANCE_0_15 = IntegerProperty.create("distance", 0, 15);
}
