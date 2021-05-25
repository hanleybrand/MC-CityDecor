package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.DyeColor;

public class Polish extends CarpetBlock {
    public Polish(String name) {
        super(DyeColor.LIGHT_BLUE,
                AbstractBlock.Properties.create(Material.GLASS, MaterialColor.LIGHT_BLUE).hardnessAndResistance(0.1F).sound(SoundType.GLASS));
        this.setRegistryName(name);
    }
}
