package io.github.thebroccolibob.downtoearth.world.gen;

import io.github.thebroccolibob.downtoearth.util.ModTags;
import io.github.thebroccolibob.downtoearth.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.registry.tag.BiomeTags;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.minecraft.world.gen.GenerationStep;

import java.util.function.Predicate;

public class ModFlintRockGeneration {
    public static Predicate<BiomeSelectionContext> flintPredicate = (context -> context.hasTag(BiomeTags.IS_FOREST) || context.hasTag(BiomeTags.IS_HILL) || context.hasTag(BiomeTags.IS_MOUNTAIN)
            || context.hasTag(BiomeTags.IS_RIVER) || context.hasTag(ModTags.Biomes.ROCK_FEATURE_BIOMES));
    public static void generateFlintRocks() {
        BiomeModifications.addFeature(flintPredicate, GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModPlacedFeatures.FLINT_PLACED_KEY);
    }
}
