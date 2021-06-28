package com.tzaranthony.citydecor.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.PushReaction;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class NeonLight extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    protected static final VoxelShape NS = Block.box(4.0D, 6.0D, 0.0D, 12.0D, 10.0D, 16.0D);
    protected static final VoxelShape EW = Block.box(0.0D, 6.0D, 4.0D, 16.0D, 10.0D, 12.0D);

    public NeonLight(String name, Properties properties) {
        super(properties);
        this.setRegistryName(name);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH));
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
                return EW;
            case Z:
                return NS;
            case Y:
                return NS;
        }
    }

    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        Direction direction = p_196258_1_.getClickedFace();
        BlockState blockstate = p_196258_1_.getLevel().getBlockState(p_196258_1_.getClickedPos().relative(direction.getOpposite()));
        return blockstate.is(this) && blockstate.getValue(FACING) == direction ? this.defaultBlockState().setValue(FACING, direction.getOpposite()) : this.defaultBlockState().setValue(FACING, direction);
    }

//    @OnlyIn(Dist.CLIENT)
//    public void animateTick(BlockState p_180655_1_, World p_180655_2_, BlockPos p_180655_3_, Random p_180655_4_) {
//        Direction direction = p_180655_1_.getValue(FACING);
//        double d0 = (double) p_180655_3_.getX() + 0.55D - (double) (p_180655_4_.nextFloat() * 0.1F);
//        double d1 = (double) p_180655_3_.getY() + 0.55D - (double) (p_180655_4_.nextFloat() * 0.1F);
//        double d2 = (double) p_180655_3_.getZ() + 0.55D - (double) (p_180655_4_.nextFloat() * 0.1F);
//        double d3 = (double) (0.4F - (p_180655_4_.nextFloat() + p_180655_4_.nextFloat()) * 0.4F);
//        if (p_180655_4_.nextInt(5) == 0) {
//            p_180655_2_.addParticle(ParticleTypes.END_ROD, d0 + (double) direction.getStepX() * d3, d1 + (double) direction.getStepY() * d3, d2 + (double) direction.getStepZ() * d3, p_180655_4_.nextGaussian() * 0.005D, p_180655_4_.nextGaussian() * 0.005D, p_180655_4_.nextGaussian() * 0.005D);
//        }
//
//    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FACING);
    }

    public PushReaction getPistonPushReaction(BlockState p_149656_1_) {
        return PushReaction.NORMAL;
    }

    public boolean isPathfindable(BlockState p_196266_1_, IBlockReader p_196266_2_, BlockPos p_196266_3_, PathType p_196266_4_) {
        return false;
    }
}
