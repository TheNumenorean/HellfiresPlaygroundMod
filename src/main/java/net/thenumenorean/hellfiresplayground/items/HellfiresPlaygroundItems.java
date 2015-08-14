package net.thenumenorean.hellfiresplayground.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.thenumenorean.hellfiresplayground.items.ingots.AluminumIngot;
import net.thenumenorean.hellfiresplayground.items.tools.Phaser;

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

	public static void initialize(CreativeTabs tab) {

		// Ingots
		aluminum_ingot = new AluminumIngot().setCreativeTab(tab);

		// Tools
		phaser = new Phaser().setCreativeTab(tab);

		dilithium_crystal = new DilithiumCrystal().setCreativeTab(tab);

	}

}
