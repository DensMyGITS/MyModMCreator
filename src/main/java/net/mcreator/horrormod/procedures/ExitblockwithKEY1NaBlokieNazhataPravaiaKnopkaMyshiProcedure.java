package net.mcreator.horrormod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;

import net.mcreator.horrormod.block.KEY2Block;
import net.mcreator.horrormod.HorrormodMod;

import java.util.Map;

public class ExitblockwithKEY1NaBlokieNazhataPravaiaKnopkaMyshiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HorrormodMod.LOGGER.warn("Failed to load dependency world for procedure ExitblockwithKEY1NaBlokieNazhataPravaiaKnopkaMyshi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HorrormodMod.LOGGER.warn("Failed to load dependency x for procedure ExitblockwithKEY1NaBlokieNazhataPravaiaKnopkaMyshi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HorrormodMod.LOGGER.warn("Failed to load dependency y for procedure ExitblockwithKEY1NaBlokieNazhataPravaiaKnopkaMyshi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HorrormodMod.LOGGER.warn("Failed to load dependency z for procedure ExitblockwithKEY1NaBlokieNazhataPravaiaKnopkaMyshi!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		{
			BlockPos _bp = new BlockPos(x, y, z);
			BlockState _bs = KEY2Block.block.getDefaultState();
			world.setBlockState(_bp, _bs, 3);
		}
	}
}
