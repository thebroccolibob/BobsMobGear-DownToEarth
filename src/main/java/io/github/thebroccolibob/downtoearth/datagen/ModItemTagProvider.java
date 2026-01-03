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
                .add(ModItems.BRONZE_SWORD)
                .add(ModItems.STEEL_SWORD);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.BRONZE_PICKAXE)
                .add(ModItems.STEEL_PICKAXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.BRONZE_SHOVEL)
                .add(ModItems.STEEL_SHOVEL);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.BRONZE_AXE)
                .add(ModItems.STEEL_AXE);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.BRONZE_HOE)
                .add(ModItems.STEEL_HOE);

        getOrCreateTagBuilder(BobsMobGearItemTags.FORGES_IRON_INGOT)
                .add(ModItems.UNFORGED_IRON_SHOVEL_HEAD)
                .add(ModItems.UNSHARPENED_IRON_SHOVEL_HEAD)
                .add(ModItems.IRON_SHOVEL_HEAD)
                .add(ModItems.UNFORGED_IRON_PICKAXE_HEAD)
                .add(ModItems.UNSHARPENED_IRON_PICKAXE_HEAD)
                .add(ModItems.IRON_PICKAXE_HEAD)
                .add(ModItems.UNFORGED_IRON_AXE_HEAD)
                .add(ModItems.UNSHARPENED_IRON_AXE_HEAD)
                .add(ModItems.IRON_AXE_HEAD)
                .add(ModItems.UNFORGED_IRON_HOE_HEAD)
                .add(ModItems.UNSHARPENED_IRON_HOE_HEAD)
                .add(ModItems.IRON_HOE_HEAD)
                .add(ModItems.UNFORGED_IRON_SWORD_BLADE)
                .add(ModItems.UNSHARPENED_IRON_SWORD_BLADE)
                .add(ModItems.IRON_SWORD_BLADE)
                .add(ModItems.UNFORGED_IRON_HELMET)
                .add(ModItems.UNPOLISHED_IRON_HELMET)
                .add(ModItems.UNFORGED_IRON_CHESTPLATE)
                .add(ModItems.UNPOLISHED_IRON_CHESTPLATE)
                .add(ModItems.UNFORGED_IRON_LEGGINGS)
                .add(ModItems.UNPOLISHED_IRON_LEGGINGS)
                .add(ModItems.UNFORGED_IRON_BOOTS)
                .add(ModItems.UNPOLISHED_IRON_BOOTS);

        getOrCreateTagBuilder(BobsMobGearItemTags.TONG_HOLDABLE)
                .add(Items.COPPER_INGOT)
                .add(ModItems.TIN_INGOT)
                .add(ModItems.BRONZE_INGOT)
                .add(ModItems.STEEL_INGOT);

        getOrCreateTagBuilder(BobsMobGearItemTags.TONG_HOLDABLE_WEAPONS)
                .add(ModItems.UNFORGED_BRONZE_SWORD_BLADE)
                .add(ModItems.UNSHARPENED_BRONZE_SWORD_BLADE)
                .add(ModItems.BRONZE_SWORD_BLADE)
                .add(ModItems.UNFORGED_BRONZE_PICKAXE_HEAD)
                .add(ModItems.UNSHARPENED_BRONZE_PICKAXE_HEAD)
                .add(ModItems.BRONZE_PICKAXE_HEAD)
                .add(ModItems.UNFORGED_BRONZE_SHOVEL_HEAD)
                .add(ModItems.UNSHARPENED_BRONZE_SHOVEL_HEAD)
                .add(ModItems.BRONZE_SHOVEL_HEAD)
                .add(ModItems.UNFORGED_BRONZE_AXE_HEAD)
                .add(ModItems.UNSHARPENED_BRONZE_AXE_HEAD)
                .add(ModItems.BRONZE_AXE_HEAD)
                .add(ModItems.UNFORGED_BRONZE_HOE_HEAD)
                .add(ModItems.UNSHARPENED_BRONZE_HOE_HEAD)
                .add(ModItems.BRONZE_HOE_HEAD)
                .add(ModItems.UNFORGED_BRONZE_HELMET)
                .add(ModItems.UNPOLISHED_BRONZE_HELMET)
                .add(ModItems.UNFORGED_BRONZE_CHESTPLATE)
                .add(ModItems.UNPOLISHED_BRONZE_CHESTPLATE)
                .add(ModItems.UNFORGED_BRONZE_LEGGINGS)
                .add(ModItems.UNPOLISHED_BRONZE_LEGGINGS)
                .add(ModItems.UNFORGED_BRONZE_BOOTS)
                .add(ModItems.UNPOLISHED_BRONZE_BOOTS)
                .add(ModItems.UNFORGED_IRON_SHOVEL_HEAD)
                .add(ModItems.UNSHARPENED_IRON_SHOVEL_HEAD)
                .add(ModItems.IRON_SHOVEL_HEAD)
                .add(ModItems.UNFORGED_IRON_PICKAXE_HEAD)
                .add(ModItems.UNSHARPENED_IRON_PICKAXE_HEAD)
                .add(ModItems.IRON_PICKAXE_HEAD)
                .add(ModItems.UNFORGED_IRON_AXE_HEAD)
                .add(ModItems.UNSHARPENED_IRON_AXE_HEAD)
                .add(ModItems.IRON_AXE_HEAD)
                .add(ModItems.UNFORGED_IRON_HOE_HEAD)
                .add(ModItems.UNSHARPENED_IRON_HOE_HEAD)
                .add(ModItems.IRON_HOE_HEAD)
                .add(ModItems.UNFORGED_IRON_SWORD_BLADE)
                .add(ModItems.UNSHARPENED_IRON_SWORD_BLADE)
                .add(ModItems.IRON_SWORD_BLADE)
                .add(ModItems.UNFORGED_IRON_HELMET)
                .add(ModItems.UNPOLISHED_IRON_HELMET)
                .add(ModItems.UNFORGED_IRON_CHESTPLATE)
                .add(ModItems.UNPOLISHED_IRON_CHESTPLATE)
                .add(ModItems.UNFORGED_IRON_LEGGINGS)
                .add(ModItems.UNPOLISHED_IRON_LEGGINGS)
                .add(ModItems.UNFORGED_IRON_BOOTS)
                .add(ModItems.UNPOLISHED_IRON_BOOTS)
                .add(ModItems.UNFORGED_STEEL_SHOVEL_HEAD)
                .add(ModItems.UNSHARPENED_STEEL_SHOVEL_HEAD)
                .add(ModItems.STEEL_SHOVEL_HEAD)
                .add(ModItems.UNFORGED_STEEL_PICKAXE_HEAD)
                .add(ModItems.UNSHARPENED_STEEL_PICKAXE_HEAD)
                .add(ModItems.STEEL_PICKAXE_HEAD)
                .add(ModItems.UNFORGED_STEEL_AXE_HEAD)
                .add(ModItems.UNSHARPENED_STEEL_AXE_HEAD)
                .add(ModItems.STEEL_AXE_HEAD)
                .add(ModItems.UNFORGED_STEEL_HOE_HEAD)
                .add(ModItems.UNSHARPENED_STEEL_HOE_HEAD)
                .add(ModItems.STEEL_HOE_HEAD)
                .add(ModItems.UNFORGED_STEEL_SWORD_BLADE)
                .add(ModItems.UNSHARPENED_STEEL_SWORD_BLADE)
                .add(ModItems.STEEL_SWORD_BLADE)
                .add(ModItems.STEEL_HELMET)
                .add(ModItems.STEEL_CHESTPLATE)
                .add(ModItems.STEEL_LEGGINGS)
                .add(ModItems.STEEL_BOOTS)
                .add(ModItems.UNFORGED_STEEL_HELMET)
                .add(ModItems.UNPOLISHED_STEEL_HELMET)
                .add(ModItems.UNFORGED_STEEL_CHESTPLATE)
                .add(ModItems.UNPOLISHED_STEEL_CHESTPLATE)
                .add(ModItems.UNFORGED_STEEL_LEGGINGS)
                .add(ModItems.UNPOLISHED_STEEL_LEGGINGS)
                .add(ModItems.UNFORGED_STEEL_BOOTS)
                .add(ModItems.UNPOLISHED_STEEL_BOOTS)
                .add(ModItems.UNFORGED_DIAMOND_SHOVEL_HEAD)
                .add(ModItems.UNSHARPENED_DIAMOND_SHOVEL_HEAD)
                .add(ModItems.DIAMOND_SHOVEL_HEAD)
                .add(ModItems.UNFORGED_DIAMOND_PICKAXE_HEAD)
                .add(ModItems.UNSHARPENED_DIAMOND_PICKAXE_HEAD)
                .add(ModItems.DIAMOND_PICKAXE_HEAD)
                .add(ModItems.UNFORGED_DIAMOND_AXE_HEAD)
                .add(ModItems.UNSHARPENED_DIAMOND_AXE_HEAD)
                .add(ModItems.DIAMOND_AXE_HEAD)
                .add(ModItems.UNFORGED_DIAMOND_HOE_HEAD)
                .add(ModItems.UNSHARPENED_DIAMOND_HOE_HEAD)
                .add(ModItems.DIAMOND_HOE_HEAD)
                .add(ModItems.UNFORGED_DIAMOND_SWORD_BLADE)
                .add(ModItems.UNSHARPENED_DIAMOND_SWORD_BLADE)
                .add(ModItems.DIAMOND_SWORD_BLADE)
                .add(ModItems.UNFORGED_DIAMOND_HELMET)
                .add(ModItems.UNPOLISHED_DIAMOND_HELMET)
                .add(ModItems.UNFORGED_DIAMOND_CHESTPLATE)
                .add(ModItems.UNPOLISHED_DIAMOND_CHESTPLATE)
                .add(ModItems.UNFORGED_DIAMOND_LEGGINGS)
                .add(ModItems.UNPOLISHED_DIAMOND_LEGGINGS)
                .add(ModItems.UNFORGED_DIAMOND_BOOTS)
                .add(ModItems.UNPOLISHED_DIAMOND_BOOTS);

        getOrCreateTagBuilder(ConventionalItemTags.HIDDEN_FROM_RECIPE_VIEWERS)
                .add(BobsMobGearItems.BLACK_STEEL_POT)
                .add(BobsMobGearItems.CLAYMORE_TEMPLATE)
                .add(BobsMobGearItems.DAGGER_TEMPLATE)
                .add(BobsMobGearItems.DOUBLE_AXE_TEMPLATE)
                .add(BobsMobGearItems.FLESH_GLOVE)
                .add(BobsMobGearItems.GLAIVE_TEMPLATE)
                .add(BobsMobGearItems.GREATHAMMER_TEMPLATE)
                .add(BobsMobGearItems.IRON_BONE_HAMMER)
                .add(BobsMobGearItems.IRON_BOOM_BATON)
                .add(BobsMobGearItems.IRON_ENDER_EYE_SPEAR)
                .add(BobsMobGearItems.IRON_ENDER_SPEAR)
                .add(BobsMobGearItems.IRON_FLESH_GLOVE)
                .add(BobsMobGearItems.IRON_SPIDER_DAGGER)
                .add(BobsMobGearItems.KITE_SHIELD_TEMPLATE)
                .add(BobsMobGearItems.KNIFE_TEMPLATE)
                .add(BobsMobGearItems.MACE_TEMPLATE)
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
                .add(ModItems.BRONZE_BOOTS)
                .add(ModItems.STEEL_HELMET)
                .add(ModItems.STEEL_CHESTPLATE)
                .add(ModItems.STEEL_LEGGINGS)
                .add(ModItems.STEEL_BOOTS);

        getOrCreateTagBuilder(BobsMobGearItemTags.SMITHING_HAMMERS).add(ModItems.STONE_SMITHING_HAMMER);
    }
}
