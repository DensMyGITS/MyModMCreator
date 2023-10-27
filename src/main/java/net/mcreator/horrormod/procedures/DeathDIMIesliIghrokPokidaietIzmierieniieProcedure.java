package net.mcreator.horrormod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.horrormod.item.KeysforOPENCRAFTGUIEXITBLOCKItem;
import net.mcreator.horrormod.item.Death_DustSwordItem;
import net.mcreator.horrormod.item.Death_DustShovelItem;
import net.mcreator.horrormod.item.Death_DustPickaxeItem;
import net.mcreator.horrormod.item.Death_DustHoeItem;
import net.mcreator.horrormod.item.Death_DustAxeItem;
import net.mcreator.horrormod.item.Death_DustArmorItem;
import net.mcreator.horrormod.block.TrofeiBlock;
import net.mcreator.horrormod.block.Trofei2Block;
import net.mcreator.horrormod.HorrormodMod;

import java.util.Map;

public class DeathDIMIesliIghrokPokidaietIzmierieniieProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HorrormodMod.LOGGER.warn("Failed to load dependency entity for procedure DeathDIMIesliIghrokPokidaietIzmierieniie!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack pickaxe = ItemStack.EMPTY;
		BlockState wheatBlock = Blocks.AIR.getDefaultState();
		double EnchtSize = 0;
		double i = 0;
		double j = 0;
		double k = 0;
		double raytrace_y = 0;
		double raytrace_x = 0;
		double raytrace_z = 0;
		if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(Death_DustArmorItem.helmet);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 54,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(Death_DustArmorItem.body);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 54,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(Death_DustArmorItem.legs);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 54,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(Death_DustArmorItem.boots);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 54,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(Death_DustSwordItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 54,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(Death_DustAxeItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 54,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(Death_DustPickaxeItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 54,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(Death_DustHoeItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 54,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(Death_DustShovelItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 54,
						((PlayerEntity) entity).container.func_234641_j_());
			}
		}
		if ((entity.world.getDimensionKey()) == (World.OVERWORLD)
				&& !((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(TrofeiBlock.block)) : false)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(TrofeiBlock.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
		if ((entity.world.getDimensionKey()) == (World.OVERWORLD)
				&& !((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Trofei2Block.block)) : false)
				&& ((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(KeysforOPENCRAFTGUIEXITBLOCKItem.block))
						: false)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(Trofei2Block.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
	}
}
