package net.thenumenorean.hellfiresplayground.blocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.fluids.Fluid;
import net.thenumenorean.hellfiresplayground.blocks.machines.LaserElectronManipulator;
import net.thenumenorean.hellfiresplayground.blocks.machines.PhaserDrill;
import net.thenumenorean.hellfiresplayground.blocks.machines.RadioisotopicGenerator;
import net.thenumenorean.hellfiresplayground.blocks.machines.Refinery;
import net.thenumenorean.hellfiresplayground.blocks.machines.replicator.Replicator;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Container for all blocks except ores, and for initialization.
 * 
 * @author The Numenorean
 * 
 */
public class HellfiresPlaygroundBlocks {

	public static Block transparent_aluminum;
	public static Block aluminum_block;
	public static Block refinery;
	public static Block laser_electron_manipulator;
	public static Fluid antimatter_fluid;
	public static Block antimatter_fluid_block;
	public static Block phaser_drill;
	public static Block electric_cable;
	public static Block radioisotopic_generator;
	public static Block replicator;

	/**
	 * Initializes non-ore blocks
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
	public static int initialize(int startID, Configuration conf, CreativeTabs ct) {

		// Liquids
		antimatter_fluid = new AntimatterFluid();

		antimatter_fluid_block = new BlockAntimatter(conf.getBlock("AntimatterFluidBlock", startID++).getInt()).setCreativeTab(ct);
		GameRegistry.registerBlock(antimatter_fluid_block, "antimatterFluidBlock");

		// Machines
		refinery = new Refinery(conf.getBlock("Refinery", startID++).getInt()).setCreativeTab(ct);
		GameRegistry.registerBlock(refinery, "refinery");

		laser_electron_manipulator = new LaserElectronManipulator(conf.getBlock("LaserElectronManipulator", startID++).getInt())
				.setCreativeTab(ct);
		GameRegistry.registerBlock(laser_electron_manipulator, "laserElectronManipulator");

		radioisotopic_generator = new RadioisotopicGenerator(conf.getBlock("RadioisotopicGenerator", startID++).getInt())
				.setCreativeTab(ct);
		GameRegistry.registerBlock(radioisotopic_generator, "radioisotopicGenerator");

		phaser_drill = new PhaserDrill(conf.getBlock("PhaserDrill", startID++).getInt()).setCreativeTab(ct);
		GameRegistry.registerBlock(phaser_drill, "phaserDrill");

		replicator = new Replicator(conf.getBlock("Replicator", startID++).getInt()).setCreativeTab(ct);
		GameRegistry.registerBlock(replicator, "replicator");

		// Others
		transparent_aluminum = new TransparentAlmuninum(conf.getBlock("TransparentAluminum", startID++).getInt()).setCreativeTab(ct);
		GameRegistry.registerBlock(transparent_aluminum, "transparentAluminum");

		aluminum_block = new AluminumBlock(conf.getBlock("AluminumBlock", startID++).getInt()).setCreativeTab(ct);
		GameRegistry.registerBlock(aluminum_block, "aluminumBlock");

		return startID;
	}

}
