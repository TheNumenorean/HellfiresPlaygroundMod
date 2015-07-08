package net.thenumenorean.hellfiresplayground.items.tools;

import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.thenumenorean.hellfiresplayground.entities.projectiles.EntityPhaserBolt;

public class Phaser extends Item implements IElectricItem {

	public static int energyUse = 200;
	public static int energyStorage = 50000;

	public Phaser(int par1) {
		super(par1);
		setMaxStackSize(1);
		setUnlocalizedName("phaser");
		setTextureName("hellfiresplayground:phaserAnimated");
		setMaxDamage(100);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack is, World par2World, EntityPlayer par3EntityPlayer) {
		if (!par2World.isRemote) {

			if (par3EntityPlayer.capabilities.isCreativeMode || ElectricItem.manager.canUse(is, energyUse)) {
				ElectricItem.manager.use(is, energyUse, par3EntityPlayer);
				par2World.playSoundAtEntity(par3EntityPlayer, "hellfiresplayground:phaser", 0.5F,
						0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
				par2World.spawnEntityInWorld(new EntityPhaserBolt(par2World, par3EntityPlayer));
			}
		}
		return is;
	}

	@Override
	public boolean canProvideEnergy(ItemStack arg0) {
		return false;
	}

	@Override
	public int getChargedItemId(ItemStack arg0) {
		return this.itemID;
	}

	@Override
	public int getEmptyItemId(ItemStack arg0) {
		return this.itemID;
	}

	@Override
	public int getMaxCharge(ItemStack arg0) {
		return 50000;
	}

	@Override
	public int getTier(ItemStack arg0) {
		return 2;
	}

	@Override
	public int getTransferLimit(ItemStack arg0) {
		return 500;
	}

}
