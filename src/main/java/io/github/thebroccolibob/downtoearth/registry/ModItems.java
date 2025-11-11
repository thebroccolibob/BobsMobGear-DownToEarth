package io.github.thebroccolibob.downtoearth.registry;

import io.github.thebroccolibob.downtoearth.BobsMobGearDownToEarth;
import io.github.thebroccolibob.downtoearth.item.FlintToolItem;
import io.github.thebroccolibob.downtoearth.item.ModToolMaterials;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item LEAF_FIBER = registerItem("leaf_fiber", new Item(new Item.Settings()));

    public static final Item FLINT_TOOL = registerItem("flint_tool",
            new FlintToolItem(ModToolMaterials.FLINT, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.FLINT, 1, -2.0F))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BobsMobGearDownToEarth.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BobsMobGearDownToEarth.LOGGER.info("These Items are " + BobsMobGearDownToEarth.MOD_ID + "!");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModItems.LEAF_FIBER);
        });
    }
}
