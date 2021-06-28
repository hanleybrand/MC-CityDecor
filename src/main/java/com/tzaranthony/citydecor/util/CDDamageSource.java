package com.tzaranthony.citydecor.util;

import net.minecraft.util.DamageSource;

public class CDDamageSource extends DamageSource {
    public static final DamageSource BARBED_WIRE = new CDDamageSource("barbedWire");

    public CDDamageSource(String damageTypeIn) {
        super(damageTypeIn);
    }
}
