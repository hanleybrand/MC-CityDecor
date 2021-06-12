package com.tzaranthony.modernvanilla.block;

import com.tzaranthony.modernvanilla.util.MVBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class IronScaffolding extends Block implements IWaterLoggable {
    private static final VoxelShape STABLE_SHAPE;
    private static final VoxelShape UNSTABLE_SHAPE;
    private static final VoxelShape UNSTABLE_SHAPE_BOTTOM = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);
    private static final VoxelShape BELOW_BLOCK = VoxelShapes.block().move(0.0D, -1.0D, 0.0D);
    public static final IntegerProperty DISTANCE = MVBlockStateProperties.DISTANCE_0_11;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty BOTTOM = BlockStateProperties.BOTTOM;

    public IronScaffolding(String name) {
        super(AbstractBlock.Properties
                .of(Material.DECORATION, MaterialColor.METAL)
                .noCollission()
                .sound(SoundType.SCAFFOLDING)
                .dynamicShape());
        this.setRegistryName(name);
        this.stateDefinition.any()
                .setValue(DISTANCE, Integer.valueOf(11))
                .setValue(WATERLOGGED, Boolean.valueOf(false))
                .setValue(BOTTOM, Boolean.valueOf(false));
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(DISTANCE, WATERLOGGED, BOTTOM);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        if (!context.isHoldingItem(state.getBlock().asItem())) {
            return state.getValue(BOTTOM) ? UNSTABLE_SHAPE : STABLE_SHAPE;
        } else {
            return VoxelShapes.block();
        }
    }

    public VoxelShape getInteractionShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return VoxelShapes.block();
    }

    public boolean canBeReplaced(BlockState state, BlockItemUseContext useContext) {
        return useContext.getItemInHand().getItem() == this.asItem();
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getClickedPos();
        World world = context.getLevel();
        int i = getDistance(world, blockpos);
        return this.defaultBlockState()
                .setValue(WATERLOGGED, Boolean.valueOf(world.getFluidState(blockpos).getType() == Fluids.WATER))
                .setValue(DISTANCE, Integer.valueOf(i))
                .setValue(BOTTOM, Boolean.valueOf(this.isBottom(world, blockpos, i)));
    }

    public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!worldIn.isClientSide) {
            worldIn.getBlockTicks().scheduleTick(pos, this, 1);
        }
    }

    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.getValue(WATERLOGGED)) {
            worldIn.getLiquidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
        }
        if (!worldIn.isClientSide()) {
            worldIn.getBlockTicks().scheduleTick(currentPos, this, 1);
        }
        return stateIn;
    }

    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        int i = getDistance(worldIn, pos);
        BlockState blockstate = state.setValue(DISTANCE, Integer.valueOf(i)).setValue(BOTTOM, Boolean.valueOf(this.isBottom(worldIn, pos, i)));
        if (blockstate.getValue(DISTANCE) == 11) {
            if (state.getValue(DISTANCE) == 11) {
                worldIn.addFreshEntity(new FallingBlockEntity(worldIn, (double) pos.getX()
                        + 0.5D, (double) pos.getY(), (double) pos.getZ() + 0.5D, blockstate.setValue(WATERLOGGED, Boolean.valueOf(false))));
            } else {
                worldIn.destroyBlock(pos, true);
            }
        } else if (state != blockstate) {
            worldIn.setBlock(pos, blockstate, 3);
        }
    }

    public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return getDistance(worldIn, pos) < 11;
    }

    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        if (context.isAbove(VoxelShapes.block(), pos, true) && !context.isDescending()) {
            return STABLE_SHAPE;
        } else {
            return state.getValue(DISTANCE) != 0
                    && state.getValue(BOTTOM)
                    && context.isAbove(BELOW_BLOCK, pos, true) ? UNSTABLE_SHAPE_BOTTOM : VoxelShapes.empty();
        }
    }

    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    private boolean isBottom(IBlockReader p_220116_1_, BlockPos p_220116_2_, int p_220116_3_) {
        return p_220116_3_ > 0 && !p_220116_1_.getBlockState(p_220116_2_.below()).is(this);
    }

    public static int getDistance(IBlockReader blockReader, BlockPos pos) {
        BlockPos.Mutable blockpos$mutable = pos.mutable().move(Direction.DOWN);
        BlockState blockstate = blockReader.getBlockState(blockpos$mutable);
        int i = 11;
        if (blockstate.is(MVBlocks.IRON_SCAFFOLDING)) {
            i = blockstate.getValue(DISTANCE);
        } else if (blockstate.isFaceSturdy(blockReader, blockpos$mutable, Direction.UP)) {
            return 0;
        }

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockState blockstate1 = blockReader.getBlockState(blockpos$mutable.setWithOffset(pos, direction));
            if (blockstate1.is(MVBlocks.IRON_SCAFFOLDING)) {
                i = Math.min(i, blockstate1.getValue(DISTANCE) + 1);
                if (i == 1) {
                    break;
                }
            }
        }
        return i;
    }

    @Override
    public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, net.minecraft.entity.LivingEntity entity) {
        return true;
    }

    static {
        VoxelShape voxelshape = Block.box(0.0D, 14.0D, 0.0D, 16.0D, 16.0D, 16.0D);
        VoxelShape voxelshape1 = Block.box(0.0D, 0.0D, 0.0D, 2.0D, 16.0D, 2.0D);
        VoxelShape voxelshape2 = Block.box(14.0D, 0.0D, 0.0D, 16.0D, 16.0D, 2.0D);
        VoxelShape voxelshape3 = Block.box(0.0D, 0.0D, 14.0D, 2.0D, 16.0D, 16.0D);
        VoxelShape voxelshape4 = Block.box(14.0D, 0.0D, 14.0D, 16.0D, 16.0D, 16.0D);
        STABLE_SHAPE = VoxelShapes.or(voxelshape, voxelshape1, voxelshape2, voxelshape3, voxelshape4);
        VoxelShape voxelshape5 = Block.box(0.0D, 0.0D, 0.0D, 2.0D, 2.0D, 16.0D);
        VoxelShape voxelshape6 = Block.box(14.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);
        VoxelShape voxelshape7 = Block.box(0.0D, 0.0D, 14.0D, 16.0D, 2.0D, 16.0D);
        VoxelShape voxelshape8 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 2.0D);
        UNSTABLE_SHAPE = VoxelShapes.or(IronScaffolding.UNSTABLE_SHAPE_BOTTOM, STABLE_SHAPE, voxelshape6, voxelshape5, voxelshape8, voxelshape7);
    }
}
