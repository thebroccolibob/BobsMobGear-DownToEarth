package io.github.thebroccolibob.downtoearth.util;

import io.github.thebroccolibob.downtoearth.condition.NoSilkOrShearsCondition;
import io.github.thebroccolibob.downtoearth.registry.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

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
    }
}
