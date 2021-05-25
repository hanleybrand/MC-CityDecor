package com.tzaranthony.modernvanilla.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Chair extends Block {//implements ITileEntityProvider {
    public static final BooleanProperty OCCUPIED = BlockStateProperties.OCCUPIED;
    protected static final VoxelShape BASE = Block.box(0.0D, 3.0D, 0.0D, 16.0D, 9.0D, 16.0D);
    protected static final VoxelShape LEG_NORTH_WEST = Block.box(0.0D, 0.0D, 0.0D, 3.0D, 3.0D, 3.0D);
    protected static final VoxelShape LEG_SOUTH_WEST = Block.box(0.0D, 0.0D, 13.0D, 3.0D, 3.0D, 16.0D);
    protected static final VoxelShape LEG_NORTH_EAST = Block.box(13.0D, 0.0D, 0.0D, 16.0D, 3.0D, 3.0D);
    protected static final VoxelShape LEG_SOUTH_EAST = Block.box(13.0D, 0.0D, 13.0D, 16.0D, 3.0D, 16.0D);
    protected static final VoxelShape NORTH_SHAPE = VoxelShapes.or(BASE, LEG_NORTH_WEST, LEG_NORTH_EAST);
    protected static final VoxelShape SOUTH_SHAPE = VoxelShapes.or(BASE, LEG_SOUTH_WEST, LEG_SOUTH_EAST);
    protected static final VoxelShape WEST_SHAPE = VoxelShapes.or(BASE, LEG_NORTH_WEST, LEG_SOUTH_WEST);
    protected static final VoxelShape EAST_SHAPE = VoxelShapes.or(BASE, LEG_NORTH_EAST, LEG_SOUTH_EAST);
    private final DyeColor color;

    public Chair(String name, DyeColor colorIn) {
        super(AbstractBlock.Properties.of(Material.WOOL, colorIn)
                .sound(SoundType.WOOD)
                .strength(0.2F)
                .noOcclusion());
        this.setRegistryName(name);
        this.color = colorIn;
        this.registerDefaultState(this.stateDefinition.any().setValue(OCCUPIED, Boolean.valueOf(false)));
    }

    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (worldIn.isClientSide) {
            return ActionResultType.CONSUME;
        } else {
            if (state.getValue(OCCUPIED)) {
                player.displayClientMessage(new TranslationTextComponent("block.minecraft.bed.occupied"), true);
                return ActionResultType.SUCCESS;
            } else {
//                player.startRiding();
                return ActionResultType.SUCCESS;
            }
        }
    }

    /**
     * Block's chance to react to a living entity falling on it.
     */
    public void fallOn(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        super.fallOn(worldIn, pos, entityIn, fallDistance * 0.5F);
    }

    /**
     * Called when an Entity lands on this Block. This method *must* update motionY because the entity will not do that
     * on its own
     */
    public void updateEntityAfterFallOn(IBlockReader worldIn, Entity entityIn) {
        if (entityIn.isSuppressingBounce()) {
            super.updateEntityAfterFallOn(worldIn, entityIn);
        } else {
            this.bounceUp(entityIn);
        }

    }

    private void bounceUp(Entity entityIn) {
        Vector3d vector3d = entityIn.getDeltaMovement();
        if (vector3d.y < 0.0D) {
            double d0 = entityIn instanceof LivingEntity ? 1.0D : 0.8D;
            entityIn.setDeltaMovement(vector3d.x, -vector3d.y * (double) 0.66F * d0, vector3d.z);
        }
    }

    public PushReaction getPistonPushReaction(BlockState stateIn) {
        return PushReaction.DESTROY;
    }

    /**
     * The type of render function called. MODEL for mixed tesr and static model, MODELBLOCK_ANIMATED for TESR-only,
     * LIQUID for vanilla liquids, INVISIBLE to skip all rendering
     */
    public BlockRenderType getRenderShape(BlockState stateIn) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(OCCUPIED);
    }

//    public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
//        return new ChairTileEntity(this.color);
//    }

    @OnlyIn(Dist.CLIENT)
    public DyeColor getColor() {
        return this.color;
    }

    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }
}
