package net.mcreator.horrormod.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.horrormod.item.ProklytayaArmorItem;
import net.mcreator.horrormod.HorrormodMod;

import java.util.Map;

public class HELMETPROKLOtobrazhatOvierlieiVIghrieProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HorrormodMod.LOGGER.warn("Failed to load dependency entity for procedure HELMETPROKLOtobrazhatOvierlieiVIghrie!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD) : ItemStack.EMPTY)
				.getItem() == ProklytayaArmorItem.helmet) {
			return true;
		}
		return false;
	}
}
