package io.github.thebroccolibob.downtoearth.emi;

import net.minecraft.item.BlockItem;
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
        super(DownToEarthEmiPlugin.CARVING, id, 76, 68);
        this.input = input;
        this.output = output;
        inputs.add(input);
        catalysts.add(TOOL);
        outputs.add(output);
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addTexture(EmiTexture.EMPTY_ARROW, 26, 51);
        if (input.getEmiStacks().getFirst().getItemStack().getItem() instanceof BlockItem blockItem)
            widgets.add(new BlockWidget(blockItem.getBlock().getDefaultState(), 22, 18, 32));
        widgets.addSlot(input, 0, 50);
        widgets.addSlot(TOOL, 29, 0)
                .catalyst(true);
        widgets.addSlot(output, 58, 50).recipeContext(this);
    }
}
