package net.mcreator.horrormod.procedures;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.horrormod.item.ProklytayaArmorItem;
import net.mcreator.horrormod.HorrormodMod;

import java.util.Map;

public class POMEXIOtobrazhatOvierlieiVIghrieProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HorrormodMod.LOGGER.warn("Failed to load dependency entity for procedure POMEXIOtobrazhatOvierlieiVIghrie!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("horrormod:dimprokl")))) {
			while (!(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD) : ItemStack.EMPTY)
					.getItem() == ProklytayaArmorItem.helmet)) {
				return true;
			}
		}
		return false;
	}
}
