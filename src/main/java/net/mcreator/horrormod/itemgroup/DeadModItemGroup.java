
package net.mcreator.horrormod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.horrormod.block.DeathblockBlock;
import net.mcreator.horrormod.HorrormodModElements;

@HorrormodModElements.ModElement.Tag
public class DeadModItemGroup extends HorrormodModElements.ModElement {
	public DeadModItemGroup(HorrormodModElements instance) {
		super(instance, 125);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabdead_mod") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(DeathblockBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
