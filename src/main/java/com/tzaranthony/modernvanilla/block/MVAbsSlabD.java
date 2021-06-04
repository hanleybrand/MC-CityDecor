package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;

public class MVAbsSlabD extends SlabBlock {
    public MVAbsSlabD(String name, Material material, DyeColor color, Float hardness, Float resistance) {
        super(AbstractBlock.Properties.of(material, color)
                .requiresCorrectToolForDrops().strength(hardness, resistance));
        this.setRegistryName(name);
    }
}
