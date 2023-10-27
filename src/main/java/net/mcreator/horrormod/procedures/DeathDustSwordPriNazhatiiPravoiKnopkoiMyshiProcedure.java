package net.mcreator.horrormod.procedures;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import net.mcreator.horrormod.HorrormodMod;

import java.util.Random;
import java.util.Map;

public class DeathDustSwordPriNazhatiiPravoiKnopkoiMyshiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HorrormodMod.LOGGER.warn("Failed to load dependency entity for procedure DeathDustSwordPriNazhatiiPravoiKnopkoiMyshi!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				HorrormodMod.LOGGER.warn("Failed to load dependency itemstack for procedure DeathDustSwordPriNazhatiiPravoiKnopkoiMyshi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		{
			Entity _shootFrom = entity;
			World projectileLevel = _shootFrom.world;
			if (!projectileLevel.isRemote()) {
				ProjectileEntity _entityToSpawn = new WitherSkullEntity(EntityType.WITHER_SKULL, projectileLevel);
				_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
				_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
				projectileLevel.addEntity(_entityToSpawn);
			}
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 100);
		{
			ItemStack _ist = itemstack;
			if (_ist.attemptDamageItem((int) 5, new Random(), null)) {
				_ist.shrink(1);
				_ist.setDamage(0);
			}
		}
	}
}
