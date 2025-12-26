package io.github.thebroccolibob.downtoearth.block.entity.client;

import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;

import io.github.thebroccolibob.downtoearth.block.entity.HammerableItemBlockEntity;
import org.jetbrains.annotations.Nullable;

public class HammerableItemBlockEntityRenderer implements BlockEntityRenderer<HammerableItemBlockEntity> {

    private final ItemRenderer itemRenderer;

    public HammerableItemBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        itemRenderer = context.getItemRenderer();
    }

    public static void renderItem(ItemStack stack, Direction facing, @Nullable World world, int light, int overlay, MatrixStack matrices, VertexConsumerProvider vertexConsumers, ItemRenderer itemRenderer) {
        matrices.push();

        matrices.translate(1.0 / 2, 0.0001, 1.0 / 2);
        matrices.scale(2f / 3, 2f / 3, 2f / 3);
        matrices.translate(0, 1.0 / 32, 0);
        matrices.multiply(facing.getRotationQuaternion());
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-45));

        itemRenderer.renderItem(stack, ModelTransformationMode.FIXED, light, overlay, matrices, vertexConsumers, world, 0);

        matrices.pop();
    }

    @Override
    public void render(HammerableItemBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        renderItem(entity.getItem(), entity.getCachedState().get(HorizontalFacingBlock.FACING), entity.getWorld(), light, overlay, matrices, vertexConsumers, itemRenderer);
    }

}
