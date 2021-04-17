package net.kunmc.lab.twfc.client.handler;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.kunmc.lab.twfc.TimeWrapFilterCamera;
import net.kunmc.lab.twfc.client.util.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RenderHandler {
    private static final Minecraft mc = Minecraft.getInstance();
    public static boolean stoped;
    private static ResourceLocation location;

    private static final List<ResourceLocation> locations = new ArrayList<>();

    @SubscribeEvent
    public static void onWorldRender(RenderWorldLastEvent e) {


    }


    @SubscribeEvent
    public static void onRender(TickEvent.RenderTickEvent e) {
   /*      if (stoped && location == null) {
            ResourceLocation ls = new ResourceLocation(TimeWrapFilterCamera.MODID, "test");
            mc.getTextureManager().register(ls, RenderUtils.takeScreen(mc.getMainRenderTarget(), 0, 0, 0, 0));
            location = ls;
        }

        if (location != null) {
            MatrixStack ms = new MatrixStack();
            ms.pushPose();
            mc.getTextureManager().bind(location);
            AbstractGui.blit(ms, 0, 0, 0, 0, mc.getWindow().getGuiScaledWidth(), mc.getWindow().getGuiScaledHeight(), mc.getWindow().getGuiScaledWidth(), mc.getWindow().getGuiScaledHeight());
            ms.popPose();
        }*/
/*
        if (stoped) {
            if (locations.size() <= mc.getWindow().getGuiScaledHeight()) {
                ResourceLocation ls = new ResourceLocation(TimeWrapFilterCamera.MODID, "twf_" + UUID.randomUUID());
                mc.getTextureManager().register(ls, RenderUtils.takeScreen(mc.getMainRenderTarget()));
                locations.add(ls);
            }
        } else {
            locations.forEach(n -> mc.getTextureManager().release(n));
            locations.clear();
        }

        if (!locations.isEmpty()) {
            MatrixStack ms = new MatrixStack();
            ms.pushPose();
            for (int i = 0; i < locations.size(); i++) {
                mc.getTextureManager().bind(locations.get(i));
                AbstractGui.blit(ms, 0, i, 0, i, mc.getWindow().getGuiScaledWidth(), i + 1, mc.getWindow().getGuiScaledWidth(), mc.getWindow().getGuiScaledHeight());
            }
            ms.popPose();
        }
*/

        if (stoped) {
            if (locations.size() <= mc.getWindow().getGuiScaledHeight()) {
                ResourceLocation ls = new ResourceLocation(TimeWrapFilterCamera.MODID, "twf_" + UUID.randomUUID());
                mc.getTextureManager().register(ls, RenderUtils.takeScreen(mc.getMainRenderTarget()));
                locations.add(ls);
            }
        } else {
            locations.forEach(n -> mc.getTextureManager().release(n));
            locations.clear();
        }
        if (!locations.isEmpty()) {
            MatrixStack ms = new MatrixStack();
            ms.pushPose();
            for (int i = 0; i < locations.size(); i++) {
                mc.getTextureManager().bind(locations.get(i));
                AbstractGui.blit(ms, 0, i, 0, i, mc.getWindow().getGuiScaledWidth(), i + 1, mc.getWindow().getGuiScaledWidth(), mc.getWindow().getGuiScaledHeight());
            }
            ms.popPose();
        }
    }


}
