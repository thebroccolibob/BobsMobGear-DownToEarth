package io.github.thebroccolibob.downtoearth.emi;

import net.minecraft.util.Identifier;

import dev.emi.emi.api.recipe.BasicEmiRecipe;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import io.github.thebroccolibob.downtoearth.registry.ModItems;

public class CarvingEmiRecipe extends BasicEmiRecipe {
    private final EmiIngredient input;
    private final EmiStack output;

    private static final EmiStack TOOL = EmiStack.of(ModItems.FLINT_TOOL.getDefaultStack());

    public CarvingEmiRecipe(Identifier id, EmiIngredient input, EmiStack output) {
        super(DownToEarthEmiPlugin.CARVING, id, 76, 36);
        this.input = input;
        this.output = output;
        inputs.add(input);
        catalysts.add(TOOL);
        outputs.add(output);
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addTexture(EmiTexture.EMPTY_ARROW, 26, 19);
        widgets.addSlot(input, 0, 18);
        widgets.addSlot(TOOL, 29, 0)
                .catalyst(true);
        widgets.addSlot(output, 58, 18).recipeContext(this);
    }
}
