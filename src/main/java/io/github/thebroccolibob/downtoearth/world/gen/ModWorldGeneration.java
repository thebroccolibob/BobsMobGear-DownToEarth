package io.github.thebroccolibob.downtoearth.world.gen;

import io.github.thebroccolibob.downtoearth.DownToEarth;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        DownToEarth.LOGGER.info("This Generation is " + DownToEarth.MOD_ID + "!");

        ModFlintRockGeneration.generateFlintRocks();
    }
}
