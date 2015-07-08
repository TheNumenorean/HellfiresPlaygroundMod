package net.thenumenorean.hellfiresplayground.client;

import net.minecraftforge.client.MinecraftForgeClient;
import net.thenumenorean.hellfiresplayground.CommonProxy;
import net.thenumenorean.hellfiresplayground.blocks.HellfiresPlaygroundBlocks;
import net.thenumenorean.hellfiresplayground.blocks.machines.LaserElectronManipulatorItemRenderer;
import net.thenumenorean.hellfiresplayground.blocks.machines.LaserElectronManipulatorTileEntity;
import net.thenumenorean.hellfiresplayground.blocks.machines.LaserElectronManipulatorTileEntityRenderer;
import net.thenumenorean.hellfiresplayground.blocks.machines.PhaserDrillItemRenderer;
import net.thenumenorean.hellfiresplayground.blocks.machines.PhaserDrillTileEntity;
import net.thenumenorean.hellfiresplayground.blocks.machines.PhaserDrillTileEntityRenderer;
import net.thenumenorean.hellfiresplayground.blocks.machines.RadioisotopicGeneratorItemRenderer;
import net.thenumenorean.hellfiresplayground.blocks.machines.RadioisotopicGeneratorTileEntity;
import net.thenumenorean.hellfiresplayground.blocks.machines.RadioisotopicGeneratorTileEntityRenderer;
import net.thenumenorean.hellfiresplayground.blocks.machines.replicator.ReplicatorItemRenderer;
import net.thenumenorean.hellfiresplayground.blocks.machines.replicator.ReplicatorTileEntity;
import net.thenumenorean.hellfiresplayground.blocks.machines.replicator.ReplicatorTileEntityRenderer;
import net.thenumenorean.hellfiresplayground.entities.projectiles.EntityPhaserBolt;
import net.thenumenorean.hellfiresplayground.entities.projectiles.PhaserBoltRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {

		ClientRegistry.bindTileEntitySpecialRenderer(LaserElectronManipulatorTileEntity.class,
				new LaserElectronManipulatorTileEntityRenderer());
		MinecraftForgeClient.registerItemRenderer(HellfiresPlaygroundBlocks.laser_electron_manipulator.blockID,
				new LaserElectronManipulatorItemRenderer());

		ClientRegistry
				.bindTileEntitySpecialRenderer(RadioisotopicGeneratorTileEntity.class, new RadioisotopicGeneratorTileEntityRenderer());
		MinecraftForgeClient.registerItemRenderer(HellfiresPlaygroundBlocks.radioisotopic_generator.blockID, new RadioisotopicGeneratorItemRenderer());

		ClientRegistry.bindTileEntitySpecialRenderer(PhaserDrillTileEntity.class, new PhaserDrillTileEntityRenderer());
		MinecraftForgeClient.registerItemRenderer(HellfiresPlaygroundBlocks.phaser_drill.blockID, new PhaserDrillItemRenderer());

		ClientRegistry.bindTileEntitySpecialRenderer(ReplicatorTileEntity.class, new ReplicatorTileEntityRenderer());
		MinecraftForgeClient.registerItemRenderer(HellfiresPlaygroundBlocks.replicator.blockID, new ReplicatorItemRenderer());

		RenderingRegistry.registerEntityRenderingHandler(EntityPhaserBolt.class, new PhaserBoltRenderer());
	}

}