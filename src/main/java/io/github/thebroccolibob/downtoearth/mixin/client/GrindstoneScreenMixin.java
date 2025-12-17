package io.github.thebroccolibob.downtoearth.mixin.client;

import io.github.thebroccolibob.downtoearth.DownToEarthCompat;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.GrindstoneScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.GrindstoneScreenHandler;
import net.minecraft.text.Text;

@Mixin(GrindstoneScreen.class)
public abstract class GrindstoneScreenMixin extends HandledScreen<GrindstoneScreenHandler> {
    private PlayerEntity player;

    public GrindstoneScreenMixin(GrindstoneScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Inject(
            method = "<init>",
            at = @At("TAIL")
    )
    private void savePlayer(GrindstoneScreenHandler handler, PlayerInventory inventory, Text title, CallbackInfo ci) {
        player = inventory.player;
    }

    @Inject(
            method = "render",
            at = @At("TAIL")
    )
    private void renderCross(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        DownToEarthCompat.renderCross(context, this, x, y, mouseX, mouseY, player);
    }
}
