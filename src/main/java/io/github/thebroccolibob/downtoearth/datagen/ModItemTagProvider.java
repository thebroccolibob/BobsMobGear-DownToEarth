package io.github.thebroccolibob.downtoearth.datagen;

import io.github.thebroccolibob.bobsmobgear.registry.BobsMobGearItems;
import io.github.thebroccolibob.downtoearth.registry.ModItemTags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;

import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ConventionalItemTags.HIDDEN_FROM_RECIPE_VIEWERS)
                .add(BobsMobGearItems.AXE_TEMPLATE)
                .add(BobsMobGearItems.BLACK_STEEL_POT)
                .add(BobsMobGearItems.CLAYMORE_TEMPLATE)
                .add(BobsMobGearItems.DAGGER_TEMPLATE)
                .add(BobsMobGearItems.DIAMOND_POT)
                .add(BobsMobGearItems.DOUBLE_AXE_TEMPLATE)
                .add(BobsMobGearItems.EMPTY_POT)
                .add(BobsMobGearItems.EMPTY_TEMPLATE)
                .add(BobsMobGearItems.FLESH_GLOVE)
                .add(BobsMobGearItems.FORGE)
                .add(BobsMobGearItems.FORGE_HEATER)
                .add(BobsMobGearItems.GLAIVE_TEMPLATE)
                .add(BobsMobGearItems.GREATHAMMER_TEMPLATE)
                .add(BobsMobGearItems.HOE_TEMPLATE)
                .add(BobsMobGearItems.IRON_BONE_HAMMER)
                .add(BobsMobGearItems.IRON_BOOM_BATON)
                .add(BobsMobGearItems.IRON_ENDER_EYE_SPEAR)
                .add(BobsMobGearItems.IRON_ENDER_SPEAR)
                .add(BobsMobGearItems.IRON_FLESH_GLOVE)
                .add(BobsMobGearItems.IRON_POT)
                .add(BobsMobGearItems.IRON_SPIDER_DAGGER)
                .add(BobsMobGearItems.KITE_SHIELD_TEMPLATE)
                .add(BobsMobGearItems.KNIFE_TEMPLATE)
                .add(BobsMobGearItems.MACE_TEMPLATE)
                .add(BobsMobGearItems.NETHERITE_POT)
                .add(BobsMobGearItems.PICKAXE_TEMPLATE)
                .add(BobsMobGearItems.SCULK_SYMBIOTE)
                .add(BobsMobGearItems.SHOVEL_TEMPLATE)
                .add(BobsMobGearItems.SICKLE_TEMPLATE)
                .add(BobsMobGearItems.SMITHING_HAMMER)
                .add(BobsMobGearItems.SMITHING_TONGS)
                .add(BobsMobGearItems.SPEAR_TEMPLATE)
                .add(BobsMobGearItems.SWORD_TEMPLATE)
                .add(BobsMobGearItems.UNLIMITED_BACON)
                .add(BobsMobGearItems.WARDEN_FIST)
                .add(BobsMobGearItems.WORN_CREEPER_CORE)
                .add(BobsMobGearItems.WORN_HARDENED_FLESH)
                .add(BobsMobGearItems.WORN_SEETHING_EYE)
                .add(BobsMobGearItems.WORN_SEETHING_PEARL)
                .add(BobsMobGearItems.WORN_SPIDER_FANG)
                .add(BobsMobGearItems.WORN_STURDY_BONE);
        getOrCreateTagBuilder(ModItemTags.SOUL_FLAME_HAMMERED).add(
                Items.NETHERITE_SWORD,
                Items.NETHERITE_SHOVEL,
                Items.NETHERITE_PICKAXE,
                Items.NETHERITE_AXE,
                Items.NETHERITE_HOE,
                Items.NETHERITE_HELMET,
                Items.NETHERITE_BOOTS,
                Items.NETHERITE_CHESTPLATE,
                Items.NETHERITE_LEGGINGS,
                Items.NETHERITE_INGOT,
                Items.NETHERITE_SCRAP,
                Items.NETHERITE_BLOCK
        );
    }
}
