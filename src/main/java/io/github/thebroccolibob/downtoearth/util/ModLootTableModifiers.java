package io.github.thebroccolibob.downtoearth.util;

import io.github.thebroccolibob.downtoearth.condition.HasSilkTouch;
import io.github.thebroccolibob.downtoearth.condition.IsFlintToolCondition;
import io.github.thebroccolibob.downtoearth.condition.NoSilkOrShearsCondition;
import io.github.thebroccolibob.downtoearth.registry.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.item.EnchantmentPredicate;
import net.minecraft.predicate.item.EnchantmentsPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.predicate.item.ItemSubPredicateTypes;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModLootTableModifiers {
    private static final Identifier ACACIA_LEAVES_ID
            = Identifier.of("minecraft", "blocks/acacia_leaves");
    private static final Identifier AZALEA_LEAVES_ID
            = Identifier.of("minecraft", "blocks/azalea_leaves");
    private static final Identifier BIRCH_LEAVES_ID
            = Identifier.of("minecraft", "blocks/birch_leaves");
    private static final Identifier CHERRY_LEAVES_ID
            = Identifier.of("minecraft", "blocks/cherry_leaves");
    private static final Identifier DARK_OAK_LEAVES_ID
            = Identifier.of("minecraft", "blocks/dark_oak_leaves");
    private static final Identifier FLOWERING_AZALEA_LEAVES_ID
            = Identifier.of("minecraft", "blocks/flowering_azalea_leaves");
    private static final Identifier JUNGLE_LEAVES_ID
            = Identifier.of("minecraft", "blocks/jungle_leaves");
    private static final Identifier MANGROVE_LEAVES_ID
            = Identifier.of("minecraft", "blocks/mangrove_leaves");
    private static final Identifier OAK_LEAVES_ID
            = Identifier.of("minecraft", "blocks/oak_leaves");
    private static final Identifier SPRUCE_LEAVES_ID
            = Identifier.of("minecraft", "blocks/spruce_leaves");

    private static final Identifier COAL_ORE_ID
            = Identifier.of("minecraft", "blocks/coal_ore");
    private static final Identifier COPPER_ORE_ID
            = Identifier.of("minecraft", "blocks/copper_ore");
    private static final Identifier IRON_ORE_ID
            = Identifier.of("minecraft", "blocks/iron_ore");
    private static final Identifier GOLD_ORE_ID
            = Identifier.of("minecraft", "blocks/gold_ore");
    private static final Identifier LAPIS_ORE_ID
            = Identifier.of("minecraft", "blocks/lapis_ore");
    private static final Identifier EMERALD_ORE_ID
            = Identifier.of("minecraft", "blocks/emerald_ore");
    private static final Identifier DIAMOND_ORE_ID
            = Identifier.of("minecraft", "blocks/diamond_ore");
    private static final Identifier DEEPSLATE_DIAMOND_ORE_ID
            = Identifier.of("minecraft", "blocks/deepslate_diamond_ore");
    private static final Identifier ANCIENT_DEBRIS_ID
            = Identifier.of("minecraft", "blocks/ancient_debris");
    private static final Identifier DEEPSLATE_REDSTONE_ORE_ID
            = Identifier.of("minecraft", "blocks/deepslate_redstone_ore");

    private static void addNuggetDrop(Identifier id, Item nugget, float minDrop, float maxDrop, Item self) {
        LootTableEvents.REPLACE.register((key, tableBuilder, source, registry) -> {
            if (!id.equals(key.getValue())) return null;

            LootPool pool = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(NoSilkOrShearsCondition.builder())
                    .with(ItemEntry.builder(nugget))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrop, maxDrop)).build())
                    .build();

            return LootTable.builder()
                    .pool(pool)
                    .build();
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registry) -> {
            if(id.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(HasSilkTouch.builder())
                        .with(ItemEntry.builder(self))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });
    }

    private static void addLeafFiberLoot(Identifier id) {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registry) -> {
            if(id.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(NoSilkOrShearsCondition.builder())
                        .conditionally(RandomChanceLootCondition.builder(0.07f))
                        .with(ItemEntry.builder(ModItems.LEAF_FIBER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registry) -> {
            if(id.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(IsFlintToolCondition.builder())
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(Items.STICK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });
    }

    public static void modifyLootTables() {
        addLeafFiberLoot(ACACIA_LEAVES_ID);
        addLeafFiberLoot(AZALEA_LEAVES_ID);
        addLeafFiberLoot(BIRCH_LEAVES_ID);
        addLeafFiberLoot(CHERRY_LEAVES_ID);
        addLeafFiberLoot(DARK_OAK_LEAVES_ID);
        addLeafFiberLoot(FLOWERING_AZALEA_LEAVES_ID);
        addLeafFiberLoot(JUNGLE_LEAVES_ID);
        addLeafFiberLoot(MANGROVE_LEAVES_ID);
        addLeafFiberLoot(OAK_LEAVES_ID);
        addLeafFiberLoot(SPRUCE_LEAVES_ID);

        addNuggetDrop(COAL_ORE_ID, ModItems.COAL_PIECE, 1f, 4f, Items.COAL_ORE);
        addNuggetDrop(COPPER_ORE_ID, ModItems.RAW_COPPER_NUGGET, 1f, 20f, Items.COPPER_ORE);
        addNuggetDrop(IRON_ORE_ID, ModItems.RAW_IRON_NUGGET, 1f, 8f, Items.IRON_ORE);
        addNuggetDrop(GOLD_ORE_ID, ModItems.RAW_GOLD_NUGGET, 1f, 8f, Items.GOLD_ORE);
        addNuggetDrop(LAPIS_ORE_ID, ModItems.LAPIS_LAZULI_PIECE, 1f, 20f, Items.LAPIS_ORE);
        addNuggetDrop(EMERALD_ORE_ID, ModItems.EMERALD_SHARD, 1f, 4f, Items.EMERALD_ORE);
        addNuggetDrop(DIAMOND_ORE_ID, ModItems.DIAMOND_SHARD, 1f, 4f, Items.DIAMOND_ORE);
        addNuggetDrop(DEEPSLATE_DIAMOND_ORE_ID, ModItems.DIAMOND_SHARD, 1f, 4f, Items.DEEPSLATE_DIAMOND_ORE);
        addNuggetDrop(ANCIENT_DEBRIS_ID, ModItems.ANCIENT_DEBRIS_FRAGMENT, 1f, 1f, Items.ANCIENT_DEBRIS);
        addNuggetDrop(DEEPSLATE_REDSTONE_ORE_ID, Items.REDSTONE, 8f, 9f, Items.DEEPSLATE_REDSTONE_ORE);
    }
}
