package io.github.thebroccolibob.downtoearth.condition;

import com.mojang.serialization.MapCodec;
import io.github.thebroccolibob.downtoearth.registry.ModLootConditions;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.LootConditionType;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;

public record HasSilkTouch() implements LootCondition {
    public static final MapCodec<NoSilkOrShearsCondition> CODEC =
            MapCodec.unit(new NoSilkOrShearsCondition());

    @Override public LootConditionType getType() { return ModLootConditions.HAS_SILK_TOUCH; }

    @Override
    public boolean test(LootContext ctx) {
        ItemStack tool = ctx.get(LootContextParameters.TOOL);
        if (tool == null) return false;
        ItemEnchantmentsComponent enchant = tool.get(DataComponentTypes.ENCHANTMENTS);
        if (enchant == null) return false;

        RegistryEntry<Enchantment> silk = ctx.getWorld().getRegistryManager()
                .getWrapperOrThrow(RegistryKeys.ENCHANTMENT)
                .getOrThrow(Enchantments.SILK_TOUCH);

        return enchant.getLevel(silk) >= 1;
    }

    public static LootCondition.Builder builder() {
        return HasSilkTouch::new;
    }
}
