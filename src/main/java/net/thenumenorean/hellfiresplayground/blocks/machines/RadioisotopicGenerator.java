package net.thenumenorean.hellfiresplayground.blocks.machines;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.thenumenorean.hellfiresplayground.HellfiresPlayground;
import net.thenumenorean.hellfiresplayground.client.gui.GuiHandler;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class RadioisotopicGenerator extends BlockContainer {

	public RadioisotopicGenerator(int par1) {
		super(par1, Material.iron);
		setStepSound(Block.soundMetalFootstep);
		setUnlocalizedName("radioisotropticGenerator");
		LanguageRegistry.addName(this, "Radioisotropic Generator");
		setTextureName("hellfiresplayground:radioisotropticGeneratorOff");

		setBlockBounds(0F, 0F, 0F, 1.0F, 2.0F, 1.0F);

		GameRegistry.registerTileEntity(RadioisotopicGeneratorTileEntity.class, "radioisotropticGeneratorTileEntity");
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l) {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public void onBlockPlacedBy(World w, int x, int y, int z, EntityLivingBase player, ItemStack is) {
		int dir = MathHelper.floor_double((player.rotationYaw * 4F) / 360F + 0.5D) & 3;
		w.setBlockMetadataWithNotify(x, y, z, dir, 0);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			FMLNetworkHandler.openGui(player, HellfiresPlayground.instance, GuiHandler.RADIOISOTOPIC_GENERATOR_GUI, world, x, y, z);
		}

		RadioisotopicGeneratorTileEntity te = ((RadioisotopicGeneratorTileEntity) world.getBlockTileEntity(x, y, z));

		te.setStatus(!te.isOn());

		return true;

	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new RadioisotopicGeneratorTileEntity();
	}
}