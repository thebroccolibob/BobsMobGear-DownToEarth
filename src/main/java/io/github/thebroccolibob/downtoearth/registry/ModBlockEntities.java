package io.github.thebroccolibob.downtoearth.registry;

import io.github.thebroccolibob.downtoearth.DownToEarth;
import io.github.thebroccolibob.downtoearth.block.entity.HammerableItemBlockEntity;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.BlockEntityType.BlockEntityFactory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static final BlockEntityType<HammerableItemBlockEntity> HAMMERABLE_ITEM =
            registerBlockEntity("hammerable_item", HammerableItemBlockEntity::new, ModBlocks.HAMMERABLE_ITEM);

    private static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String name, BlockEntityFactory<T> factory, Block... blocks) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(DownToEarth.MOD_ID, name), BlockEntityType.Builder.create(factory, blocks).build());
    }

    public static void registerModBlockEntities() {

    }

}
