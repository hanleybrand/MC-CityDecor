package com.tzaranthony.modernvanilla.tileentity;

import com.tzaranthony.modernvanilla.block.CardboardBox;
import com.tzaranthony.modernvanilla.util.MVTileEntityType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ShulkerBoxContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;
import java.util.stream.IntStream;

public class BoxTileEntity extends LockableLootTileEntity implements ISidedInventory {
    private static final int[] SLOTS = IntStream.range(0, 27).toArray();
    private NonNullList<ItemStack> itemStacks = NonNullList.withSize(27, ItemStack.EMPTY);
    private int openCount;

    public BoxTileEntity() {
        super(MVTileEntityType.BOX);
    }

    public void load(BlockState p_230337_1_, CompoundNBT p_230337_2_) {
        super.load(p_230337_1_, p_230337_2_);
        this.loadFromTag(p_230337_2_);
    }

    public CompoundNBT save(CompoundNBT p_189515_1_) {
        super.save(p_189515_1_);
        return this.saveToTag(p_189515_1_);
    }

    public void loadFromTag(CompoundNBT p_190586_1_) {
        this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(p_190586_1_) && p_190586_1_.contains("Items", 9)) {
            ItemStackHelper.loadAllItems(p_190586_1_, this.itemStacks);
        }

    }

    public CompoundNBT saveToTag(CompoundNBT p_190580_1_) {
        if (!this.trySaveLootTable(p_190580_1_)) {
            ItemStackHelper.saveAllItems(p_190580_1_, this.itemStacks, false);
        }
        return p_190580_1_;
    }


    public boolean triggerEvent(int p_145842_1_, int p_145842_2_) {
        if (p_145842_1_ == 1) {
            this.openCount = p_145842_2_;
            if (p_145842_2_ == 0) {
                this.doNeighborUpdates();
            }

            if (p_145842_2_ == 1) {
                this.doNeighborUpdates();
            }

            return true;
        } else {
            return super.triggerEvent(p_145842_1_, p_145842_2_);
        }
    }

    private void doNeighborUpdates() {
        this.getBlockState().updateNeighbourShapes(this.getLevel(), this.getBlockPos(), 3);
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

    public int[] getSlotsForFace(Direction p_180463_1_) {
        return SLOTS;
    }

    public boolean canPlaceItemThroughFace(int p_180462_1_, ItemStack p_180462_2_, @Nullable Direction p_180462_3_) {
        return !(Block.byItem(p_180462_2_.getItem()) instanceof ShulkerBoxBlock) |
                !(Block.byItem(p_180462_2_.getItem()) instanceof CardboardBox);
    }

    public boolean canTakeItemThroughFace(int p_180461_1_, ItemStack p_180461_2_, Direction p_180461_3_) {
        return true;
    }

    protected NonNullList<ItemStack> getItems() {
        return this.itemStacks;
    }

    protected void setItems(NonNullList<ItemStack> p_199721_1_) {
        this.itemStacks = p_199721_1_;
    }

    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("Cardboard Box");
    }

    protected Container createMenu(int p_213906_1_, PlayerInventory p_213906_2_) {
        return new ShulkerBoxContainer(p_213906_1_, p_213906_2_, this);
    }

    public int getContainerSize() {
        return this.itemStacks.size();
    }
}