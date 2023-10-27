
package net.mcreator.horrormod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.horrormod.item.DeadBoneItem;
import net.mcreator.horrormod.HorrormodModElements;

@HorrormodModElements.ModElement.Tag
public class ItemsItemGroup extends HorrormodModElements.ModElement {
	public ItemsItemGroup(HorrormodModElements instance) {
		super(instance, 132);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabitems") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(DeadBoneItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
