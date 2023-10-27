
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
public class Page3GuiWindow extends ContainerScreen<Page3Gui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = Page3Gui.guistate;

	public Page3GuiWindow(Page3Gui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 0;
		this.ySize = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("horrormod:textures/screens/page_3.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/arrowforcg.png"));
		this.blit(ms, this.guiLeft + 40, this.guiTop + 65, 0, 0, 11, 7, 11, 7);

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
		this.font.drawString(ms, "\u0414\u0430\u043D\u0436 1 (\u0441 \u043A\u043B\u044E\u0447\u043E\u043C)", -43, -70, -12829636);
		this.font.drawString(ms, "\u042D\u0442\u043E \u0434\u0430\u043D\u0436 \u0433\u0434\u0435 \u0432\u0430\u043C \u043F\u0440\u0435\u0434-", -57,
				-31, -12829636);
		this.font.drawString(ms, "-\u0441\u0442\u043E\u0438\u0442 \u043D\u0430\u0439\u0442\u0438 \u043A\u043B\u044E\u0447 \u043E\u0442", -57, -21,
				-12829636);
		this.font.drawString(ms, "\u0432\u044B\u0445\u043E\u0434\u0430 \u0438\u0437 \u044D\u0442\u043E\u0433\u043E \u043C\u0435\u0441\u0442\u0430",
				-56, -12, -12829636);
		this.font.drawString(ms, "\u041D\u043E \u0432\u044B \u043D\u0435 \u0441\u043C\u043E\u0436\u0435\u0442\u0435 \u043F\u043E\u043A\u0438-", -56,
				1, -12829636);
		this.font.drawString(ms, "-\u043D\u0443\u0442\u044C \u044D\u0442\u043E \u043C\u0435\u0441\u0442\u043E \u0435\u0441\u043B\u0438", -54, 11,
				-12829636);
		this.font.drawString(ms,
				"\u043D\u0435 \u043D\u0430\u0439\u0434\u0435\u0442\u0435 \u0432\u0442\u043E\u0440\u043E\u0439 \u0434\u0430\u043D\u0436, ", -58, 21,
				-12829636);
		this.font.drawString(ms,
				"\u0432 \u043A\u043E\u0442\u043E\u0440\u043E\u043C \u043D\u0430\u0445\u043E\u0434\u0438\u0442\u0441\u044F \u0432\u044B-", -58, 32,
				-12829636);
		this.font.drawString(ms, "\u0445\u043E\u0434...", -57, 42, -12829636);
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
		this.addButton(new Button(this.guiLeft + 50, this.guiTop + 79, 30, 20, new StringTextComponent(">"), e -> {
			if (true) {
				HorrormodMod.PACKET_HANDLER.sendToServer(new Page3Gui.ButtonPressedMessage(0, x, y, z));
				Page3Gui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -38, this.guiTop + -55, 77, 20, new StringTextComponent("Посмотреть"), e -> {
			if (true) {
				HorrormodMod.PACKET_HANDLER.sendToServer(new Page3Gui.ButtonPressedMessage(1, x, y, z));
				Page3Gui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -77, this.guiTop + 79, 30, 20, new StringTextComponent("<"), e -> {
			if (true) {
				HorrormodMod.PACKET_HANDLER.sendToServer(new Page3Gui.ButtonPressedMessage(2, x, y, z));
				Page3Gui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
