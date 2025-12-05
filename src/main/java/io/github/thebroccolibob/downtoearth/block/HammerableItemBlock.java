package io.github.thebroccolibob.downtoearth.block;

import io.github.thebroccolibob.downtoearth.block.entity.HammerableItemBlockEntity;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class HammerableItemBlock extends HorizontalFacingBlock implements BlockEntityProvider {

    public static final VoxelShape SHAPE = createCuboidShape(0, 0, 0, 16, 1, 16);

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
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
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
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new HammerableItemBlockEntity(pos, state);
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }
}
