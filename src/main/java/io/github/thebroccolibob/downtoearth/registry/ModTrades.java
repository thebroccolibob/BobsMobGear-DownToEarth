package io.github.thebroccolibob.downtoearth.registry;

import io.github.thebroccolibob.downtoearth.DownToEarth;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class ModTrades {

    public static void registerModTrades() {
        DownToEarth.LOGGER.info("These Trades are " + DownToEarth.MOD_ID + "!");

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 3, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 27),
                    new ItemStack(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE, 1),
                    4,
                    15,
                    0.05f
            )));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 3, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 27),
                    new ItemStack(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE, 1),
                    4,
                    15,
                    0.05f
            )));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 3, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 27),
                    new ItemStack(ModItems.DIAMOND_UPGRADE_SMITHING_TEMPLATE, 1),
                    4,
                    15,
                    0.05f
            )));
        });
    }
}
