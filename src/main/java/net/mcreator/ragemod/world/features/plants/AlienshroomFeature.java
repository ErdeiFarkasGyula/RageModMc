
package net.mcreator.ragemod.world.features.plants;

import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.HeightmapConfiguration;
import net.minecraft.world.level.levelgen.feature.blockplacers.SimpleBlockPlacer;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.DefaultFlowerFeature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;

import net.mcreator.ragemod.init.RagemodModBlocks;

import java.util.Set;

public class AlienshroomFeature extends DefaultFlowerFeature {
	public static final AlienshroomFeature FEATURE = (AlienshroomFeature) new AlienshroomFeature().setRegistryName("ragemod:alien_shroom");
	public static final ConfiguredFeature<?, ?> CONFIGURED_FEATURE = FEATURE
			.configured(
					new RandomPatchConfiguration.GrassConfigurationBuilder(new SimpleStateProvider(RagemodModBlocks.ALIEN_SHROOM.defaultBlockState()),
							SimpleBlockPlacer.INSTANCE).tries(100)

									.build())
			.decorated(FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING))).squared().rarity(32)
			.count(40);
	public static final Set<ResourceLocation> GENERATE_BIOMES = null;

	public AlienshroomFeature() {
		super(RandomPatchConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<RandomPatchConfiguration> context) {
		WorldGenLevel world = context.level();
		ResourceKey<Level> dimensionType = world.getLevel().dimension();
		boolean dimensionCriteria = false;
		if (dimensionType == ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("ragemod:alien_dimension_portal_igniter")))
			dimensionCriteria = true;
		if (!dimensionCriteria)
			return false;
		return super.place(context);
	}
}
