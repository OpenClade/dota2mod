package dota2.game.mod.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemGold extends Item {

	public ItemGold(int par1) {
		super(par1);
		this.setMaxStackSize(1);
	}
      @Override
    public void registerIcons(IconRegister par1IconRegister) {
    	    super.itemIcon = par1IconRegister.registerIcon("dota2:gold");
    		this.setCreativeTab(CreativeTabs.tabMaterials);
    }
}
