package io.github.thebroccolibob.downtoearth.datagen;

import io.github.thebroccolibob.bobsmobgear.registry.BobsMobGearItemTags;
import io.github.thebroccolibob.bobsmobgear.registry.BobsMobGearItems;
import io.github.thebroccolibob.downtoearth.registry.ModItemTags;

import io.github.thebroccolibob.downtoearth.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;

import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.BRONZE_SWORD);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.BRONZE_PICKAXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.BRONZE_SHOVEL);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.BRONZE_AXE);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.BRONZE_HOE);

        getOrCreateTagBuilder(BobsMobGearItemTags.TONG_HOLDABLE)
                .add(Items.COPPER_INGOT)
                .add(ModItems.TIN_INGOT)
                .add(ModItems.BRONZE_INGOT);

        getOrCreateTagBuilder(BobsMobGearItemTags.TONG_HOLDABLE_WEAPONS)
                .add(ModItems.UNFORGED_BRONZE_SWORD_BLADE)
                .add(ModItems.UNSHARPENED_BRONZE_SWORD_BLADE)
                .add(ModItems.BRONZE_SWORD_BLADE)
                .add(ModItems.BRONZE_SWORD)
                .add(ModItems.UNFORGED_BRONZE_PICKAXE_HEAD)
                .add(ModItems.UNSHARPENED_BRONZE_PICKAXE_HEAD)
                .add(ModItems.BRONZE_PICKAXE_HEAD)
                .add(ModItems.BRONZE_PICKAXE)
                .add(ModItems.UNFORGED_BRONZE_SHOVEL_HEAD)
                .add(ModItems.UNSHARPENED_BRONZE_SHOVEL_HEAD)
                .add(ModItems.BRONZE_SHOVEL_HEAD)
                .add(ModItems.BRONZE_SHOVEL)
                .add(ModItems.UNFORGED_BRONZE_AXE_HEAD)
                .add(ModItems.UNSHARPENED_BRONZE_AXE_HEAD)
                .add(ModItems.BRONZE_AXE_HEAD)
                .add(ModItems.BRONZE_AXE)
                .add(ModItems.UNFORGED_BRONZE_HOE_HEAD)
                .add(ModItems.UNSHARPENED_BRONZE_HOE_HEAD)
                .add(ModItems.BRONZE_HOE_HEAD)
                .add(ModItems.BRONZE_HOE)
                .add(ModItems.UNFORGED_BRONZE_HELMET)
                .add(ModItems.UNPOLISHED_BRONZE_HELMET)
                .add(ModItems.UNFORGED_BRONZE_CHESTPLATE)
                .add(ModItems.UNPOLISHED_BRONZE_CHESTPLATE)
                .add(ModItems.UNFORGED_BRONZE_LEGGINGS)
                .add(ModItems.UNPOLISHED_BRONZE_LEGGINGS)
                .add(ModItems.UNFORGED_BRONZE_BOOTS)
                .add(ModItems.UNPOLISHED_BRONZE_BOOTS);

        getOrCreateTagBuilder(ConventionalItemTags.HIDDEN_FROM_RECIPE_VIEWERS)
                .add(BobsMobGearItems.BLACK_STEEL_POT)
                .add(BobsMobGearItems.CLAYMORE_TEMPLATE)
                .add(BobsMobGearItems.DAGGER_TEMPLATE)
                .add(BobsMobGearItems.DIAMOND_POT)
                .add(BobsMobGearItems.DOUBLE_AXE_TEMPLATE)
                .add(BobsMobGearItems.FLESH_GLOVE)
                .add(BobsMobGearItems.FORGE_HEATER)
                .add(BobsMobGearItems.GLAIVE_TEMPLATE)
                .add(BobsMobGearItems.GREATHAMMER_TEMPLATE)
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
                .add(BobsMobGearItems.SCULK_SYMBIOTE)
                .add(BobsMobGearItems.SICKLE_TEMPLATE)
                .add(BobsMobGearItems.SPEAR_TEMPLATE)
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

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.BRONZE_HELMET)
                .add(ModItems.BRONZE_CHESTPLATE)
                .add(ModItems.BRONZE_LEGGINGS)
                .add(ModItems.BRONZE_BOOTS);

        getOrCreateTagBuilder(BobsMobGearItemTags.SMITHING_HAMMERS).add(ModItems.STONE_SMITHING_HAMMER);
    }
}
