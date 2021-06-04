package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class MVLightBlock extends Block {
    public MVLightBlock(String name, float hardResist, int light) {
        super(Block.Properties.of(Material.GLASS)
                .requiresCorrectToolForDrops()
                .sound(SoundType.GLASS)
                .strength(hardResist)
                .harvestLevel(4)
                .lightLevel((state) -> {return light;})
                .harvestTool(ToolType.PICKAXE));
        this.setRegistryName(name);
    }
}
