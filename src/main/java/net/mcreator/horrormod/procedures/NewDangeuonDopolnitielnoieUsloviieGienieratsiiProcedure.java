package net.mcreator.horrormod.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;

import net.mcreator.horrormod.HorrormodMod;

import java.util.Map;

public class NewDangeuonDopolnitielnoieUsloviieGienieratsiiProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HorrormodMod.LOGGER.warn("Failed to load dependency world for procedure NewDangeuonDopolnitielnoieUsloviieGienieratsii!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (!((world instanceof World) ? ((World) world).isDaytime() : false)) {
			return true;
		}
		return false;
	}
}
