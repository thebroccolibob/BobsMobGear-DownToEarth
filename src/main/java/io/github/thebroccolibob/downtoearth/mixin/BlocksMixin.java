package io.github.thebroccolibob.downtoearth.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Blocks.class)
public class BlocksMixin {
    @ModifyArg(
            method = "createLogBlock(Lnet/minecraft/block/MapColor;Lnet/minecraft/block/MapColor;)Lnet/minecraft/block/Block;",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/PillarBlock;<init>(Lnet/minecraft/block/AbstractBlock$Settings;)V"
            ),
            index = 0
    )
    private static AbstractBlock.Settings LogsRequireTool1(AbstractBlock.Settings settings) {
       return settings.requiresTool();
    }

    @ModifyArg(
            method = "createLogBlock(Lnet/minecraft/block/MapColor;Lnet/minecraft/block/MapColor;Lnet/minecraft/sound/BlockSoundGroup;)Lnet/minecraft/block/Block;",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/PillarBlock;<init>(Lnet/minecraft/block/AbstractBlock$Settings;)V"
            ),
            index = 0
    )
    private static AbstractBlock.Settings LogsRequireTool2(AbstractBlock.Settings settings) {
        return settings.requiresTool();
    }

    @ModifyArg(
            method = "createNetherStemBlock",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/PillarBlock;<init>(Lnet/minecraft/block/AbstractBlock$Settings;)V"
            ),
            index = 0
    )
    private static AbstractBlock.Settings NetherStemsRequireTool(AbstractBlock.Settings settings) {
        return settings.requiresTool();
    }
}
