package net.nikkune.nylle;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.nikkune.nylle.block.ModBlocks;
import net.nikkune.nylle.item.ModCreativeModeTab;
import net.nikkune.nylle.item.ModItems;
import org.slf4j.Logger;

@Mod(Nylle.MOD_ID)
public class Nylle {
    public static final String MOD_ID = "nylle";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Nylle() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == ModCreativeModeTab.NYLLE_TAB) {
            event.accept(ModItems.WRENCH);

            event.accept(ModItems.RAW_TIN);
            event.accept(ModItems.RAW_LEAD);
            event.accept(ModItems.RAW_SILVER);
            event.accept(ModItems.RAW_PLATINUM);
            event.accept(ModItems.RAW_IRIDIUM);
            event.accept(ModItems.RAW_OSMIUM);
            event.accept(ModItems.RAW_TUNGSTEN);

            event.accept(ModItems.TIN_INGOT);
            event.accept(ModItems.LEAD_INGOT);
            event.accept(ModItems.SILVER_INGOT);
            event.accept(ModItems.PLATINUM_INGOT);
            event.accept(ModItems.IRIDIUM_INGOT);
            event.accept(ModItems.OSMIUM_INGOT);
            event.accept(ModItems.TUNGSTEN_INGOT);

            event.accept(ModBlocks.TIN_BLOCK);
            event.accept(ModBlocks.LEAD_BLOCK);
            event.accept(ModBlocks.SILVER_BLOCK);
            event.accept(ModBlocks.PLATINUM_BLOCK);
            event.accept(ModBlocks.IRIDIUM_BLOCK);
            event.accept(ModBlocks.OSMIUM_BLOCK);
            event.accept(ModBlocks.TUNGSTEN_BLOCK);

            event.accept(ModBlocks.TIN_ORE);
            event.accept(ModBlocks.LEAD_ORE);
            event.accept(ModBlocks.SILVER_ORE);
            event.accept(ModBlocks.PLATINUM_ORE);
            event.accept(ModBlocks.IRIDIUM_ORE);
            event.accept(ModBlocks.OSMIUM_ORE);
            event.accept(ModBlocks.TUNGSTEN_ORE);

            event.accept(ModBlocks.DEEPSLATE_TIN_ORE);
            event.accept(ModBlocks.DEEPSLATE_LEAD_ORE);
            event.accept(ModBlocks.DEEPSLATE_SILVER_ORE);
            event.accept(ModBlocks.DEEPSLATE_PLATINUM_ORE);
            event.accept(ModBlocks.DEEPSLATE_IRIDIUM_ORE);
            event.accept(ModBlocks.DEEPSLATE_OSMIUM_ORE);
            event.accept(ModBlocks.DEEPSLATE_TUNGSTEN_ORE);
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
