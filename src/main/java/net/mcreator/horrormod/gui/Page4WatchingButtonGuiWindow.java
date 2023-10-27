
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
public class Page4WatchingButtonGuiWindow extends ContainerScreen<Page4WatchingButtonGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = Page4WatchingButtonGui.guistate;

	public Page4WatchingButtonGuiWindow(Page4WatchingButtonGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("horrormod:textures/screens/page_4_watching_button.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/exit2.png"));
		this.blit(ms, this.guiLeft + -369, this.guiTop + -110, 0, 0, 960, 513, 960, 513);

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
				"\u0412\u043E\u0442 \u0442\u0430\u043A \u0432\u044B\u0433\u043B\u044F\u0434\u0438\u0442 \u0434\u0430\u043D\u0436 \u0432 \u043A\u043E\u0442\u043E\u0440\u043E\u043C \u043D\u0430\u0445\u043E\u0434\u0438\u0442\u0441\u044F \u0432\u044B\u0445\u043E\u0434 \u0438\u0437 \u044D\u0442\u043E\u0433\u043E \u043C\u0435\u0441\u0442\u0430",
				-73, -29, -1);
		this.font.drawString(ms,
				"\u0421\u043E\u0432\u0435\u0442\u0443\u044E \u043F\u0440\u043E\u0432\u0435\u0440\u044F\u0442\u044C \u043A\u043E\u0432\u0440\u0438\u043A\u0438",
				34, -16, -1);
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
				HorrormodMod.PACKET_HANDLER.sendToServer(new Page4WatchingButtonGui.ButtonPressedMessage(0, x, y, z));
				Page4WatchingButtonGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
