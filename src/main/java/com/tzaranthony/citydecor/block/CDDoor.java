package com.tzaranthony.citydecor.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.SoundType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class CDDoor extends DoorBlock {
    public CDDoor(String name, Properties properties) {
        super(properties);
        this.setRegistryName(name);
    }

    public ActionResultType use(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        if (this.soundType == SoundType.METAL) {
            return ActionResultType.PASS;
        } else {
            p_225533_1_ = p_225533_1_.cycle(OPEN);
            p_225533_2_.setBlock(p_225533_3_, p_225533_1_, 10);
            p_225533_2_.levelEvent(p_225533_4_, p_225533_1_.getValue(OPEN) ? this.getOpenSound() : this.getCloseSound(), p_225533_3_, 0);
            return ActionResultType.sidedSuccess(p_225533_2_.isClientSide);
        }
    }

    public void setOpen(World p_242663_1_, BlockState p_242663_2_, BlockPos p_242663_3_, boolean p_242663_4_) {
        if (p_242663_2_.is(this) && p_242663_2_.getValue(OPEN) != p_242663_4_) {
            p_242663_1_.setBlock(p_242663_3_, p_242663_2_.setValue(OPEN, Boolean.valueOf(p_242663_4_)), 10);
            this.playSound(p_242663_1_, p_242663_3_, p_242663_4_);
        }
    }

    public void neighborChanged(BlockState p_220069_1_, World p_220069_2_, BlockPos p_220069_3_, Block p_220069_4_, BlockPos p_220069_5_, boolean p_220069_6_) {
        boolean flag = p_220069_2_.hasNeighborSignal(p_220069_3_) || p_220069_2_.hasNeighborSignal(p_220069_3_.relative(p_220069_1_.getValue(HALF) == DoubleBlockHalf.LOWER ? Direction.UP : Direction.DOWN));
        if (p_220069_4_ != this && flag != p_220069_1_.getValue(POWERED)) {
            if (flag != p_220069_1_.getValue(OPEN)) {
                this.playSound(p_220069_2_, p_220069_3_, flag);
            }

            p_220069_2_.setBlock(p_220069_3_, p_220069_1_.setValue(POWERED, Boolean.valueOf(flag)).setValue(OPEN, Boolean.valueOf(flag)), 2);
        }

    }

    private void playSound(World p_196426_1_, BlockPos p_196426_2_, boolean p_196426_3_) {
        p_196426_1_.levelEvent((PlayerEntity) null, p_196426_3_ ? this.getOpenSound() : this.getCloseSound(), p_196426_2_, 0);
    }

    private int getCloseSound() {
        return this.soundType != SoundType.WOOD ? 1011 : 1012;
    }

    private int getOpenSound() {
        return this.soundType != SoundType.WOOD ? 1005 : 1006;
    }
}
