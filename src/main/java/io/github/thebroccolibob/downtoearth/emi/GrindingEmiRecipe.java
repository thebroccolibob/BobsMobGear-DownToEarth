package io.github.thebroccolibob.downtoearth.emi;

import net.minecraft.util.Identifier;

import dev.emi.emi.api.recipe.BasicEmiRecipe;
import dev.emi.emi.api.recipe.VanillaEmiRecipeCategories;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;

public class GrindingEmiRecipe extends BasicEmiRecipe {
    private final EmiIngredient ingredient;
    private final EmiIngredient reference;
    private final EmiStack output;

    private static final Identifier BACKGROUND = Identifier.ofVanilla("textures/gui/container/grindstone.png");

    public GrindingEmiRecipe(Identifier id, EmiIngredient ingredient, EmiIngredient reference, EmiStack output) {
        super(VanillaEmiRecipeCategories.GRINDING, id, 116, 56);
        this.ingredient = ingredient;
        this.reference = reference;
        this.output = output;
        inputs.add(ingredient);
        if (!reference.isEmpty())
            catalysts.add(reference);
        outputs.add(output);
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addTexture(BACKGROUND, 0, 0, 116, 56, 30, 15);

        widgets.addSlot(ingredient, 18, 3)
                .drawBack(false);
        if (!reference.isEmpty())
            widgets.addSlot(reference, 18, 24)
                    .drawBack(false)
                    .catalyst(true);
        widgets.addSlot(output, 98, 18)
                .drawBack(false)
                .recipeContext(this);
    }
}
