package io.github.thebroccolibob.downtoearth;

import io.github.thebroccolibob.downtoearth.entity.client.FlintToolProjectileRenderer;
import io.github.thebroccolibob.downtoearth.registry.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class DownToEarthClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.FLINT_TOOL, FlintToolProjectileRenderer::new);
    }
}
