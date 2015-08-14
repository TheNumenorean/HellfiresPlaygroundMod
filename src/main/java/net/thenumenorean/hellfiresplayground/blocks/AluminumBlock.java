package net.thenumenorean.hellfiresplayground.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class AluminumBlock extends Block {

	public AluminumBlock(int par1) {
		super(Material.anvil);

		setHardness(20.0F); // 33% harder than diamond
		setStepSound(Block.soundTypeMetal);
		setBlockName("aluminumBlock");
		setBlockTextureName("hellfiresplayground:aluminumBlock");
		setHarvestLevel("pickaxe", 3);
		this.setResistance(20.0F);
	}

}
