package net.mcreator.horrormod.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.horrormod.block.TrofeiBlock;
import net.mcreator.horrormod.HorrormodMod;

import java.util.Map;

public class Posle1PobegyaProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HorrormodMod.LOGGER.warn("Failed to load dependency entity for procedure Posle1Pobegya!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(TrofeiBlock.block)) : false) {
			return true;
		}
		return false;
	}
}
