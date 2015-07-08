package net.thenumenorean.hellfiresplayground.blocks.machines;

import ic2.api.energy.prefab.BasicSink;
import ic2.api.energy.tile.IEnergySink;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class LaserElectronManipulatorTileEntity extends TileEntity implements ISidedInventory, IEnergySink {

	private final ItemStack[] inventory;
	private BasicSink ic2EnergySink;
	private final ArrayList<ForgeDirection> outputDirections;
	private boolean isCooking;
	private int time_remaining;

	private static final ArrayList<ItemStack> recipeIngredients = new ArrayList<ItemStack>(), recipeProducts = new ArrayList<ItemStack>();
	private static final double ENERGY_PER_TICK = 10;
	private static final int COOK_TIME = 300;

	public LaserElectronManipulatorTileEntity() {
		super();

		inventory = new ItemStack[2];
		ic2EnergySink = new BasicSink(this, 1000, 1);

		outputDirections = new ArrayList<ForgeDirection>();
		for (ForgeDirection fd : ForgeDirection.values())
			if (!fd.equals(ForgeDirection.UNKNOWN))
				outputDirections.add(fd);
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
	}

	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData packet) {
		readFromNBT(packet.data);
	}

	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return inventory[i];
	}

	@Override
	public ItemStack decrStackSize(int slot, int count) {
		ItemStack itemstack = getStackInSlot(slot);
		if (itemstack != null) {
			if (itemstack.stackSize <= count) {
				setInventorySlotContents(slot, null);
			} else {
				itemstack = itemstack.splitStack(count);
				onInventoryChanged();
			}
		}
		return itemstack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		ItemStack itemstack = getStackInSlot(i);
		setInventorySlotContents(i, null);
		return itemstack;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {

		inventory[i] = itemstack;
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}
		onInventoryChanged();

	}

	@Override
	public String getInvName() {
		return "Laser Electron Manipulator";
	}

	@Override
	public boolean isInvNameLocalized() {
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64;
	}

	@Override
	public void openChest() {

	}

	@Override
	public void closeChest() {

	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		if (itemstack == null)
			return true;

		for (ItemStack is : recipeIngredients)
			if (is.itemID == itemstack.itemID)
				return true;

		return false;
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		ic2EnergySink.writeToNBT(compound);

		NBTTagList list = new NBTTagList();
		for (int i = 0; i < getSizeInventory(); i++) {
			ItemStack itemstack = getStackInSlot(i);
			if (itemstack != null) {
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("LEMSlot", (byte) i);
				itemstack.writeToNBT(item);
				list.appendTag(item);
			}
		}
		compound.setTag("LEMItems", list);

		compound.setBoolean("cooking", isCooking);
		compound.setInteger("remaining", time_remaining);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		ic2EnergySink.readFromNBT(compound);

		NBTTagList list = compound.getTagList("LEMItems");
		for (int i = 0; i < list.tagCount(); i++) {

			NBTTagCompound item = (NBTTagCompound) list.tagAt(i);

			int slot = item.getByte("LEMSlot");
			if (slot >= 0 && slot < getSizeInventory()) {
				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
			}
		}

		isCooking = compound.getBoolean("cooking");
		time_remaining = compound.getInteger("remaining");
	}

	public static void addRecipe(ItemStack in, ItemStack out) {
		recipeIngredients.add(in);
		recipeProducts.add(out);
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		int[] tmp = new int[2];
		tmp[0] = 0;
		tmp[1] = 1;
		return tmp;
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return isItemValidForSlot(i, itemstack);
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return true;
	}

	@Override
	public boolean acceptsEnergyFrom(TileEntity emitter, ForgeDirection direction) {
		return true;
	}

	@Override
	public double demandedEnergyUnits() {
		return ic2EnergySink.demandedEnergyUnits();
	}

	@Override
	public double injectEnergyUnits(ForgeDirection directionFrom, double amount) {
		return ic2EnergySink.injectEnergyUnits(directionFrom, amount);
	}

	@Override
	public int getMaxSafeInput() {
		return ic2EnergySink.getMaxSafeInput();
	}

	@Override
	public void invalidate() {
		ic2EnergySink.invalidate(); // notify the energy sink

		super.invalidate(); // this is important for mc!
	}

	@Override
	public void onChunkUnload() {
		ic2EnergySink.onChunkUnload(); // notify the energy sink

	}

	@Override
	public void updateEntity() {
		ic2EnergySink.updateEntity(); // notify the energy sink

		if (this.worldObj.isRemote)
			return;

		if (!validIngredient()) {
			isCooking = false;
			time_remaining = 0;
			return;
		}

		if (time_remaining > 0 && ic2EnergySink.useEnergy(ENERGY_PER_TICK)) {
			time_remaining--;
		}

		if (isCooking && time_remaining == 0) {

			{

				ItemStack tmp = inventory[1];

				ItemStack product = getProduct(inventory[0]);

				if (tmp == null) {
					isCooking = false;
					inventory[1] = product.copy();
				} else if (tmp.getMaxStackSize() >= tmp.stackSize + product.stackSize && tmp.getItem().equals(product.getItem())) {
					isCooking = false;
					inventory[1].stackSize += product.stackSize;

				}

				if (!isCooking)
					if (inventory[0].stackSize <= 1)
						inventory[0] = null;
					else
						inventory[0].stackSize--;
			}

		}

		if (!isCooking && validIngredient()) {

			time_remaining = COOK_TIME;
			isCooking = true;

		}

		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);

	}

	private boolean validIngredient() {
		if (inventory[0] != null)
			for (ItemStack is : recipeIngredients)
				if (inventory[0].getItem().equals(is.getItem()))
					return true;
		return false;
	}

	private ItemStack getProduct(ItemStack ingredient) {
		for (int i = 0; i < recipeIngredients.size(); i++)
			if (recipeIngredients.get(i).getItem().equals(ingredient.getItem()))
				return recipeProducts.get(i);
		return null;
	}

	public int getBurnTimeRemainingScaled(int outOf) {
		return outOf - outOf * time_remaining / COOK_TIME;
	}

	public boolean isCooking() {
		return isCooking;
	}

}
