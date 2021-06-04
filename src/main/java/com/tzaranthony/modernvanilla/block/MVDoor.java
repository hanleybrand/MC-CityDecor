package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class MVDoor extends DoorBlock {
    public MVDoor(Material material) {
        super(AbstractBlock.Properties.of(material, MaterialColor.METAL)
                .requiresCorrectToolForDrops()
                .strength(5.0F)
                .sound(SoundType.METAL)
                .noOcclusion());
    }
}
