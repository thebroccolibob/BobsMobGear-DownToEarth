package io.github.thebroccolibob.downtoearth.registry;

import io.github.thebroccolibob.downtoearth.DownToEarth;
import io.github.thebroccolibob.downtoearth.item.FlintToolItem;
import io.github.thebroccolibob.downtoearth.item.ModToolMaterials;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item LEAF_FIBER = registerItem("leaf_fiber", new Item(new Item.Settings()));
    public static final Item WOODEN_SWORD_BLADE = registerItem("wooden_sword_blade", new Item(new Item.Settings()));
    public static final Item WOODEN_SHOVEL_HEAD = registerItem("wooden_shovel_head", new Item(new Item.Settings()));
    public static final Item WOODEN_PICKAXE_HEAD = registerItem("wooden_pickaxe_head", new Item(new Item.Settings()));
    public static final Item WOODEN_AXE_HEAD = registerItem("wooden_axe_head", new Item(new Item.Settings()));
    public static final Item WOODEN_HOE_HEAD = registerItem("wooden_hoe_head", new Item(new Item.Settings()));

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
            fabricItemGroupEntries.add(ModItems.WOODEN_SWORD_BLADE);
            fabricItemGroupEntries.add(ModItems.WOODEN_SHOVEL_HEAD);
            fabricItemGroupEntries.add(ModItems.WOODEN_PICKAXE_HEAD);
            fabricItemGroupEntries.add(ModItems.WOODEN_AXE_HEAD);
            fabricItemGroupEntries.add(ModItems.WOODEN_HOE_HEAD);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModItems.FLINT_TOOL);
            fabricItemGroupEntries.add(ModItems.FLINT_AXE);
        });
    }
}
