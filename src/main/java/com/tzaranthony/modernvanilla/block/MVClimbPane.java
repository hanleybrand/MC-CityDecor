package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class MVClimbPane extends PaneBlock {
    public MVClimbPane(String name) {
        super(AbstractBlock.Properties
                .create(Material.IRON, MaterialColor.AIR)
                .func_235861_h_()
                .hardnessAndResistance(5.0F, 6.0F)
                .sound(SoundType.METAL)
                .notSolid());
        this.setRegistryName(name);
    }
    
    @Override
    public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, net.minecraft.entity.LivingEntity entity) {
        return true;
    }
}
