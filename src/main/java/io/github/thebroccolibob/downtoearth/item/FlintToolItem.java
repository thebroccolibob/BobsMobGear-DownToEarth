package io.github.thebroccolibob.downtoearth.item;

import io.github.thebroccolibob.downtoearth.entity.item.FlintToolProjectileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class FlintToolItem extends ToolItem {
    public FlintToolItem(ToolMaterial material, Settings settings) {
        super(material, settings.component(DataComponentTypes.TOOL, createToolComponent()));
    }

    private static ToolComponent createToolComponent() {
        return new ToolComponent(
                List.of(ToolComponent.Rule.ofAlwaysDropping(List.of(Blocks.COBWEB), 15.0F), ToolComponent.Rule.of(BlockTags.SWORD_EFFICIENT, 1.5F)), 1.0F, 2
        );
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPEAR;
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity player) {
            int i = this.getMaxUseTime(stack, user) - remainingUseTicks;
            if (i >= 5 && !isAboutToBreak(stack) && !world.isClient) {
                stack.damage(1, player, LivingEntity.getSlotForHand(user.getActiveHand()));

                FlintToolProjectileEntity flintToolEntity = new FlintToolProjectileEntity(world, player, stack);
                flintToolEntity.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 2.5F, 1.0F);

                if (player.isInCreativeMode()) {
                    flintToolEntity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                }

                world.spawnEntity(flintToolEntity);
                world.playSoundFromEntity(null, flintToolEntity, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F);

                if (!player.isInCreativeMode()) {
                    player.getInventory().removeOne(stack);
                }
            }
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (isAboutToBreak(itemStack)) {
            return TypedActionResult.fail(itemStack);
        } else {
            user.setCurrentHand(hand);
            return TypedActionResult.consume(itemStack);
        }
    }

    private static boolean isAboutToBreak(ItemStack stack) {
        return stack.getDamage() >= stack.getMaxDamage() - 1;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) { return true; }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient() && state.getHardness(world, pos) > 0.0F) {
            stack.damage(1, miner, EquipmentSlot.MAINHAND);
        }
        return true;
    }
}
