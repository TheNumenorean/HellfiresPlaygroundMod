package net.thenumenorean.hellfiresplayground.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TransparentAlmuninum extends Block {

	public TransparentAlmuninum() {
		super(Material.glass);

		setHardness(40.0F); // 33% harder than diamond
		setStepSound(Block.soundTypeMetal);
		setBlockName("transparentAluminum");
		setBlockTextureName("hellfiresplayground:transparentAluminum");
		setHarvestLevel("pickaxe", 3);
		setResistance(160.0F);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderBlockPass() {
		return 1;
	}

}
