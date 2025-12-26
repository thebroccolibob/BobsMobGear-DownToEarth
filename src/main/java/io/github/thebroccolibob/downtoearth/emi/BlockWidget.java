package io.github.thebroccolibob.downtoearth.emi;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;

import dev.emi.emi.api.widget.Bounds;
import dev.emi.emi.api.widget.Widget;

// Because for some reason BMG's breaks only when it is a dependency in a dev environment
class BlockWidget extends Widget {
    private final BlockState state;
    private final int x;
    private final int y;
    private final int width;

    public BlockWidget(BlockState state, int x, int y, int width) {
        this.state = state;
        this.x = x;
        this.y = y;
        this.width = width;
    }

    @Override
    public void render(DrawContext draw, int mouseX, int mouseY, float delta) {
        var matrices = draw.getMatrices();
        matrices.push();
        matrices.translate(x + width / 2f, y + width / 2f, 0f);
        var scale = width * 0.6f;
        matrices.scale(scale, -scale, scale);
        matrices.translate(0f, 0f, 1f);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(35f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-45f));
        matrices.translate(-0.5f, -0.5f, -0.5f);
        renderBlock(matrices, draw.getVertexConsumers());
        matrices.pop();
    }

    protected void renderBlock(MatrixStack matrices, VertexConsumerProvider vertexConsumers) {
        blockRenderManger.renderBlockAsEntity(state, matrices, vertexConsumers, LightmapTextureManager.MAX_LIGHT_COORDINATE, OverlayTexture.DEFAULT_UV);
    }

    @SuppressWarnings("SuspiciousNameCombination")
    @Override
    public Bounds getBounds() {
        return new Bounds(x, y, width, width);
    }

    private static final BlockRenderManager blockRenderManger = MinecraftClient.getInstance().getBlockRenderManager();
}
