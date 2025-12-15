package io.github.thebroccolibob.downtoearth.mixin.client;

import archives.tater.rpgskills.client.render.CrossedArrowRenderer;
import archives.tater.rpgskills.data.LockGroup;
import io.github.thebroccolibob.downtoearth.DownToEarth;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.GrindstoneScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.GrindstoneScreenHandler;
import net.minecraft.text.Text;

@Mixin(GrindstoneScreen.class)
public abstract class GrindstoneScreenMixin extends HandledScreen<GrindstoneScreenHandler> {
    public GrindstoneScreenMixin(GrindstoneScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Inject(
            method = "render",
            at = @At("TAIL")
    )
    private void renderCross(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        if (DownToEarth.RPGSKILLS_INSTALLED)
            CrossedArrowRenderer.renderTooltip(context,
                    this,
                    x + 92,
                    y + 31,
                    28,
                    21,
                    mouseX,
                    mouseY,
                    LockGroup::recipeMessage
            );
    }
}
