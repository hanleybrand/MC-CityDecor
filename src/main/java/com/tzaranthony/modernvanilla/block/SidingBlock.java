package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class SidingBlock extends Block {
    public SidingBlock(String name) {
        super(Block.Properties.create(Material.IRON)
                .func_235861_h_()
                .sound(SoundType.field_235594_P_)
                .hardnessAndResistance(4, 20)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE));
        this.setRegistryName(name);
    }
}
