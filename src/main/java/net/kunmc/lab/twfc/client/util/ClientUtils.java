package net.kunmc.lab.twfc.client.util;

import net.minecraft.client.Minecraft;

import java.util.concurrent.CompletableFuture;

public class ClientUtils {
    private static final Minecraft mc = Minecraft.getInstance();

    public static void deferTask(Runnable taskIn) {
        CompletableFuture.supplyAsync(() -> {
            taskIn.run();
            return null;
        }, mc);
    }
}
