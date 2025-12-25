package io.github.thebroccolibob.downtoearth.registry;

import io.github.thebroccolibob.bobsmobgear.block.TemplateBlock;
import io.github.thebroccolibob.bobsmobgear.registry.BobsMobGearBlocks;
import io.github.thebroccolibob.downtoearth.DownToEarth;
import io.github.thebroccolibob.downtoearth.block.FlintBlock;
import io.github.thebroccolibob.downtoearth.block.HammerableItemBlock;

import io.github.thebroccolibob.downtoearth.block.StoneAnvilBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroups;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;

public class ModBlocks {
    public static final Block LEAF_FIBER_BALE = registerBlockWithItem("leaf_fiber_bale",
            new HayBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BANJO)
                    .strength(0.5f)
                    .pistonBehavior(PistonBehavior.BLOCK)
                    .sounds(BlockSoundGroup.GRASS)
            ));

    public static final Block STONE_ANVIL = registerBlockWithItem("stone_anvil",
            new StoneAnvilBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.STONE_GRAY)
                    .strength(5.0F, 1200.0F)
                    .pistonBehavior(PistonBehavior.BLOCK)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)));

    public static final Block TIN_ORE = registerBlockWithItem("tin_ore",
            new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.create()
                    .mapColor(MapColor.STONE_GRAY)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(3.0F, 3.0F)
                    .sounds(BlockSoundGroup.STONE)
                    .pistonBehavior(PistonBehavior.BLOCK)));
    public static final Block RAW_TIN_BLOCK = registerBlockWithItem("raw_tin_block",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.GOLD)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(3.0F, 3.0F)
                    .sounds(BlockSoundGroup.STONE)
                    .pistonBehavior(PistonBehavior.BLOCK)));
    public static final Block DEEPSLATE_TIN_ORE = registerBlockWithItem("deepslate_tin_ore",
            new ExperienceDroppingBlock(ConstantIntProvider.create(0), AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(4.5F, 3.0F)
                    .sounds(BlockSoundGroup.DEEPSLATE)
                    .pistonBehavior(PistonBehavior.BLOCK)));

    public static final Block TIN_BLOCK = registerBlockWithItem("tin_block",
            new Block(AbstractBlock.Settings.copy(Blocks.COPPER_BLOCK).mapColor(MapColor.GOLD)));
    public static final Block CUT_TIN = registerBlockWithItem("cut_tin",
            new Block(AbstractBlock.Settings.copy(Blocks.COPPER_BLOCK).mapColor(MapColor.GOLD)));
    public static final Block CUT_TIN_STAIRS = registerBlockWithItem("cut_tin_stairs",
            new StairsBlock(ModBlocks.CUT_TIN.getDefaultState(),
                    AbstractBlock.Settings.copy(Blocks.COPPER_BLOCK).mapColor(MapColor.GOLD)));
    public static final Block CUT_TIN_SLAB = registerBlockWithItem("cut_tin_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.COPPER_BLOCK).mapColor(MapColor.GOLD)));
    public static final Block CHISELED_TIN = registerBlockWithItem("chiseled_tin",
            new Block(AbstractBlock.Settings.copy(Blocks.COPPER_BLOCK).mapColor(MapColor.GOLD)));
    public static final Block TIN_GRATE = registerBlockWithItem("tin_grate",
            new GrateBlock(AbstractBlock.Settings.copy(Blocks.COPPER_GRATE).mapColor(MapColor.GOLD)));
    public static final Block TIN_DOOR = registerBlockWithItem("tin_door",
            new DoorBlock(BlockSetType.COPPER, AbstractBlock.Settings.copy(Blocks.COPPER_DOOR).mapColor(MapColor.GOLD)));
    public static final Block TIN_TRAPDOOR = registerBlockWithItem("tin_trapdoor",
            new TrapdoorBlock(BlockSetType.COPPER, AbstractBlock.Settings.copy(Blocks.COPPER_TRAPDOOR).mapColor(MapColor.GOLD)));
    public static final Block TIN_BULB = registerBlockWithItem("tin_bulb",
            new BulbBlock(AbstractBlock.Settings.copy(Blocks.COPPER_BULB).mapColor(MapColor.GOLD)));

    public static final Block FLINT = registerBlockWithItem("flint",
            new FlintBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.STONE_GRAY)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .breakInstantly()));

    public static final Block CERAMIC_HELMET_MOLD = BobsMobGearBlocks.registerTemplate(Identifier.of(DownToEarth.MOD_ID, "ceramic_helmet_mold"));
    public static final Block CERAMIC_CHESTPLATE_MOLD = BobsMobGearBlocks.registerTemplate(Identifier.of(DownToEarth.MOD_ID, "ceramic_chestplate_mold"));
    public static final Block CERAMIC_LEGGINGS_MOLD = BobsMobGearBlocks.registerTemplate(Identifier.of(DownToEarth.MOD_ID, "ceramic_leggings_mold"));
    public static final Block CERAMIC_BOOTS_MOLD = BobsMobGearBlocks.registerTemplate(Identifier.of(DownToEarth.MOD_ID, "ceramic_boots_mold"));

    public static final Item CERAMIC_HELMET_ITEM = registerBlockItem("ceramic_helmet_mold", CERAMIC_HELMET_MOLD);
    public static final Item CERAMIC_CHESTPLATE_ITEM = registerBlockItem("ceramic_chestplate_mold", CERAMIC_CHESTPLATE_MOLD);
    public static final Item CERAMIC_LEGGINGS_ITEM = registerBlockItem("ceramic_leggings_mold", CERAMIC_LEGGINGS_MOLD);
    public static final Item CERAMIC_BOOTS_ITEM = registerBlockItem("ceramic_boots_mold", CERAMIC_BOOTS_MOLD);

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

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(DownToEarth.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        DownToEarth.LOGGER.info("These Blocks are " + DownToEarth.MOD_ID + "!");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.LEAF_FIBER_BALE);
        });
    }
}
