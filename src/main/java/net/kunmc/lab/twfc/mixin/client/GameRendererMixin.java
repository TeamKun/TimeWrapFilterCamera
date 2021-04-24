package net.kunmc.lab.twfc.mixin.client;

import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void render(float p_195458_1_, long p_195458_2_, boolean p_195458_4_, CallbackInfo ci) {
        //   GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_LINE);
        //     GL11.glDisable(GL11.GL_TEXTURE_2D);
    }

    @Inject(method = "render", at = @At("TAIL"), cancellable = true)
    private void render2(float p_195458_1_, long p_195458_2_, boolean p_195458_4_, CallbackInfo ci) {
        //   GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
        //    GL11.glEnable(GL11.GL_TEXTURE_2D);
    }
}
