package io.github.thebroccolibob.downtoearth.registry;

import io.github.thebroccolibob.downtoearth.DownToEarth;
import io.github.thebroccolibob.downtoearth.recipe.CarvingRecipe;
import io.github.thebroccolibob.downtoearth.recipe.GrindingRecipe;
import io.github.thebroccolibob.downtoearth.recipe.HammeringRecipe;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeType<CarvingRecipe> CARVING_TYPE = registerRecipeType("carving");

    public static final RecipeSerializer<CarvingRecipe> CARVING_SERIALIZER =
            registerRecipeSerializer("carving", new CarvingRecipe.Serializer());

    public static final RecipeType<HammeringRecipe> HAMMERING_TYPE = registerRecipeType("hammering");

    public static final RecipeSerializer<HammeringRecipe> HAMMERING_SERIALIZER =
            registerRecipeSerializer("hammering", new HammeringRecipe.Serializer());

    public static final RecipeType<GrindingRecipe> GRINDING_TYPE = registerRecipeType("grinding");

    public static final RecipeSerializer<GrindingRecipe> GRINDING_SERIALIZER =
            registerRecipeSerializer("grinding", GrindingRecipe.SERIALIZER);

    private static <T extends Recipe<?>> RecipeType<T> registerRecipeType(String name) {
        return Registry.register(Registries.RECIPE_TYPE,
                Identifier.of(DownToEarth.MOD_ID, name),
                new RecipeType<T>() {
                    @Override
                    public String toString() {
                        return DownToEarth.MOD_ID + ":" + name;
                    }
                });
    }

    private static <T extends RecipeSerializer<?>> T registerRecipeSerializer(String name, T serializer) {
        return Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(DownToEarth.MOD_ID, name), serializer);
    }

    public static void registerModRecipes() {
        DownToEarth.LOGGER.info("These Recipes are " + DownToEarth.MOD_ID + "!");
    }
}
