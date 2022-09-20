package com.tzaranthony.citydecor.block;

import com.tzaranthony.citydecor.util.CDDamageSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class CDStairsDmg extends StairBlock {
    public CDStairsDmg(String name, BlockState state, BlockBehaviour block) {
        super(state, Properties.copy(block));
        this.setRegistryName(name);
    }

    public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity) {
            entityIn.makeStuckInBlock(state, new Vec3((double) 0.5F, 0.75D, (double) 0.5F));
            entityIn.hurt(CDDamageSource.BARBED_WIRE, 0.5F);
            double d0 = Math.abs(entityIn.getX() - entityIn.xOld);
            double d1 = Math.abs(entityIn.getZ() - entityIn.zOld);
            double d2 = Math.abs(entityIn.getY() - entityIn.yOld);
            if (d0 >= (double) 0.003F || d1 >= (double) 0.003F || d2 >= (double) 0.0003F) {
                entityIn.hurt(CDDamageSource.BARBED_WIRE, 4.5F);
            }
        }
    }
}