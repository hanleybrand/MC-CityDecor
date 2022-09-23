package com.tzaranthony.citydecor.mixin;

import com.tzaranthony.citydecor.block.CardboardBox;
import net.minecraft.world.inventory.ShulkerBoxSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShulkerBoxSlot.class)
public abstract class MixinShulkerSlot {
    @Inject(at = @At(value = "HEAD"), method = "mayPlace", cancellable = true)
    public void restrictCardboardBox(ItemStack p_40207_, CallbackInfoReturnable<Boolean> cir) {
        if (Block.byItem(p_40207_.getItem()) instanceof CardboardBox) {
            cir.cancel();
            cir.setReturnValue(false);
        }
    }
}