package com.tzaranthony.modernvanilla.block;

import com.tzaranthony.modernvanilla.util.MVDamageSource;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class BarbedWire extends RotatedPillarBlock {

    public BarbedWire(String name) {
        super(MVBlockProperties.BarbedWire());
        this.setRegistryName(name);
    }

    public void entityInside(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity) {
            entityIn.makeStuckInBlock(state, new Vector3d((double) 0.5F, 0.75D, (double) 0.5F));
            entityIn.hurt(MVDamageSource.BARBED_WIRE, 0.5F);
            double d0 = Math.abs(entityIn.getX() - entityIn.xOld);
            double d1 = Math.abs(entityIn.getZ() - entityIn.zOld);
            double d2 = Math.abs(entityIn.getY() - entityIn.yOld);
            if (d0 >= (double) 0.003F || d1 >= (double) 0.003F || d2 >= (double) 0.0003F) {
                entityIn.hurt(MVDamageSource.BARBED_WIRE, 4.5F);
            }
        }
    }

    @Override
    public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, net.minecraft.entity.LivingEntity entity) {
        return true;
    }
}
