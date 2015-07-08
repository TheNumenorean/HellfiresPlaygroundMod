package net.thenumenorean.hellfiresplayground;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.thenumenorean.hellfiresplayground.blocks.ores.HellfiresPlaygroundOres;
import net.thenumenorean.hellfiresplayground.items.HellfiresPlaygroundItems;

public class HellfiresPlaygroundCreativeTab extends CreativeTabs {

	public HellfiresPlaygroundCreativeTab(String label) {
		super(label);
	}

	public HellfiresPlaygroundCreativeTab(int par1, String par2Str) {
		super(par1, par2Str);
	}

	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(HellfiresPlaygroundItems.phaser);
	}

}
