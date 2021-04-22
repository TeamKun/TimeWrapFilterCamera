package net.kunmc.lab.twfc.client.handler;

import net.minecraft.client.Minecraft;

public class ClientHandler {
    private static final Minecraft mc = Minecraft.getInstance();
    public static boolean renderGUIed;
/*
    @SubscribeEvent
    public static void onKey(InputEvent.KeyInputEvent e) {
        if (e.getKey() == mc.options.keySprint.getKey().getValue()) {
            mc.setScreen(new TestScreen());
        }
    }*/
}
