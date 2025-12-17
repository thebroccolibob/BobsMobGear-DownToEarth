package io.github.thebroccolibob.downtoearth;

import archives.tater.rpgskills.client.render.CrossedArrowRenderer;
import archives.tater.rpgskills.data.LockGroup;
import archives.tater.rpgskills.networking.UiActionBlockedPayload;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.server.network.ServerPlayerEntity;

public class DownToEarthCompat {
    public static final boolean RPGSKILLS_INSTALLED = FabricLoader.getInstance().isModLoaded("rpgskills");

    public static boolean checkLocked(PlayerEntity player, RecipeEntry<?> recipe) {
        if (!RPGSKILLS_INSTALLED) return false;

        var lockGroup = LockGroup.findLocked(player, recipe);
        if (lockGroup == null) return false;

        if (player instanceof ServerPlayerEntity serverPlayer)
            ServerPlayNetworking.send(serverPlayer, new UiActionBlockedPayload(lockGroup));

        return true;
    }

    public static void renderCross(DrawContext context, HandledScreen<?> screen, int x, int y, int mouseX, int mouseY, PlayerEntity player) {
        if (DownToEarthCompat.RPGSKILLS_INSTALLED)
            CrossedArrowRenderer.renderTooltip(context,
                    screen,
                    x + 92,
                    y + 31,
                    28,
                    21,
                    mouseX,
                    mouseY,
                    LockGroup::recipeMessage,
                    player
            );
    }
}
