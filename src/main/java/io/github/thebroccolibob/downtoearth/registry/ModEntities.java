package io.github.thebroccolibob.downtoearth.registry;

import io.github.thebroccolibob.downtoearth.DownToEarth;
import io.github.thebroccolibob.downtoearth.entity.item.FlintToolProjectileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<FlintToolProjectileEntity> FLINT_TOOL = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(DownToEarth.MOD_ID, "flint_tool"),
            EntityType.Builder.<FlintToolProjectileEntity>create(FlintToolProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.5f)
                    .build());

    public static void registerModEntities() {
        DownToEarth.LOGGER.info("These Entities are " + DownToEarth.MOD_ID + "!");
    }
}
