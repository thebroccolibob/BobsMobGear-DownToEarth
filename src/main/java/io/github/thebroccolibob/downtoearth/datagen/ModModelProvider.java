package io.github.thebroccolibob.downtoearth.datagen;

import io.github.thebroccolibob.bobsmobgear.datagen.ModelGenerator;
import io.github.thebroccolibob.downtoearth.registry.ModBlocks;
import io.github.thebroccolibob.downtoearth.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;

import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerAxisRotated(ModBlocks.LEAF_FIBER_BALE, TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COKING_COAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_COKING_COAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_TIN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_GRATE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_TIN_BLOCK);
        blockStateModelGenerator.registerDoor(ModBlocks.TIN_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.TIN_TRAPDOOR);
        blockStateModelGenerator.registerCopperBulb(ModBlocks.TIN_BULB);
        blockStateModelGenerator.registerBuiltin(ModBlocks.HAMMERABLE_ITEM, Blocks.ANVIL).includeWithoutItem(ModBlocks.HAMMERABLE_ITEM);

        ModelGenerator.registerCutoutTemplate(blockStateModelGenerator, ModBlocks.CERAMIC_HELMET_MOLD);
        ModelGenerator.registerCutoutTemplate(blockStateModelGenerator, ModBlocks.CERAMIC_CHESTPLATE_MOLD);
        ModelGenerator.registerCutoutTemplate(blockStateModelGenerator, ModBlocks.CERAMIC_LEGGINGS_MOLD);
        ModelGenerator.registerCutoutTemplate(blockStateModelGenerator, ModBlocks.CERAMIC_BOOTS_MOLD);

        BlockStateModelGenerator.BlockTexturePool cutTinPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CUT_TIN);
        cutTinPool.slab(ModBlocks.CUT_TIN_SLAB);
        cutTinPool.stairs(ModBlocks.CUT_TIN_STAIRS);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.LEAF_FIBER, Models.GENERATED);

        itemModelGenerator.register(ModItems.WOODEN_SWORD_BLADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WOODEN_SHOVEL_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.WOODEN_PICKAXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.WOODEN_AXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.WOODEN_HOE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.STONE_SMITHING_HAMMER_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.STONE_SWORD_BLADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STONE_SHOVEL_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.STONE_PICKAXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.STONE_AXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.STONE_HOE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_BRONZE_SWORD_BLADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNSHARPENED_BRONZE_SWORD_BLADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_SWORD_BLADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_BRONZE_PICKAXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNSHARPENED_BRONZE_PICKAXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_PICKAXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_BRONZE_SHOVEL_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNSHARPENED_BRONZE_SHOVEL_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_SHOVEL_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_BRONZE_AXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNSHARPENED_BRONZE_AXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_AXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_BRONZE_HOE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNSHARPENED_BRONZE_HOE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_HOE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_IRON_SHOVEL_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNSHARPENED_IRON_SHOVEL_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_SHOVEL_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_IRON_PICKAXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNSHARPENED_IRON_PICKAXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_PICKAXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_IRON_AXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNSHARPENED_IRON_AXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_AXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_IRON_HOE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNSHARPENED_IRON_HOE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_HOE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_IRON_SWORD_BLADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNSHARPENED_IRON_SWORD_BLADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_SWORD_BLADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_STEEL_SHOVEL_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNSHARPENED_STEEL_SHOVEL_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_SHOVEL_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_STEEL_PICKAXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNSHARPENED_STEEL_PICKAXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_PICKAXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_STEEL_AXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNSHARPENED_STEEL_AXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_AXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_STEEL_HOE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNSHARPENED_STEEL_HOE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_HOE_HEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_STEEL_SWORD_BLADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNSHARPENED_STEEL_SWORD_BLADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_SWORD_BLADE, Models.GENERATED);

        itemModelGenerator.register(ModItems.UNFORGED_BRONZE_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNPOLISHED_BRONZE_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_BRONZE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNPOLISHED_BRONZE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_BRONZE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNPOLISHED_BRONZE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_BRONZE_BOOTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNPOLISHED_BRONZE_BOOTS, Models.GENERATED);

        itemModelGenerator.register(ModItems.UNFORGED_IRON_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNPOLISHED_IRON_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_IRON_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNPOLISHED_IRON_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_IRON_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNPOLISHED_IRON_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_IRON_BOOTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNPOLISHED_IRON_BOOTS, Models.GENERATED);

        itemModelGenerator.register(ModItems.UNFORGED_STEEL_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNPOLISHED_STEEL_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_STEEL_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNPOLISHED_STEEL_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_STEEL_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNPOLISHED_STEEL_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNFORGED_STEEL_BOOTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNPOLISHED_STEEL_BOOTS, Models.GENERATED);

        itemModelGenerator.register(ModItems.CLAY_INGOT_MOLD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLAY_SWORD_BLADE_MOLD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLAY_SHOVEL_HEAD_MOLD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLAY_PICKAXE_HEAD_MOLD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLAY_AXE_HEAD_MOLD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLAY_HOE_HEAD_MOLD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLAY_HELMET_MOLD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLAY_CHESTPLATE_MOLD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLAY_LEGGINGS_MOLD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLAY_BOOTS_MOLD, Models.GENERATED);

        itemModelGenerator.register(ModItems.COAL_PIECE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COKING_COAL_PIECE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_COPPER_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_TIN_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_TIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_IRON_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_GOLD_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.LAPIS_LAZULI_PIECE, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMERALD_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.ANCIENT_DEBRIS_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_MIX, Models.GENERATED);
        itemModelGenerator.register(ModItems.COKING_COAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_POT, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_POT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_POT, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_POT, Models.GENERATED);

        itemModelGenerator.register(ModItems.FLINT_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_SMITHING_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BRONZE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BRONZE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BRONZE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BRONZE_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STEEL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STEEL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STEEL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STEEL_BOOTS));
    }
}
