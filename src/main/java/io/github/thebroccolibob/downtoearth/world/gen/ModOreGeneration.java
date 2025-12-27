package io.github.thebroccolibob.downtoearth.world.gen;

import io.github.thebroccolibob.downtoearth.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.TIN_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(ConventionalBiomeTags.IS_SWAMP), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.COKING_COAL_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(ConventionalBiomeTags.IS_SWAMP), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.COKING_COAL_ORE_BURIED_PLACED_KEY);
    }
}
