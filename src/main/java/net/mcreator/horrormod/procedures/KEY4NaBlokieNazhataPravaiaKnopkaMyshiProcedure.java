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
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
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
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.BlockState;

import net.mcreator.horrormod.item.DeathDIMItem;
import net.mcreator.horrormod.block.KEY5Block;
import net.mcreator.horrormod.HorrormodMod;

import java.util.Map;

public class KEY4NaBlokieNazhataPravaiaKnopkaMyshiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HorrormodMod.LOGGER.warn("Failed to load dependency world for procedure KEY4NaBlokieNazhataPravaiaKnopkaMyshi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HorrormodMod.LOGGER.warn("Failed to load dependency x for procedure KEY4NaBlokieNazhataPravaiaKnopkaMyshi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HorrormodMod.LOGGER.warn("Failed to load dependency y for procedure KEY4NaBlokieNazhataPravaiaKnopkaMyshi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HorrormodMod.LOGGER.warn("Failed to load dependency z for procedure KEY4NaBlokieNazhataPravaiaKnopkaMyshi!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HorrormodMod.LOGGER.warn("Failed to load dependency entity for procedure KEY4NaBlokieNazhataPravaiaKnopkaMyshi!");
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
				if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0) <= 15) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager()
								.handleCommand(new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4,
										"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(), "say ERROR!");
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
							if (world instanceof ServerWorld) {
								((World) world).getServer().getCommandManager()
										.handleCommand(
												new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4,
														"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
												"say ERROR!");
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
									if (world instanceof ServerWorld) {
										((World) world).getServer().getCommandManager().handleCommand(
												new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4,
														"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
												"say ERROR!");
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
																nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(),
																_ent.rotationYaw, _ent.rotationPitch);
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
											if (world instanceof ServerWorld) {
												((World) world).getServer().getCommandManager().handleCommand(
														new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																(ServerWorld) world, 4, "", new StringTextComponent(""), ((World) world).getServer(),
																null).withFeedbackDisabled(),
														"say \u041F\u0420\u041E\u041A\u041B\u042F\u0422\u042B\u0419 \u041C\u0418\u0420");
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 20);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 20);
				} else if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0) >= 20) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"title @s times 20 1 20");
					}
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"title @s title {\"text\":\"\\u0412\\u044b\\u0445\\u043e\\u0434 \\u041e\\u0442\\u043a\\u0440\\u044b\\u0442!\",\"bold\":true,\"color\":\"white\"}");
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world)
								.playSound(null, new BlockPos(x, y, z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("entity.ender_dragon.ambient")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("entity.ender_dragon.ambient")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("horrormod", "portalframe-surfacedone"));
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
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 20);
	}
}
