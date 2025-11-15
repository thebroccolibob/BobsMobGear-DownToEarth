package io.github.thebroccolibob.downtoearth.registry;

import io.github.thebroccolibob.downtoearth.DownToEarth;
import io.github.thebroccolibob.downtoearth.screen.CarvingScreenData;
import io.github.thebroccolibob.downtoearth.screen.CarvingScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;

public class ModScreens {
    public static final ScreenHandlerType<CarvingScreenHandler> CARVING =
            Registry.register(Registries.SCREEN_HANDLER,
                    DownToEarth.MOD_ID,
                    new ExtendedScreenHandlerType<>(CarvingScreenHandler::new, CarvingScreenData.CODEC));

    public static void registerModScreens() {
        DownToEarth.LOGGER.info("These Screens are " + DownToEarth.MOD_ID + "!");
    }
}
