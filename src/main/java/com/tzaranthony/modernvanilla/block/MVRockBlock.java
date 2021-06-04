package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class MVRockBlock extends Block {
    public MVRockBlock(String name, float hardness, float resistance) {
        super(Block.Properties.of(Material.STONE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .strength(hardness, resistance)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE));
        this.setRegistryName(name);
    }
}
