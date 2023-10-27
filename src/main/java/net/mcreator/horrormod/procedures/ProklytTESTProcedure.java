package net.mcreator.horrormod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.horrormod.item.ProklytiiSwordItem;
import net.mcreator.horrormod.item.ProklytiiShovelItem;
import net.mcreator.horrormod.item.ProklytiiPickaxeItem;
import net.mcreator.horrormod.item.ProklytiiMetallIngotItem;
import net.mcreator.horrormod.item.ProklytiiHoeItem;
import net.mcreator.horrormod.item.ProklytiiAxeItem;
import net.mcreator.horrormod.item.ProklytayaArmorItem;
import net.mcreator.horrormod.item.Death_DustSwordItem;
import net.mcreator.horrormod.item.Death_DustShovelItem;
import net.mcreator.horrormod.item.Death_DustPickaxeItem;
import net.mcreator.horrormod.item.Death_DustHoeItem;
import net.mcreator.horrormod.item.Death_DustAxeItem;
import net.mcreator.horrormod.item.Death_DustArmorItem;
import net.mcreator.horrormod.item.DeadIngotItem;
import net.mcreator.horrormod.HorrormodMod;

import java.util.Map;
import java.util.HashMap;

public class ProklytTESTProcedure {
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
				HorrormodMod.LOGGER.warn("Failed to load dependency entity for procedure ProklytTEST!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("horrormod:dimprokl")))) {
			while ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(DeadIngotItem.block)) : false) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(DeadIngotItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ProklytiiMetallIngotItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
			if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Death_DustArmorItem.helmet)) : false)
					|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD) : ItemStack.EMPTY)
							.getItem() == Death_DustArmorItem.helmet) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Death_DustArmorItem.helmet);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (entity instanceof LivingEntity) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).inventory.armorInventory.set((int) 3, new ItemStack(ProklytayaArmorItem.helmet));
					else
						((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(ProklytayaArmorItem.helmet));
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			}
			if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Death_DustArmorItem.body)) : false)
					|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST) : ItemStack.EMPTY)
							.getItem() == Death_DustArmorItem.body) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Death_DustArmorItem.body);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (entity instanceof LivingEntity) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).inventory.armorInventory.set((int) 2, new ItemStack(ProklytayaArmorItem.body));
					else
						((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(ProklytayaArmorItem.body));
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			}
			if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Death_DustArmorItem.legs)) : false)
					|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.LEGS) : ItemStack.EMPTY)
							.getItem() == Death_DustArmorItem.legs) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Death_DustArmorItem.legs);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (entity instanceof LivingEntity) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).inventory.armorInventory.set((int) 1, new ItemStack(ProklytayaArmorItem.legs));
					else
						((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(ProklytayaArmorItem.legs));
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			}
			if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Death_DustArmorItem.boots)) : false)
					|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET) : ItemStack.EMPTY)
							.getItem() == Death_DustArmorItem.boots) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Death_DustArmorItem.boots);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (entity instanceof LivingEntity) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).inventory.armorInventory.set((int) 0, new ItemStack(ProklytayaArmorItem.boots));
					else
						((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(ProklytayaArmorItem.boots));
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			}
			if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Death_DustSwordItem.block)) : false) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Death_DustSwordItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ProklytiiSwordItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
			if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Death_DustAxeItem.block)) : false) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Death_DustAxeItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ProklytiiAxeItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
			if ((entity instanceof PlayerEntity)
					? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Death_DustPickaxeItem.block))
					: false) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Death_DustPickaxeItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ProklytiiPickaxeItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
			if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Death_DustHoeItem.block)) : false) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Death_DustHoeItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ProklytiiHoeItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
			if ((entity instanceof PlayerEntity)
					? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Death_DustShovelItem.block))
					: false) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(Death_DustShovelItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ProklytiiShovelItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		}
	}
}
