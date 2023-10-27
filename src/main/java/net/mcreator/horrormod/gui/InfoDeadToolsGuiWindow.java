
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
public class InfoDeadToolsGuiWindow extends ContainerScreen<InfoDeadToolsGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = InfoDeadToolsGui.guistate;

	public InfoDeadToolsGuiWindow(InfoDeadToolsGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 0;
		this.ySize = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("horrormod:textures/screens/info_dead_tools.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/death_dust_sword.png"));
		this.blit(ms, this.guiLeft + -55, this.guiTop + -44, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/death_dust_axe.png"));
		this.blit(ms, this.guiLeft + -55, this.guiTop + -34, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/death_dust_pickaxe.png"));
		this.blit(ms, this.guiLeft + -55, this.guiTop + -24, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/death_dust_hoe.png"));
		this.blit(ms, this.guiLeft + -55, this.guiTop + -14, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/death_dust_shovel.png"));
		this.blit(ms, this.guiLeft + -55, this.guiTop + -5, 0, 0, 8, 8, 8, 8);

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
		this.font.drawString(ms,
				"\u0418\u043D\u0441\u0442\u0440\u0443\u043C\u0435\u043D\u0442\u044B \u043C\u0435\u0440\u0442\u0432\u0435\u0446\u0430", -50, -71,
				-12829636);
		this.font.drawString(ms, "\u0415\u0441\u0442\u044C 5 \u0442\u0438\u043F\u043E\u0432 \u0438\u043D\u0441\u0442\u0440-\u0432:", -55, -56,
				-12829636);
		this.font.drawString(ms, "\u041C\u0435\u0447 \u041C\u0435\u0440\u0442\u0432\u0435\u0446\u0430", -44, -45, -12829636);
		this.font.drawString(ms, "\u0422\u043E\u043F\u043E\u0440 \u041C\u0435\u0440\u0442\u0432\u0435\u0446\u0430", -44, -35, -12829636);
		this.font.drawString(ms, "\u041A\u0438\u0440\u043A\u0430 \u041C\u0435\u0440\u0442\u0432\u0435\u0446\u0430", -44, -25, -12829636);
		this.font.drawString(ms, "\u041C\u043E\u0442\u044B\u0433\u0430 \u041C\u0435\u0440\u0442\u0432\u0435\u0446\u0430", -44, -15, -12829636);
		this.font.drawString(ms, "\u041B\u043E\u043F\u0430\u0442\u0430 \u041C\u0435\u0440\u0442\u0432\u0435\u0446\u0430", -44, -6, -12829636);
		this.font.drawString(ms, "\u0422\u043E\u043B\u044C\u043A\u043E \u043E\u0434\u0438\u043D \u043F\u0440\u0435\u0434\u043C\u0435\u0442", -55, 7,
				-12829636);
		this.font.drawString(ms, "\u0438\u043C\u0435\u0435\u0442 \u0441\u043F\u043E\u0441\u043E\u0431\u043D\u043E\u0441\u0442\u044C", -56, 17,
				-12829636);
		this.font.drawString(ms, "\u042D\u0442\u043E \u041C\u0435\u0447 \u043C\u0435\u0440\u0442\u0432\u0435\u0446\u0430 -", -56, 29, -12829636);
		this.font.drawString(ms,
				"\u041F\u0440\u0438 \u043D\u0430\u0436\u0430\u0442\u0438\u0438 \u041F\u041A\u041C \u0432\u044B\u043F\u0443\u0441\u043A\u0430\u0435\u0442",
				-57, 39, -12829636);
		this.font.drawString(ms, "\u0427\u0435\u0440\u0435\u043F \u0412\u0438\u0437\u0435\u0440-\u0421\u043A\u0435\u043B\u0435\u0442\u0430", -56, 50,
				-12829636);
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
		this.addButton(new Button(this.guiLeft + -72, this.guiTop + 77, 30, 20, new StringTextComponent("<"), e -> {
			if (true) {
				HorrormodMod.PACKET_HANDLER.sendToServer(new InfoDeadToolsGui.ButtonPressedMessage(0, x, y, z));
				InfoDeadToolsGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 44, this.guiTop + 77, 30, 20, new StringTextComponent(">"), e -> {
			if (true) {
				HorrormodMod.PACKET_HANDLER.sendToServer(new InfoDeadToolsGui.ButtonPressedMessage(1, x, y, z));
				InfoDeadToolsGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
