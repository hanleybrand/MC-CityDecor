package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class MVLightBlock extends Block {
    public MVLightBlock(String name, float hardResist, int light) {
        super(Block.Properties.create(Material.GLASS)
                .func_235861_h_()
                .sound(SoundType.GLASS)
                .hardnessAndResistance(hardResist)
                .harvestLevel(4)
                .func_235838_a_((lightVar) -> {
                    return light;
                })
                .harvestTool(ToolType.PICKAXE));
        this.setRegistryName(name);
    }
}
