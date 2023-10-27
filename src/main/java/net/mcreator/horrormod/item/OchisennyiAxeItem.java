
package net.mcreator.horrormod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.horrormod.HorrormodModElements;

@HorrormodModElements.ModElement.Tag
public class OchisennyiAxeItem extends HorrormodModElements.ModElement {
	@ObjectHolder("horrormod:ochisennyi_axe")
	public static final Item block = null;

	public OchisennyiAxeItem(HorrormodModElements instance) {
		super(instance, 319);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2380;
			}

			public float getEfficiency() {
				return 16f;
			}

			public float getAttackDamage() {
				return 8f;
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
		}, 1, -3f, new Item.Properties().group(null)) {
		}.setRegistryName("ochisennyi_axe"));
	}
}
