package io.github.thebroccolibob.downtoearth.block;

import io.github.thebroccolibob.downtoearth.BobsMobGearDownToEarth;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block LEAF_FIBER_BALE = registerBlock("leaf_fiber_bale",
            new PillarBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.OFF_WHITE)
                    .instrument(NoteBlockInstrument.GUITAR)
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.WOOL)
            ));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BobsMobGearDownToEarth.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(BobsMobGearDownToEarth.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        BobsMobGearDownToEarth.LOGGER.info("These Blocks are " + BobsMobGearDownToEarth.MOD_ID + "!");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.LEAF_FIBER_BALE);
        });
    }
}
