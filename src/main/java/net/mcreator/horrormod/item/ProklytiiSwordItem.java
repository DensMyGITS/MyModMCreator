
package net.mcreator.horrormod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.horrormod.HorrormodModElements;

@HorrormodModElements.ModElement.Tag
public class ProklytiiSwordItem extends HorrormodModElements.ModElement {
	@ObjectHolder("horrormod:proklytii_sword")
	public static final Item block = null;

	public ProklytiiSwordItem(HorrormodModElements instance) {
		super(instance, 267);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return -1f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 21;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(ProklytiiMetallIngotItem.block));
			}
		}, 3, -3f, new Item.Properties().group(null)) {
		}.setRegistryName("proklytii_sword"));
	}
}
