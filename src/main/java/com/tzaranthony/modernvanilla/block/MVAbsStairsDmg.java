package com.tzaranthony.modernvanilla.block;

import com.tzaranthony.modernvanilla.util.MVDamageSource;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class MVAbsStairsDmg extends StairsBlock {
    public MVAbsStairsDmg(String name, BlockState state, AbstractBlock block) {
        super(state, Properties.from(block));
        this.setRegistryName(name);
    }

    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity) {
            entityIn.setMotionMultiplier(state, new Vector3d((double) 0.5F, 0.75D, (double) 0.5F));
            entityIn.attackEntityFrom(MVDamageSource.BARBED_WIRE, 0.5F);
            double d0 = Math.abs(entityIn.getPosX() - entityIn.lastTickPosX);
            double d1 = Math.abs(entityIn.getPosZ() - entityIn.lastTickPosZ);
            double d2 = Math.abs(entityIn.getPosY() - entityIn.lastTickPosY);
            if (d0 >= (double) 0.003F || d1 >= (double) 0.003F || d2 >= (double) 0.0003F) {
                entityIn.attackEntityFrom(MVDamageSource.BARBED_WIRE, 4.5F);
            }
        }
    }

    @Override
    public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, net.minecraft.entity.LivingEntity entity) {
        return true;
    }
}
