package net.mcreator.ragemod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.ragemod.init.RagemodModMobEffects;
import net.mcreator.ragemod.init.RagemodModGameRules;
import net.mcreator.ragemod.entity.SavragerobiEntity;
import net.mcreator.ragemod.entity.Mob1Entity;

public class Savmobcloseproc1Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (true == world.getLevelData().getGameRules().getBoolean(RagemodModGameRules.TOXICGIVESYOUBADEFFECTS)
				&& !(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(RagemodModMobEffects.SAVELLENALLAS) : false) && (new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
						} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft
									.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
						}
						return false;
					}
				}.checkGamemode(entity) || new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
						} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId())
											.getGameMode() == GameType.ADVENTURE;
						}
						return false;
					}
				}.checkGamemode(entity))) {
			if (!world.getEntitiesOfClass(Mob1Entity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 2, 2, 2),
					e -> true).isEmpty()
					|| !world.getEntitiesOfClass(SavragerobiEntity.class,
							AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 2, 2, 2), e -> true).isEmpty()) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 1, (false), (false)));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 20, 1, (false), (false)));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 20, 1, (false), (false)));
			}
		}
	}
}
