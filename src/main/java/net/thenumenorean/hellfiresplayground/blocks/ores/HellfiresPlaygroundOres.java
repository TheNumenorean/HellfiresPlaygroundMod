package net.thenumenorean.hellfiresplayground.blocks.ores;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;

public class HellfiresPlaygroundOres {

	public static Ore bauxite_ore;

	/**
	 * Initializes ore blocks
	 * 
	 * @param ct
	 *            Creative tab to add blocks to (Should probably not be used
	 *            this way)
	 * @return The last id that wasn't used
	 */
	public static void initialize(CreativeTabs ct, OreGenerator gen) {

		registerOre(bauxite_ore = new BauxiteOre(), ct, gen);

	}

	/**
	 * Does some standard ore registration. Sets the creative tab, adds it to
	 * the OreGenerator, registers it to the GameRegistry. Mostly a helper
	 * method.
	 * 
	 * @param o
	 *            Ore to do operations on
	 * @param ct
	 *            CreativeTabs to add the ore to.
	 * @param gen
	 *            OreGenerator to add the ore to.
	 */
	private static void registerOre(Ore o, CreativeTabs ct, OreGenerator gen) {
		o.setCreativeTab(ct);
		GameRegistry.registerBlock(o, o.getUnlocalizedName());
		gen.addOre(o);

	}

}
