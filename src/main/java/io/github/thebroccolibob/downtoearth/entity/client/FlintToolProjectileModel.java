package io.github.thebroccolibob.downtoearth.entity.client;

import io.github.thebroccolibob.downtoearth.BobsMobGearDownToEarth;
import io.github.thebroccolibob.downtoearth.entity.item.FlintToolProjectileEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class FlintToolProjectileModel extends EntityModel<FlintToolProjectileEntity> {
    public static final EntityModelLayer FLINT_TOOL = new EntityModelLayer(Identifier.of(BobsMobGearDownToEarth.MOD_ID, "flint_tool"), "main");
    private final ModelPart flintTool;
    public FlintToolProjectileModel(ModelPart root) {
        this.flintTool = root.getChild("parent");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData parent = modelPartData.addChild("parent", ModelPartBuilder.create().uv(28, 28).cuboid(8.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 24).cuboid(7.0F, -1.0F, -1.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
                .uv(16, 16).cuboid(6.0F, -1.0F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 8).cuboid(5.0F, -1.0F, -5.0F, 1.0F, 1.0F, 7.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(3.0F, -1.0F, -6.0F, 2.0F, 1.0F, 7.0F, new Dilation(0.0F))
                .uv(18, 0).cuboid(2.0F, -1.0F, -6.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 16).cuboid(1.0F, -1.0F, -7.0F, 1.0F, 1.0F, 7.0F, new Dilation(0.0F))
                .uv(16, 8).cuboid(0.0F, -1.0F, -8.0F, 1.0F, 1.0F, 7.0F, new Dilation(0.0F))
                .uv(16, 23).cuboid(-1.0F, -1.0F, -9.0F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F))
                .uv(28, 23).cuboid(-2.0F, -1.0F, -9.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 29).cuboid(-3.0F, -1.0F, -9.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 24.0F, -3.0F, -3.1416F, 0.0F, -3.1416F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public void setAngles(FlintToolProjectileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        flintTool.render(matrices, vertexConsumer, light, overlay, color);
    }
}
