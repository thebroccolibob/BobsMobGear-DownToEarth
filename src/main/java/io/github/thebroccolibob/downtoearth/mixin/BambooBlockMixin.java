package io.github.thebroccolibob.downtoearth.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import io.github.thebroccolibob.downtoearth.registry.ModItems;
import net.minecraft.block.BambooBlock;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;

@Mixin(BambooBlock.class)
public class BambooBlockMixin {
    @WrapOperation(
            method = "calcBlockBreakingDelta",
            constant = @Constant(classValue = SwordItem.class)
    )
    private boolean flintToolInstantBreaks(Object obj, Operation<Boolean> original) {
        boolean isSword = original.call(obj);
        if (isSword) return true;

        if (obj instanceof Item item) {
            return item == ModItems.FLINT_TOOL;
        }

        return false;
    }
}
