package io.github.thebroccolibob.downtoearth.condition;

import com.mojang.serialization.MapCodec;
import io.github.thebroccolibob.downtoearth.DownToEarth;
import io.github.thebroccolibob.downtoearth.registry.ModItems;
import io.github.thebroccolibob.downtoearth.registry.ModLootConditions;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.LootConditionType;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;

public record IsFlintToolCondition() implements LootCondition {
    public static final MapCodec<IsFlintToolCondition> CODEC =
            MapCodec.unit(new IsFlintToolCondition());

    @Override public LootConditionType getType() { return ModLootConditions.NO_SILK_OR_SHEARS; }

    @Override
    public boolean test(LootContext ctx) {
        ItemStack tool = ctx.get(LootContextParameters.TOOL);
       if (tool == null) return false;

       return (tool.isOf(ModItems.FLINT_TOOL));
    }

    public static LootCondition.Builder builder() {
        return IsFlintToolCondition::new;
    }
}
