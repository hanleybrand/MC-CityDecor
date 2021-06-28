package com.tzaranthony.citydecor.item;

import com.tzaranthony.citydecor.block.SteelScaffolding;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.network.play.server.SChatPacket;
import net.minecraft.util.Direction;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class SteelScaffoldingItem extends BlockItem {
    public SteelScaffoldingItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Nullable
    public BlockItemUseContext updatePlacementContext(BlockItemUseContext context) {
        BlockPos blockpos = context.getClickedPos();
        World world = context.getLevel();
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = this.getBlock();
        if (!blockstate.is(block)) {
            return SteelScaffolding.getDistance(world, blockpos) == 15 ? null : context;
        } else {
            Direction direction;
            if (context.isSecondaryUseActive()) {
                direction = context.isInside() ? context.getClickedFace().getOpposite() : context.getClickedFace();
            } else {
                direction = context.getClickedFace() == Direction.UP ? context.getHorizontalDirection() : Direction.UP;
            }

            int i = 0;
            BlockPos.Mutable blockpos$mutable = blockpos.mutable().move(direction);

            while (i < 15) {
                if (!world.isClientSide && !World.isInWorldBounds(blockpos$mutable)) {
                    PlayerEntity playerentity = context.getPlayer();
                    int j = world.getHeight();
                    if (playerentity instanceof ServerPlayerEntity && blockpos$mutable.getY() >= j) {
                        SChatPacket schatpacket = new SChatPacket((new TranslationTextComponent("build.tooHigh", j))
                                .withStyle(TextFormatting.RED), ChatType.GAME_INFO, Util.NIL_UUID);
                        ((ServerPlayerEntity) playerentity).connection.send(schatpacket);
                    }
                    break;
                }

                blockstate = world.getBlockState(blockpos$mutable);
                if (!blockstate.is(this.getBlock())) {
                    if (blockstate.canBeReplaced(context)) {
                        return BlockItemUseContext.at(context, blockpos$mutable, direction);
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
