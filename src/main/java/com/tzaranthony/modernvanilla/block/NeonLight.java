package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.PushReaction;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class NeonLight extends DirectionalBlock implements IWaterLoggable {
    public static final IntegerProperty RODS = MVBlockStateProperties.ROD_PACKING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape Y_AXIS_AA = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);
    protected static final VoxelShape Z_AXIS_AA = Block.box(6.0D, 6.0D, 0.0D, 10.0D, 10.0D, 16.0D);
    protected static final VoxelShape X_AXIS_AA = Block.box(0.0D, 6.0D, 6.0D, 16.0D, 10.0D, 10.0D);

    protected static final VoxelShape Y_AXIS_BB = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    protected static final VoxelShape Z_AXIS_BB = Block.box(2.0D, 2.0D, 0.0D, 14.0D, 14.0D, 16.0D);
    protected static final VoxelShape X_AXIS_BB = Block.box(0.0D, 2.0D, 2.0D, 16.0D, 14.0D, 14.0D);

    public NeonLight(String name, int light) {
        super(AbstractBlock.Properties.of(Material.DECORATION)
                .instabreak()
                .lightLevel((state) -> {
                    return light * state.getValue(RODS);
                })
                .sound(SoundType.GLASS)
                .noOcclusion());
        this.setRegistryName(name);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.UP)
                .setValue(RODS, Integer.valueOf(1))
                .setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        Direction direction = p_196258_1_.getClickedFace();
        BlockState blockstate = p_196258_1_.getLevel().getBlockState(p_196258_1_.getClickedPos().relative(direction.getOpposite()));
        if (blockstate.is(this)) {
            return blockstate.is(this)
                    && blockstate.getValue(FACING) == direction ? this.defaultBlockState()
                    .setValue(FACING, direction.getOpposite())
                    .setValue(RODS, Integer.valueOf(Math.min(2, blockstate.getValue(RODS) + 1)))
                    : this.defaultBlockState()
                    .setValue(FACING, direction)
                    .setValue(RODS, Integer.valueOf(Math.min(2, blockstate.getValue(RODS) + 1)));
        } else {
            FluidState fluidstate = p_196258_1_.getLevel().getFluidState(p_196258_1_.getClickedPos());
            boolean flag = fluidstate.getType() == Fluids.WATER;
            return super.getStateForPlacement(p_196258_1_).setValue(WATERLOGGED, Boolean.valueOf(flag));
        }
    }

    public BlockState rotate(BlockState p_185499_1_, Rotation p_185499_2_) {
        return p_185499_1_.setValue(FACING, p_185499_2_.rotate(p_185499_1_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_185471_1_, Mirror p_185471_2_) {
        return p_185471_1_.setValue(FACING, p_185471_2_.mirror(p_185471_1_.getValue(FACING)));
    }

    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        switch (p_220053_1_.getValue(FACING).getAxis()) {
            case X:
            default:
                switch (p_220053_1_.getValue(RODS)) {
                    case 1:
                    default:
                        return X_AXIS_AA;
                    case 2:
                        return X_AXIS_BB;
                }
            case Z:
                switch (p_220053_1_.getValue(RODS)) {
                    case 1:
                    default:
                        return Y_AXIS_AA;
                    case 2:
                        return Y_AXIS_BB;
                }
            case Y:
                switch (p_220053_1_.getValue(RODS)) {
                    case 1:
                    default:
                        return Z_AXIS_AA;
                    case 2:
                        return Z_AXIS_BB;
                }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState p_180655_1_, World p_180655_2_, BlockPos p_180655_3_, Random p_180655_4_) {
        Direction direction = p_180655_1_.getValue(FACING);
        double d0 = (double) p_180655_3_.getX() + 0.55D - (double) (p_180655_4_.nextFloat() * 0.1F);
        double d1 = (double) p_180655_3_.getY() + 0.55D - (double) (p_180655_4_.nextFloat() * 0.1F);
        double d2 = (double) p_180655_3_.getZ() + 0.55D - (double) (p_180655_4_.nextFloat() * 0.1F);
        double d3 = (double) (0.4F - (p_180655_4_.nextFloat() + p_180655_4_.nextFloat()) * 0.4F);
        if (p_180655_4_.nextInt(5) == 0) {
            p_180655_2_.addParticle(ParticleTypes.END_ROD, d0 + (double) direction.getStepX() * d3, d1 + (double) direction.getStepY() * d3, d2 + (double) direction.getStepZ() * d3, p_180655_4_.nextGaussian() * 0.005D, p_180655_4_.nextGaussian() * 0.005D, p_180655_4_.nextGaussian() * 0.005D);
        }

    }

    public BlockState updateShape(BlockState p_196271_1_, Direction p_196271_2_, BlockState p_196271_3_, IWorld p_196271_4_, BlockPos p_196271_5_, BlockPos p_196271_6_) {
        if (!p_196271_1_.canSurvive(p_196271_4_, p_196271_5_)) {
            return Blocks.AIR.defaultBlockState();
        } else {
            if (p_196271_1_.getValue(WATERLOGGED)) {
                p_196271_4_.getLiquidTicks().scheduleTick(p_196271_5_, Fluids.WATER, Fluids.WATER.getTickDelay(p_196271_4_));
            }

            return super.updateShape(p_196271_1_, p_196271_2_, p_196271_3_, p_196271_4_, p_196271_5_, p_196271_6_);
        }
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(RODS, WATERLOGGED, FACING);
    }

    public PushReaction getPistonPushReaction(BlockState p_149656_1_) {
        return PushReaction.NORMAL;
    }

    public boolean isPathfindable(BlockState p_196266_1_, IBlockReader p_196266_2_, BlockPos p_196266_3_, PathType p_196266_4_) {
        return false;
    }

    public FluidState getFluidState(BlockState p_204507_1_) {
        return p_204507_1_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_204507_1_);
    }
}
