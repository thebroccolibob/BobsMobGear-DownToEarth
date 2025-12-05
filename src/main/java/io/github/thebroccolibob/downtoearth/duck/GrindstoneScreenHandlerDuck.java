package io.github.thebroccolibob.downtoearth.duck;

import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.screen.ScreenHandlerContext;

public interface GrindstoneScreenHandlerDuck {
    boolean downtoearth$isCustomRecipe();
    Inventory downtoearth$getInput();
    RecipeManager downtoearth$getRecipeManager();
    void downtoearth$updateResult();
    ScreenHandlerContext downtoearth$getContext();
}
