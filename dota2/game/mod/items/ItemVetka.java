package dota2.game.mod.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemVetka extends Item {

	public ItemVetka(int par1) {
		super(par1);
		this.setMaxStackSize(1);
		// TODO Auto-generated constructor stub
	}
    @Override
  public void registerIcons(IconRegister par1IconRegister) {
  	    super.itemIcon = par1IconRegister.registerIcon("dota2:vetka");
  		this.setCreativeTab(CreativeTabs.tabMaterials);
  }
}
