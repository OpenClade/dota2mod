package dota2.game.mod.player;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class Dota2Player implements IExtendedEntityProperties {
       
	public EntityPlayer player;
	public static int coin;
	   public Dota2Player(EntityPlayer player) {
		   this.player = player;
		   }
	   public static final void register(EntityPlayer player) {
		      player.registerExtendedProperties("epa", new Dota2Player(player));
		   }
	   public static final Dota2Player get(EntityPlayer player) {
		      return (Dota2Player)player.getExtendedProperties("epa");
		   }
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		compound.setTag("epa", properties);
		properties.setInteger("coin", this.coin);
		
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
	NBTTagCompound properties = (NBTTagCompound) compound.getTag("epa");
	    this.coin = properties.getInteger("coin");
	}

	@Override
	public void init(Entity entity, World world) {
		// TODO Auto-generated method stub
		
	}
	

}
