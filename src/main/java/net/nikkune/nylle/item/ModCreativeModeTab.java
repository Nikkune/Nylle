package net.nikkune.nylle.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nikkune.nylle.Nylle;

@Mod.EventBusSubscriber(modid = Nylle.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab {
    public static CreativeModeTab NYLLE_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        NYLLE_TAB = event.registerCreativeModeTab(new ResourceLocation(Nylle.MOD_ID, "nylle_tab"), builder -> builder.icon(() -> new ItemStack(ModItems.WRENCH.get())).title(Component.translatable("tabs.nylle_tab")).build());
    }
}
