package com.tzaranthony.modernvanilla.block;

import com.tzaranthony.modernvanilla.tileentity.BoxTileEntity;
import com.tzaranthony.modernvanilla.util.MVBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.PushReaction;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.*;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class CardboardBox extends ContainerBlock {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    public static final ResourceLocation CONTENTS = new ResourceLocation("contents");
    public boolean isPallet;

    public CardboardBox(String name, Properties properties, boolean isPallet) {
        super(properties);
        this.setRegistryName(name);
        this.isPallet = isPallet;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        return this.defaultBlockState().setValue(FACING, p_196258_1_.getHorizontalDirection().getOpposite());
    }

    public BlockRenderType getRenderShape(BlockState p_149645_1_) {
        return BlockRenderType.MODEL;
    }

    public BlockState rotate(BlockState p_185499_1_, Rotation p_185499_2_) {
        return p_185499_1_.setValue(FACING, p_185499_2_.rotate(p_185499_1_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_185471_1_, Mirror p_185471_2_) {
        return p_185471_1_.rotate(p_185471_2_.getRotation(p_185471_1_.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FACING);
    }

    public ActionResultType use(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        if (p_225533_2_.isClientSide) {
            return ActionResultType.SUCCESS;
        } else if (p_225533_4_.isSpectator()) {
            return ActionResultType.CONSUME;
        } else {
            TileEntity tileentity = p_225533_2_.getBlockEntity(p_225533_3_);
            if (tileentity instanceof BoxTileEntity) {
                BoxTileEntity boxtileentity = (BoxTileEntity) tileentity;
                p_225533_4_.openMenu(boxtileentity);
//                p_225533_4_.awardStat(Stats.OPEN_SHULKER_BOX);
                PiglinTasks.angerNearbyPiglins(p_225533_4_, true);

                return ActionResultType.CONSUME;
            } else {
                return ActionResultType.PASS;
            }
        }
    }

    public void playerWillDestroy(World p_176208_1_, BlockPos p_176208_2_, BlockState p_176208_3_, PlayerEntity p_176208_4_) {
        TileEntity tileentity = p_176208_1_.getBlockEntity(p_176208_2_);
        if (tileentity instanceof BoxTileEntity) {
            BoxTileEntity boxtileentity = (BoxTileEntity) tileentity;
            if (!p_176208_1_.isClientSide && p_176208_4_.isCreative() && !boxtileentity.isEmpty()) {
//            if (!p_176208_1_.isClientSide && !boxtileentity.isEmpty()) {
                ItemStack itemstack = new ItemStack(getType());
                CompoundNBT compoundnbt = boxtileentity.saveToTag(new CompoundNBT());
                if (!compoundnbt.isEmpty()) {
                    itemstack.addTagElement("BlockEntityTag", compoundnbt);
                }

                if (boxtileentity.hasCustomName()) {
                    itemstack.setHoverName(boxtileentity.getCustomName());
                }

                ItemEntity itementity = new ItemEntity(p_176208_1_, (double) p_176208_2_.getX() + 0.5D, (double) p_176208_2_.getY() + 0.5D, (double) p_176208_2_.getZ() + 0.5D, itemstack);
                itementity.setDefaultPickUpDelay();
                p_176208_1_.addFreshEntity(itementity);
            } else {
                boxtileentity.unpackLootTable(p_176208_4_);
            }
        }
        super.playerWillDestroy(p_176208_1_, p_176208_2_, p_176208_3_, p_176208_4_);
    }

    public List<ItemStack> getDrops(BlockState p_220076_1_, LootContext.Builder p_220076_2_) {
        TileEntity tileentity = p_220076_2_.getOptionalParameter(LootParameters.BLOCK_ENTITY);
        if (tileentity instanceof BoxTileEntity) {
            BoxTileEntity boxtileentity = (BoxTileEntity) tileentity;
            p_220076_2_ = p_220076_2_.withDynamicDrop(CONTENTS, (p_220168_1_, p_220168_2_) -> {
                for (int i = 0; i < boxtileentity.getContainerSize(); ++i) {
                    p_220168_2_.accept(boxtileentity.getItem(i));
                }
            });
        }
        return super.getDrops(p_220076_1_, p_220076_2_);
    }

    public void setPlacedBy(World p_180633_1_, BlockPos p_180633_2_, BlockState p_180633_3_, LivingEntity p_180633_4_, ItemStack p_180633_5_) {
        if (p_180633_5_.hasCustomHoverName()) {
            TileEntity tileentity = p_180633_1_.getBlockEntity(p_180633_2_);
            if (tileentity instanceof BoxTileEntity) {
                ((BoxTileEntity) tileentity).setCustomName(p_180633_5_.getHoverName());
            }
        }
    }

    public void onRemove(BlockState p_196243_1_, World p_196243_2_, BlockPos p_196243_3_, BlockState p_196243_4_, boolean p_196243_5_) {
        if (!p_196243_1_.is(p_196243_4_.getBlock())) {
            TileEntity tileentity = p_196243_2_.getBlockEntity(p_196243_3_);
            if (tileentity instanceof BoxTileEntity) {
                p_196243_2_.updateNeighbourForOutputSignal(p_196243_3_, p_196243_1_.getBlock());
            }
            super.onRemove(p_196243_1_, p_196243_2_, p_196243_3_, p_196243_4_, p_196243_5_);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack p_190948_1_, @Nullable IBlockReader p_190948_2_, List<ITextComponent> p_190948_3_, ITooltipFlag p_190948_4_) {
        super.appendHoverText(p_190948_1_, p_190948_2_, p_190948_3_, p_190948_4_);
        CompoundNBT compoundnbt = p_190948_1_.getTagElement("BlockEntityTag");
        if (compoundnbt != null) {
            if (compoundnbt.contains("LootTable", 8)) {
                p_190948_3_.add(new StringTextComponent("???????"));
            }

            if (compoundnbt.contains("Items", 9)) {
                NonNullList<ItemStack> nonnulllist = NonNullList.withSize(27, ItemStack.EMPTY);
                ItemStackHelper.loadAllItems(compoundnbt, nonnulllist);
                int i = 0;
                int j = 0;

                for (ItemStack itemstack : nonnulllist) {
                    if (!itemstack.isEmpty()) {
                        ++j;
                        if (i <= 4) {
                            ++i;
                            IFormattableTextComponent iformattabletextcomponent = itemstack.getHoverName().copy();
                            iformattabletextcomponent.append(" x").append(String.valueOf(itemstack.getCount()));
                            p_190948_3_.add(iformattabletextcomponent);
                        }
                    }
                }
                if (j - i > 0) {
                    p_190948_3_.add((new TranslationTextComponent("container.shulkerBox.more", j - i)).withStyle(TextFormatting.ITALIC));
                }
            }
        }
    }

    public PushReaction getPistonPushReaction(BlockState p_149656_1_) {
        return PushReaction.DESTROY;
    }

    public boolean hasAnalogOutputSignal(BlockState p_149740_1_) {
        return true;
    }

    public int getAnalogOutputSignal(BlockState p_180641_1_, World p_180641_2_, BlockPos p_180641_3_) {
        return Container.getRedstoneSignalFromContainer((IInventory) p_180641_2_.getBlockEntity(p_180641_3_));
    }

    public ItemStack getCloneItemStack(IBlockReader p_185473_1_, BlockPos p_185473_2_, BlockState p_185473_3_) {
        ItemStack itemstack = super.getCloneItemStack(p_185473_1_, p_185473_2_, p_185473_3_);
        BoxTileEntity boxtileentity = (BoxTileEntity) p_185473_1_.getBlockEntity(p_185473_2_);
        CompoundNBT compoundnbt = boxtileentity.saveToTag(new CompoundNBT());
        if (!compoundnbt.isEmpty()) {
            itemstack.addTagElement("BlockEntityTag", compoundnbt);
        }
        return itemstack;
    }

    public Block getType() {
        if (this.isPallet) {
            return MVBlocks.SHIPPING_PALLET;
        } else {
            return MVBlocks.CARDBOARD_BOX;
        }
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader reader) {
        return new BoxTileEntity();
    }
}
