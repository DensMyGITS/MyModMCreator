package net.mcreator.horrormod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.horrormod.HorrormodMod;

import java.util.Map;

public class OsvobProcProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HorrormodMod.LOGGER.warn("Failed to load dependency entity for procedure OsvobProc!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("horrormod:dimprokl")))) {
			if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0) == 20) {
				while (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0) == 20) {
					if (entity instanceof PlayerEntity) {
						((PlayerEntity) entity).giveExperiencePoints((int) -1);
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
						RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
								new ResourceLocation("horrormod:death_dim"));
						ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
						if (nextWorld != null) {
							((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
							((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
									nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
							((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
							for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
							}
							((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
						}
					}
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
							"\u0412\u044B \u0432\u044B\u0431\u0440\u0430\u043B\u0438\u0441\u044C \u0438\u0437 \u043C\u0438\u0440\u0430 \u043F\u0440\u043E\u043A\u043B\u044F\u0442\u044B\u0445! \u0410 \u0442\u0435\u043F\u0435\u0440\u044C \u0432\u044B\u0431\u0435\u0440\u0435\u0442\u0435\u0441\u044C \u0432 \u043E\u0431\u044B\u0447\u043D\u044B\u0439 \u043C\u0438\u0440 \u0438\u0437 \u044D\u0442\u043E\u0433\u043E \u043C\u0438\u0440\u0430 :)"),
							(false));
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
							"\u041D\u0435\u0434\u043E\u0441\u0442\u0430\u0442\u043E\u0447\u043D\u043E \u043E\u043F\u044B\u0442\u0430! \u041D\u0443\u0436\u043D\u043E 20!"),
							(false));
				}
			}
		}
	}
}
