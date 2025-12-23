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
        blockStateModelGenerator.registerBuiltin(ModBlocks.HAMMERABLE_ITEM, Blocks.ANVIL).includeWithoutItem(ModBlocks.HAMMERABLE_ITEM);
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

        itemModelGenerator.register(ModItems.FLINT_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_SMITHING_HAMMER, Models.HANDHELD);
    }
}
