package com.tzaranthony.citydecor.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.BlockHitResult;

public class CDDoor extends DoorBlock {
    public CDDoor(String name, Properties properties) {
        super(properties);
        this.setRegistryName(name);
    }

    public InteractionResult use(BlockState p_225533_1_, Level p_225533_2_, BlockPos p_225533_3_, Player p_225533_4_, InteractionHand p_225533_5_, BlockHitResult p_225533_6_) {
        if (this.soundType == SoundType.METAL) {
            return InteractionResult.PASS;
        } else {
            p_225533_1_ = p_225533_1_.cycle(OPEN);
            p_225533_2_.setBlock(p_225533_3_, p_225533_1_, 10);
            p_225533_2_.levelEvent(p_225533_4_, p_225533_1_.getValue(OPEN) ? this.getOpenSound() : this.getCloseSound(), p_225533_3_, 0);
            return InteractionResult.sidedSuccess(p_225533_2_.isClientSide);
        }
    }

    public void setOpen(Level p_242663_1_, BlockState p_242663_2_, BlockPos p_242663_3_, boolean p_242663_4_) {
        if (p_242663_2_.is(this) && p_242663_2_.getValue(OPEN) != p_242663_4_) {
            p_242663_1_.setBlock(p_242663_3_, p_242663_2_.setValue(OPEN, Boolean.valueOf(p_242663_4_)), 10);
            this.playSound(p_242663_1_, p_242663_3_, p_242663_4_);
        }
    }

    public void neighborChanged(BlockState p_220069_1_, Level p_220069_2_, BlockPos p_220069_3_, Block p_220069_4_, BlockPos p_220069_5_, boolean p_220069_6_) {
        boolean flag = p_220069_2_.hasNeighborSignal(p_220069_3_) || p_220069_2_.hasNeighborSignal(p_220069_3_.relative(p_220069_1_.getValue(HALF) == DoubleBlockHalf.LOWER ? Direction.UP : Direction.DOWN));
        if (p_220069_4_ != this && flag != p_220069_1_.getValue(POWERED)) {
            if (flag != p_220069_1_.getValue(OPEN)) {
                this.playSound(p_220069_2_, p_220069_3_, flag);
            }

            p_220069_2_.setBlock(p_220069_3_, p_220069_1_.setValue(POWERED, Boolean.valueOf(flag)).setValue(OPEN, Boolean.valueOf(flag)), 2);
        }

    }

    private void playSound(Level p_196426_1_, BlockPos p_196426_2_, boolean p_196426_3_) {
        p_196426_1_.levelEvent((Player) null, p_196426_3_ ? this.getOpenSound() : this.getCloseSound(), p_196426_2_, 0);
    }

    private int getCloseSound() {
        return this.soundType != SoundType.WOOD ? 1011 : 1012;
    }

    private int getOpenSound() {
        return this.soundType != SoundType.WOOD ? 1005 : 1006;
    }
}