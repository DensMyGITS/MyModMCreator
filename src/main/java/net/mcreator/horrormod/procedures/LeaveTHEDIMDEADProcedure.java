package net.mcreator.horrormod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.server.MinecraftServer;
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
import java.util.HashMap;

public class LeaveTHEDIMDEADProcedure {
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
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HorrormodMod.LOGGER.warn("Failed to load dependency world for procedure LeaveTHEDIMDEAD!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HorrormodMod.LOGGER.warn("Failed to load dependency entity for procedure LeaveTHEDIMDEAD!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (!(((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("horrormod:find_to_special_key")))
						.isDone()
				: false)) {
			if ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
					? ((ServerPlayerEntity) entity).getAdvancements()
							.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("horrormod:leavethe_deaddim")))
							.isDone()
					: false)
					&& (entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
							new ResourceLocation("horrormod:death_dim")))) {
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
						RegistryKey<World> destinationType = World.OVERWORLD;
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
							"\u0414\u043E\u0441\u0442\u0443\u043F \u0432 \u041C\u0438\u0440 \u041C\u0451\u0440\u0442\u0432\u044B\u0445 \u0437\u0430\u043A\u0440\u044B\u0442!"),
							(false));
				}
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private IWorld world;

					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
									"[\u041A\u043D\u0438\u0433\u0430 \u041C\u0435\u0440\u0442\u0432\u0435\u0446\u0430] \u0414\u043E\u0441\u0442\u0443\u043F\u043D\u0430 \u043D\u043E\u0432\u0430\u044F \u0438\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0438\u044F!"),
									(false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 20);
			}
		}
	}
}
