
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
public class Page3WatchingButtonGuiWindow extends ContainerScreen<Page3WatchingButtonGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = Page3WatchingButtonGui.guistate;

	public Page3WatchingButtonGuiWindow(Page3WatchingButtonGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/chast.png"));
		this.blit(ms, this.guiLeft + -474, this.guiTop + -124, 0, 0, 960, 513, 960, 513);

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
				"\u0412 \u044D\u0442\u043E\u043C \u0434\u0430\u043D\u0436\u0435 \u0441\u043F\u0440\u044F\u0442\u0430\u043D \u041A\u043B\u044E\u0447 \u043E\u0442 \u0412\u044B\u0445\u043E\u0434\u0430",
				3, -31, -1);
		this.font.drawString(ms,
				"\u0421\u043E\u0432\u0435\u0442\u0443\u044E \u043F\u0440\u043E\u0432\u0435\u0440\u044F\u0442\u044C \u0432\u0441\u0435 \u0442\u044B\u043A\u0432\u044B",
				24, -18, -1);
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
		this.addButton(new Button(this.guiLeft + 66, this.guiTop + 170, 72, 20, new StringTextComponent("Назад"), e -> {
			if (true) {
				HorrormodMod.PACKET_HANDLER.sendToServer(new Page3WatchingButtonGui.ButtonPressedMessage(0, x, y, z));
				Page3WatchingButtonGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
