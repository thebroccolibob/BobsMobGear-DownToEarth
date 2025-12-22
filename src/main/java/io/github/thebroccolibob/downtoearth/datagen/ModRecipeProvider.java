package io.github.thebroccolibob.downtoearth.datagen;

import io.github.thebroccolibob.bobsmobgear.registry.BobsMobGearItems;
import io.github.thebroccolibob.downtoearth.registry.ModBlocks;
import io.github.thebroccolibob.downtoearth.registry.ModItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.LEAF_FIBER, RecipeCategory.MISC, ModBlocks.LEAF_FIBER_BALE);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FLINT_TOOL)
                .pattern("^")
                .pattern("~")
                .input('^', Items.FLINT)
                .input('~', ModItems.LEAF_FIBER)
                .criterion(hasItem(ModItems.LEAF_FIBER), conditionsFromItem(ModItems.LEAF_FIBER))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FLINT_AXE)
                .pattern("^|")
                .pattern(" |")
                .input('^', ModItems.FLINT_TOOL)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.FLINT_TOOL), conditionsFromItem(ModItems.FLINT_TOOL))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CLAY_INGOT_MOLD)
                .pattern(" o ")
                .pattern("ono")
                .pattern(" o ")
                .input('o', Items.CLAY_BALL)
                .input('n', Items.BRICK)
                .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                .offerTo(recipeExporter);
    }
}
