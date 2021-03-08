package dota2.game.mod;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import dota2.game.mod.items.ItemBlink;
import dota2.game.mod.items.ItemGold;
import dota2.game.mod.items.ItemHeal;
import dota2.game.mod.items.ItemTango;
import dota2.game.mod.items.ItemTeleport;
import dota2.game.mod.items.ItemVetka;
import dota2.game.mod.proxy.ClientProxy;
import dota2.game.mod.proxy.ServerProxy;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

@Mod(name = "Dota2", modid = "Dota2")
@NetworkMod(
		   clientSideRequired = true,
		   serverSideRequired = false
		)
public class Dota {
	
	   @SidedProxy(
			      clientSide = "dota2.game.mod.proxy.ClientProxy",
			      serverSide = "dota2.game.mod.proxy.ServerProxy"
			   )
   public static ServerProxy proxy;
   public static Item itemgold;
   public static Item blinkdagger;
   public static Item vetka;
   public static Item tango;
   public static Item heal;
   public static Item teleport;
   public EventHandler eventHandler;
   private ClientTickHandler ClientTickHandler;
	@PreInit
	public void doload(FMLPreInitializationEvent e) {
		
	      MinecraftForge.EVENT_BUS.register(this.eventHandler);
	}
	@Init
	public void onload(FMLInitializationEvent e) {
		itemgold = new ItemGold(1024).setUnlocalizedName("itemgold");
		LanguageRegistry.addName(itemgold, "Голда");
		blinkdagger = new ItemBlink(1025).setUnlocalizedName("itemblink");
		LanguageRegistry.addName(blinkdagger, "Blink Dagger");
		vetka = new ItemVetka(1026).setUnlocalizedName("itemvetka");
		LanguageRegistry.addName(vetka, "Ветка");
		tango = new ItemTango(1027).setUnlocalizedName("itemtango");
		LanguageRegistry.addName(tango, "Танго");
		heal = new ItemHeal(1028).setUnlocalizedName("itemheal");
		LanguageRegistry.addName(heal, "Хилка");
		teleport = new ItemTeleport(1029).setUnlocalizedName("itemteleport");
		LanguageRegistry.addName(teleport, "Телепорт");
        proxy.register_renderers();
	}
	@PostInit
	public void postload(FMLPostInitializationEvent e) {
	}
}
