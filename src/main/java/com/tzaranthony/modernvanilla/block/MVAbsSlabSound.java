package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class MVAbsSlabSound extends SlabBlock {
    public MVAbsSlabSound(String name, Material material, MaterialColor color, Float hardness, Float resistance) {
        super(AbstractBlock.Properties.of(material, color)
                .requiresCorrectToolForDrops().strength(hardness, resistance).sound(SoundType.NETHER_BRICKS));
        this.setRegistryName(name);
    }
}
