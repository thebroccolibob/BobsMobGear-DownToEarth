package io.github.thebroccolibob.downtoearth.world;

import io.github.thebroccolibob.downtoearth.DownToEarth;
import io.github.thebroccolibob.downtoearth.block.FlintBlock;
import io.github.thebroccolibob.downtoearth.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLINT_BLOCK_KEY = registryKey("flint_block");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLINT_KEY = registryKey("flint");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TIN_ORE_KEY = registryKey("tin_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldTinOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.TIN_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_TIN_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.RAW_TIN_BLOCK.getDefaultState()));

        register(context, TIN_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldTinOres, 10));

        DataPool.Builder<BlockState> flint_pool = DataPool.builder();
        flint_pool.add(ModBlocks.FLINT.getDefaultState()
                .with(FlintBlock.FACING, Direction.EAST)
                .with(FlintBlock.FLINT_TYPE, FlintBlock.FlintVariants.SMALL), 1);
        flint_pool.add(ModBlocks.FLINT.getDefaultState()
                .with(FlintBlock.FACING, Direction.WEST)
                .with(FlintBlock.FLINT_TYPE, FlintBlock.FlintVariants.SMALL), 1);
        flint_pool.add(ModBlocks.FLINT.getDefaultState()
                .with(FlintBlock.FACING, Direction.NORTH)
                .with(FlintBlock.FLINT_TYPE, FlintBlock.FlintVariants.SMALL), 1);
        flint_pool.add(ModBlocks.FLINT.getDefaultState()
                .with(FlintBlock.FACING, Direction.SOUTH)
                .with(FlintBlock.FLINT_TYPE, FlintBlock.FlintVariants.SMALL), 1);
        flint_pool.add(ModBlocks.FLINT.getDefaultState()
                .with(FlintBlock.FACING, Direction.EAST)
                .with(FlintBlock.FLINT_TYPE, FlintBlock.FlintVariants.MEDIUM), 2);
        flint_pool.add(ModBlocks.FLINT.getDefaultState()
                .with(FlintBlock.FACING, Direction.WEST)
                .with(FlintBlock.FLINT_TYPE, FlintBlock.FlintVariants.MEDIUM), 2);
        flint_pool.add(ModBlocks.FLINT.getDefaultState()
                .with(FlintBlock.FACING, Direction.NORTH)
                .with(FlintBlock.FLINT_TYPE, FlintBlock.FlintVariants.MEDIUM), 2);
        flint_pool.add(ModBlocks.FLINT.getDefaultState()
                .with(FlintBlock.FACING, Direction.SOUTH)
                .with(FlintBlock.FLINT_TYPE, FlintBlock.FlintVariants.MEDIUM), 2);

        BlockStateProvider flint_provider = new WeightedBlockStateProvider(flint_pool.build());

        register(context, FLINT_BLOCK_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(flint_provider));

        RegistryEntry<ConfiguredFeature<?, ?>> flintBlock =
                context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE)
                        .getOrThrow(FLINT_BLOCK_KEY);

        RegistryEntry<PlacedFeature> placed_flint = PlacedFeatures.createEntry(flintBlock);

        register(context, FLINT_KEY, Feature.SIMPLE_RANDOM_SELECTOR, new SimpleRandomFeatureConfig(RegistryEntryList.of(placed_flint)));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(DownToEarth.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
