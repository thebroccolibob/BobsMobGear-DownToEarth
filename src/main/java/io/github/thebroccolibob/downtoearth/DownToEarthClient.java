package io.github.thebroccolibob.downtoearth;

import io.github.thebroccolibob.downtoearth.entity.client.FlintToolProjectileRenderer;
import io.github.thebroccolibob.downtoearth.registry.ModEntities;
import io.github.thebroccolibob.downtoearth.registry.ModScreens;
import io.github.thebroccolibob.downtoearth.screen.CarvingScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class DownToEarthClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.FLINT_TOOL, FlintToolProjectileRenderer::new);

        HandledScreens.register(ModScreens.CARVING, CarvingScreen::new);
    }
}
