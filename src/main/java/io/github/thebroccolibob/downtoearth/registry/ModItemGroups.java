package io.github.thebroccolibob.downtoearth.registry;

import io.github.thebroccolibob.downtoearth.DownToEarth;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BOBS_MOB_GEAR_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(DownToEarth.MOD_ID, "bobs_mob_gear_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.LEAF_FIBER))
                    .displayName(Text.translatable("itemgroup.downtoearth.bobs_mob_gear_items"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.LEAF_FIBER);

                        entries.add(ModItems.FLINT_TOOL);
                        entries.add(ModItems.FLINT_AXE);

                        entries.add(ModItems.CLAY_INGOT_MOLD);
                        entries.add(ModItems.CLAY_SHOVEL_HEAD_MOLD);
                        entries.add(ModItems.CLAY_PICKAXE_HEAD_MOLD);
                        entries.add(ModItems.CLAY_AXE_HEAD_MOLD);
                        entries.add(ModItems.CLAY_HOE_HEAD_MOLD);
                        entries.add(ModItems.CLAY_SWORD_BLADE_MOLD);
                        entries.add(ModItems.CLAY_HELMET_MOLD);
                        entries.add(ModItems.CLAY_CHESTPLATE_MOLD);
                        entries.add(ModItems.CLAY_LEGGINGS_MOLD);
                        entries.add(ModItems.CLAY_BOOTS_MOLD);

                        entries.add(ModItems.WOODEN_SHOVEL_HEAD);
                        entries.add(ModItems.WOODEN_PICKAXE_HEAD);
                        entries.add(ModItems.WOODEN_AXE_HEAD);
                        entries.add(ModItems.WOODEN_HOE_HEAD);
                        entries.add(ModItems.WOODEN_SWORD_BLADE);
                        entries.add(ModItems.STONE_SMITHING_HAMMER_HEAD);
                        entries.add(ModItems.STONE_SHOVEL_HEAD);
                        entries.add(ModItems.STONE_PICKAXE_HEAD);
                        entries.add(ModItems.STONE_AXE_HEAD);
                        entries.add(ModItems.STONE_HOE_HEAD);
                        entries.add(ModItems.STONE_SWORD_BLADE);
                        entries.add(ModItems.UNFORGED_BRONZE_SHOVEL_HEAD);
                        entries.add(ModItems.UNSHARPENED_BRONZE_SHOVEL_HEAD);
                        entries.add(ModItems.BRONZE_SHOVEL_HEAD);
                        entries.add(ModItems.UNFORGED_BRONZE_PICKAXE_HEAD);
                        entries.add(ModItems.UNSHARPENED_BRONZE_PICKAXE_HEAD);
                        entries.add(ModItems.BRONZE_PICKAXE_HEAD);
                        entries.add(ModItems.UNFORGED_BRONZE_AXE_HEAD);
                        entries.add(ModItems.UNSHARPENED_BRONZE_AXE_HEAD);
                        entries.add(ModItems.BRONZE_AXE_HEAD);
                        entries.add(ModItems.UNFORGED_BRONZE_HOE_HEAD);
                        entries.add(ModItems.UNSHARPENED_BRONZE_HOE_HEAD);
                        entries.add(ModItems.BRONZE_HOE_HEAD);
                        entries.add(ModItems.UNFORGED_BRONZE_SWORD_BLADE);
                        entries.add(ModItems.UNSHARPENED_BRONZE_SWORD_BLADE);
                        entries.add(ModItems.BRONZE_SWORD_BLADE);
                        entries.add(ModItems.UNFORGED_BRONZE_HELMET);
                        entries.add(ModItems.UNPOLISHED_BRONZE_HELMET);
                        entries.add(ModItems.UNFORGED_BRONZE_CHESTPLATE);
                        entries.add(ModItems.UNPOLISHED_BRONZE_CHESTPLATE);
                        entries.add(ModItems.UNFORGED_BRONZE_LEGGINGS);
                        entries.add(ModItems.UNPOLISHED_BRONZE_LEGGINGS);
                        entries.add(ModItems.UNFORGED_BRONZE_BOOTS);
                        entries.add(ModItems.UNPOLISHED_BRONZE_BOOTS);
                        entries.add(ModItems.UNFORGED_IRON_SHOVEL_HEAD);
                        entries.add(ModItems.UNSHARPENED_IRON_SHOVEL_HEAD);
                        entries.add(ModItems.IRON_SHOVEL_HEAD);
                        entries.add(ModItems.UNFORGED_IRON_PICKAXE_HEAD);
                        entries.add(ModItems.UNSHARPENED_IRON_PICKAXE_HEAD);
                        entries.add(ModItems.IRON_PICKAXE_HEAD);
                        entries.add(ModItems.UNFORGED_IRON_AXE_HEAD);
                        entries.add(ModItems.UNSHARPENED_IRON_AXE_HEAD);
                        entries.add(ModItems.IRON_AXE_HEAD);
                        entries.add(ModItems.UNFORGED_IRON_HOE_HEAD);
                        entries.add(ModItems.UNSHARPENED_IRON_HOE_HEAD);
                        entries.add(ModItems.IRON_HOE_HEAD);
                        entries.add(ModItems.UNFORGED_IRON_SWORD_BLADE);
                        entries.add(ModItems.UNSHARPENED_IRON_SWORD_BLADE);
                        entries.add(ModItems.IRON_SWORD_BLADE);
                        entries.add(ModItems.UNFORGED_STEEL_SHOVEL_HEAD);
                        entries.add(ModItems.UNSHARPENED_STEEL_SHOVEL_HEAD);
                        entries.add(ModItems.STEEL_SHOVEL_HEAD);
                        entries.add(ModItems.UNFORGED_STEEL_PICKAXE_HEAD);
                        entries.add(ModItems.UNSHARPENED_STEEL_PICKAXE_HEAD);
                        entries.add(ModItems.STEEL_PICKAXE_HEAD);
                        entries.add(ModItems.UNFORGED_STEEL_AXE_HEAD);
                        entries.add(ModItems.UNSHARPENED_STEEL_AXE_HEAD);
                        entries.add(ModItems.STEEL_AXE_HEAD);
                        entries.add(ModItems.UNFORGED_STEEL_HOE_HEAD);
                        entries.add(ModItems.UNSHARPENED_STEEL_HOE_HEAD);
                        entries.add(ModItems.STEEL_HOE_HEAD);
                        entries.add(ModItems.UNFORGED_STEEL_SWORD_BLADE);
                        entries.add(ModItems.UNSHARPENED_STEEL_SWORD_BLADE);
                        entries.add(ModItems.STEEL_SWORD_BLADE);
                        entries.add(ModItems.UNFORGED_DIAMOND_SHOVEL_HEAD);
                        entries.add(ModItems.UNSHARPENED_DIAMOND_SHOVEL_HEAD);
                        entries.add(ModItems.DIAMOND_SHOVEL_HEAD);
                        entries.add(ModItems.UNFORGED_DIAMOND_PICKAXE_HEAD);
                        entries.add(ModItems.UNSHARPENED_DIAMOND_PICKAXE_HEAD);
                        entries.add(ModItems.DIAMOND_PICKAXE_HEAD);
                        entries.add(ModItems.UNFORGED_DIAMOND_AXE_HEAD);
                        entries.add(ModItems.UNSHARPENED_DIAMOND_AXE_HEAD);
                        entries.add(ModItems.DIAMOND_AXE_HEAD);
                        entries.add(ModItems.UNFORGED_DIAMOND_HOE_HEAD);
                        entries.add(ModItems.UNSHARPENED_DIAMOND_HOE_HEAD);
                        entries.add(ModItems.DIAMOND_HOE_HEAD);
                        entries.add(ModItems.UNFORGED_DIAMOND_SWORD_BLADE);
                        entries.add(ModItems.UNSHARPENED_DIAMOND_SWORD_BLADE);
                        entries.add(ModItems.DIAMOND_SWORD_BLADE);
                        entries.add(ModItems.UNFORGED_NETHERITE_SHOVEL_HEAD);
                        entries.add(ModItems.UNSHARPENED_NETHERITE_SHOVEL_HEAD);
                        entries.add(ModItems.NETHERITE_SHOVEL_HEAD);
                        entries.add(ModItems.UNFORGED_NETHERITE_PICKAXE_HEAD);
                        entries.add(ModItems.UNSHARPENED_NETHERITE_PICKAXE_HEAD);
                        entries.add(ModItems.NETHERITE_PICKAXE_HEAD);
                        entries.add(ModItems.UNFORGED_NETHERITE_AXE_HEAD);
                        entries.add(ModItems.UNSHARPENED_NETHERITE_AXE_HEAD);
                        entries.add(ModItems.NETHERITE_AXE_HEAD);
                        entries.add(ModItems.UNFORGED_NETHERITE_HOE_HEAD);
                        entries.add(ModItems.UNSHARPENED_NETHERITE_HOE_HEAD);
                        entries.add(ModItems.NETHERITE_HOE_HEAD);
                        entries.add(ModItems.UNFORGED_NETHERITE_SWORD_BLADE);
                        entries.add(ModItems.UNSHARPENED_NETHERITE_SWORD_BLADE);
                        entries.add(ModItems.NETHERITE_SWORD_BLADE);
                        entries.add(ModItems.UNFORGED_IRON_HELMET);
                        entries.add(ModItems.UNPOLISHED_IRON_HELMET);
                        entries.add(ModItems.UNFORGED_IRON_CHESTPLATE);
                        entries.add(ModItems.UNPOLISHED_IRON_CHESTPLATE);
                        entries.add(ModItems.UNFORGED_IRON_LEGGINGS);
                        entries.add(ModItems.UNPOLISHED_IRON_LEGGINGS);
                        entries.add(ModItems.UNFORGED_IRON_BOOTS);
                        entries.add(ModItems.UNPOLISHED_IRON_BOOTS);
                        entries.add(ModItems.UNFORGED_STEEL_HELMET);
                        entries.add(ModItems.UNPOLISHED_STEEL_HELMET);
                        entries.add(ModItems.UNFORGED_STEEL_CHESTPLATE);
                        entries.add(ModItems.UNPOLISHED_STEEL_CHESTPLATE);
                        entries.add(ModItems.UNFORGED_STEEL_LEGGINGS);
                        entries.add(ModItems.UNPOLISHED_STEEL_LEGGINGS);
                        entries.add(ModItems.UNFORGED_STEEL_BOOTS);
                        entries.add(ModItems.UNPOLISHED_STEEL_BOOTS);
                        entries.add(ModItems.UNFORGED_DIAMOND_HELMET);
                        entries.add(ModItems.UNPOLISHED_DIAMOND_HELMET);
                        entries.add(ModItems.UNFORGED_DIAMOND_CHESTPLATE);
                        entries.add(ModItems.UNPOLISHED_DIAMOND_CHESTPLATE);
                        entries.add(ModItems.UNFORGED_DIAMOND_LEGGINGS);
                        entries.add(ModItems.UNPOLISHED_DIAMOND_LEGGINGS);
                        entries.add(ModItems.UNFORGED_DIAMOND_BOOTS);
                        entries.add(ModItems.UNPOLISHED_DIAMOND_BOOTS);
                        entries.add(ModItems.UNFORGED_NETHERITE_HELMET);
                        entries.add(ModItems.UNPOLISHED_NETHERITE_HELMET);
                        entries.add(ModItems.UNFORGED_NETHERITE_CHESTPLATE);
                        entries.add(ModItems.UNPOLISHED_NETHERITE_CHESTPLATE);
                        entries.add(ModItems.UNFORGED_NETHERITE_LEGGINGS);
                        entries.add(ModItems.UNPOLISHED_NETHERITE_LEGGINGS);
                        entries.add(ModItems.UNFORGED_NETHERITE_BOOTS);
                        entries.add(ModItems.UNPOLISHED_NETHERITE_BOOTS);

                        entries.add(ModItems.BRONZE_SHOVEL);
                        entries.add(ModItems.BRONZE_PICKAXE);
                        entries.add(ModItems.BRONZE_AXE);
                        entries.add(ModItems.BRONZE_HOE);
                        entries.add(ModItems.BRONZE_SWORD);
                        entries.add(ModItems.BRONZE_HELMET);
                        entries.add(ModItems.BRONZE_CHESTPLATE);
                        entries.add(ModItems.BRONZE_LEGGINGS);
                        entries.add(ModItems.BRONZE_BOOTS);

                        entries.add(ModItems.STEEL_SHOVEL);
                        entries.add(ModItems.STEEL_PICKAXE);
                        entries.add(ModItems.STEEL_AXE);
                        entries.add(ModItems.STEEL_HOE);
                        entries.add(ModItems.STEEL_SWORD);
                        entries.add(ModItems.STEEL_HELMET);
                        entries.add(ModItems.STEEL_CHESTPLATE);
                        entries.add(ModItems.STEEL_LEGGINGS);
                        entries.add(ModItems.STEEL_BOOTS);

                        entries.add(ModItems.STONE_SMITHING_HAMMER);

                        entries.add(ModItems.COAL_PIECE);
                        entries.add(ModItems.COKING_COAL_PIECE);
                        entries.add(ModItems.RAW_COPPER_NUGGET);
                        entries.add(ModItems.RAW_TIN_NUGGET);
                        entries.add(ModItems.RAW_TIN);
                        entries.add(ModItems.RAW_IRON_NUGGET);
                        entries.add(ModItems.RAW_GOLD_NUGGET);
                        entries.add(ModItems.LAPIS_LAZULI_PIECE);
                        entries.add(ModItems.EMERALD_SHARD);
                        entries.add(ModItems.DIAMOND_SHARD);
                        entries.add(ModItems.ANCIENT_DEBRIS_FRAGMENT);

                        entries.add(ModItems.BRONZE_MIX);
                        entries.add(ModItems.COKING_COAL);
                        entries.add(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE);
                        entries.add(ModItems.NETHERITE_MIX);

                        entries.add(ModItems.COPPER_POT);
                        entries.add(ModItems.TIN_POT);
                        entries.add(ModItems.BRONZE_POT);
                        entries.add(ModItems.STEEL_POT);

                        entries.add(ModItems.TIN_INGOT);
                        entries.add(ModItems.BRONZE_INGOT);
                        entries.add(ModItems.STEEL_INGOT);
                    })).build());

    public static final ItemGroup BOBS_MOB_GEAR_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(DownToEarth.MOD_ID, "bobs_mob_gear_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.LEAF_FIBER_BALE))
                    .displayName(Text.translatable("itemgroup.downtoearth.bobs_mob_gear_blocks"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModBlocks.LEAF_FIBER_BALE);
                        entries.add(ModBlocks.STONE_ANVIL);
                        entries.add(ModBlocks.FLINT);
                        entries.add(ModBlocks.CERAMIC_HELMET_MOLD);
                        entries.add(ModBlocks.CERAMIC_CHESTPLATE_MOLD);
                        entries.add(ModBlocks.CERAMIC_LEGGINGS_MOLD);
                        entries.add(ModBlocks.CERAMIC_BOOTS_MOLD);
                        entries.add(ModBlocks.TIN_ORE);
                        entries.add(ModBlocks.DEEPSLATE_TIN_ORE);
                        entries.add(ModBlocks.COKING_COAL_ORE);
                        entries.add(ModBlocks.DEEPSLATE_COKING_COAL_ORE);
                        entries.add(ModBlocks.RAW_TIN_BLOCK);
                        entries.add(ModBlocks.TIN_BLOCK);
                        entries.add(ModBlocks.CHISELED_TIN);
                        entries.add(ModBlocks.TIN_GRATE);
                        entries.add(ModBlocks.CUT_TIN);
                        entries.add(ModBlocks.CUT_TIN_STAIRS);
                        entries.add(ModBlocks.CUT_TIN_SLAB);
                        entries.add(ModBlocks.TIN_DOOR);
                        entries.add(ModBlocks.TIN_TRAPDOOR);
                        entries.add(ModBlocks.TIN_BULB);
                    })).build());

    public static void registerItemGroups() {
        DownToEarth.LOGGER.info("These Item Groups are " + DownToEarth.MOD_ID + "!");
    }
}
