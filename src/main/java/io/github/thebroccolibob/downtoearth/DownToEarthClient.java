package io.github.thebroccolibob.downtoearth;

import io.github.thebroccolibob.bobsmobgear.BobsMobGearClient;
import io.github.thebroccolibob.bobsmobgear.client.BobsMobGearParticleFactoryKt;
import io.github.thebroccolibob.bobsmobgear.registry.BobsMobGearBlocks;
import io.github.thebroccolibob.downtoearth.block.entity.client.HammerableItemBlockEntityRenderer;
import io.github.thebroccolibob.downtoearth.entity.client.FlintToolProjectileRenderer;
import io.github.thebroccolibob.downtoearth.registry.*;
import io.github.thebroccolibob.downtoearth.screen.CarvingScreen;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
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
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CERAMIC_HELMET_MOLD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CERAMIC_CHESTPLATE_MOLD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CERAMIC_LEGGINGS_MOLD, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CERAMIC_BOOTS_MOLD, RenderLayer.getCutout());

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.COPPER, new SimpleFluidRenderHandler(
                BobsMobGearClient.INSTANCE.getLIQUID_METAL_TEXTURE(),
                BobsMobGearClient.INSTANCE.getLIQUID_METAL_TEXTURE(),
                ModFluids.COPPER.getTint()
        ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.TIN, new SimpleFluidRenderHandler(
                BobsMobGearClient.INSTANCE.getLIQUID_METAL_TEXTURE(),
                BobsMobGearClient.INSTANCE.getLIQUID_METAL_TEXTURE(),
                ModFluids.TIN.getTint()
        ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.BRONZE, new SimpleFluidRenderHandler(
                BobsMobGearClient.INSTANCE.getLIQUID_METAL_TEXTURE(),
                BobsMobGearClient.INSTANCE.getLIQUID_METAL_TEXTURE(),
                ModFluids.BRONZE.getTint()
        ));

        BobsMobGearParticleFactoryKt.registerDrips(ModFluids.COPPER_DRIPS, ModFluids.COPPER);
        BobsMobGearParticleFactoryKt.registerDrips(ModFluids.TIN_DRIPS, ModFluids.TIN);
        BobsMobGearParticleFactoryKt.registerDrips(ModFluids.BRONZE_DRIPS, ModFluids.BRONZE);
    }
}
