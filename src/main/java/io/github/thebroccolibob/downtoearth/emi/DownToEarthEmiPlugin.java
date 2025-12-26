package io.github.thebroccolibob.downtoearth.emi;

import net.minecraft.client.MinecraftClient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import io.github.thebroccolibob.bobsmobgear.registry.BobsMobGearItems;
import io.github.thebroccolibob.downtoearth.DownToEarth;
import io.github.thebroccolibob.downtoearth.registry.ModRecipes;

public class DownToEarthEmiPlugin implements EmiPlugin {
    private static final Identifier ICONS = Identifier.of(DownToEarth.MOD_ID, "textures/gui/emi/icons.png");
    private static final int ICONS_WIDTH = 32;
    private static final int ICONS_HEIGHT = 16;

    public static EmiRecipeCategory CARVING = new EmiRecipeCategory(
            Identifier.of(DownToEarth.MOD_ID, "carving"),
            CarvingEmiRecipe.TOOL,
            new EmiTexture(ICONS, 0, 0, 16, 16, 16, 16, ICONS_WIDTH, ICONS_HEIGHT)
    );
    public static EmiRecipeCategory HAMMERING = new EmiRecipeCategory(
            Identifier.of(DownToEarth.MOD_ID, "hammering"),
            EmiStack.of(BobsMobGearItems.SMITHING_HAMMER),
            new EmiTexture(ICONS, 16, 0, 16, 16, 16, 16, ICONS_WIDTH, ICONS_HEIGHT)
    );

    @Override
    public void register(EmiRegistry registry) {
        registry.addCategory(CARVING);
        registry.addWorkstation(CARVING, CarvingEmiRecipe.TOOL);
        for (var recipe : registry.getRecipeManager().listAllOfType(ModRecipes.CARVING_TYPE))
            //noinspection DataFlowIssue
            registry.addRecipe(new CarvingEmiRecipe(
                    recipe.id(),
                    EmiIngredient.of(recipe.value().getIngredients().getFirst()),
                    EmiStack.of(recipe.value().getResult(MinecraftClient.getInstance().world.getRegistryManager()))
            ));

        for (var recipe : registry.getRecipeManager().listAllOfType(ModRecipes.GRINDING_TYPE))
            registry.addRecipe(new GrindingEmiRecipe(
                    recipe.id(),
                    EmiIngredient.of(recipe.value().ingredient()),
                    EmiIngredient.of(recipe.value().reference()),
                    EmiStack.of(recipe.value().result())
            ));

        registry.addCategory(HAMMERING);
        registry.addWorkstation(HAMMERING, EmiIngredient.of(BlockTags.ANVIL));
        for (var recipe : registry.getRecipeManager().listAllOfType(ModRecipes.HAMMERING_TYPE))
            //noinspection DataFlowIssue
            registry.addRecipe(new HammeringEmiRecipe(
                    recipe.id(),
                    EmiIngredient.of(recipe.value().getIngredients().getFirst()),
                    EmiStack.of(recipe.value().getResult(MinecraftClient.getInstance().world.getRegistryManager())) // sure hope we're in a world
            ));
    }
}
