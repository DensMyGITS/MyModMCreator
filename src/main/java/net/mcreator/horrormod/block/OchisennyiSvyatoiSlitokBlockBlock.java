
package net.mcreator.horrormod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.horrormod.itemgroup.DeadModItemGroup;
import net.mcreator.horrormod.HorrormodModElements;

import java.util.List;
import java.util.Collections;

@HorrormodModElements.ModElement.Tag
public class OchisennyiSvyatoiSlitokBlockBlock extends HorrormodModElements.ModElement {
	@ObjectHolder("horrormod:ochisennyi_svyatoi_slitok_block")
	public static final Block block = null;

	public OchisennyiSvyatoiSlitokBlockBlock(HorrormodModElements instance) {
		super(instance, 220);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(DeadModItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(5f, 10f).setLightLevel(s -> 0).harvestLevel(10)
					.harvestTool(ToolType.PICKAXE).setRequiresTool());
			setRegistryName("ochisennyi_svyatoi_slitok_block");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
