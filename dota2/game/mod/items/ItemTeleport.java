package dota2.game.mod.items;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import dota2.game.mod.proxy.ClientProxy;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.world.World;

public class ItemTeleport extends Item {

	public ItemTeleport(int par1) {
		super(par1);
	
	}
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
	    super.itemIcon = par1IconRegister.registerIcon("dota2:teleport");
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if(!par2World.isRemote) {
            ClientProxy.mc.thePlayer.sendQueue.addToSendQueue(new Packet3Chat("/spawn"));
            --par1ItemStack.stackSize;
		}
		return par1ItemStack;}
}
