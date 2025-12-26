package io.github.thebroccolibob.downtoearth.registry;

import io.github.thebroccolibob.bobsmobgear.item.FluidPotItem;
import io.github.thebroccolibob.bobsmobgear.item.SmithingHammerItem;
import io.github.thebroccolibob.bobsmobgear.registry.BobsMobGearItems;
import io.github.thebroccolibob.downtoearth.DownToEarth;
import io.github.thebroccolibob.downtoearth.item.FlintToolItem;
import io.github.thebroccolibob.downtoearth.item.ModToolMaterials;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.EmptyItemFluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.FullItemFluidStorage;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item LEAF_FIBER = registerItem("leaf_fiber", new Item(new Item.Settings()));

    public static final Item WOODEN_SWORD_BLADE = registerItem("wooden_sword_blade", new Item(new Item.Settings()));
    public static final Item WOODEN_SHOVEL_HEAD = registerItem("wooden_shovel_head", new Item(new Item.Settings()));
    public static final Item WOODEN_PICKAXE_HEAD = registerItem("wooden_pickaxe_head", new Item(new Item.Settings()));
    public static final Item WOODEN_AXE_HEAD = registerItem("wooden_axe_head", new Item(new Item.Settings()));
    public static final Item WOODEN_HOE_HEAD = registerItem("wooden_hoe_head", new Item(new Item.Settings()));
    public static final Item STONE_SMITHING_HAMMER_HEAD = registerItem("stone_smithing_hammer_head", new Item(new Item.Settings()));
    public static final Item STONE_SWORD_BLADE = registerItem("stone_sword_blade", new Item(new Item.Settings()));
    public static final Item STONE_SHOVEL_HEAD = registerItem("stone_shovel_head", new Item(new Item.Settings()));
    public static final Item STONE_PICKAXE_HEAD = registerItem("stone_pickaxe_head", new Item(new Item.Settings()));
    public static final Item STONE_AXE_HEAD = registerItem("stone_axe_head", new Item(new Item.Settings()));
    public static final Item STONE_HOE_HEAD = registerItem("stone_hoe_head", new Item(new Item.Settings()));

    public static final Item CLAY_INGOT_MOLD = registerItem("clay_ingot_mold", new Item(new Item.Settings()));
    public static final Item CLAY_SWORD_BLADE_MOLD = registerItem("clay_sword_blade_mold", new Item(new Item.Settings()));
    public static final Item CLAY_SHOVEL_HEAD_MOLD = registerItem("clay_shovel_head_mold", new Item(new Item.Settings()));
    public static final Item CLAY_PICKAXE_HEAD_MOLD = registerItem("clay_pickaxe_head_mold", new Item(new Item.Settings()));
    public static final Item CLAY_AXE_HEAD_MOLD = registerItem("clay_axe_head_mold", new Item(new Item.Settings()));
    public static final Item CLAY_HOE_HEAD_MOLD = registerItem("clay_hoe_head_mold", new Item(new Item.Settings()));
    public static final Item CLAY_HELMET_MOLD = registerItem("clay_helmet_mold", new Item(new Item.Settings()));
    public static final Item CLAY_CHESTPLATE_MOLD = registerItem("clay_chestplate_mold", new Item(new Item.Settings()));
    public static final Item CLAY_LEGGINGS_MOLD = registerItem("clay_leggings_mold", new Item(new Item.Settings()));
    public static final Item CLAY_BOOTS_MOLD = registerItem("clay_boots_mold", new Item(new Item.Settings()));

    public static final Item COAL_PIECE = registerItem("coal_piece", new Item(new Item.Settings()));
    public static final Item RAW_COPPER_NUGGET = registerItem("raw_copper_nugget", new Item(new Item.Settings()));
    public static final Item RAW_TIN_NUGGET = registerItem("raw_tin_nugget", new Item(new Item.Settings()));
    public static final Item RAW_TIN = registerItem("raw_tin", new Item(new Item.Settings()));
    public static final Item RAW_IRON_NUGGET = registerItem("raw_iron_nugget", new Item(new Item.Settings()));
    public static final Item RAW_GOLD_NUGGET = registerItem("raw_gold_nugget", new Item(new Item.Settings()));
    public static final Item LAPIS_LAZULI_PIECE = registerItem("lapis_lazuli_piece", new Item(new Item.Settings()));
    public static final Item EMERALD_SHARD = registerItem("emerald_shard", new Item(new Item.Settings()));
    public static final Item DIAMOND_SHARD = registerItem("diamond_shard", new Item(new Item.Settings()));
    public static final Item ANCIENT_DEBRIS_FRAGMENT = registerItem("ancient_debris_fragment", new Item(new Item.Settings()));

    public static final Item BRONZE_MIX = registerItem("bronze_mix", new Item(new Item.Settings()));

    public static final Item TIN_INGOT = registerItem("tin_ingot", new Item(new Item.Settings()));
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot", new Item(new Item.Settings()));

    public static final Item UNFORGED_BRONZE_SHOVEL_HEAD = registerItem("unforged_bronze_shovel_head", new Item(new Item.Settings()));
    public static final Item UNSHARPENED_BRONZE_SHOVEL_HEAD = registerItem("unsharpened_bronze_shovel_head", new Item(new Item.Settings()));
    public static final Item BRONZE_SHOVEL_HEAD = registerItem("bronze_shovel_head", new Item(new Item.Settings()));

    public static final Item UNFORGED_BRONZE_PICKAXE_HEAD = registerItem("unforged_bronze_pickaxe_head", new Item(new Item.Settings()));
    public static final Item UNSHARPENED_BRONZE_PICKAXE_HEAD = registerItem("unsharpened_bronze_pickaxe_head", new Item(new Item.Settings()));
    public static final Item BRONZE_PICKAXE_HEAD = registerItem("bronze_pickaxe_head", new Item(new Item.Settings()));

    public static final Item UNFORGED_BRONZE_AXE_HEAD = registerItem("unforged_bronze_axe_head", new Item(new Item.Settings()));
    public static final Item UNSHARPENED_BRONZE_AXE_HEAD = registerItem("unsharpened_bronze_axe_head", new Item(new Item.Settings()));
    public static final Item BRONZE_AXE_HEAD = registerItem("bronze_axe_head", new Item(new Item.Settings()));

    public static final Item UNFORGED_BRONZE_HOE_HEAD = registerItem("unforged_bronze_hoe_head", new Item(new Item.Settings()));
    public static final Item UNSHARPENED_BRONZE_HOE_HEAD = registerItem("unsharpened_bronze_hoe_head", new Item(new Item.Settings()));
    public static final Item BRONZE_HOE_HEAD = registerItem("bronze_hoe_head", new Item(new Item.Settings()));

    public static final Item UNFORGED_BRONZE_SWORD_BLADE = registerItem("unforged_bronze_sword_blade", new Item(new Item.Settings()));
    public static final Item UNSHARPENED_BRONZE_SWORD_BLADE = registerItem("unsharpened_bronze_sword_blade", new Item(new Item.Settings()));
    public static final Item BRONZE_SWORD_BLADE = registerItem("bronze_sword_blade", new Item(new Item.Settings()));

    public static final Item STONE_SMITHING_HAMMER = registerItem("stone_smithing_hammer",
            new SmithingHammerItem(new Item.Settings()
                    .maxDamage(128)
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.STONE, 1, -3.2F))
                    .component(DataComponentTypes.TOOL, new ToolComponent(List.of(), 1f, 2))));

    public static final Item FLINT_TOOL = registerItem("flint_tool",
            new FlintToolItem(ModToolMaterials.FLINT, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.FLINT, 1, -2.0F))));

    public static final Item FLINT_AXE = registerItem("flint_axe",
            new AxeItem(ModToolMaterials.FLINT, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.FLINT, 3.0F, -3.2F))));

    public static final Item COPPER_POT = BobsMobGearItems.registerPot(ModFluids.COPPER);
    public static final Item TIN_POT = BobsMobGearItems.registerPot(ModFluids.TIN);
    public static final Item BRONZE_POT = BobsMobGearItems.registerPot(ModFluids.BRONZE);

    public static final Item BRONZE_SHOVEL = registerItem("bronze_shovel",
            new ShovelItem(ModToolMaterials.BRONZE, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.BRONZE, 1.5F, -3.0F))));

    public static final Item BRONZE_PICKAXE = registerItem("bronze_pickaxe",
            new PickaxeItem(ModToolMaterials.BRONZE, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.BRONZE, 1, -2.8F))));

    public static final Item BRONZE_AXE = registerItem("bronze_axe",
            new AxeItem(ModToolMaterials.BRONZE, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.BRONZE, 6, -3.2F))));

    public static final Item BRONZE_HOE = registerItem("bronze_hoe",
            new HoeItem(ModToolMaterials.BRONZE, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.BRONZE, 0, -3))));

    public static final Item BRONZE_SWORD = registerItem("bronze_sword",
            new SwordItem(ModToolMaterials.BRONZE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.BRONZE, 3, -2.4F))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(DownToEarth.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DownToEarth.LOGGER.info("These Items are " + DownToEarth.MOD_ID + "!");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModItems.LEAF_FIBER);

            fabricItemGroupEntries.add(ModItems.WOODEN_SHOVEL_HEAD);
            fabricItemGroupEntries.add(ModItems.WOODEN_PICKAXE_HEAD);
            fabricItemGroupEntries.add(ModItems.WOODEN_AXE_HEAD);
            fabricItemGroupEntries.add(ModItems.WOODEN_HOE_HEAD);
            fabricItemGroupEntries.add(ModItems.WOODEN_SWORD_BLADE);

            fabricItemGroupEntries.add(ModItems.CLAY_INGOT_MOLD);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModItems.FLINT_TOOL);
            fabricItemGroupEntries.add(ModItems.FLINT_AXE);
        });

        // COPPER
        FluidStorage.ITEM.registerForItems((itemStack, containerItemContext) ->
                new FullItemFluidStorage(containerItemContext, BobsMobGearItems.EMPTY_POT,
                        FluidVariant.of(((FluidPotItem) itemStack.getItem()).getFluid()), FluidConstants.INGOT), COPPER_POT);

        FluidStorage.combinedItemApiProvider(BobsMobGearItems.EMPTY_POT).register(containerItemContext ->
                new EmptyItemFluidStorage(containerItemContext, COPPER_POT, ModFluids.COPPER, FluidConstants.INGOT));

        // TIN
        FluidStorage.ITEM.registerForItems((itemStack, containerItemContext) ->
                new FullItemFluidStorage(containerItemContext, BobsMobGearItems.EMPTY_POT,
                        FluidVariant.of(((FluidPotItem) itemStack.getItem()).getFluid()), FluidConstants.INGOT), TIN_POT);

        FluidStorage.combinedItemApiProvider(BobsMobGearItems.EMPTY_POT).register(containerItemContext ->
                new EmptyItemFluidStorage(containerItemContext, TIN_POT, ModFluids.TIN, FluidConstants.INGOT));

        // BRONZE
        FluidStorage.ITEM.registerForItems((itemStack, containerItemContext) ->
                new FullItemFluidStorage(containerItemContext, BobsMobGearItems.EMPTY_POT,
                        FluidVariant.of(((FluidPotItem) itemStack.getItem()).getFluid()), FluidConstants.INGOT), BRONZE_POT);

        FluidStorage.combinedItemApiProvider(BobsMobGearItems.EMPTY_POT).register(containerItemContext ->
                new EmptyItemFluidStorage(containerItemContext, BRONZE_POT, ModFluids.BRONZE, FluidConstants.INGOT));
    }
}
