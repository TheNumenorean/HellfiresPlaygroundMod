package net.thenumenorean.hellfiresplayground.blocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fluids.Fluid;
import net.thenumenorean.hellfiresplayground.blocks.machines.LaserElectronManipulator;
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
	public static void initialize(CreativeTabs ct) {

		laser_electron_manipulator = new LaserElectronManipulator().setCreativeTab(ct);
		GameRegistry.registerBlock(laser_electron_manipulator, "laserElectronManipulator");

		// Others
		transparent_aluminum = new TransparentAlmuninum().setCreativeTab(ct);
		GameRegistry.registerBlock(transparent_aluminum, "transparentAluminum");

		aluminum_block = new AluminumBlock().setCreativeTab(ct);
		GameRegistry.registerBlock(aluminum_block, "aluminumBlock");

	}

}
