package io.github.thebroccolibob.downtoearth.recipe;

import io.github.thebroccolibob.downtoearth.registry.ModRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.world.World;


public class CarvingRecipe extends CuttingRecipe {
    public CarvingRecipe(String group, Ingredient ingredient, ItemStack result) {
        super(ModRecipes.CARVING_TYPE, ModRecipes.CARVING_SERIALIZER, group, ingredient, result);
    }

    @Override
    public boolean matches(SingleStackRecipeInput input, World world) {
        return this.ingredient.test(input.getStackInSlot(0));
    }

    public static class Serializer extends CuttingRecipe.Serializer<CarvingRecipe> {
        public Serializer() {
            super(CarvingRecipe::new);
        }
    }
}
