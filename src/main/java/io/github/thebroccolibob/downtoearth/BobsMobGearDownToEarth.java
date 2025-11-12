package io.github.thebroccolibob.downtoearth;

import io.github.thebroccolibob.downtoearth.registry.*;
import io.github.thebroccolibob.downtoearth.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.ComposterBlock;
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
        ModDataComponentTypes.registerDataComponentTypes();
        ModEntities.registerModEntities();
        ModLootConditions.registerModLootConditions();
        ModLootTableModifiers.modifyLootTables();

        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.LEAF_FIBER_BALE, 60, 20);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.LEAF_FIBER_BALE.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LEAF_FIBER, 0.3f);

	}
}