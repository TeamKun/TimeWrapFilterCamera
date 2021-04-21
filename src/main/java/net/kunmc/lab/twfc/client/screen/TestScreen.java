package net.kunmc.lab.twfc.client.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.TranslationTextComponent;

public class TestScreen extends Screen {
    public TestScreen() {
        super(new TranslationTextComponent("ikisugi"));
    }

    @Override
    public void render(MatrixStack matrixStack, int mx, int my, float pt) {
        super.render(matrixStack, mx, my, pt);
        // .getTextureManager().bind(new ResourceLocation("textures/gui/container/beacon.png"));

        //   RenderSystem.clear(0, false);
        RenderSystem.bindTexture(Minecraft.getInstance().getMainRenderTarget().getColorTextureId());
        blit(matrixStack, mx, my, 100, 100, 100, 100);
    }
}
