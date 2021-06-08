package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class MVDoor extends DoorBlock {
    public MVDoor(String name, SoundType sound) {
        super(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL)
                .requiresCorrectToolForDrops()
                .strength(5.0F)
                .sound(sound)
                .noOcclusion());
        this.setRegistryName(name);
    }
}
