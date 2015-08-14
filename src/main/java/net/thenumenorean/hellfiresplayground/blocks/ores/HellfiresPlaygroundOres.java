package net.thenumenorean.hellfiresplayground.blocks.ores;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;

public class HellfiresPlaygroundOres {

	public static Ore dilithium_ore;
	public static Ore duranium_ore;
	public static Ore tritanium_ore;
	public static Ore bauxite_ore;
	public static Ore chromite_ore;
	public static Ore platinum_ore;
	public static Ore titanium_ore;
	public static Ore tungsten_ore;
	public static Ore invisible_ore;
	public static Ore nitrium_ore;

	/**
	 * Initializes ore blocks
	 * 
	 * @param startID
	 *            First ID to use as a default id for blocks
	 * @param conf
	 *            Configuration to pull block data from
	 * @param ct
	 *            Creative tab to add blocks to (Should probably not be used
	 *            this way)
	 * @return The last id that wasn't used
	 */
	public static void initialize(CreativeTabs ct, OreGenerator gen) {
		registerOre(dilithium_ore = new DilithiumOre(), ct, gen);

		registerOre(tritanium_ore = new TritaniumOre(), ct, gen);

		registerOre(duranium_ore = new DuraniumOre(), ct, gen);

		registerOre(bauxite_ore = new BauxiteOre(), ct, gen);

		registerOre(chromite_ore = new ChromiteOre(), ct, gen);

		registerOre(titanium_ore = new TitaniumOre(), ct, gen);

		registerOre(tungsten_ore = new TungstenOre(), ct, gen);

		registerOre(invisible_ore = new InvisibleOre(), ct, gen);

		registerOre(nitrium_ore = new NitriumOre(), ct, gen);
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
