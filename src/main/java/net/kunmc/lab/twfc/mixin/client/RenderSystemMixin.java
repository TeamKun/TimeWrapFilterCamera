package net.kunmc.lab.twfc.mixin.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.kunmc.lab.twfc.client.handler.ClientHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderSystem.class)
public class RenderSystemMixin {

    @Inject(method = "clear", at = @At("HEAD"), cancellable = true)
    private static void clear(int p_clear_0_, boolean p_clear_1_, CallbackInfo ci) {
      /*  Minecraft mc = Minecraft.getInstance();
        if (TWFRenderer.getInstance().isStarted() && p_clear_0_ == 256) {
            //   System.out.println(p_clear_0_);
            ci.cancel();
        }*/
      //  if (ClientHandler.renderGUIed) {
      //      ci.cancel();
     //       ClientHandler.renderGUIed = false;
    //    }
    }

}
