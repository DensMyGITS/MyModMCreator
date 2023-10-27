package net.mcreator.horrormod.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.Mirror;
import net.minecraft.state.Property;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.horrormod.item.DeathDIMItem;
import net.mcreator.horrormod.block.KEY5Block;
import net.mcreator.horrormod.block.ExitBlock;
import net.mcreator.horrormod.HorrormodMod;

import java.util.Map;

public class KEY5NaBlokieNazhataPravaiaKnopkaMyshiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HorrormodMod.LOGGER.warn("Failed to load dependency world for procedure KEY5NaBlokieNazhataPravaiaKnopkaMyshi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HorrormodMod.LOGGER.warn("Failed to load dependency x for procedure KEY5NaBlokieNazhataPravaiaKnopkaMyshi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HorrormodMod.LOGGER.warn("Failed to load dependency y for procedure KEY5NaBlokieNazhataPravaiaKnopkaMyshi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HorrormodMod.LOGGER.warn("Failed to load dependency z for procedure KEY5NaBlokieNazhataPravaiaKnopkaMyshi!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HorrormodMod.LOGGER.warn("Failed to load dependency entity for procedure KEY5NaBlokieNazhataPravaiaKnopkaMyshi!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		{
			BlockPos _bp = new BlockPos(x, y, z);
			BlockState _bs = KEY5Block.block.getDefaultState();
			BlockState _bso = world.getBlockState(_bp);
			for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
				Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
				if (_property != null && _bs.get(_property) != null)
					try {
						_bs = _bs.with(_property, (Comparable) entry.getValue());
					} catch (Exception e) {
					}
			}
			world.setBlockState(_bp, _bs, 3);
		}
		if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0) <= 15) {
			if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == KEY5Block.block) {
				world.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState(), 3);
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
							"\u041D\u0435\u0434\u043E\u0441\u0442\u0430\u0442\u043E\u0447\u043D\u043E \u043E\u043F\u044B\u0442\u0430! \u041D\u0443\u0436\u043D\u043E 20 \u043E\u043F\u044B\u0442\u0430!"),
							(false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("ERROR!"), (false));
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
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("ERROR!"), (false));
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
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("ERROR!"), (false));
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
										{
											Entity _ent = entity;
											if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
												RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
														new ResourceLocation("horrormod:dimprokl"));
												ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
												if (nextWorld != null) {
													((ServerPlayerEntity) _ent).connection
															.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
													((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
															nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
															_ent.rotationPitch);
													((ServerPlayerEntity) _ent).connection
															.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
													for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
														((ServerPlayerEntity) _ent).connection
																.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
													}
													((ServerPlayerEntity) _ent).connection
															.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
												}
											}
										}
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
													"\u041E\u0442\u043A\u0440\u044B\u0442 \u043D\u043E\u0432\u044B\u0439 \u043C\u0438\u0440! \u041C\u0438\u0440 \u043F\u0440\u043E\u043A\u043B\u044F\u0442\u044B\u0445!"),
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
										}.start(world, (int) 10);
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) 20);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 20);
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 20);
			}
		} else if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0) >= 20) {
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos(x, y, z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.ambient")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.ambient")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
			if (world instanceof ServerWorld) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("horrormod", "deathstr"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world, new BlockPos(x, y, z),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
							((World) world).rand);
				}
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(DeathDIMItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
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
					world.setBlockState(new BlockPos(x, y, z), ExitBlock.block.getDefaultState(), 3);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		}
	}
}
