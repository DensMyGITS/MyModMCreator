package net.mcreator.horrormod.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.horrormod.HorrormodMod;

import java.util.Map;

public class ZidSmertProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HorrormodMod.LOGGER.warn("Failed to load dependency entity for procedure ZidSmert!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof MonsterEntity) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, (int) 1, (int) 5, (false), (false)));
		} else if (entity instanceof PlayerEntity) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
		}
	}
}
