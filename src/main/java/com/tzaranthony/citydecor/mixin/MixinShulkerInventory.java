package com.tzaranthony.citydecor.mixin;

import com.tzaranthony.citydecor.block.CardboardBox;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;

@Mixin(ShulkerBoxBlockEntity.class)
public abstract class MixinShulkerInventory {
    @Inject(at = @At(value = "HEAD"), method = "canPlaceItemThroughFace", cancellable = true)
    public void restrictCardboardBox(int p_59663_, ItemStack p_59664_, @Nullable Direction p_59665_, CallbackInfoReturnable<Boolean> cir) {
        if (Block.byItem(p_59664_.getItem()) instanceof CardboardBox) {
            cir.cancel();
            cir.setReturnValue(false);
        }
    }
}