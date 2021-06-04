package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ConcretePowderBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;

public class MVConcretePowder extends ConcretePowderBlock {
    public MVConcretePowder(Block block, String name) {
        super(block, AbstractBlock.Properties
                .of(Material.SAND, DyeColor.WHITE)
                .strength(0.5F)
                .sound(SoundType.SAND));
        this.setRegistryName(name);
    }
}
