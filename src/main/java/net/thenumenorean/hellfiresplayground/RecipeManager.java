package net.thenumenorean.hellfiresplayground;

import ic2.api.item.Items;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.thenumenorean.hellfiresplayground.blocks.HellfiresPlaygroundBlocks;
import net.thenumenorean.hellfiresplayground.blocks.machines.LaserElectronManipulatorTileEntity;
import net.thenumenorean.hellfiresplayground.blocks.ores.HellfiresPlaygroundOres;
import net.thenumenorean.hellfiresplayground.items.HellfiresPlaygroundItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeManager {

	public RecipeManager() {
	}

	public static void addRecipes() {
		GameRegistry.addSmelting(HellfiresPlaygroundOres.bauxite_ore.blockID, new ItemStack(HellfiresPlaygroundItems.aluminum_ingot), 1.0F);
		GameRegistry
				.addSmelting(HellfiresPlaygroundOres.titanium_ore.blockID, new ItemStack(HellfiresPlaygroundItems.titanium_ingot), 1.0F);
		GameRegistry
				.addSmelting(HellfiresPlaygroundOres.tungsten_ore.blockID, new ItemStack(HellfiresPlaygroundItems.tungsten_ingot), 1.0F);
		GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestone), new ItemStack(HellfiresPlaygroundItems.rubble), new ItemStack(
				HellfiresPlaygroundItems.rubble));

		LaserElectronManipulatorTileEntity.addRecipe(new ItemStack(HellfiresPlaygroundBlocks.aluminum_block), new ItemStack(
				HellfiresPlaygroundBlocks.transparent_aluminum));

		ItemStack eCrystal = Items.getItem("energyCrystal");
		eCrystal.setItemDamage(26);
		GameRegistry.addShapedRecipe(
				new ItemStack(HellfiresPlaygroundItems.phaser, 1),
				new Object[] { "ZXC", "DA ", 'C', HellfiresPlaygroundItems.dilithium_crystal, 'Z', eCrystal, 'X',
						Items.getItem("glassFiberCableItem"), 'D', Items.getItem("advancedAlloy"), 'A', Items.getItem("advancedCircuit") });

		GameRegistry.addShapedRecipe(new ItemStack(HellfiresPlaygroundBlocks.aluminum_block), "XXX", "XXX", "XXX", 'X', new ItemStack(
				HellfiresPlaygroundItems.aluminum_ingot));

		ItemStack lapCrystal = Items.getItem("lapotronCrystal");
		lapCrystal.setItemDamage(26);
		ItemStack miningLaser = Items.getItem("miningLaser");
		miningLaser.setItemDamage(26);
		GameRegistry.addShapedRecipe(
				new ItemStack(HellfiresPlaygroundBlocks.laser_electron_manipulator, 1),
				new Object[] { "XLX", "ACA", "XZX", 'C', Items.getItem("advancedMachine"), 'Z', lapCrystal, 'X',
						Items.getItem("advancedAlloy"), 'D', Items.getItem("advancedAlloy"), 'A', Items.getItem("advancedCircuit"), 'L',
						miningLaser });

	}

}
