package io.github.thebroccolibob.downtoearth.mixin;

import io.github.thebroccolibob.downtoearth.duck.GrindstoneScreenHandlerDuck;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GrindstoneScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.world.WorldEvents;

@Mixin(targets = "net.minecraft.screen.GrindstoneScreenHandler$4")
public class GrindstoneScreenHandlerSlot3Mixin {
    @Shadow
    @Final
    GrindstoneScreenHandler field_16780;

    @Shadow
    @Final
    ScreenHandlerContext field_16779;

    @Inject(
            method = "onTakeItem",
            at = @At("HEAD"),
            cancellable = true
    )
    private void onlyDecrementIngredient(PlayerEntity player, ItemStack stack, CallbackInfo ci) {
        var outer = (GrindstoneScreenHandlerDuck) field_16780;
        if (!outer.downtoearth$isCustomRecipe()) return;

        field_16779.run((world, pos) -> {
            world.syncWorldEvent(WorldEvents.GRINDSTONE_USED, pos, 0);
        });
        outer.downtoearth$getInput().getStack(0).decrement(1);
        outer.downtoearth$updateResult();

        ci.cancel();
    }
}
