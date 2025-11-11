package io.github.thebroccolibob.downtoearth.mixin;

import io.github.thebroccolibob.downtoearth.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CampfireBlock.class)
class CampfireBlockMixin {
    @Inject(method = "isSignalFireBaseBlock", at = @At("RETURN"), cancellable = true)
    private void AltIsSignalFireBaseBlock(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValue()) {
            if (state.isOf(ModBlocks.LEAF_FIBER_BALE)) {
                cir.setReturnValue(true);
            }
        }
    }
}
