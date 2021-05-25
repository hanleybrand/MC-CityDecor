package com.tzaranthony.modernvanilla.util;

import net.minecraft.util.DamageSource;

public class MVDamageSource extends DamageSource {
    public static final DamageSource BARBED_WIRE = new MVDamageSource("barbedWire");

    public MVDamageSource(String damageTypeIn) {
        super(damageTypeIn);
    }
}
