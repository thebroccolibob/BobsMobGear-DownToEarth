package io.github.thebroccolibob.downtoearth.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class LeafFiberBaleBlock extends PillarBlock {
    public static final MapCodec<LeafFiberBaleBlock> CODEC = createCodec(LeafFiberBaleBlock::new);

    @Override
    public MapCodec<LeafFiberBaleBlock> getCodec() {
        return CODEC;
    }

    public LeafFiberBaleBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(AXIS, Direction.Axis.Y));
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        entity.handleFallDamage(fallDistance, 0.2F, world.getDamageSources().fall());
    }
}
