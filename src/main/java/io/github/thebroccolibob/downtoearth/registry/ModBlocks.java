package io.github.thebroccolibob.downtoearth.registry;

import io.github.thebroccolibob.downtoearth.DownToEarth;
import io.github.thebroccolibob.downtoearth.block.HammerableItemBlock;

import io.github.thebroccolibob.downtoearth.block.StoneAnvilBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.HayBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block LEAF_FIBER_BALE = registerBlockWithItem("leaf_fiber_bale",
            new HayBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BANJO)
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.WOOL)
            ));

    public static final Block STONE_ANVIL = registerBlockWithItem("stone_anvil",
            new StoneAnvilBlock(AbstractBlock.Settings.create()
                    .strength(2.0F)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)));

    public static final Block HAMMERABLE_ITEM = registerBlock("hammerable_item",
            new HammerableItemBlock(AbstractBlock.Settings.create()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.METAL)
                    .noCollision()
            ));

    private static Block registerBlockWithItem(String name, Block block) {
        registerBlockItem(name, block);
        return registerBlock(name, block);
    }

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(DownToEarth.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(DownToEarth.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        DownToEarth.LOGGER.info("These Blocks are " + DownToEarth.MOD_ID + "!");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.LEAF_FIBER_BALE);
        });
    }
}
