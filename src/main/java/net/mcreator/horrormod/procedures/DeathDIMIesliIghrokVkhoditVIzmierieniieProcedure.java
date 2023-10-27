package net.mcreator.horrormod.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.horrormod.item.Death_DustSwordItem;
import net.mcreator.horrormod.item.DeadBookGUIDEItem;
import net.mcreator.horrormod.HorrormodMod;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;

public class DeathDIMIesliIghrokVkhoditVIzmierieniieProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HorrormodMod.LOGGER.warn("Failed to load dependency world for procedure DeathDIMIesliIghrokVkhoditVIzmierieniie!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HorrormodMod.LOGGER.warn("Failed to load dependency x for procedure DeathDIMIesliIghrokVkhoditVIzmierieniie!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HorrormodMod.LOGGER.warn("Failed to load dependency y for procedure DeathDIMIesliIghrokVkhoditVIzmierieniie!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HorrormodMod.LOGGER.warn("Failed to load dependency z for procedure DeathDIMIesliIghrokVkhoditVIzmierieniie!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HorrormodMod.LOGGER.warn("Failed to load dependency entity for procedure DeathDIMIesliIghrokVkhoditVIzmierieniie!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (!(((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("horrormod:leavethe_deaddim")))
						.isDone()
				: false)) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
						"\u0412\u044B \u043F\u043E\u043F\u0430\u043B\u0438 \u0432 \u041C\u0438\u0440 \u041C\u0451\u0440\u0442\u0432\u044B\u0445!"),
						(false));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
						"\u041E\u0442\u043A\u0440\u043E\u0439\u0442\u0435 \u043A\u043D\u0438\u0433\u0443 \u041C\u0435\u0440\u0442\u0432\u0435\u0446\u0430 \u0438 \u043F\u0440\u043E\u0447\u0438\u0442\u0430\u0439\u0442\u0435 \u0435\u0451"),
						(false));
			}
		}
		if (world instanceof ServerWorld) {
			Template template = ((ServerWorld) world).getStructureTemplateManager()
					.getTemplateDefaulted(new ResourceLocation("horrormod", "platform"));
			if (template != null) {
				template.func_237144_a_((ServerWorld) world, new BlockPos(x, y, z),
						new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
						((World) world).rand);
			}
		}
		if (!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Death_DustSwordItem.block)) : false)) {
			{
				final ItemStack _setstack = new ItemStack(Death_DustSwordItem.block);
				final int _sltid = (int) (0);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		} else if (!((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Death_DustSwordItem.block))
				: false) && !((new Object() {
					public ItemStack getItemStack(int sltid, Entity entity) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
						return _retval.get();
					}
				}.getItemStack((int) (0), entity)).getItem() == (ItemStack.EMPTY).getItem())) {
			{
				final ItemStack _setstack = new ItemStack(Death_DustSwordItem.block);
				final int _sltid = (int) (5);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		}
		if (!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(DeadBookGUIDEItem.block)) : false)) {
			{
				final ItemStack _setstack = new ItemStack(DeadBookGUIDEItem.block);
				final int _sltid = (int) (8);
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
		}
	}
}
