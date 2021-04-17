package net.kunmc.lab.twfc;

import net.kunmc.lab.twfc.client.handler.RenderHandler;
import net.kunmc.lab.twfc.item.TWFCameraItem;
import net.kunmc.lab.twfc.packet.PacketHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TimeWrapFilterCamera.MODID)
public class TimeWrapFilterCamera {
    public static final String MODID = "timewrapfiltercamera";
    public static final Item CAMERA = new TWFCameraItem(new Item.Properties().tab(ItemGroup.TAB_TOOLS)).setRegistryName(MODID, "camera");

    public TimeWrapFilterCamera() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

    }

    private void setup(final FMLCommonSetupEvent event) {
        PacketHandler.init();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(RenderHandler.class);
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryHandler {
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> e) {
            e.getRegistry().register(CAMERA);
        }
    }
}
