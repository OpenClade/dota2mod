package dota2.game.mod.proxy;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import dota2.game.mod.ClientTickHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;

public class ClientProxy extends ServerProxy {
	public static final RenderItem itemRenderer = new RenderItem();
	public static Minecraft mc = Minecraft.getMinecraft();
	public void register_renderers() {
     
	    TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
    }
}
