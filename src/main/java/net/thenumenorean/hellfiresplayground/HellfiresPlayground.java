package net.thenumenorean.hellfiresplayground;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;
import net.thenumenorean.hellfiresplayground.blocks.HellfiresPlaygroundBlocks;
import net.thenumenorean.hellfiresplayground.blocks.ores.HellfiresPlaygroundOres;
import net.thenumenorean.hellfiresplayground.blocks.ores.OreGenerator;
import net.thenumenorean.hellfiresplayground.client.gui.GuiHandler;
import net.thenumenorean.hellfiresplayground.entities.projectiles.EntityPhaserBolt;
import net.thenumenorean.hellfiresplayground.items.HellfiresPlaygroundItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "hellfiresplayground", name = "HellfiresPlayground", version = "0.2.0", dependencies = "required-after:IC2")
public class HellfiresPlayground {

	@SidedProxy(clientSide = "net.thenumenorean.hellfiresplayground.client.ClientProxy", serverSide = "net.thenumenorean.hellfiresplayground.CommonProxy")
	public static CommonProxy proxy;

	public static CreativeTabs creativeTab;
	public static OreGenerator oreGenerator;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("Initializing HellfiresPlayground...");

		new GuiHandler();

		oreGenerator = new OreGenerator();
		GameRegistry.registerWorldGenerator(oreGenerator, 0);

		creativeTab = new HellfiresPlaygroundCreativeTab("HellfiresPlayground");
		LanguageRegistry.instance().addStringLocalization("itemGroup.HellfiresPlayground", "HellfiresPlayground");

		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		// Initialize all blocks and items
		HellfiresPlaygroundOres.initialize(creativeTab, oreGenerator);
		HellfiresPlaygroundBlocks.initialize(creativeTab);
		HellfiresPlaygroundItems.initialize(creativeTab);

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
