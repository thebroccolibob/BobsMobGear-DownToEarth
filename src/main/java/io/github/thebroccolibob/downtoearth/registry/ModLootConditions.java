package io.github.thebroccolibob.downtoearth.registry;

import io.github.thebroccolibob.downtoearth.DownToEarth;
import io.github.thebroccolibob.downtoearth.condition.HasSilkTouch;
import io.github.thebroccolibob.downtoearth.condition.IsFlintToolCondition;
import io.github.thebroccolibob.downtoearth.condition.NoSilkOrShearsCondition;
import net.minecraft.loot.condition.LootConditionType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModLootConditions {
    public static LootConditionType NO_SILK_OR_SHEARS;
    public static LootConditionType IS_FLINT_TOOL;
    public static LootConditionType HAS_SILK_TOUCH;

    public static void registerModLootConditions() {
        DownToEarth.LOGGER.info("These Loot Conditions are " + DownToEarth.MOD_ID + "!");

        NO_SILK_OR_SHEARS = Registry.register(
                Registries.LOOT_CONDITION_TYPE,
                Identifier.of(DownToEarth.MOD_ID, "no_silk_or_shears"),
                new LootConditionType(NoSilkOrShearsCondition.CODEC)
        );

        HAS_SILK_TOUCH = Registry.register(
                Registries.LOOT_CONDITION_TYPE,
                Identifier.of(DownToEarth.MOD_ID, "has_silk_touch"),
                new LootConditionType(HasSilkTouch.CODEC)
        );

        IS_FLINT_TOOL = Registry.register(
                Registries.LOOT_CONDITION_TYPE,
                Identifier.of(DownToEarth.MOD_ID, "is_flint_tool"),
                new LootConditionType(IsFlintToolCondition.CODEC)
        );
    }
}
