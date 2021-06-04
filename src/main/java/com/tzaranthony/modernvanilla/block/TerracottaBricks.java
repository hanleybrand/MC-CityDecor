package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class TerracottaBricks extends Block {
    public TerracottaBricks(String name, MaterialColor color) {
        super(AbstractBlock.Properties.of(Material.STONE, color)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .strength(1.25F, 4.2F)
                .harvestTool(ToolType.PICKAXE));
        this.setRegistryName(name);
    }
}
