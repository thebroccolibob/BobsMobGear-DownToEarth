package io.github.thebroccolibob.downtoearth;

import io.github.thebroccolibob.downtoearth.registry.ModBlocks;
import io.github.thebroccolibob.downtoearth.registry.ModItemGroups;
import io.github.thebroccolibob.downtoearth.registry.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BobsMobGearDownToEarth implements ModInitializer {
	public static final String MOD_ID = "downtoearth";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        LOGGER.info("Bob's Mob Gear is running! This mod is very Down to Earth.");

        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
	}
}