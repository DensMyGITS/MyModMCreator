
package net.mcreator.horrormod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.horrormod.item.Death_DustSwordItem;
import net.mcreator.horrormod.HorrormodModElements;

@HorrormodModElements.ModElement.Tag
public class ToolsItemGroup extends HorrormodModElements.ModElement {
	public ToolsItemGroup(HorrormodModElements instance) {
		super(instance, 131);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtools") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Death_DustSwordItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
