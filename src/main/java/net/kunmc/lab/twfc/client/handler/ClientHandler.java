package net.kunmc.lab.twfc.client.handler;

import net.kunmc.lab.twfc.client.screen.TestScreen;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ClientHandler {
    private static final Minecraft mc = Minecraft.getInstance();

    @SubscribeEvent
    public static void onKey(InputEvent.KeyInputEvent e) {
        if (e.getKey() == mc.options.keySprint.getKey().getValue()) {
            mc.setScreen(new TestScreen());
        }
    }
}
