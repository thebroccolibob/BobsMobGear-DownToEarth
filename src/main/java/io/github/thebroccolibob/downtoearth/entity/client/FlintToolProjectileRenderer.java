package io.github.thebroccolibob.downtoearth.entity.client;

import io.github.thebroccolibob.downtoearth.DownToEarth;
import io.github.thebroccolibob.downtoearth.entity.item.FlintToolProjectileEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class FlintToolProjectileRenderer extends EntityRenderer<FlintToolProjectileEntity> {
    private static final float MIN_DISTANCE = 3.5f * 3.5f;
    private final ItemRenderer itemRenderer;
    private final float scale;

    public FlintToolProjectileRenderer(EntityRendererFactory.Context ctx, float scale, boolean lit) {
        super(ctx);
        this.itemRenderer = ctx.getItemRenderer();
        this.scale = scale;
    }

    public FlintToolProjectileRenderer(EntityRendererFactory.Context context) {
        this(context, 1.0f, false);
    }

    @Override
    public void render(FlintToolProjectileEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        if (entity.age < 2 && dispatcher.camera.getFocusedEntity().squaredDistanceTo(entity) < MIN_DISTANCE) return;

        matrices.push();
        matrices.scale(0.5f * scale, 0.5f * scale, 0.5f * scale);
        matrices.translate(0, -0.1f, 0);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevYaw, entity.getYaw()) - 90.0F));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevPitch, entity.getPitch()) + 90.0F));
        matrices.translate(scale * 0.2, scale * 0.1, 0);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-45));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));

        itemRenderer.renderItem(
                entity.getItemStack(), ModelTransformationMode.NONE, light, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), entity.getId()
        );

        matrices.pop();

        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(FlintToolProjectileEntity entity) {
        return Identifier.of(DownToEarth.MOD_ID, "textures/entity/flint_tool/flint_tool.png");
    }
}
