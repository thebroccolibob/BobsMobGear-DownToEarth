package io.github.thebroccolibob.downtoearth.recipe;

import io.github.thebroccolibob.downtoearth.registry.ModRecipes;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CuttingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;

public class HammeringRecipe extends CuttingRecipe {
    public HammeringRecipe(String group, Ingredient ingredient, ItemStack result) {
        super(ModRecipes.HAMMERING_TYPE, ModRecipes.HAMMERING_SERIALIZER, group, ingredient, result);
    }

    @Override
    public boolean matches(SingleStackRecipeInput input, World world) {
        return this.ingredient.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(SingleStackRecipeInput singleStackRecipeInput, RegistryWrapper.WrapperLookup wrapperLookup) {
        var stack = singleStackRecipeInput.item().copyComponentsToNewStack(result.getItem(), result.getCount());
        stack.applyUnvalidatedChanges(result.getComponentChanges());
        return stack;
    }

    public static class Serializer extends CuttingRecipe.Serializer<HammeringRecipe> {
        public Serializer() {
            super(HammeringRecipe::new);
        }
    }
}
