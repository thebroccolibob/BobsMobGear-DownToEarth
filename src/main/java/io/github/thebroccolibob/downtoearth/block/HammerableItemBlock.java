package io.github.thebroccolibob.downtoearth.block;

import io.github.thebroccolibob.bobsmobgear.registry.*;
import io.github.thebroccolibob.bobsmobgear.util.ComparableItemStack;
import io.github.thebroccolibob.downtoearth.block.entity.HammerableItemBlockEntity;
import io.github.thebroccolibob.downtoearth.registry.ModBlocks;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import static java.util.Objects.requireNonNull;

public class HammerableItemBlock extends HorizontalFacingBlock implements BlockEntityProvider {

    public static final VoxelShape SHAPE_X = createCuboidShape(0, 0, 3, 16, 1, 13);
    public static final VoxelShape SHAPE_Z = createCuboidShape(3, 0, 0, 13, 1, 16);

    public HammerableItemBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING);
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isIn(BlockTags.ANVIL);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        var down = ctx.getWorld().getBlockState(ctx.getBlockPos().down());
        if (down.isIn(BlockTags.ANVIL) && down.contains(FACING))
            return getDefaultState().with(FACING, down.get(FACING));
        return getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing());
    }

    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return canPlaceAt(state, world, pos) ? super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos) : Blocks.AIR.getDefaultState();
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(FACING).getAxis() == Axis.Z ? SHAPE_Z : SHAPE_X;
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.isOf(newState.getBlock())) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof HammerableItemBlockEntity hammerableItemBlockEntity) {
                var posD = pos.toBottomCenterPos();
                ItemScatterer.spawn(world, posD.x, posD.y, posD.z, hammerableItemBlockEntity.getItem());
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.isOf(BobsMobGearItems.SMITHING_TONGS)) {
            if (!stack.getOrDefault(BobsMobGearComponents.TONGS_HELD_ITEM, ComparableItemStack.Companion.getEMPTY()).isEmpty()) return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            if (!(world.getBlockEntity(pos) instanceof HammerableItemBlockEntity blockEntity))
                return ItemActionResult.FAIL;

            stack.set(BobsMobGearComponents.TONGS_HELD_ITEM, new ComparableItemStack(blockEntity.getItem()));
            blockEntity.setItem(null);
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
            world.playSound(player, pos, BobsMobGearSounds.TONGS_PICKUP, SoundCategory.PLAYERS, 1f, 1f);

            return ItemActionResult.SUCCESS;
        }

        if (stack.isIn(BobsMobGearItemTags.SMITHING_HAMMERS)) {
            if (!(world.getBlockEntity(pos) instanceof HammerableItemBlockEntity blockEntity))
                return ItemActionResult.FAIL;

            if (!blockEntity.onHammered(player)) return ItemActionResult.FAIL;

            stack.damage(1, player, LivingEntity.getSlotForHand(hand));
            return ItemActionResult.SUCCESS;
        }

        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new HammerableItemBlockEntity(pos, state);
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }

    public static void registerTongEvent() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            var stack = player.getStackInHand(hand);
            if (!stack.isOf(BobsMobGearItems.SMITHING_TONGS)) return ActionResult.PASS;
            if (stack.getOrDefault(BobsMobGearComponents.TONGS_HELD_ITEM, ComparableItemStack.Companion.getEMPTY()).isEmpty()) return ActionResult.PASS;

            var context = new ItemPlacementContext(world, player, hand, stack, hitResult);
            if (!context.canPlace()) return ActionResult.PASS;

            var pos = context.getBlockPos();
            var state = ModBlocks.HAMMERABLE_ITEM.getPlacementState(context);
            if (state == null) return ActionResult.PASS;
            if (!state.canPlaceAt(world, pos)) return ActionResult.PASS;
            if (!context.getWorld().canPlace(state, pos, ShapeContext.of(player))) return ActionResult.PASS;

            world.setBlockState(pos, state);
            if (!(world.getBlockEntity(pos) instanceof HammerableItemBlockEntity blockEntity)) return ActionResult.FAIL;

            blockEntity.setItem(requireNonNull(stack.set(BobsMobGearComponents.TONGS_HELD_ITEM, ComparableItemStack.Companion.getEMPTY())).getStack());
            world.playSound(player, hitResult.getBlockPos(), BobsMobGearSounds.TONGS_PICKUP, SoundCategory.PLAYERS, 1f, 1f);

            return ActionResult.SUCCESS;
        });
    }
}
