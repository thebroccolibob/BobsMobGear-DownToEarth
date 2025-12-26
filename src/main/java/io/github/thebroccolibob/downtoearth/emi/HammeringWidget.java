package io.github.thebroccolibob.downtoearth.emi;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;

import io.github.thebroccolibob.downtoearth.block.entity.client.HammerableItemBlockEntityRenderer;

public class HammeringWidget extends BlockWidget {

    private final ItemStack stack;

    private static final BlockState STATE = Blocks.ANVIL.getDefaultState();

    public HammeringWidget(ItemStack stack, int x, int y, int width) {
        super(STATE, x, y, width);
        this.stack = stack;
    }

    @Override
    protected void renderBlock(MatrixStack matrices, VertexConsumerProvider vertexConsumers) {
        super.renderBlock(matrices, vertexConsumers);
        matrices.push();
        matrices.translate(0f, 1f, 0f);
        HammerableItemBlockEntityRenderer.renderItem(
                stack,
                Direction.NORTH,
                MinecraftClient.getInstance().world,
                LightmapTextureManager.MAX_LIGHT_COORDINATE,
                OverlayTexture.DEFAULT_UV,
                matrices,
                vertexConsumers,
                MinecraftClient.getInstance().getItemRenderer()
        );
        matrices.pop();
    }

}
