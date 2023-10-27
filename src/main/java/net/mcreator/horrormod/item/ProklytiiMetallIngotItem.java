
package net.mcreator.horrormod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.horrormod.HorrormodModElements;

@HorrormodModElements.ModElement.Tag
public class ProklytiiMetallIngotItem extends HorrormodModElements.ModElement {
	@ObjectHolder("horrormod:proklytii_metall_ingot")
	public static final Item block = null;

	public ProklytiiMetallIngotItem(HorrormodModElements instance) {
		super(instance, 208);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(null).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("proklytii_metall_ingot");
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
