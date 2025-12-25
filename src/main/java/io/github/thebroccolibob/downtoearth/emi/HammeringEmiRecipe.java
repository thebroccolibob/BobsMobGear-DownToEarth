package io.github.thebroccolibob.downtoearth.emi;

import net.minecraft.util.Identifier;

import dev.emi.emi.api.recipe.BasicEmiRecipe;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import io.github.thebroccolibob.bobsmobgear.registry.BobsMobGearItemTags;
import io.github.thebroccolibob.bobsmobgear.registry.BobsMobGearItems;

public class HammeringEmiRecipe extends BasicEmiRecipe {
    private final EmiIngredient ingredient;
    private final EmiStack result;
    private final EmiIngredient hammer;
    private static final EmiStack TONGS = EmiStack.of(BobsMobGearItems.SMITHING_TONGS);

    public HammeringEmiRecipe(Identifier id, EmiIngredient ingredient, EmiStack result) {
        super(DownToEarthEmiPlugin.HAMMERING, id, 92, 74);
        this.ingredient = ingredient;
        this.result = result;
        inputs.add(ingredient);
        hammer = EmiIngredient.of(BobsMobGearItemTags.HAMMERS);
        catalysts.add(hammer);
        catalysts.add(TONGS);
        outputs.add(result);
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.add(new HammeringWidget(ingredient.getEmiStacks().getFirst().getItemStack(), 22, 22, 48));
        widgets.addSlot(ingredient, 4, 28);
        widgets.addSlot(TONGS, 4, 46)
                .catalyst(true);
        widgets.addSlot(hammer, 37, 4)
                .catalyst(true);
        widgets.addSlot(result, 70, 33)
                .recipeContext(this);
    }
}
