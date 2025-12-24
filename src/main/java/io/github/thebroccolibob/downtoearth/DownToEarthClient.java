package io.github.thebroccolibob.downtoearth;

import io.github.thebroccolibob.downtoearth.block.entity.client.HammerableItemBlockEntityRenderer;
import io.github.thebroccolibob.downtoearth.entity.client.FlintToolProjectileRenderer;
import io.github.thebroccolibob.downtoearth.registry.ModBlockEntities;
import io.github.thebroccolibob.downtoearth.registry.ModBlocks;
import io.github.thebroccolibob.downtoearth.registry.ModEntities;
import io.github.thebroccolibob.downtoearth.registry.ModScreens;
import io.github.thebroccolibob.downtoearth.screen.CarvingScreen;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class DownToEarthClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.FLINT_TOOL, FlintToolProjectileRenderer::new);

        BlockEntityRendererFactories.register(ModBlockEntities.HAMMERABLE_ITEM, HammerableItemBlockEntityRenderer::new);

        HandledScreens.register(ModScreens.CARVING, CarvingScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TIN_GRATE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TIN_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TIN_TRAPDOOR, RenderLayer.getCutout());
    }
}
