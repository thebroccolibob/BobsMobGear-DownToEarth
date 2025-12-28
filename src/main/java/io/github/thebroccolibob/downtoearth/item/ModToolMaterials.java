package io.github.thebroccolibob.downtoearth.item;

import com.google.common.base.Suppliers;
import io.github.thebroccolibob.downtoearth.registry.ModItems;
import io.github.thebroccolibob.downtoearth.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {
    FLINT(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 25, 1.5F, 0.0F, 5, () -> Ingredient.ofItems(Items.FLINT)),
    BRONZE(ModTags.Blocks.INCORRECT_FOR_BRONZE_TOOL, 191, 5.0F, 1.5F, 10, () -> Ingredient.ofItems(ModItems.BRONZE_INGOT)),
    STEEL(ModTags.Blocks.INCORRECT_FOR_STEEL_TOOL, 906, 7.0F, 2.5F, 14, () -> Ingredient.ofItems(ModItems.STEEL_INGOT));

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(
            final TagKey<Block> inverseTag,
            final int itemDurability,
            final float miningSpeed,
            final float attackDamage,
            final int enchantability,
            final Supplier<Ingredient> repairIngredient
    ) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
