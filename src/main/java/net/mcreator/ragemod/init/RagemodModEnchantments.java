
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ragemod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.ragemod.enchantment.VedelemplusEnchantment;
import net.mcreator.ragemod.enchantment.PingvinhunenchantEnchantment;
import net.mcreator.ragemod.enchantment.LifeStealerEnchantment;
import net.mcreator.ragemod.enchantment.ColliderEnchantment;
import net.mcreator.ragemod.enchantment.BlockLockEnchantment;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RagemodModEnchantments {
	private static final List<Enchantment> REGISTRY = new ArrayList<>();
	public static final Enchantment PINGVINHUNENCHANT = register("ragemod:pingvinhunenchant", new PingvinhunenchantEnchantment());
	public static final Enchantment VEDELEMPLUS = register("ragemod:vedelemplus", new VedelemplusEnchantment());
	public static final Enchantment LIFE_STEALER = register("ragemod:life_stealer", new LifeStealerEnchantment());
	public static final Enchantment COLLIDER = register("ragemod:collider", new ColliderEnchantment());
	public static final Enchantment BLOCK_LOCK = register("ragemod:block_lock", new BlockLockEnchantment());

	private static Enchantment register(String registryname, Enchantment enchantment) {
		REGISTRY.add(enchantment.setRegistryName(registryname));
		return enchantment;
	}

	@SubscribeEvent
	public static void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Enchantment[0]));
	}
}
