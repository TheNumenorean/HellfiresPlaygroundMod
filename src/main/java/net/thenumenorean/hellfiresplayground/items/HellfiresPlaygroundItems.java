package net.thenumenorean.hellfiresplayground.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import net.thenumenorean.hellfiresplayground.items.ingots.AluminumIngot;
import net.thenumenorean.hellfiresplayground.items.ingots.BrassIngot;
import net.thenumenorean.hellfiresplayground.items.ingots.ChromiumIngot;
import net.thenumenorean.hellfiresplayground.items.ingots.DilithiumIngot;
import net.thenumenorean.hellfiresplayground.items.ingots.DuraniumIngot;
import net.thenumenorean.hellfiresplayground.items.ingots.InvisibleIngot;
import net.thenumenorean.hellfiresplayground.items.ingots.PlatinumIngot;
import net.thenumenorean.hellfiresplayground.items.ingots.TitaniumIngot;
import net.thenumenorean.hellfiresplayground.items.ingots.TritaniumIngot;
import net.thenumenorean.hellfiresplayground.items.ingots.TungstenIngot;
import net.thenumenorean.hellfiresplayground.items.tools.Phaser;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Contains and initializes all HellfiresPlayground Items
 * 
 * @author The Numenorean
 * 
 */
public class HellfiresPlaygroundItems {

	public static Item dilithium_ingot;
	public static Item brass_ingot;
	public static Item chromium_ingot;
	public static Item duranium_ingot;
	public static Item invisible_ingot;
	public static Item iridium_ingot;
	public static Item platinum_ingot;
	public static Item titanium_ingot;
	public static Item tritanium_ingot;
	public static Item tungsten_ingot;
	public static Item aluminum_ingot;
	public static Item rubble;
	public static Item dilithium_crystal;
	public static Item phaser;
	public static Item smallAntimatterStorage;

	public static int initialize(int startID, Configuration conf, CreativeTabs tab) {

		// Ingots
		aluminum_ingot = new AluminumIngot(conf.getItem("AluminumIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(aluminum_ingot, "Aluminum Ingot");

		dilithium_ingot = new DilithiumIngot(conf.getItem("DilithiumIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(dilithium_ingot, "Dilithium Ingot");

		brass_ingot = new BrassIngot(conf.getItem("BrassIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(brass_ingot, "Brass Ingot");

		chromium_ingot = new ChromiumIngot(conf.getItem("ChromiumIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(chromium_ingot, "Chromium Ingot");

		duranium_ingot = new DuraniumIngot(conf.getItem("DuraniumIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(duranium_ingot, "Duranium Ingot");

		invisible_ingot = new InvisibleIngot(conf.getItem("InvisibleIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(invisible_ingot, "Invisible Ingot");

		platinum_ingot = new PlatinumIngot(conf.getItem("PlatinumIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(platinum_ingot, "Platinum Ingot");

		titanium_ingot = new TitaniumIngot(conf.getItem("TitaniumIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(titanium_ingot, "Titanium Ingot");

		tritanium_ingot = new TritaniumIngot(conf.getItem("TritaniumIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(tritanium_ingot, "Tritanium Ingot");

		tungsten_ingot = new TungstenIngot(conf.getItem("TungstenIngot", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(tungsten_ingot, "Tungsten Ingot");

		// Dust

		// Tools
		phaser = new Phaser(conf.getItem("Phaser", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(phaser, "phaser");

		// Others
		rubble = new Rubble(conf.getItem("Rubble", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(rubble, "Rubble");

		dilithium_crystal = new DilithiumCrystal(conf.getItem("DilithiumCrystal", startID++).getInt()).setCreativeTab(tab);
		LanguageRegistry.addName(dilithium_crystal, "Dilithium Crystal");

		smallAntimatterStorage = new SmallAntimatterStorage(conf.getItem("SmallAntimatterStorage", startID++).getInt()).setCreativeTab(tab);

		return startID;

	}

}
