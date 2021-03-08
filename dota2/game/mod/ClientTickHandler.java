package dota2.game.mod;

import java.util.EnumSet;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import dota2.game.mod.items.ItemBlink;
import dota2.game.mod.player.Dota2Player;
import dota2.game.mod.proxy.ClientProxy;
import net.minecraft.client.Minecraft;

public class ClientTickHandler implements ITickHandler {
	Minecraft mc = Minecraft.getMinecraft();
	public long tick = 0;

	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		if(type.contains(TickType.PLAYER)) {
			Dota2Player player = new Dota2Player(mc.thePlayer);
			if(this.tick % 20 == 0) {
				player.coin++;
			}
			this.tick++;
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
		
	}

	   public EnumSet ticks() {
		      return EnumSet.of(TickType.WORLDLOAD, TickType.CLIENT, TickType.PLAYER, TickType.RENDER);
		   }

	
	
	  public String getLabel() {
	      return "dota2";
	   }

}
