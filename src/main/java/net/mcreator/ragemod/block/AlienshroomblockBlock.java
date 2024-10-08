
package net.mcreator.ragemod.block;

import net.minecraftforge.common.IPlantable;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.ragemod.init.RagemodModParticles;

import java.util.Random;
import java.util.List;
import java.util.Collections;

public class AlienshroomblockBlock extends Block {
	public AlienshroomblockBlock() {
		super(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.CORAL_BLOCK).strength(0.7f, 2f).lightLevel(s -> 7).noCollission()
				.speedFactor(1.1f).jumpFactor(1.1f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true));
		setRegistryName("alienshroomblock");
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction direction, IPlantable plantable) {
		return true;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(BlockState blockstate, Level world, BlockPos pos, Random random) {
		super.animateTick(blockstate, world, pos, random);
		Player entity = Minecraft.getInstance().player;
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		for (int l = 0; l < 2; ++l) {
			double x0 = x + random.nextFloat();
			double y0 = y + random.nextFloat();
			double z0 = z + random.nextFloat();
			double dx = (random.nextFloat() - 0.5D) * 0.3999999985098839D;
			double dy = (random.nextFloat() - 0.5D) * 0.3999999985098839D;
			double dz = (random.nextFloat() - 0.5D) * 0.3999999985098839D;
			world.addParticle(RagemodModParticles.ALIENPLANTPARTICLE, x0, y0, z0, dx, dy, dz);
		}
	}
}
