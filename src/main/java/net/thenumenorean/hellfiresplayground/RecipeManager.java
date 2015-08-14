package net.thenumenorean.hellfiresplayground;

import ic2.api.item.IC2Items;
import net.minecraft.init.Blocks;
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
		GameRegistry.addSmelting(HellfiresPlaygroundOres.bauxite_ore, new ItemStack(HellfiresPlaygroundItems.aluminum_ingot), 1.0F);
		GameRegistry.addSmelting(HellfiresPlaygroundOres.titanium_ore, new ItemStack(HellfiresPlaygroundItems.titanium_ingot), 1.0F);
		GameRegistry.addSmelting(HellfiresPlaygroundOres.tungsten_ore, new ItemStack(HellfiresPlaygroundItems.tungsten_ingot), 1.0F);
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone), new ItemStack(HellfiresPlaygroundItems.rubble), new ItemStack(
				HellfiresPlaygroundItems.rubble));

		LaserElectronManipulatorTileEntity.addRecipe(new ItemStack(HellfiresPlaygroundBlocks.aluminum_block), new ItemStack(
				HellfiresPlaygroundBlocks.transparent_aluminum));

		ItemStack eCrystal = IC2Items.getItem("energyCrystal");
		eCrystal.setItemDamage(26);
		GameRegistry.addShapedRecipe(
				new ItemStack(HellfiresPlaygroundItems.phaser, 1),
				new Object[] { "ZXC", "DA ", 'C', HellfiresPlaygroundItems.dilithium_crystal, 'Z', eCrystal, 'X',
						IC2Items.getItem("glassFiberCableItem"), 'D', IC2Items.getItem("advancedAlloy"), 'A',
						IC2Items.getItem("advancedCircuit") });

		GameRegistry.addShapedRecipe(new ItemStack(HellfiresPlaygroundBlocks.aluminum_block), "XXX", "XXX", "XXX", 'X', new ItemStack(
				HellfiresPlaygroundItems.aluminum_ingot));

		ItemStack lapCrystal = IC2Items.getItem("lapotronCrystal");
		lapCrystal.setItemDamage(26);
		ItemStack miningLaser = IC2Items.getItem("miningLaser");
		miningLaser.setItemDamage(26);
		GameRegistry.addShapedRecipe(
				new ItemStack(HellfiresPlaygroundBlocks.laser_electron_manipulator, 1),
				new Object[] { "XLX", "ACA", "XZX", 'C', IC2Items.getItem("advancedMachine"), 'Z', lapCrystal, 'X',
						IC2Items.getItem("advancedAlloy"), 'D', IC2Items.getItem("advancedAlloy"), 'A',
						IC2Items.getItem("advancedCircuit"), 'L', miningLaser });

	}

}
