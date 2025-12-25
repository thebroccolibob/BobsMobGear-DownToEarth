package io.github.thebroccolibob.downtoearth.emi;

import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import io.github.thebroccolibob.bobsmobgear.registry.BobsMobGearItems;
import io.github.thebroccolibob.downtoearth.DownToEarth;
import io.github.thebroccolibob.downtoearth.registry.ModItems;
import io.github.thebroccolibob.downtoearth.registry.ModRecipes;

public class DownToEarthEmiPlugin implements EmiPlugin {
    public static EmiRecipeCategory CARVING = new EmiRecipeCategory(Identifier.of(DownToEarth.MOD_ID, "carving"), EmiStack.of(ModItems.FLINT_TOOL));
    public static EmiRecipeCategory GRINDING = new EmiRecipeCategory(Identifier.of(DownToEarth.MOD_ID, "grinding"), EmiStack.of(Items.GRINDSTONE));
    public static EmiRecipeCategory HAMMERING = new EmiRecipeCategory(Identifier.of(DownToEarth.MOD_ID, "hammering"), EmiStack.of(BobsMobGearItems.SMITHING_HAMMER));

    @Override
    public void register(EmiRegistry registry) {
        registry.addCategory(CARVING);
        registry.addWorkstation(CARVING, EmiStack.of(ModItems.FLINT_TOOL));

        registry.addCategory(GRINDING);
        registry.addWorkstation(GRINDING, EmiStack.of(Items.GRINDSTONE));

        for (var recipe : registry.getRecipeManager().listAllOfType(ModRecipes.GRINDING_TYPE))
            registry.addRecipe(new GrindingEmiRecipe(
                    recipe.id(),
                    EmiIngredient.of(recipe.value().ingredient()),
                    EmiIngredient.of(recipe.value().reference()),
                    EmiStack.of(recipe.value().result())
            ));

        registry.addCategory(HAMMERING);
        registry.addWorkstation(HAMMERING, EmiIngredient.of(BlockTags.ANVIL));
        registry.addWorkstation(HAMMERING, EmiStack.of(BobsMobGearItems.SMITHING_HAMMER));
    }
}
