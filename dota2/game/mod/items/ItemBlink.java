package dota2.game.mod.items;

import org.bukkit.enchantments.EnchantmentTarget;

import dota2.game.mod.RayTrace;
import dota2.game.mod.Utils;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemBlink extends Item{
	public static final int DISTANCE = 7;
	public ItemBlink(int par1) {
		super(par1);
		this.maxStackSize = 1;
		// TODO Auto-generated constructor stub
	}
	
@Override
public ItemStack onItemRightClick(ItemStack par1ItemStack, World w, EntityPlayer pl) {

	if(!w.isRemote) {
		 Vec3 vec3 = Vec3.createVectorHelper(pl.posX, pl.posY, pl.posZ);
         Vec3 vec31 = pl.getLook(0);
         Vec3 vec32 = vec3.addVector(vec31.xCoord * DISTANCE, Math.max(0, vec31.yCoord) * DISTANCE, vec31.zCoord * DISTANCE);
         MovingObjectPosition trace = RayTrace.traceBlinkPath(w, vec3, vec32, false, false, true);
         if (trace != null && trace.hitVec != null) {
             Vec3 look = pl.getLookVec();
             Vec3 rv = trace.hitVec.addVector(-look.xCoord, -look.yCoord, -look.zCoord);
             pl.setPositionAndUpdate(rv.xCoord, rv.yCoord + 0.1F, rv.zCoord);
             return par1ItemStack;
         }
         
	}
	return par1ItemStack;
}
@Override
public void registerIcons(IconRegister par1IconRegister) {
    super.itemIcon = par1IconRegister.registerIcon("dota2:blink");
	this.setCreativeTab(CreativeTabs.tabCombat);
}
}
