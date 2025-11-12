package io.github.thebroccolibob.downtoearth;

import io.github.thebroccolibob.downtoearth.entity.client.FlintToolProjectileModel;
import io.github.thebroccolibob.downtoearth.entity.client.FlintToolProjectileRenderer;
import io.github.thebroccolibob.downtoearth.registry.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class BobsMobGearDownToEarthClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(FlintToolProjectileModel.FLINT_TOOL, FlintToolProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.FLINT_TOOL, FlintToolProjectileRenderer::new);
    }
}
