package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class MVDoor extends DoorBlock {
    public MVDoor(String name, SoundType sound) {
        super(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL)
                .requiresCorrectToolForDrops()
                .strength(5.0F)
                .sound(sound)
                .noOcclusion());
        this.setRegistryName(name);
    }

    public ActionResultType use(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        if (this.soundType == soundType.METAL) {
            return ActionResultType.PASS;
        } else {
            p_225533_1_ = p_225533_1_.cycle(OPEN);
            p_225533_2_.setBlock(p_225533_3_, p_225533_1_, 10);
            p_225533_2_.levelEvent(p_225533_4_, p_225533_1_.getValue(OPEN) ? this.getOpenSound() : this.getCloseSound(), p_225533_3_, 0);
            return ActionResultType.sidedSuccess(p_225533_2_.isClientSide);
        }
    }

    private int getCloseSound() {
        return this.material == Material.METAL ? 1011 : 1012;
    }

    private int getOpenSound() {
        return this.material == Material.METAL ? 1005 : 1006;
    }
}
