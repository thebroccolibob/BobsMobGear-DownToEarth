package io.github.thebroccolibob.downtoearth.registry;

import io.github.thebroccolibob.downtoearth.BobsMobGearDownToEarth;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(BobsMobGearDownToEarth.MOD_ID, name),
                builderOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataComponentTypes() {
        BobsMobGearDownToEarth.LOGGER.info("These Data Component Types are " + BobsMobGearDownToEarth.MOD_ID + "!");
    }
}
