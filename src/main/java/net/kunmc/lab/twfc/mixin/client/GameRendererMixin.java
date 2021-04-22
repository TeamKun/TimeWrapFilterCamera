package net.kunmc.lab.twfc.mixin.client;

import net.kunmc.lab.twfc.client.handler.ClientHandler;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;clear(IZ)V", ordinal = 1))
    private void render(float p_195458_1_, long p_195458_2_, boolean p_195458_4_, CallbackInfo ci) {

    }
}
