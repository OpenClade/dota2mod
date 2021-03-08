package dota2.game.mod;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dota2.game.mod.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;

public class Utils {
	  
	 public static int sec(int i) {
		 return i * 20;
	 }
	
      public static void renderskill() {
    	  ScaledResolution scaledresolution = new ScaledResolution(ClientProxy.mc.gameSettings,ClientProxy.mc.displayWidth, ClientProxy.mc.displayHeight);
			String name = "dwadwa";
    	  int k = ClientProxy.mc.displayWidth;
			int l = ClientProxy.mc.displayHeight;
			  GL11.glPushMatrix();
    	  ClientProxy.mc.fontRenderer.drawString(name, k - ClientProxy.mc.fontRenderer.getStringWidth(name) - 50 , l - 50, Color.blue.getRGB());
    	  GL11.glPopMatrix();
      }
	   @SideOnly(Side.CLIENT)
	   public static void renderItemStack(FontRenderer fr, ItemStack it, int x, int y) {
	      FontRenderer font = null;
	      if(it != null) {
	         font = it.getItem().getFontRenderer(it);
	      }

	      if(font == null) {
	         font = fr;
	      }

	     ClientProxy.itemRenderer.renderItemAndEffectIntoGUI(font, Minecraft.getMinecraft().renderEngine, it, x, y);
	   }
}
