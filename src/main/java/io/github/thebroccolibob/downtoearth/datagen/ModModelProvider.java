package io.github.thebroccolibob.downtoearth.datagen;

import io.github.thebroccolibob.downtoearth.registry.ModBlocks;
import io.github.thebroccolibob.downtoearth.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;

import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerAxisRotated(ModBlocks.LEAF_FIBER_BALE, TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_TIN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TIN_GRATE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_TIN_BLOCK);
        blockStateModelGenerator.registerDoor(ModBlocks.TIN_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.TIN_TRAPDOOR);
        blockStateModelGenerator.registerCopperBulb(ModBlocks.TIN_BULB);
        blockStateModelGenerator.registerBuiltin(ModBlocks.HAMMERABLE_ITEM, Blocks.ANVIL).includeWithoutItem(ModBlocks.HAMMERABLE_ITEM);

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

        itemModelGenerator.register(ModItems.CLAY_INGOT_MOLD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLAY_SWORD_BLADE_MOLD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLAY_SHOVEL_HEAD_MOLD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLAY_PICKAXE_HEAD_MOLD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLAY_AXE_HEAD_MOLD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLAY_HOE_HEAD_MOLD, Models.GENERATED);

        itemModelGenerator.register(ModItems.COAL_PIECE, Models.GENERATED);
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
        itemModelGenerator.register(ModItems.BRONZE_MIX, Models.GENERATED);

        itemModelGenerator.register(ModItems.FLINT_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_SMITHING_HAMMER, Models.HANDHELD);
    }
}
