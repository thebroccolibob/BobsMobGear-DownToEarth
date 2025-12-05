package io.github.thebroccolibob.downtoearth.duck;

import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.RecipeManager;

public interface GrindstoneScreenHandlerDuck {
    boolean downtoearth$isCustomRecipe();
    Inventory downtoearth$getInput();
    RecipeManager downtoearth$getRecipeManager();
    void downtoearth$updateResult();
}
