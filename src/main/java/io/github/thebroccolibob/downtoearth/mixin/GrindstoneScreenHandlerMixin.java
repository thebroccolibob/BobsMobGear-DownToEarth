package io.github.thebroccolibob.downtoearth.mixin;

import io.github.thebroccolibob.downtoearth.duck.GrindstoneScreenHandlerDuck;
import io.github.thebroccolibob.downtoearth.recipe.GrindingRecipe.Input;
import io.github.thebroccolibob.downtoearth.registry.ModRecipes;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.screen.GrindstoneScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;

@Mixin(GrindstoneScreenHandler.class)
public abstract class GrindstoneScreenHandlerMixin extends ScreenHandler implements GrindstoneScreenHandlerDuck {

    @Shadow
    @Final
    Inventory input;

    @Shadow
    protected abstract void updateResult();

    @Shadow
    @Final
    private ScreenHandlerContext context;
    @Unique
    private World world;
    @Unique
    private boolean customRecipe = false;

    protected GrindstoneScreenHandlerMixin(@Nullable ScreenHandlerType<?> type, int syncId) {
        super(type, syncId);
    }

    @Override
    public boolean downtoearth$isCustomRecipe() {
        return customRecipe;
    }

    @Override
    public Inventory downtoearth$getInput() {
        return input;
    }

    @Override
    public RecipeManager downtoearth$getRecipeManager() {
        return world.getRecipeManager();
    }

    @Override
    public void downtoearth$updateResult() {
        updateResult();
    }

    @Override
    public ScreenHandlerContext downtoearth$getContext() {
        return context;
    }

    @Inject(
            method = "<init>(ILnet/minecraft/entity/player/PlayerInventory;Lnet/minecraft/screen/ScreenHandlerContext;)V",
            at = @At("TAIL")
    )
    private void saveWorld(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context, CallbackInfo ci) {
        world = playerInventory.player.getWorld();
    }

    @Inject(
            method = "getOutputStack",
            at = @At("HEAD"),
            cancellable = true
    )
    private void applyRecipe(ItemStack firstInput, ItemStack secondInput, CallbackInfoReturnable<ItemStack> cir) {
        var input = new Input(firstInput, secondInput);
        var result = world.getRecipeManager().getFirstMatch(ModRecipes.GRINDING_TYPE, input, world);
        if (result.isEmpty()) {
            customRecipe = false;
            return;
        }
        customRecipe = true;
        cir.setReturnValue(result.get().value().craft(input, world.getRegistryManager()));
    }

}
