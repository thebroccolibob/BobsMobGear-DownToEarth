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
                        entries.add(ModItems.CLAY_SWORD_BLADE_MOLD);
                        entries.add(ModItems.CLAY_SHOVEL_HEAD_MOLD);
                        entries.add(ModItems.CLAY_PICKAXE_HEAD_MOLD);
                        entries.add(ModItems.CLAY_AXE_HEAD_MOLD);
                        entries.add(ModItems.CLAY_HOE_HEAD_MOLD);

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

                        entries.add(ModItems.STONE_SMITHING_HAMMER);

                        entries.add(ModItems.COAL_PIECE);
                        entries.add(ModItems.RAW_COPPER_NUGGET);
                        entries.add(ModItems.RAW_TIN_NUGGET);
                        entries.add(ModItems.RAW_TIN);
                        entries.add(ModItems.RAW_IRON_NUGGET);
                        entries.add(ModItems.RAW_GOLD_NUGGET);
                        entries.add(ModItems.LAPIS_LAZULI_PIECE);
                        entries.add(ModItems.EMERALD_SHARD);
                        entries.add(ModItems.DIAMOND_SHARD);
                        entries.add(ModItems.ANCIENT_DEBRIS_FRAGMENT);
                    })).build());

    public static final ItemGroup BOBS_MOB_GEAR_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(DownToEarth.MOD_ID, "bobs_mob_gear_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.LEAF_FIBER_BALE))
                    .displayName(Text.translatable("itemgroup.downtoearth.bobs_mob_gear_blocks"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModBlocks.LEAF_FIBER_BALE);
                        entries.add(ModBlocks.STONE_ANVIL);
                        entries.add(ModBlocks.FLINT);
                    })).build());

    public static void registerItemGroups() {
        DownToEarth.LOGGER.info("These Item Groups are " + DownToEarth.MOD_ID + "!");
    }
}
