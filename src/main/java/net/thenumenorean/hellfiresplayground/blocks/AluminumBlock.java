package net.thenumenorean.hellfiresplayground.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class AluminumBlock extends Block {

	public AluminumBlock(int par1) {
		super(par1, Material.anvil);

		setHardness(20.0F); // 33% harder than diamond
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName("aluminumBlock");
		setTextureName("hellfiresplayground:aluminumBlock");
		LanguageRegistry.addName(this, "Aluminum Block");
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 3);
		this.setResistance(100.0F);
	}

}
