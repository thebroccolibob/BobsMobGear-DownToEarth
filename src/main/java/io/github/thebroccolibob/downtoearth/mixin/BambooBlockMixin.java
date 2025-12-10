package io.github.thebroccolibob.downtoearth.mixin;

import io.github.thebroccolibob.downtoearth.registry.ModItems;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.block.BambooBlock;
import net.minecraft.block.BambooShootBlock;
import net.minecraft.entity.player.PlayerEntity;

@Mixin({BambooBlock.class, BambooShootBlock.class})
public class BambooBlockMixin {
    @ModifyReturnValue(
            method = "calcBlockBreakingDelta",
            at = @At("RETURN")
    )
    private float flintToolInstantBreaks(float original, @Local(argsOnly = true) PlayerEntity player) {
        return player.getMainHandStack().isOf(ModItems.FLINT_TOOL) ? 1 : original;
    }
}
