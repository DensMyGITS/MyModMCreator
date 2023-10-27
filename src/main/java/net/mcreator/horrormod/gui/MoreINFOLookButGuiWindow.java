
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
public class MoreINFOLookButGuiWindow extends ContainerScreen<MoreINFOLookButGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = MoreINFOLookButGui.guistate;

	public MoreINFOLookButGuiWindow(MoreINFOLookButGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 0;
		this.ySize = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("horrormod:textures/screens/more_info_look_but.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/ddd.png"));
		this.blit(ms, this.guiLeft + -414, this.guiTop + -220, 0, 0, 960, 513, 960, 513);

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
				"\u0412\u043E\u0442 \u0442\u0430\u043A \u0432\u044B\u0433\u043B\u044F\u0434\u0438\u0442 \u0434\u0430\u043D\u0436 \u0432 \u0442\u0451\u043C\u043D\u043E\u043C \u043B\u0435\u0441\u0443",
				-97, -118, -1);
		this.font.drawString(ms,
				"\u0412 \u043D\u0451\u043C \u043D\u0430\u0445\u043E\u0434\u0438\u0442\u0441\u044F \u0441\u043F\u0435\u0446.\u043A\u043B\u044E\u0447 \u043A\u043E\u0442\u043E\u0440\u044B\u0439 \u043D\u0443\u0436\u0435\u043D \u0434\u043B\u044F \u043E\u0447\u0438\u0449\u0435\u043D\u0438\u044F \u043F\u0440\u043E\u043A\u043B\u044F\u0442\u0438\u0439",
				-162, -103, -1);
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
		this.addButton(new Button(this.guiLeft + -17, this.guiTop + 86, 72, 20, new StringTextComponent("Назад"), e -> {
			if (true) {
				HorrormodMod.PACKET_HANDLER.sendToServer(new MoreINFOLookButGui.ButtonPressedMessage(0, x, y, z));
				MoreINFOLookButGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
