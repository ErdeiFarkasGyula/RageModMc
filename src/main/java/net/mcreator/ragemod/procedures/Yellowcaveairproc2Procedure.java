package net.mcreator.ragemod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class Yellowcaveairproc2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double zs = 0;
		double ys = 0;
		double xs = 0;
		if (y <= 40) {
			zs = -32;
			for (int index0 = 0; index0 < (int) (64); index0++) {
				xs = -32;
				for (int index1 = 0; index1 < (int) (64); index1++) {
					ys = -8;
					for (int index2 = 0; index2 < (int) (16); index2++) {
						ys = ys + 1;
						YellowcaveairtickProcedure.execute(world, (x + xs), (y + ys), (z + zs));
					}
					xs = xs + 1;
				}
				zs = zs + 1;
			}
		}
		world.setBlock(new BlockPos((int) x, (int) y, (int) z), Blocks.STONE.defaultBlockState(), 3);
	}
}
