package dota2.game.mod;





import java.awt.Color;

import org.bukkit.event.entity.EntityDeathEvent;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dota2.game.mod.player.Dota2Player;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Post;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

public class EventHandler {
	Minecraft mc = Minecraft.getMinecraft();
	public long tick = 0;
	  @ForgeSubscribe
	   public void onEntityConstructing(EntityConstructing event) {
	      if(event.entity instanceof EntityPlayer && Dota2Player.get((EntityPlayer)event.entity) == null) {
	         Dota2Player.register((EntityPlayer)event.entity);
	      }
	      if(event.entity instanceof EntityPlayer && event.entity.getExtendedProperties("epa") == null) {
	          event.entity.registerExtendedProperties("epa", new Dota2Player((EntityPlayer)event.entity));
	       }
	  }
	  @SideOnly(Side.CLIENT)
	   @ForgeSubscribe
	   public void OverlayEvent(RenderGameOverlayEvent event) {
	         ScaledResolution scaledresolution = new ScaledResolution(mc.gameSettings,mc.displayWidth, mc.displayHeight);
	        
		Dota2Player player = new Dota2Player(mc.thePlayer);
		  if(event.type == ElementType.HOTBAR) {
			  String coin = String.valueOf(player.coin);
				int k = scaledresolution.getScaledWidth();
				int l = scaledresolution.getScaledHeight();
			    GL11.glPushMatrix();
					 mc.fontRenderer.drawString(coin, k - mc.fontRenderer.getStringWidth(coin) - 28, l - 15, Color.WHITE.getRGB());
			         RenderHelper.enableStandardItemLighting();
			         Utils.renderItemStack(mc.fontRenderer, new ItemStack(Dota.itemgold, 1, 1), k - 24, l - 19);
			         RenderHelper.disableStandardItemLighting();
		        GL11.glPopMatrix();
		  }
	  }
	 @SideOnly(Side.CLIENT)
	 @ForgeSubscribe
	 public void one(EntityJoinWorldEvent e) {
		  Dota2Player player = new Dota2Player((EntityPlayer) e.entity);  
	 } 
}
