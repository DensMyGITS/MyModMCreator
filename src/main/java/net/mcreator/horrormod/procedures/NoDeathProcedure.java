package net.mcreator.horrormod.procedures;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.FoodStats;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.horrormod.HorrormodMod;

import java.util.Map;
import java.util.HashMap;

public class NoDeathProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HorrormodMod.LOGGER.warn("Failed to load dependency entity for procedure NoDeath!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("horrormod:dimprokl")))) {
				if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) <= 8) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, (int) 60, (int) 5, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).setHealth((float) 30);
				}
				if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).getFoodStats().getFoodLevel() : 0) < 8) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SATURATION, (int) 60, (int) 30, (false), (false)));
					if (entity instanceof PlayerEntity) {
						ObfuscationReflectionHelper.setPrivateValue(FoodStats.class, ((PlayerEntity) entity).getFoodStats(), (float) 100,
								"field_75125_b");
					}
				}
			}
		}
	}
}
