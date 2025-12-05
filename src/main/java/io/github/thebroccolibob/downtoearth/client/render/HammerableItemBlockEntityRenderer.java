package io.github.thebroccolibob.downtoearth.client.render;

import io.github.thebroccolibob.downtoearth.block.entity.HammerableItemBlockEntity;

import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;

public class HammerableItemBlockEntityRenderer implements BlockEntityRenderer<HammerableItemBlockEntity> {

    private final ItemRenderer itemRenderer;

    public HammerableItemBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(HammerableItemBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();

        matrices.translate(1.0 / 2, 0, 1.0 / 2);
        matrices.scale(2f / 3, 2f / 3, 2f / 3);
        matrices.translate(0, 1.0 / 32, 0);
        matrices.multiply(entity.getCachedState().get(HorizontalFacingBlock.FACING).getRotationQuaternion());
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-45));

        itemRenderer.renderItem(entity.getItem(), ModelTransformationMode.FIXED, light, overlay, matrices, vertexConsumers, entity.getWorld(), 0);

        matrices.pop();
    }

}
