package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class SidingBlock extends Block {
    public SidingBlock(String name) {
        super(Block.Properties.of(Material.METAL)
                .requiresCorrectToolForDrops()
                .sound(SoundType.NETHERITE_BLOCK)
                .strength(4, 20)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE));
        this.setRegistryName(name);
    }
}
