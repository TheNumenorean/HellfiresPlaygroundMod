package net.thenumenorean.hellfiresplayground;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.thenumenorean.hellfiresplayground.blocks.HellfiresPlaygroundBlocks;
import net.thenumenorean.hellfiresplayground.blocks.ores.HellfiresPlaygroundOres;
import net.thenumenorean.hellfiresplayground.blocks.ores.OreGenerator;
import net.thenumenorean.hellfiresplayground.client.gui.GuiHandler;
import net.thenumenorean.hellfiresplayground.entities.projectiles.EntityPhaserBolt;
import net.thenumenorean.hellfiresplayground.items.HellfiresPlaygroundItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "hellfiresplayground", name = "HellfiresPlayground", version = "0.0.1", dependencies = "required-after:IC2")
@NetworkMod(clientSideRequired = true)
public class HellfiresPlayground {

	@Instance(value = "HellfiresPlayground")
	public static HellfiresPlayground instance;

	@SidedProxy(clientSide = "net.thenumenorean.hellfiresplayground.client.ClientProxy", serverSide = "net.thenumenorean.hellfiresplayground.CommonProxy")
	public static CommonProxy proxy;

	public static CreativeTabs creativeTab;
	public static OreGenerator oreGenerator;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("Initializing HellfiresPlayground...");

		new GuiHandler();

		MinecraftForge.EVENT_BUS.register(new SoundLoader());
		instance = this;

		oreGenerator = new OreGenerator();
		GameRegistry.registerWorldGenerator(oreGenerator);

		creativeTab = new HellfiresPlaygroundCreativeTab("HellfiresPlayground");
		LanguageRegistry.instance().addStringLocalization("itemGroup.HellfiresPlayground", "HellfiresPlayground");

		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		// Initialize all blocks and items
		int currID = HellfiresPlaygroundOres.initialize(1701, config, creativeTab, oreGenerator);
		currID = HellfiresPlaygroundBlocks.initialize(currID, config, creativeTab);
		HellfiresPlaygroundItems.initialize(20000, config, creativeTab);

		EntityRegistry
				.registerModEntity(EntityPhaserBolt.class, "PhaserBolt", EntityRegistry.findGlobalUniqueEntityId(), this, 64, 1, true);

		config.save();
		System.out.println("Finished Initializing HellfiresPlayground");
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {

		RecipeManager.addRecipes();
		proxy.registerRenderers();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}

}
