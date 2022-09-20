package com.tzaranthony.citydecor.item;

import com.tzaranthony.citydecor.block.CDScaffolding;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class SteelScaffoldingItem extends BlockItem {
    public SteelScaffoldingItem(Block block, Item.Properties properties) {
        super(block, properties);
    }

    @Nullable
    public BlockPlaceContext updatePlacementContext(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        Level world = context.getLevel();
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = this.getBlock();
        if (!blockstate.is(block)) {
            return CDScaffolding.getDistance(world, blockpos) == 15 ? null : context;
        } else {
            Direction direction;
            if (context.isSecondaryUseActive()) {
                direction = context.isInside() ? context.getClickedFace().getOpposite() : context.getClickedFace();
            } else {
                direction = context.getClickedFace() == Direction.UP ? context.getHorizontalDirection() : Direction.UP;
            }

            int i = 0;
            BlockPos.MutableBlockPos blockpos$mutable = blockpos.mutable().move(direction);

            while (i < 15) {
                if (!world.isClientSide && !Level.isInSpawnableBounds(blockpos$mutable)) {
                    Player playerentity = context.getPlayer();
                    int j = world.getHeight();
                    if (playerentity instanceof ServerPlayer && blockpos$mutable.getY() >= j) {
                        ((ServerPlayer)playerentity).sendMessage((new TranslatableComponent("build.tooHigh", j - 1))
                                .withStyle(ChatFormatting.RED), ChatType.GAME_INFO, Util.NIL_UUID);
                    }
                    break;
                }

                blockstate = world.getBlockState(blockpos$mutable);
                if (!blockstate.is(this.getBlock())) {
                    if (blockstate.canBeReplaced(context)) {
                        return BlockPlaceContext.at(context, blockpos$mutable, direction);
                    }
                    break;
                }

                blockpos$mutable.move(direction);
                if (direction.getAxis().isHorizontal()) {
                    ++i;
                }
            }
            return null;
        }
    }

    protected boolean mustSurvive() {
        return false;
    }
}