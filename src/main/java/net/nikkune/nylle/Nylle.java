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
            event.accept(ModBlocks.SILVER_ORE);
            event.accept(ModBlocks.DEEPSLATE_SILVER_ORE);
            event.accept(ModBlocks.SILVER_BLOCK);
            event.accept(ModItems.RAW_SILVER);
            event.accept(ModItems.SILVER_INGOT);
            event.accept(ModBlocks.TIN_ORE);
            event.accept(ModBlocks.DEEPSLATE_TIN_ORE);
            event.accept(ModBlocks.TIN_BLOCK);
            event.accept(ModItems.RAW_TIN);
            event.accept(ModItems.TIN_INGOT);
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
