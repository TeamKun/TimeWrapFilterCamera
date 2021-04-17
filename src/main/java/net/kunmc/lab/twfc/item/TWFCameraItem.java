package net.kunmc.lab.twfc.item;

import net.kunmc.lab.twfc.client.handler.RenderHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class TWFCameraItem extends Item {
    public TWFCameraItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        ItemStack itemstack = playerEntity.getItemInHand(hand);
        if (world.isClientSide) {
         /*   Minecraft mc = Minecraft.getInstance();
            NativeImage nativeimage = ScreenShotHelper.takeScreenshot(mc.getWindow().getWidth(), mc.getWindow().getHeight(), mc.getMainRenderTarget());


            try {
                nativeimage.writeToFile(Paths.get("V:\\dev\\minecraft\\TimeWrapFilterCamera\\run\\test").resolve("sc.png"));
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                nativeimage.close();
            }*/
            RenderHandler.stoped = !RenderHandler.stoped;
        }
        return ActionResult.sidedSuccess(itemstack, world.isClientSide());
    }
}
