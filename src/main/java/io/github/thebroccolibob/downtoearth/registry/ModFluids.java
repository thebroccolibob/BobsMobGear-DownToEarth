package io.github.thebroccolibob.downtoearth.registry;

import io.github.thebroccolibob.bobsmobgear.fluid.MetalFluid;
import io.github.thebroccolibob.bobsmobgear.registry.BobsMobGearFluids;
import io.github.thebroccolibob.bobsmobgear.registry.BobsMobGearParticles;
import io.github.thebroccolibob.downtoearth.DownToEarth;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static final BobsMobGearParticles.Drips COPPER_DRIPS = BobsMobGearParticles.registerDrips(Identifier.of(DownToEarth.MOD_ID, "copper"));
    public static final BobsMobGearParticles.Drips TIN_DRIPS = BobsMobGearParticles.registerDrips(Identifier.of(DownToEarth.MOD_ID, "tin"));
    public static final BobsMobGearParticles.Drips BRONZE_DRIPS = BobsMobGearParticles.registerDrips(Identifier.of(DownToEarth.MOD_ID, "bronze"));
    public static final BobsMobGearParticles.Drips GOLD_DRIPS = BobsMobGearParticles.registerDrips(Identifier.of(DownToEarth.MOD_ID, "gold"));

    public static final MetalFluid COPPER = Registry.register(Registries.FLUID, Identifier.of(DownToEarth.MOD_ID, "copper"
    ), new MetalFluid(0xE15731, COPPER_DRIPS.getDripping()));

    public static final MetalFluid TIN = Registry.register(Registries.FLUID, Identifier.of(DownToEarth.MOD_ID, "tin"
    ), new MetalFluid(0xE5BC88, TIN_DRIPS.getDripping()));

    public static final MetalFluid BRONZE = Registry.register(Registries.FLUID, Identifier.of(DownToEarth.MOD_ID, "bronze"
    ), new MetalFluid(0xC2751F, BRONZE_DRIPS.getDripping()));

    public static void registerModFluids() {
        DownToEarth.LOGGER.info("These Fluids are " + DownToEarth.MOD_ID + "!");

        BobsMobGearFluids.registerAttributes(COPPER, SoundEvents.ITEM_BUCKET_EMPTY_LAVA);
        BobsMobGearFluids.registerAttributes(TIN, SoundEvents.ITEM_BUCKET_EMPTY_LAVA);
        BobsMobGearFluids.registerAttributes(BRONZE, SoundEvents.ITEM_BUCKET_EMPTY_LAVA);
    }
}
