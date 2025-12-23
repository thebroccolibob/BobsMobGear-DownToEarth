package io.github.thebroccolibob.downtoearth.util;

import io.github.thebroccolibob.downtoearth.DownToEarth;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(DownToEarth.MOD_ID, name));
        }

        public static final TagKey<Block> ROCK_FEATURE_BLOCKS = createTag("rock_feature_blocks");
    }

    public static class Items {
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(DownToEarth.MOD_ID, name));
        }
    }

    public static class Biomes {
        private static TagKey<Biome> createTag(String name) {
            return TagKey.of(RegistryKeys.BIOME, Identifier.of(DownToEarth.MOD_ID, name));
        }

        public static final TagKey<Biome> ROCK_FEATURE_BIOMES = createTag("rock_feature_biomes");
    }
}
