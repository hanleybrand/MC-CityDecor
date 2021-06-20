package com.tzaranthony.modernvanilla.tileentity;

import com.tzaranthony.modernvanilla.util.MVTileEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class BoxTileEntity extends ChestTileEntity {
    private NonNullList<ItemStack> items = NonNullList.withSize(27, ItemStack.EMPTY);
    private int openCount;
    private int tickInterval;

    public BoxTileEntity() {
        super(MVTileEntityType.BOX);
    }

    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
    }

    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("Cardboard Box");
    }

    public CompoundNBT save(CompoundNBT compound) {
        super.save(compound);
        return compound;
    }

    public void tick() {
        int i = this.worldPosition.getX();
        int j = this.worldPosition.getY();
        int k = this.worldPosition.getZ();
        ++this.tickInterval;
        this.openCount = getOpenCount(this.level, this, this.tickInterval, i, j, k, this.openCount);
        this.oOpenness = this.openness;
        float f = 0.1F;

        if (this.openCount == 0 && this.openness > 0.0F || this.openCount > 0 && this.openness < 1.0F) {
            float f1 = this.openness;
            if (this.openCount > 0) {
                this.openness += 0.1F;
            } else {
                this.openness -= 0.1F;
            }

            if (this.openness > 1.0F) {
                this.openness = 1.0F;
            }

            if (this.openness < 0.0F) {
                this.openness = 0.0F;
            }
        }
    }

    public void startOpen(PlayerEntity p_174889_1_) {
        if (!p_174889_1_.isSpectator()) {
            if (this.openCount < 0) {
                this.openCount = 0;
            }

            ++this.openCount;
            this.level.blockEvent(this.worldPosition, this.getBlockState().getBlock(), 1, this.openCount);
            if (this.openCount == 1) {
                this.level.playSound((PlayerEntity) null, this.worldPosition, SoundEvents.BARREL_OPEN, SoundCategory.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
            }
        }

    }

    public void stopOpen(PlayerEntity p_174886_1_) {
        if (!p_174886_1_.isSpectator()) {
            --this.openCount;
            this.level.blockEvent(this.worldPosition, this.getBlockState().getBlock(), 1, this.openCount);
            if (this.openCount <= 0) {
                this.level.playSound((PlayerEntity) null, this.worldPosition, SoundEvents.BARREL_CLOSE, SoundCategory.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
            }
        }

    }

    private void playSound(SoundEvent p_213965_2_) {
        double d0 = (double) this.worldPosition.getX() + 0.5D;
        double d1 = (double) this.worldPosition.getY() + 0.5D;
        double d2 = (double) this.worldPosition.getZ() + 0.5D;
        this.level.playSound((PlayerEntity) null, d0, d1, d2, p_213965_2_, SoundCategory.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
    }
}