package com.tzaranthony.citydecor.block;

import com.tzaranthony.citydecor.tileentity.BoxTileEntity;
import com.tzaranthony.citydecor.util.CDBlocks;
import com.tzaranthony.citydecor.util.CDTileEntityType;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class CardboardBox extends BaseEntityBlock {
    public static final DirectionProperty FACING = DirectionalBlock.FACING;
    public static final ResourceLocation CONTENTS = new ResourceLocation("contents");
    public boolean isPallet;

    public CardboardBox(Properties properties, boolean isPallet) {
        super(properties);
        this.isPallet = isPallet;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BoxTileEntity(pos, state);
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_196258_1_) {
        return this.defaultBlockState().setValue(FACING, p_196258_1_.getHorizontalDirection().getOpposite());
    }

    public RenderShape getRenderShape(BlockState p_149645_1_) {
        return RenderShape.MODEL;
    }

    public BlockState rotate(BlockState p_185499_1_, Rotation p_185499_2_) {
        return p_185499_1_.setValue(FACING, p_185499_2_.rotate(p_185499_1_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_185471_1_, Mirror p_185471_2_) {
        return p_185471_1_.rotate(p_185471_2_.getRotation(p_185471_1_.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FACING);
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else if (player.isSpectator()) {
            return InteractionResult.CONSUME;
        } else {
            BlockEntity tileentity = level.getBlockEntity(pos);
            if (tileentity instanceof BoxTileEntity) {
                BoxTileEntity boxtileentity = (BoxTileEntity) tileentity;
                player.openMenu(boxtileentity);
//                p_225533_4_.awardStat(Stats.OPEN_SHULKER_BOX);
                PiglinAi.angerNearbyPiglins(player, true);

                return InteractionResult.CONSUME;
            } else {
                return InteractionResult.PASS;
            }
        }
    }

    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        BlockEntity tileentity = level.getBlockEntity(pos);
        if (tileentity instanceof BoxTileEntity) {
            BoxTileEntity boxtileentity = (BoxTileEntity) tileentity;
            if (!level.isClientSide && player.isCreative() && !boxtileentity.isEmpty()) {
                ItemStack itemstack = new ItemStack(this.getType());
                boxtileentity.saveToItem(itemstack);
                if (boxtileentity.hasCustomName()) {
                    itemstack.setHoverName(boxtileentity.getCustomName());
                }
                ItemEntity itementity = new ItemEntity(level, (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, itemstack);
                itementity.setDefaultPickUpDelay();
                level.addFreshEntity(itementity);
            } else {
                boxtileentity.unpackLootTable(player);

                ItemStack itemstack = new ItemStack(this.getType());
                boxtileentity.saveToItem(itemstack);
                if (boxtileentity.hasCustomName()) {
                    itemstack.setHoverName(boxtileentity.getCustomName());
                }
                ItemEntity itementity = new ItemEntity(level, (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, itemstack);
                itementity.setDefaultPickUpDelay();
                level.addFreshEntity(itementity);
            }
        }
        super.playerWillDestroy(level, pos, state, player);
    }

    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        BlockEntity tileentity = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (tileentity instanceof BoxTileEntity) {
            BoxTileEntity boxtileentity = (BoxTileEntity) tileentity;
            builder = builder.withDynamicDrop(CONTENTS, (p_220168_1_, p_220168_2_) -> {
                for (int i = 0; i < boxtileentity.getContainerSize(); ++i) {
                    p_220168_2_.accept(boxtileentity.getItem(i));
                }
            });
        }
        return super.getDrops(state, builder);
    }

    public void setPlacedBy(Level p_180633_1_, BlockPos p_180633_2_, BlockState p_180633_3_, LivingEntity p_180633_4_, ItemStack p_180633_5_) {
        if (p_180633_5_.hasCustomHoverName()) {
            BlockEntity tileentity = p_180633_1_.getBlockEntity(p_180633_2_);
            if (tileentity instanceof BoxTileEntity) {
                ((BoxTileEntity) tileentity).setCustomName(p_180633_5_.getHoverName());
            }
        }
    }

    public void onRemove(BlockState p_196243_1_, Level p_196243_2_, BlockPos p_196243_3_, BlockState p_196243_4_, boolean p_196243_5_) {
        if (!p_196243_1_.is(p_196243_4_.getBlock())) {
            BlockEntity tileentity = p_196243_2_.getBlockEntity(p_196243_3_);
            if (tileentity instanceof BoxTileEntity) {
                p_196243_2_.updateNeighbourForOutputSignal(p_196243_3_, p_196243_1_.getBlock());
            }
            super.onRemove(p_196243_1_, p_196243_2_, p_196243_3_, p_196243_4_, p_196243_5_);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack p_190948_1_, @Nullable BlockGetter p_190948_2_, List<Component> p_190948_3_, TooltipFlag p_190948_4_) {
        super.appendHoverText(p_190948_1_, p_190948_2_, p_190948_3_, p_190948_4_);
        CompoundTag compoundnbt = p_190948_1_.getTagElement("BlockEntityTag");
        if (compoundnbt != null) {
            if (compoundnbt.contains("LootTable", 8)) {
                p_190948_3_.add(new TextComponent("???????"));
            }

            if (compoundnbt.contains("Items", 9)) {
                NonNullList<ItemStack> nonnulllist = NonNullList.withSize(27, ItemStack.EMPTY);
                ContainerHelper.loadAllItems(compoundnbt, nonnulllist);
                int i = 0;
                int j = 0;

                for (ItemStack itemstack : nonnulllist) {
                    if (!itemstack.isEmpty()) {
                        ++j;
                        if (i <= 4) {
                            ++i;
                            MutableComponent component = itemstack.getHoverName().copy();
                            component.append(" x").append(String.valueOf(itemstack.getCount()));
                            p_190948_3_.add(component);
                        }
                    }
                }
                if (j - i > 0) {
                    p_190948_3_.add((new TranslatableComponent("container.shulkerBox.more", j - i)).withStyle(ChatFormatting.ITALIC));
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

    public int getAnalogOutputSignal(BlockState p_56223_, Level p_56224_, BlockPos p_56225_) {
        return AbstractContainerMenu.getRedstoneSignalFromContainer((Container)p_56224_.getBlockEntity(p_56225_));
    }

    public ItemStack getCloneItemStack(BlockGetter p_185473_1_, BlockPos p_185473_2_, BlockState p_185473_3_) {
        ItemStack itemstack = super.getCloneItemStack(p_185473_1_, p_185473_2_, p_185473_3_);
        p_185473_1_.getBlockEntity(p_185473_2_, CDTileEntityType.BOX.get()).ifPresent((p_187446_) -> {
            p_187446_.saveToItem(itemstack);
        });
        return itemstack;
    }

    public Block getType() {
        if (this.isPallet) {
            return CDBlocks.SHIPPING_PALLET.get();
        } else {
            return CDBlocks.CARDBOARD_BOX.get();
        }
    }
}