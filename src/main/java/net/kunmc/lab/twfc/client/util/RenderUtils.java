package net.kunmc.lab.twfc.client.util;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.NativeImage;
import net.minecraft.client.shader.Framebuffer;

public class RenderUtils {
    public static DynamicTexture takeScreen(Framebuffer fb) {
        NativeImage nativeimage = new NativeImage(fb.width, fb.height, false);
        RenderSystem.bindTexture(fb.getColorTextureId());
        ctDownloadTexture(nativeimage, 0, true);
        //  nativeimage.downloadTexture(0, true);
        nativeimage.flipY();
        return new DynamicTexture(nativeimage);
    }

    private static void ctDownloadTexture(NativeImage nativeimage, int num, boolean flag) {
        RenderSystem.assertThread(RenderSystem::isOnRenderThread);
        nativeimage.checkAllocated();
        nativeimage.format().setPackPixelStoreState();
        GlStateManager._getTexImage(3553, num, nativeimage.format().glFormat(), 5121, nativeimage.pixels);
        if (flag && nativeimage.format().hasAlpha()) {
            for (int i = 0; i < nativeimage.getHeight(); ++i) {
                for (int j = 0; j < nativeimage.getWidth(); ++j) {
                    nativeimage.setPixelRGBA(j, i, nativeimage.getPixelRGBA(j, i) | 255 << nativeimage.format().alphaOffset());
                }
            }
        }

    }
}
