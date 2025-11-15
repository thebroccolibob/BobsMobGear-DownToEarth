package io.github.thebroccolibob.downtoearth.screen;

import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.util.math.BlockPos;

public record CarvingScreenData(ItemStack plank, BlockPos pos) {
    public static final PacketCodec<RegistryByteBuf, CarvingScreenData> CODEC =
            PacketCodec.tuple(
                    ItemStack.PACKET_CODEC, CarvingScreenData::plank,
                    BlockPos.PACKET_CODEC, CarvingScreenData::pos,

                    CarvingScreenData::new
            );
}
