
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
public class ArmorINFOGuiWindow extends ContainerScreen<ArmorINFOGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = ArmorINFOGui.guistate;

	public ArmorINFOGuiWindow(ArmorINFOGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 0;
		this.ySize = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("horrormod:textures/screens/armor_info.png");

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
		this.font.drawString(ms, "\u0418\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0438\u044F", -27, -74, -12829636);
		this.font.drawString(ms, "\u0411\u0440\u043E\u043D\u044E \u041C\u0435\u0440\u0442\u0432\u0435\u0446\u0430 \u043C\u043E\u0436\u043D\u043E",
				-58, -63, -12829636);
		this.font.drawString(ms, "\u0441\u043E\u0437\u0434\u0430\u0442\u044C \u0442\u043E\u043B\u044C\u043A\u043E \u0432 \u0441\u043F\u0435\u0446.",
				-57, -51, -12829636);
		this.font.drawString(ms, "\u0432\u0435\u0440\u0441\u0442\u0430\u043A\u0435.", -57, -40, -12829636);
		this.font.drawString(ms, "\u0412 \u041F\u0440\u043E\u043A\u043B\u044F\u0442\u043E\u043C \u0432\u0435\u0440\u0441\u0442\u0430\u043A\u0435.",
				-57, -29, -12829636);
		this.font.drawString(ms,
				"\u0414\u043B\u044F \u0441\u043E\u0437\u0434\u0430\u043D\u0438\u044F \u043F\u0440\u043E\u043A\u043B\u044F\u0442\u043E\u0433\u043E",
				-57, -17, -12829636);
		this.font.drawString(ms, "-\u0433\u043E \u0432\u0435\u0440\u0441\u0442\u0430\u043A\u0430, \u043D\u0443\u0436\u043D\u043E ", -58, -5,
				-12829636);
		this.font.drawString(ms, "\u043E\u0431\u044B\u0447\u043D\u044B\u0439 \u0432\u0435\u0440\u0441\u0442\u0430\u043A, \u043E\u0431\u043B\u043E-",
				-58, 7, -12829636);
		this.font.drawString(ms, "\u0436\u0438\u0442\u044C \u043C\u0451\u0440\u0442\u0432\u044B\u043C \u0434\u043E\u0441\u043A\u0430\u043C\u0438",
				-58, 17, -12829636);
		this.font.drawString(ms, "\u041D\u043E \u0431\u0443\u0434\u044C\u0442\u0435 \u043E\u0441\u0442\u043E\u0440\u043E\u0436\u043D\u044B!", -57, 28,
				-12829636);
		this.font.drawString(ms,
				"\u0412\u0441\u0451 \u0442\u0430\u043A\u0438 \u0432\u0435\u0440\u0441\u0442\u0430\u043A \u041F\u0420\u041E\u041A\u041B\u042F\u0422\u042B\u0419 :)",
				-57, 40, -12829636);
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
				HorrormodMod.PACKET_HANDLER.sendToServer(new ArmorINFOGui.ButtonPressedMessage(0, x, y, z));
				ArmorINFOGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 45, this.guiTop + 78, 30, 20, new StringTextComponent(">"), e -> {
			if (true) {
				HorrormodMod.PACKET_HANDLER.sendToServer(new ArmorINFOGui.ButtonPressedMessage(1, x, y, z));
				ArmorINFOGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
