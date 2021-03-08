package dota2.game.mod.items;

import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import dota2.game.mod.player.Dota2Player;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemTango extends Item {

	public ItemTango(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
	    super.itemIcon = par1IconRegister.registerIcon("dota2:tango");
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	
	@Override
	public ItemStack onItemRightClick(ItemStack item, World par2World, EntityPlayer par3EntityPlayer) {
		if(!par2World.isRemote && par3EntityPlayer.getHealth() < 20 && (Dota2Player.coin - 40) >= 0) {
			par3EntityPlayer.addPotionEffect(new PotionEffect(10,20));
			Dota2Player.coin -= 40;
			item.stackSize--;
			return item;
		}
		return item;
	}
}
