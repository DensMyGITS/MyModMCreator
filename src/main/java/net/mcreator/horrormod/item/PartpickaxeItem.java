
package net.mcreator.horrormod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.horrormod.HorrormodModElements;

@HorrormodModElements.ModElement.Tag
public class PartpickaxeItem extends HorrormodModElements.ModElement {
	@ObjectHolder("horrormod:partpickaxe")
	public static final Item block = null;

	public PartpickaxeItem(HorrormodModElements instance) {
		super(instance, 330);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(null).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("partpickaxe");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
