
package net.mcreator.horrormod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.horrormod.itemgroup.ItemsItemGroup;
import net.mcreator.horrormod.HorrormodModElements;

@HorrormodModElements.ModElement.Tag
public class KeyItem extends HorrormodModElements.ModElement {
	@ObjectHolder("horrormod:key")
	public static final Item block = null;

	public KeyItem(HorrormodModElements instance) {
		super(instance, 49);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemsItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("key");
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
