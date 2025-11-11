package io.github.thebroccolibob.downtoearth.registry;

import io.github.thebroccolibob.downtoearth.BobsMobGearDownToEarth;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item LEAF_FIBER = registerItem("leaf_fiber", new Item(new Item.Settings()));

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
