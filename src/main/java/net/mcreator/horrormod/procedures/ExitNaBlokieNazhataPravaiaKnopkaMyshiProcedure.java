package net.mcreator.horrormod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.state.Property;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.BlockState;

import net.mcreator.horrormod.item.KeyItem;
import net.mcreator.horrormod.block.ExitblockwithKEY1Block;
import net.mcreator.horrormod.HorrormodMod;

import java.util.Map;

public class ExitNaBlokieNazhataPravaiaKnopkaMyshiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HorrormodMod.LOGGER.warn("Failed to load dependency world for procedure ExitNaBlokieNazhataPravaiaKnopkaMyshi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HorrormodMod.LOGGER.warn("Failed to load dependency x for procedure ExitNaBlokieNazhataPravaiaKnopkaMyshi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HorrormodMod.LOGGER.warn("Failed to load dependency y for procedure ExitNaBlokieNazhataPravaiaKnopkaMyshi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HorrormodMod.LOGGER.warn("Failed to load dependency z for procedure ExitNaBlokieNazhataPravaiaKnopkaMyshi!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HorrormodMod.LOGGER.warn("Failed to load dependency entity for procedure ExitNaBlokieNazhataPravaiaKnopkaMyshi!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("horrormod:death_dim")))) {
				if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == KeyItem.block) {
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(KeyItem.block);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) entity).container.func_234641_j_());
					}
					{
						BlockPos _bp = new BlockPos(x, y, z);
						BlockState _bs = ExitblockwithKEY1Block.block.getDefaultState();
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
				} else {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
								"say \u0423 \u0432\u0430\u0441 \u043D\u0435\u0442 \u043A\u043B\u044E\u0447\u0430!");
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos(x, y, z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chest.locked")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chest.locked")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
				}
			}
		}
	}
}
