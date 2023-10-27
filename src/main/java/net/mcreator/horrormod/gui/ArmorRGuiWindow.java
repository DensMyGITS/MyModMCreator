
package net.mcreator.horrormod.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.horrormod.HorrormodMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class ArmorRGuiWindow extends ContainerScreen<ArmorRGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = ArmorRGui.guistate;

	public ArmorRGuiWindow(ArmorRGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 0;
		this.ySize = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("horrormod:textures/screens/armor_r.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/bookbackground.png"));
		this.blit(ms, this.guiLeft + -72, this.guiTop + -85, 0, 0, 146, 180, 146, 180);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/craftgui.png"));
		this.blit(ms, this.guiLeft + -36, this.guiTop + -58, 0, 0, 27, 28, 27, 28);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/arrowforcg.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + -49, 0, 0, 11, 7, 11, 7);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/iron_ingot.png"));
		this.blit(ms, this.guiLeft + -26, this.guiTop + -57, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/bone.png"));
		this.blit(ms, this.guiLeft + -35, this.guiTop + -57, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/bone.png"));
		this.blit(ms, this.guiLeft + -17, this.guiTop + -57, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/iron_ingot.png"));
		this.blit(ms, this.guiLeft + -35, this.guiTop + -48, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/iron_ingot.png"));
		this.blit(ms, this.guiLeft + -17, this.guiTop + -48, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/death_dust_head.png"));
		this.blit(ms, this.guiLeft + 16, this.guiTop + -53, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/craftgui.png"));
		this.blit(ms, this.guiLeft + -36, this.guiTop + -22, 0, 0, 27, 28, 27, 28);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/craftgui.png"));
		this.blit(ms, this.guiLeft + -36, this.guiTop + 14, 0, 0, 27, 28, 27, 28);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/craftgui.png"));
		this.blit(ms, this.guiLeft + -36, this.guiTop + 50, 0, 0, 27, 28, 27, 28);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/arrowforcg.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + -13, 0, 0, 11, 7, 11, 7);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/arrowforcg.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + 23, 0, 0, 11, 7, 11, 7);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/arrowforcg.png"));
		this.blit(ms, this.guiLeft + 0, this.guiTop + 59, 0, 0, 11, 7, 11, 7);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/death_dust_body.png"));
		this.blit(ms, this.guiLeft + 16, this.guiTop + -16, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/bone.png"));
		this.blit(ms, this.guiLeft + -35, this.guiTop + -21, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/bone.png"));
		this.blit(ms, this.guiLeft + -17, this.guiTop + -21, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/death_dust_dust.png"));
		this.blit(ms, this.guiLeft + -26, this.guiTop + -12, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/iron_ingot.png"));
		this.blit(ms, this.guiLeft + -35, this.guiTop + -12, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/iron_ingot.png"));
		this.blit(ms, this.guiLeft + -17, this.guiTop + -12, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/bone.png"));
		this.blit(ms, this.guiLeft + -35, this.guiTop + -3, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/iron_ingot.png"));
		this.blit(ms, this.guiLeft + -26, this.guiTop + -3, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/bone.png"));
		this.blit(ms, this.guiLeft + -17, this.guiTop + -3, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/death_dust_leggings.png"));
		this.blit(ms, this.guiLeft + 16, this.guiTop + 20, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/bone.png"));
		this.blit(ms, this.guiLeft + -35, this.guiTop + 15, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/bone.png"));
		this.blit(ms, this.guiLeft + -17, this.guiTop + 15, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/iron_ingot.png"));
		this.blit(ms, this.guiLeft + -35, this.guiTop + 24, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/iron_ingot.png"));
		this.blit(ms, this.guiLeft + -26, this.guiTop + 15, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/iron_ingot.png"));
		this.blit(ms, this.guiLeft + -17, this.guiTop + 24, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/iron_ingot.png"));
		this.blit(ms, this.guiLeft + -35, this.guiTop + 33, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/iron_ingot.png"));
		this.blit(ms, this.guiLeft + -17, this.guiTop + 33, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/death_dust_boots.png"));
		this.blit(ms, this.guiLeft + 16, this.guiTop + 56, 0, 0, 16, 16, 16, 16);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/bone.png"));
		this.blit(ms, this.guiLeft + -35, this.guiTop + 60, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/bone.png"));
		this.blit(ms, this.guiLeft + -17, this.guiTop + 60, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/iron_ingot.png"));
		this.blit(ms, this.guiLeft + -35, this.guiTop + 69, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/iron_ingot.png"));
		this.blit(ms, this.guiLeft + -17, this.guiTop + 69, 0, 0, 8, 8, 8, 8);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "\u041A\u0440\u0430\u0444\u0442 \u0411\u0440\u043E\u043D\u0438 \u041C\u0435\u0440\u0442\u0432\u0435\u0446\u0430",
				-50, -75, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + -76, this.guiTop + 78, 30, 20, new StringTextComponent("<"), e -> {
			if (true) {
				HorrormodMod.PACKET_HANDLER.sendToServer(new ArmorRGui.ButtonPressedMessage(0, x, y, z));
				ArmorRGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 45, this.guiTop + 78, 30, 20, new StringTextComponent(">"), e -> {
			if (true) {
				HorrormodMod.PACKET_HANDLER.sendToServer(new ArmorRGui.ButtonPressedMessage(1, x, y, z));
				ArmorRGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
