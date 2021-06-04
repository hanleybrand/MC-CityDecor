package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class MetalBlock extends Block {
    public MetalBlock(String name, int harvestLevel, float hardness, float resistance) {
        super(Block.Properties.of(Material.METAL)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
                .strength(hardness, resistance)
                .harvestLevel(harvestLevel)
                .harvestTool(ToolType.PICKAXE));
        this.setRegistryName(name);
    }
}
