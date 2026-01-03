package io.github.thebroccolibob.downtoearth.datagen;

import io.github.thebroccolibob.bobsmobgear.registry.BobsMobGearItems;
import io.github.thebroccolibob.downtoearth.registry.ModBlocks;
import io.github.thebroccolibob.downtoearth.registry.ModItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.StonecuttingRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
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
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.LEAF_FIBER, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEAF_FIBER_BALE);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.TIN_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TIN_BLOCK);

        offer2x2CompactingRecipe(recipeExporter, RecipeCategory.MISC, Items.COAL, ModItems.COAL_PIECE);
        offer2x2CompactingRecipe(recipeExporter, RecipeCategory.MISC, ModItems.COKING_COAL, ModItems.COKING_COAL_PIECE);
        offer2x2CompactingRecipe(recipeExporter, RecipeCategory.MISC, Items.LAPIS_LAZULI, ModItems.LAPIS_LAZULI_PIECE);
        offer2x2CompactingRecipe(recipeExporter, RecipeCategory.MISC, Items.EMERALD, ModItems.EMERALD_SHARD);
        offer2x2CompactingRecipe(recipeExporter, RecipeCategory.MISC, Items.DIAMOND, ModItems.DIAMOND_SHARD);

        offerCompactingRecipe(recipeExporter, RecipeCategory.MISC, Items.RAW_COPPER, ModItems.RAW_COPPER_NUGGET);
        offerCompactingRecipe(recipeExporter, RecipeCategory.MISC, Items.RAW_IRON, ModItems.RAW_IRON_NUGGET);
        offerCompactingRecipe(recipeExporter, RecipeCategory.MISC, ModItems.RAW_TIN, ModItems.RAW_TIN_NUGGET);
        offerCompactingRecipe(recipeExporter, RecipeCategory.MISC, ModBlocks.RAW_TIN_BLOCK, ModItems.RAW_TIN);

        offerSlabRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_TIN_SLAB, ModBlocks.CUT_TIN);
        offerGrateRecipe(recipeExporter, ModBlocks.TIN_GRATE, ModBlocks.TIN_BLOCK);
        offerChiseledBlockRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_TIN, ModBlocks.CUT_TIN_SLAB);
        offerBulbRecipe(recipeExporter, ModBlocks.TIN_BULB, ModBlocks.TIN_BLOCK);

        createDoorRecipe(ModBlocks.TIN_DOOR, Ingredient.ofItems(ModItems.TIN_INGOT))
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(recipeExporter);

        createTrapdoorRecipe(ModBlocks.TIN_TRAPDOOR, Ingredient.ofItems(ModItems.TIN_INGOT))
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .offerTo(recipeExporter);

        createStairsRecipe(ModBlocks.CUT_TIN_STAIRS, Ingredient.ofItems(ModBlocks.CUT_TIN))
                .criterion(hasItem(ModBlocks.CUT_TIN), conditionsFromItem(ModBlocks.CUT_TIN))
                .offerTo(recipeExporter);

        offerCustomSmithingTemplateCopyingRecipe(recipeExporter, ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE, Items.COBBLED_DEEPSLATE, ModItems.STEEL_INGOT);

        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBlocks.TIN_BLOCK), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_TIN)
                .criterion(hasItem(ModBlocks.TIN_BLOCK), conditionsFromItem(ModBlocks.TIN_BLOCK))
                .offerTo(recipeExporter);
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBlocks.TIN_BLOCK), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_TIN_STAIRS)
                .criterion(hasItem(ModBlocks.TIN_BLOCK), conditionsFromItem(ModBlocks.TIN_BLOCK))
                .offerTo(recipeExporter, "downtoearth:cut_tin_stairs_stonecutting");
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBlocks.TIN_BLOCK), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_TIN_SLAB)
                .criterion(hasItem(ModBlocks.TIN_BLOCK), conditionsFromItem(ModBlocks.TIN_BLOCK))
                .offerTo(recipeExporter, "downtoearth:cut_tin_slab_stonecutting");
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBlocks.TIN_BLOCK), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_TIN)
                .criterion(hasItem(ModBlocks.TIN_BLOCK), conditionsFromItem(ModBlocks.TIN_BLOCK))
                .offerTo(recipeExporter, "downtoearth:chiseled_tin_stonecutting");
        StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(ModBlocks.TIN_BLOCK), RecipeCategory.BUILDING_BLOCKS, ModBlocks.TIN_GRATE)
                .criterion(hasItem(ModBlocks.TIN_BLOCK), conditionsFromItem(ModBlocks.TIN_BLOCK))
                .offerTo(recipeExporter, "downtoearth:tin_grate_stonecutting");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRONZE_MIX)
                .input(ModItems.RAW_TIN)
                .input(ModItems.RAW_TIN)
                .input(ModItems.RAW_TIN)
                .input(ModItems.RAW_TIN)
                .input(Items.RAW_COPPER)
                .input(Items.RAW_COPPER)
                .input(Items.RAW_COPPER)
                .input(Items.RAW_COPPER)
                .criterion(hasItem(ModItems.RAW_TIN), conditionsFromItem(ModItems.RAW_TIN))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.FLINT_AND_STEEL)
                .input(ModItems.STEEL_INGOT)
                .input(Items.FLINT)
                .criterion(hasItem(ModItems.STEEL_INGOT), conditionsFromItem(ModItems.STEEL_INGOT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_TIN, 4)
                .pattern("nn")
                .pattern("nn")
                .input('n', ModBlocks.TIN_BLOCK)
                .criterion(hasItem(ModBlocks.TIN_BLOCK), conditionsFromItem(ModBlocks.TIN_BLOCK))
                .offerTo(recipeExporter, "downtoearth:cut_tin_compact");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.NETHERITE_SCRAP)
                .pattern("-o-")
                .input('-', ModItems.ANCIENT_DEBRIS_FRAGMENT)
                .input('o', Items.FIRE_CHARGE)
                .criterion(hasItem(ModItems.ANCIENT_DEBRIS_FRAGMENT), conditionsFromItem(ModItems.ANCIENT_DEBRIS_FRAGMENT))
                .offerTo(recipeExporter);

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

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CLAY_HELMET_MOLD)
                .pattern(" o ")
                .pattern("ono")
                .pattern(" o ")
                .input('o', Items.CLAY_BALL)
                .input('n', Items.LEATHER_HELMET)
                .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CLAY_CHESTPLATE_MOLD)
                .pattern(" o ")
                .pattern("ono")
                .pattern(" o ")
                .input('o', Items.CLAY_BALL)
                .input('n', Items.LEATHER_CHESTPLATE)
                .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CLAY_LEGGINGS_MOLD)
                .pattern(" o ")
                .pattern("ono")
                .pattern(" o ")
                .input('o', Items.CLAY_BALL)
                .input('n', Items.LEATHER_LEGGINGS)
                .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CLAY_BOOTS_MOLD)
                .pattern(" o ")
                .pattern("ono")
                .pattern(" o ")
                .input('o', Items.CLAY_BALL)
                .input('n', Items.LEATHER_BOOTS)
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_SWORD)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.BRONZE_SWORD_BLADE)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.BRONZE_SWORD_BLADE), conditionsFromItem(ModItems.BRONZE_SWORD_BLADE))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_PICKAXE)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.BRONZE_PICKAXE_HEAD)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.BRONZE_PICKAXE_HEAD), conditionsFromItem(ModItems.BRONZE_PICKAXE_HEAD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_SHOVEL)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.BRONZE_SHOVEL_HEAD)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.BRONZE_SHOVEL_HEAD), conditionsFromItem(ModItems.BRONZE_SHOVEL_HEAD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_AXE)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.BRONZE_AXE_HEAD)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.BRONZE_AXE_HEAD), conditionsFromItem(ModItems.BRONZE_AXE_HEAD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_HOE)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.BRONZE_HOE_HEAD)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.BRONZE_HOE_HEAD), conditionsFromItem(ModItems.BRONZE_HOE_HEAD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.IRON_SHOVEL)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.IRON_SHOVEL_HEAD)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.IRON_SHOVEL_HEAD), conditionsFromItem(ModItems.IRON_SHOVEL_HEAD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.IRON_PICKAXE)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.IRON_PICKAXE_HEAD)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.IRON_PICKAXE_HEAD), conditionsFromItem(ModItems.IRON_PICKAXE_HEAD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.IRON_AXE)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.IRON_AXE_HEAD)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.IRON_AXE_HEAD), conditionsFromItem(ModItems.IRON_AXE_HEAD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.IRON_HOE)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.IRON_HOE_HEAD)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.IRON_HOE_HEAD), conditionsFromItem(ModItems.IRON_HOE_HEAD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.IRON_SWORD)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.IRON_SWORD_BLADE)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.IRON_SWORD_BLADE), conditionsFromItem(ModItems.IRON_SWORD_BLADE))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.STEEL_SHOVEL)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.STEEL_SHOVEL_HEAD)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.STEEL_SHOVEL_HEAD), conditionsFromItem(ModItems.STEEL_SHOVEL_HEAD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.STEEL_PICKAXE)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.STEEL_PICKAXE_HEAD)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.STEEL_PICKAXE_HEAD), conditionsFromItem(ModItems.STEEL_PICKAXE_HEAD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.STEEL_AXE)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.STEEL_AXE_HEAD)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.STEEL_AXE_HEAD), conditionsFromItem(ModItems.STEEL_AXE_HEAD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.STEEL_HOE)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.STEEL_HOE_HEAD)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.STEEL_HOE_HEAD), conditionsFromItem(ModItems.STEEL_HOE_HEAD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.STEEL_SWORD)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.STEEL_SWORD_BLADE)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.STEEL_SWORD_BLADE), conditionsFromItem(ModItems.STEEL_SWORD_BLADE))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.DIAMOND_SWORD)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.DIAMOND_SWORD_BLADE)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.DIAMOND_SWORD_BLADE), conditionsFromItem(ModItems.DIAMOND_SWORD_BLADE))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.DIAMOND_HOE)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.DIAMOND_HOE_HEAD)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.DIAMOND_HOE_HEAD), conditionsFromItem(ModItems.DIAMOND_HOE_HEAD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.DIAMOND_AXE)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.DIAMOND_AXE_HEAD)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.DIAMOND_AXE_HEAD), conditionsFromItem(ModItems.DIAMOND_AXE_HEAD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.DIAMOND_PICKAXE)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.DIAMOND_PICKAXE_HEAD)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.DIAMOND_PICKAXE_HEAD), conditionsFromItem(ModItems.DIAMOND_PICKAXE_HEAD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.DIAMOND_SHOVEL)
                .pattern(" n")
                .pattern("| ")
                .input('n', ModItems.DIAMOND_SHOVEL_HEAD)
                .input('|', Items.STICK)
                .criterion(hasItem(ModItems.DIAMOND_SHOVEL_HEAD), conditionsFromItem(ModItems.DIAMOND_SHOVEL_HEAD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.STONE_ANVIL)
                .pattern("nnn")
                .pattern(" - ")
                .pattern("---")
                .input('n', Items.STONE)
                .input('-', Items.STONE_SLAB)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BobsMobGearItems.FORGE)
                .pattern("bBb")
                .pattern("BFB")
                .pattern("TTT")
                .input('b', Items.BRICK)
                .input('B', Items.BRICKS)
                .input('F', Items.FURNACE)
                .input('T', Items.TERRACOTTA)
                .criterion(hasItem(Items.FURNACE), conditionsFromItem(Items.FURNACE))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BobsMobGearItems.FORGE_HEATER)
                .pattern("bBb")
                .pattern("bFb")
                .pattern("TTT")
                .input('b', Items.TERRACOTTA)
                .input('B', Items.COAL_BLOCK)
                .input('F', BobsMobGearItems.FORGE)
                .input('T', ModItems.BRONZE_INGOT)
                .criterion(hasItem(BobsMobGearItems.FORGE), conditionsFromItem(BobsMobGearItems.FORGE))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, BobsMobGearItems.SMITHING_TONGS)
                .pattern(" n ")
                .pattern("n--")
                .pattern(" - ")
                .input('n', Items.BRICK)
                .input('-', Items.STICK)
                .criterion(hasItem(Items.BRICK), conditionsFromItem(Items.BRICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BobsMobGearItems.EMPTY_POT)
                .pattern("n n")
                .pattern("n n")
                .pattern(" n ")
                .input('n', Items.BRICK)
                .criterion(hasItem(Items.BRICK), conditionsFromItem(Items.BRICK))
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

        List<ItemConvertible> TIN_SMELT = List.of(ModItems.RAW_TIN, ModBlocks.TIN_ORE, ModBlocks.DEEPSLATE_TIN_ORE);
        offerBlasting(recipeExporter, TIN_SMELT, RecipeCategory.MISC, ModItems.TIN_INGOT, 0.7f, 100, "tin_ingot");

        List<ItemConvertible> COKE_SMELT = List.of(Items.COAL_BLOCK, ModBlocks.COKING_COAL_ORE, ModBlocks.DEEPSLATE_COKING_COAL_ORE);
        offerBlasting(recipeExporter, COKE_SMELT, RecipeCategory.MISC, ModItems.COKING_COAL, 0.15f, 100, "coking_coal");

        List<ItemConvertible> HELMET_MOLD_SMELT = List.of(ModItems.CLAY_HELMET_MOLD);
        offerSmelting(recipeExporter, HELMET_MOLD_SMELT, RecipeCategory.MISC, ModBlocks.CERAMIC_HELMET_MOLD, 0f, 200, "helmet_mold");

        List<ItemConvertible> CHESTPLATE_MOLD_SMELT = List.of(ModItems.CLAY_CHESTPLATE_MOLD);
        offerSmelting(recipeExporter, CHESTPLATE_MOLD_SMELT, RecipeCategory.MISC, ModBlocks.CERAMIC_CHESTPLATE_MOLD, 0f, 200, "chestplate_mold");

        List<ItemConvertible> LEGGINGS_MOLD_SMELT = List.of(ModItems.CLAY_LEGGINGS_MOLD);
        offerSmelting(recipeExporter, LEGGINGS_MOLD_SMELT, RecipeCategory.MISC, ModBlocks.CERAMIC_LEGGINGS_MOLD, 0f, 200, "leggings_mold");

        List<ItemConvertible> BOOTS_MOLD_SMELT = List.of(ModItems.CLAY_BOOTS_MOLD);
        offerSmelting(recipeExporter, BOOTS_MOLD_SMELT, RecipeCategory.MISC, ModBlocks.CERAMIC_BOOTS_MOLD, 0f, 200, "boots_mold");
    }

    public static void offerCustomSmithingTemplateCopyingRecipe(RecipeExporter exporter, ItemConvertible template, Item resource, Item outlineResource) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, template, 2).input('#', outlineResource).input('C', resource).input('S', template).pattern("#S#").pattern("#C#").pattern("###").criterion(hasItem(template), conditionsFromItem(template)).offerTo(exporter);
    }
}
