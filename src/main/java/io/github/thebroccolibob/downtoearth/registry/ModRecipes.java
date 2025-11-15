package io.github.thebroccolibob.downtoearth.registry;

import io.github.thebroccolibob.downtoearth.DownToEarth;
import io.github.thebroccolibob.downtoearth.recipe.CarvingRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeType<CarvingRecipe> CARVING_TYPE =
            Registry.register(Registries.RECIPE_TYPE,
                    Identifier.of(DownToEarth.MOD_ID, "carving"),
                    new RecipeType<CarvingRecipe>() {
                        @Override
                        public String toString() {
                            return DownToEarth.MOD_ID + ":carving";
                        }
                    });

    public static final RecipeSerializer<CarvingRecipe> CARVING_SERIALIZER =
            Registry.register(Registries.RECIPE_SERIALIZER,
                    Identifier.of(DownToEarth.MOD_ID, "carving"),
                    new CarvingRecipe.Serializer());

    public static void registerModRecipes() {
        DownToEarth.LOGGER.info("These Recipes are " + DownToEarth.MOD_ID + "!");
    }
}
