package io.github.thebroccolibob.downtoearth.block.entity;

import archives.tater.rpgskills.data.LockGroup;
import io.github.thebroccolibob.bobsmobgear.registry.BobsMobGearComponents;
import io.github.thebroccolibob.bobsmobgear.registry.BobsMobGearSounds;
import io.github.thebroccolibob.downtoearth.DownToEarthCompat;
import io.github.thebroccolibob.downtoearth.registry.ModBlockEntities;
import io.github.thebroccolibob.downtoearth.registry.ModItemTags;
import io.github.thebroccolibob.downtoearth.registry.ModRecipes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Unit;
import net.minecraft.util.math.BlockPos;

import org.jetbrains.annotations.Nullable;

import static java.util.Objects.requireNonNullElse;

public class HammerableItemBlockEntity extends BlockEntity {

    private ItemStack item = ItemStack.EMPTY;
    private int hammerHits = 0;

    private static final String ITEM_NBT = "item";
    private static final String HAMMER_NBT = "hammer_hits";

    private static final int REQUIRED_HAMMER_HITS = 5;

    public HammerableItemBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.HAMMERABLE_ITEM, pos, state);
    }

    public ItemStack getItem() {
        return item;
    }

    public void setItem(@Nullable ItemStack item) {
        this.item = requireNonNullElse(item, ItemStack.EMPTY);
        updateListeners();
    }

    public boolean onHammered(PlayerEntity user) {
        if (!getItem().contains(BobsMobGearComponents.HEATED)) return false;

        var world = getWorld();
        if (world == null) return false;

        var input = new SingleStackRecipeInput(getItem());
        var recipe = world.getRecipeManager().getFirstMatch(ModRecipes.HAMMERING_TYPE, input, world);
        if (recipe.isEmpty()) return false;
        if (DownToEarthCompat.RPGSKILLS_INSTALLED) {
            var lockGroup = LockGroup.findLocked(user, recipe.get());
            if (lockGroup != null) {
                user.sendMessage(lockGroup.recipeMessage(), true);
                return false;
            }
        }

        var pos = getPos();
        world.playSound(user, pos, BobsMobGearSounds.TEMPLATE_HAMMER, user.getSoundCategory());
        if (world instanceof ServerWorld serverWorld) {
            var shape = getCachedState().getOutlineShape(world, pos).getBoundingBox();
            var center = shape.getCenter();
            serverWorld.spawnParticles(
                    getItem().isIn(ModItemTags.SOUL_FLAME_HAMMERED)
                        ? ParticleTypes.SOUL_FIRE_FLAME
                        : ParticleTypes.SMALL_FLAME,
                    pos.getX() + center.x,
                    pos.getY() + center.y,
                    pos.getZ() + center.z,
                    16,
                    shape.getLengthX() / 4,
                    shape.getLengthY() / 4,
                    shape.getLengthZ() / 4,
                    0.025
            );
        }

        if (++hammerHits >= REQUIRED_HAMMER_HITS) {
            var result = recipe.get().value().craft(input, world.getRegistryManager());
            result.set(BobsMobGearComponents.HEATED, Unit.INSTANCE);

            result.onCraftByPlayer(world, user, result.getCount());
            setItem(result);
            updateListeners();
            return true;
        }

        markDirty();
        return true;
    }

    private void updateListeners() {
        markDirty();
        if (getWorld() != null)
            getWorld().updateListeners(getPos(), getCachedState(), getCachedState(), Block.NOTIFY_ALL);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

    @Override
    public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    protected void writeNbt(NbtCompound nbt, WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);

        if (!getItem().isEmpty())
            nbt.put(ITEM_NBT, getItem().encode(registryLookup));

        nbt.putInt(HAMMER_NBT, hammerHits);
    }

    @Override
    protected void readNbt(NbtCompound nbt, WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);

        if (nbt.contains(ITEM_NBT))
            setItem(ItemStack.fromNbtOrEmpty(registryLookup, nbt.getCompound(ITEM_NBT)));
        else
            setItem(null);

        hammerHits = nbt.getInt(HAMMER_NBT);
    }

}
