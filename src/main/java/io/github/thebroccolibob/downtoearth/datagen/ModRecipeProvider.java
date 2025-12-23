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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CLAY_SWORD_BLADE_MOLD)
                .pattern(" o ")
                .pattern("ono")
                .pattern(" o ")
                .input('o', Items.CLAY_BALL)
                .input('n', ModItems.WOODEN_SWORD_BLADE)
                .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CLAY_SHOVEL_HEAD_MOLD)
                .pattern(" o ")
                .pattern("ono")
                .pattern(" o ")
                .input('o', Items.CLAY_BALL)
                .input('n', ModItems.WOODEN_SHOVEL_HEAD)
                .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CLAY_PICKAXE_HEAD_MOLD)
                .pattern(" o ")
                .pattern("ono")
                .pattern(" o ")
                .input('o', Items.CLAY_BALL)
                .input('n', ModItems.WOODEN_PICKAXE_HEAD)
                .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CLAY_AXE_HEAD_MOLD)
                .pattern(" o ")
                .pattern("ono")
                .pattern(" o ")
                .input('o', Items.CLAY_BALL)
                .input('n', ModItems.WOODEN_AXE_HEAD)
                .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CLAY_HOE_HEAD_MOLD)
                .pattern(" o ")
                .pattern("ono")
                .pattern(" o ")
                .input('o', Items.CLAY_BALL)
                .input('n', ModItems.WOODEN_HOE_HEAD)
                .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.STONE_SMITHING_HAMMER)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.STONE_SMITHING_HAMMER_HEAD)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.STONE_SMITHING_HAMMER_HEAD), conditionsFromItem(ModItems.STONE_SMITHING_HAMMER_HEAD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.STONE_SHOVEL)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.STONE_SHOVEL_HEAD)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.STONE_SHOVEL_HEAD), conditionsFromItem(ModItems.STONE_SHOVEL_HEAD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.STONE_PICKAXE)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.STONE_PICKAXE_HEAD)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.STONE_PICKAXE_HEAD), conditionsFromItem(ModItems.STONE_PICKAXE_HEAD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.STONE_AXE)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.STONE_AXE_HEAD)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.STONE_AXE_HEAD), conditionsFromItem(ModItems.STONE_AXE_HEAD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.STONE_HOE)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.STONE_HOE_HEAD)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.STONE_HOE_HEAD), conditionsFromItem(ModItems.STONE_HOE_HEAD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.STONE_SWORD)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.STONE_SWORD_BLADE)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.STONE_SWORD_BLADE), conditionsFromItem(ModItems.STONE_SWORD_BLADE))
                .offerTo(recipeExporter);

        List<ItemConvertible> SWORD_BLADE_SMELT = List.of(ModItems.CLAY_SWORD_BLADE_MOLD);
        offerSmelting(recipeExporter, SWORD_BLADE_SMELT, RecipeCategory.MISC, BobsMobGearItems.SWORD_TEMPLATE, 0f, 200, "sword_template");

        List<ItemConvertible> SHOVEL_HEAD_SMELT = List.of(ModItems.CLAY_SHOVEL_HEAD_MOLD);
        offerSmelting(recipeExporter, SHOVEL_HEAD_SMELT, RecipeCategory.MISC, BobsMobGearItems.SHOVEL_TEMPLATE, 0f, 200, "shovel_template");

        List<ItemConvertible> PICKAXE_HEAD_SMELT = List.of(ModItems.CLAY_PICKAXE_HEAD_MOLD);
        offerSmelting(recipeExporter, PICKAXE_HEAD_SMELT, RecipeCategory.MISC, BobsMobGearItems.PICKAXE_TEMPLATE, 0f, 200, "pickaxe_template");

        List<ItemConvertible> AXE_HEAD_SMELT = List.of(ModItems.CLAY_AXE_HEAD_MOLD);
        offerSmelting(recipeExporter, AXE_HEAD_SMELT, RecipeCategory.MISC, BobsMobGearItems.AXE_TEMPLATE, 0f, 200, "axe_template");

        List<ItemConvertible> HOE_HEAD_SMELT = List.of(ModItems.CLAY_HOE_HEAD_MOLD);
        offerSmelting(recipeExporter, HOE_HEAD_SMELT, RecipeCategory.MISC, BobsMobGearItems.HOE_TEMPLATE, 0f, 200, "hoe_template");
    }
}
