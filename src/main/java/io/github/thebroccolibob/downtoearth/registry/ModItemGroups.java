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

                        entries.add(ModItems.WOODEN_SHOVEL_HEAD);
                        entries.add(ModItems.WOODEN_PICKAXE_HEAD);
                        entries.add(ModItems.WOODEN_AXE_HEAD);
                        entries.add(ModItems.WOODEN_HOE_HEAD);
                        entries.add(ModItems.WOODEN_SWORD_BLADE);

                        entries.add(ModItems.CLAY_INGOT_MOLD);
                    })).build());

    public static final ItemGroup BOBS_MOB_GEAR_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(DownToEarth.MOD_ID, "bobs_mob_gear_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.LEAF_FIBER_BALE))
                    .displayName(Text.translatable("itemgroup.downtoearth.bobs_mob_gear_blocks"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModBlocks.LEAF_FIBER_BALE);
                    })).build());

    public static void registerItemGroups() {
        DownToEarth.LOGGER.info("These Item Groups are " + DownToEarth.MOD_ID + "!");
    }
}
