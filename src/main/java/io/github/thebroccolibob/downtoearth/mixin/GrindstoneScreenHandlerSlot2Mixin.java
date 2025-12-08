package io.github.thebroccolibob.downtoearth.mixin;

import io.github.thebroccolibob.downtoearth.duck.GrindstoneScreenHandlerDuck;
import io.github.thebroccolibob.downtoearth.registry.ModRecipes;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GrindstoneScreenHandler;

@Mixin(targets = "net.minecraft.screen.GrindstoneScreenHandler$3")
public class GrindstoneScreenHandlerSlot2Mixin {
    @Unique
    private GrindstoneScreenHandler outer;

    @Inject(
            method = "<init>",
            at = @At("TAIL")
    )
    private void saveOuter(GrindstoneScreenHandler grindstoneScreenHandler, Inventory inventory, int i, int j, int k, CallbackInfo ci) {
        outer = grindstoneScreenHandler;
    }

    @ModifyReturnValue(
            method = "canInsert",
            at = @At("RETURN")
    )
    private boolean allowRecipeItems(boolean original, @Local(argsOnly = true) ItemStack stack) {
        return original || ((GrindstoneScreenHandlerDuck) outer).downtoearth$getRecipeManager()
                .listAllOfType(ModRecipes.GRINDING_TYPE).stream()
                .anyMatch(recipe -> recipe.value().reference().test(stack));
    }
}
