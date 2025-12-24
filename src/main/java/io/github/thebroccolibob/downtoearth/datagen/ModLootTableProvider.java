package io.github.thebroccolibob.downtoearth.datagen;

import io.github.thebroccolibob.downtoearth.registry.ModBlocks;
import io.github.thebroccolibob.downtoearth.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.LEAF_FIBER_BALE);
        addDrop(ModBlocks.FLINT, Items.FLINT);
        addDrop(ModBlocks.TIN_BLOCK);
        addDrop(ModBlocks.CUT_TIN);
        addDrop(ModBlocks.CUT_TIN_SLAB, slabDrops(ModBlocks.CUT_TIN_SLAB));
        addDrop(ModBlocks.TIN_DOOR, doorDrops(ModBlocks.TIN_DOOR));
        addDrop(ModBlocks.TIN_TRAPDOOR);
        addDrop(ModBlocks.TIN_BLOCK);
        addDrop(ModBlocks.CHISELED_TIN);
        addDrop(ModBlocks.CUT_TIN_STAIRS);
        addDrop(ModBlocks.TIN_BULB);
        addDrop(ModBlocks.RAW_TIN_BLOCK);

        addDrop(ModBlocks.TIN_ORE, multiOreDrop(ModBlocks.TIN_ORE, ModItems.RAW_TIN_NUGGET,1f, 8f));
        addDrop(ModBlocks.DEEPSLATE_TIN_ORE, multiOreDrop(ModBlocks.DEEPSLATE_TIN_ORE, ModItems.RAW_TIN,2f, 3f));
    }

    public LootTable.Builder multiOreDrop(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, (LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops)))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)));
    }
}
