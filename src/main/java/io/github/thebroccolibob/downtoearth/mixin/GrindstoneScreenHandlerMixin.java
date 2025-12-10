package io.github.thebroccolibob.downtoearth.mixin;

import io.github.thebroccolibob.downtoearth.recipe.GrindingRecipe.Input;
import io.github.thebroccolibob.downtoearth.registry.ModRecipes;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GrindstoneScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;

import org.jetbrains.annotations.Nullable;

@Mixin(GrindstoneScreenHandler.class)
public abstract class GrindstoneScreenHandlerMixin extends ScreenHandler {

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

    @ModifyArg(
            method = "<init>(ILnet/minecraft/entity/player/PlayerInventory;Lnet/minecraft/screen/ScreenHandlerContext;)V",
            at = @At(ordinal = 0, value = "INVOKE", target = "Lnet/minecraft/screen/GrindstoneScreenHandler;addSlot(Lnet/minecraft/screen/slot/Slot;)Lnet/minecraft/screen/slot/Slot;")
    )
    private Slot allowRecipeItems1(Slot slot) {
        return new Slot(slot.inventory, slot.getIndex(), slot.x, slot.y) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return slot.canInsert(stack) || world.getRecipeManager()
                        .listAllOfType(ModRecipes.GRINDING_TYPE).stream()
                        .anyMatch(recipe -> recipe.value().ingredient().test(stack));
            }
        };
    }

    @ModifyArg(
            method = "<init>(ILnet/minecraft/entity/player/PlayerInventory;Lnet/minecraft/screen/ScreenHandlerContext;)V",
            at = @At(ordinal = 1, value = "INVOKE", target = "Lnet/minecraft/screen/GrindstoneScreenHandler;addSlot(Lnet/minecraft/screen/slot/Slot;)Lnet/minecraft/screen/slot/Slot;")
    )
    private Slot allowRecipeItems2(Slot slot) {
        return new Slot(slot.inventory, slot.getIndex(), slot.x, slot.y) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return slot.canInsert(stack) || world.getRecipeManager()
                        .listAllOfType(ModRecipes.GRINDING_TYPE).stream()
                        .anyMatch(recipe -> recipe.value().reference().test(stack));
            }
        };
    }

    @ModifyArg(
            method = "<init>(ILnet/minecraft/entity/player/PlayerInventory;Lnet/minecraft/screen/ScreenHandlerContext;)V",
            at = @At(ordinal = 2, value = "INVOKE", target = "Lnet/minecraft/screen/GrindstoneScreenHandler;addSlot(Lnet/minecraft/screen/slot/Slot;)Lnet/minecraft/screen/slot/Slot;")
    )
    private Slot onlyDecrementIngredient(Slot slot) {
        return new Slot(slot.inventory, slot.getIndex(), slot.x, slot.y) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return slot.canInsert(stack);
            }

            @Override
            public void onTakeItem(PlayerEntity player, ItemStack stack) {
                if (!customRecipe) {
                    slot.onTakeItem(player, stack);
                    return;
                }

                context.run((world, pos) -> {
                    world.syncWorldEvent(WorldEvents.GRINDSTONE_USED, pos, 0);
                });
                input.getStack(0).decrement(1);
                updateResult();
            }
        };
    }
}
