
package net.mcreator.horrormod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

import net.mcreator.horrormod.itemgroup.ToolsItemGroup;
import net.mcreator.horrormod.HorrormodModElements;

@HorrormodModElements.ModElement.Tag
public class Death_DustHoeItem extends HorrormodModElements.ModElement {
	@ObjectHolder("horrormod:death_dust_hoe")
	public static final Item block = null;

	public Death_DustHoeItem(HorrormodModElements instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 500;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 6;
			}

			public int getEnchantability() {
				return 42;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Death_DustDustItem.block));
			}
		}, 0, -3f, new Item.Properties().group(ToolsItemGroup.tab)) {
		}.setRegistryName("death_dust_hoe"));
	}
}
