package io.github.thebroccolibob.downtoearth.emi;

import net.minecraft.util.Identifier;

import dev.emi.emi.api.recipe.BasicEmiRecipe;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import io.github.thebroccolibob.bobsmobgear.registry.BobsMobGearItemTags;

public class HammeringEmiRecipe extends BasicEmiRecipe {
    private final EmiIngredient ingredient;
    private final EmiStack result;
    private final EmiIngredient hammer;

    public HammeringEmiRecipe(Identifier id, EmiIngredient ingredient, EmiStack result) {
        super(DownToEarthEmiPlugin.HAMMERING, id, 92, 74);
        this.ingredient = ingredient;
        this.result = result;
        inputs.add(ingredient);
        hammer = EmiIngredient.of(BobsMobGearItemTags.HAMMERS);
        catalysts.add(hammer);
        outputs.add(result);
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.add(new HammeringWidget(ingredient.getEmiStacks().getFirst().getItemStack(), 22, 22, 48));
        widgets.addSlot(ingredient, 4, 33);
        widgets.addSlot(hammer, 37, 4)
                .catalyst(true);
        widgets.addSlot(result, 70, 33)
                .recipeContext(this);
    }
}
