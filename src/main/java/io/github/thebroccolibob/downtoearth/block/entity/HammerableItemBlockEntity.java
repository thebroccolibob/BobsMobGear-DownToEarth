package io.github.thebroccolibob.downtoearth.block.entity;

import io.github.thebroccolibob.downtoearth.registry.ModBlockEntities;
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
import net.minecraft.sound.SoundEvents;
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
        // TODO require heated
        var world = getWorld();
        if (world == null) return false;

        var input = new SingleStackRecipeInput(getItem());
        var recipe = world.getRecipeManager().getFirstMatch(ModRecipes.HAMMERING_TYPE, input, world);
        if (recipe.isEmpty()) return false;

        world.playSound(user, getPos(), SoundEvents.BLOCK_ANVIL_USE, user.getSoundCategory()); // TODO hammer sound
        if (world.isClient) {
            var shape = getCachedState().getOutlineShape(world, getPos()).getBoundingBox();
            for (var i = 0; i < 8; i++) {
                world.addParticle(
                        ParticleTypes.SMALL_FLAME,
                        getPos().getX() + shape.minX + world.random.nextFloat() * shape.getLengthX(),
                        getPos().getY() + shape.minY + world.random.nextFloat() * shape.getLengthY(),
                        getPos().getZ() + shape.minZ + world.random.nextFloat() * shape.getLengthZ(),
                        0.1 * world.random.nextDouble() - 0.05,
                        0.05 * world.random.nextDouble(),
                        0.1 * world.random.nextDouble() - 0.05
                );
            }
        }

        if (++hammerHits > REQUIRED_HAMMER_HITS) {
            setItem(recipe.get().value().craft(input, world.getRegistryManager()));
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
