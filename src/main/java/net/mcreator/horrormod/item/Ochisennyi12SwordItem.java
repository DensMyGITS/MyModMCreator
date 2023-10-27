
package net.mcreator.horrormod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.horrormod.HorrormodModElements;

@HorrormodModElements.ModElement.Tag
public class Ochisennyi12SwordItem extends HorrormodModElements.ModElement {
	@ObjectHolder("horrormod:ochisennyi_12_sword")
	public static final Item block = null;

	public Ochisennyi12SwordItem(HorrormodModElements instance) {
		super(instance, 325);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2380;
			}

			public float getEfficiency() {
				return 16f;
			}

			public float getAttackDamage() {
				return 28f;
			}

			public int getHarvestLevel() {
				return 10;
			}

			public int getEnchantability() {
				return 70;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(OchisennyiSvyatoiSlitokIngotItem.block));
			}
		}, 3, -3f, new Item.Properties().group(null)) {
		}.setRegistryName("ochisennyi_12_sword"));
	}
}
