package io.github.thebroccolibob.downtoearth.registry;

import io.github.thebroccolibob.downtoearth.BobsMobGearDownToEarth;
import io.github.thebroccolibob.downtoearth.condition.NoSilkOrShearsCondition;
import net.minecraft.loot.condition.LootConditionType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModLootConditions {
    public static LootConditionType NO_SILK_OR_SHEARS;

    public static void registerModLootConditions() {
        BobsMobGearDownToEarth.LOGGER.info("These Loot Conditions are " + BobsMobGearDownToEarth.MOD_ID + "!");

        NO_SILK_OR_SHEARS = Registry.register(
                Registries.LOOT_CONDITION_TYPE,
                Identifier.of(BobsMobGearDownToEarth.MOD_ID, "no_silk_or_shears"),
                new LootConditionType(NoSilkOrShearsCondition.CODEC)
        );
    }
}
