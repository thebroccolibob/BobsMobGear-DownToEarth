package io.github.thebroccolibob.downtoearth.registry;

import io.github.thebroccolibob.bobsmobgear.item.SmithingHammerItem;
import io.github.thebroccolibob.downtoearth.DownToEarth;
import io.github.thebroccolibob.downtoearth.item.FlintToolItem;
import io.github.thebroccolibob.downtoearth.item.ModToolMaterials;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item LEAF_FIBER = registerItem("leaf_fiber", new Item(new Item.Settings()));

    public static final Item WOODEN_SWORD_BLADE = registerItem("wooden_sword_blade", new Item(new Item.Settings()));
    public static final Item WOODEN_SHOVEL_HEAD = registerItem("wooden_shovel_head", new Item(new Item.Settings()));
    public static final Item WOODEN_PICKAXE_HEAD = registerItem("wooden_pickaxe_head", new Item(new Item.Settings()));
    public static final Item WOODEN_AXE_HEAD = registerItem("wooden_axe_head", new Item(new Item.Settings()));
    public static final Item WOODEN_HOE_HEAD = registerItem("wooden_hoe_head", new Item(new Item.Settings()));
    public static final Item STONE_SMITHING_HAMMER_HEAD = registerItem("stone_smithing_hammer_head", new Item(new Item.Settings()));
    public static final Item STONE_SWORD_BLADE = registerItem("stone_sword_blade", new Item(new Item.Settings()));
    public static final Item STONE_SHOVEL_HEAD = registerItem("stone_shovel_head", new Item(new Item.Settings()));
    public static final Item STONE_PICKAXE_HEAD = registerItem("stone_pickaxe_head", new Item(new Item.Settings()));
    public static final Item STONE_AXE_HEAD = registerItem("stone_axe_head", new Item(new Item.Settings()));
    public static final Item STONE_HOE_HEAD = registerItem("stone_hoe_head", new Item(new Item.Settings()));

    public static final Item CLAY_INGOT_MOLD = registerItem("clay_ingot_mold", new Item(new Item.Settings()));
    public static final Item CLAY_SWORD_BLADE_MOLD = registerItem("clay_sword_blade_mold", new Item(new Item.Settings()));
    public static final Item CLAY_SHOVEL_HEAD_MOLD = registerItem("clay_shovel_head_mold", new Item(new Item.Settings()));
    public static final Item CLAY_PICKAXE_HEAD_MOLD = registerItem("clay_pickaxe_head_mold", new Item(new Item.Settings()));
    public static final Item CLAY_AXE_HEAD_MOLD = registerItem("clay_axe_head_mold", new Item(new Item.Settings()));
    public static final Item CLAY_HOE_HEAD_MOLD = registerItem("clay_hoe_head_mold", new Item(new Item.Settings()));

    public static final Item COAL_PIECE = registerItem("coal_piece", new Item(new Item.Settings()));
    public static final Item RAW_COPPER_NUGGET = registerItem("raw_copper_nugget", new Item(new Item.Settings()));
    public static final Item RAW_TIN_NUGGET = registerItem("raw_tin_nugget", new Item(new Item.Settings()));
    public static final Item RAW_TIN = registerItem("raw_tin", new Item(new Item.Settings()));
    public static final Item RAW_IRON_NUGGET = registerItem("raw_iron_nugget", new Item(new Item.Settings()));
    public static final Item RAW_GOLD_NUGGET = registerItem("raw_gold_nugget", new Item(new Item.Settings()));
    public static final Item LAPIS_LAZULI_PIECE = registerItem("lapis_lazuli_piece", new Item(new Item.Settings()));
    public static final Item EMERALD_SHARD = registerItem("emerald_shard", new Item(new Item.Settings()));
    public static final Item DIAMOND_SHARD = registerItem("diamond_shard", new Item(new Item.Settings()));
    public static final Item ANCIENT_DEBRIS_FRAGMENT = registerItem("ancient_debris_fragment", new Item(new Item.Settings()));

    public static final Item STONE_SMITHING_HAMMER = registerItem("stone_smithing_hammer",
            new SmithingHammerItem(new Item.Settings()
                    .maxDamage(128)
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 1, -3.2F))
                    .component(DataComponentTypes.TOOL, new ToolComponent(List.of(), 1f, 2))));

    public static final Item FLINT_TOOL = registerItem("flint_tool",
            new FlintToolItem(ModToolMaterials.FLINT, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.FLINT, 1, -2.0F))));

    public static final Item FLINT_AXE = registerItem("flint_axe",
            new AxeItem(ModToolMaterials.FLINT, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.FLINT, 3.0F, -3.2F))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(DownToEarth.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DownToEarth.LOGGER.info("These Items are " + DownToEarth.MOD_ID + "!");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModItems.LEAF_FIBER);

            fabricItemGroupEntries.add(ModItems.WOODEN_SHOVEL_HEAD);
            fabricItemGroupEntries.add(ModItems.WOODEN_PICKAXE_HEAD);
            fabricItemGroupEntries.add(ModItems.WOODEN_AXE_HEAD);
            fabricItemGroupEntries.add(ModItems.WOODEN_HOE_HEAD);
            fabricItemGroupEntries.add(ModItems.WOODEN_SWORD_BLADE);

            fabricItemGroupEntries.add(ModItems.CLAY_INGOT_MOLD);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModItems.FLINT_TOOL);
            fabricItemGroupEntries.add(ModItems.FLINT_AXE);
        });
    }
}
