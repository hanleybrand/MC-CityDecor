package com.tzaranthony.citydecor.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.material.PushReaction;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class Rod extends DirectionalBlock {
    protected static final VoxelShape ROD_VERTICAL_AABB = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);
    protected static final VoxelShape ROD_NS_AABB = Block.box(6.0D, 6.0D, 0.0D, 10.0D, 10.0D, 16.0D);
    protected static final VoxelShape ROD_EW_AABB = Block.box(0.0D, 6.0D, 6.0D, 16.0D, 10.0D, 10.0D);

    public Rod(String name, Properties properties) {
        super(properties);
        this.setRegistryName(name);
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.setValue(FACING, mirrorIn.mirror(state.getValue(FACING)));
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.getValue(FACING).getAxis()) {
            case X:
            default:
                return ROD_EW_AABB;
            case Z:
                return ROD_NS_AABB;
            case Y:
                return ROD_VERTICAL_AABB;
        }
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        Direction direction = context.getClickedFace();
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos().relative(direction.getOpposite()));
        return blockstate.is(this)
                && blockstate.getValue(FACING) == direction ? this.defaultBlockState().setValue(FACING, direction.getOpposite())
                : this.defaultBlockState().setValue(FACING, direction);
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.NORMAL;
    }

    public boolean isPathfindable(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }
}
