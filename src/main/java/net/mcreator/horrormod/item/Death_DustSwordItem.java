
package net.mcreator.horrormod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.player.PlayerEntity;

import net.mcreator.horrormod.procedures.DeathDustSwordPriNazhatiiPravoiKnopkoiMyshiProcedure;
import net.mcreator.horrormod.itemgroup.ToolsItemGroup;
import net.mcreator.horrormod.HorrormodModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

@HorrormodModElements.ModElement.Tag
public class Death_DustSwordItem extends HorrormodModElements.ModElement {
	@ObjectHolder("horrormod:death_dust_sword")
	public static final Item block = null;

	public Death_DustSwordItem(HorrormodModElements instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 700;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 6;
			}

			public int getEnchantability() {
				return 42;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DeadIngotItem.block));
			}
		}, 3, -2f, new Item.Properties().group(ToolsItemGroup.tab)) {
			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = retval.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				DeathDustSwordPriNazhatiiPravoiKnopkoiMyshiProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}.setRegistryName("death_dust_sword"));
	}
}
