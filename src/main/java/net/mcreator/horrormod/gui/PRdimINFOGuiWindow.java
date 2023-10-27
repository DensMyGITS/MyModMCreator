
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
public class PRdimINFOGuiWindow extends ContainerScreen<PRdimINFOGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = PRdimINFOGui.guistate;

	public PRdimINFOGuiWindow(PRdimINFOGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 0;
		this.ySize = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("horrormod:textures/screens/p_rdim_info.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/pr_page.png"));
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
		this.font.drawString(ms, "\u041F\u0440\u043E\u043A\u043B\u044F\u0442\u044B\u0439 \u043C\u0438\u0440", -26, -73, -16777216);
		this.font.drawString(ms,
				"\u0410, \u0437\u0430\u0431\u044B\u043B \u0441\u043A\u0430\u0437\u0430\u0442\u044C \u0447\u0442\u043E \u0447\u0442\u043E\u0431\u044B \u0432\u044B\u0431\u0440\u0430\u0442\u044C\u0441\u044F \u043E\u0442\u0441\u044E\u0434\u0430",
				-56, -63, -16777216);
		this.font.drawString(ms,
				"\u0412\u0430\u043C \u043D\u0443\u0436\u043D\u043E \u0438\u043C\u0435\u0442\u044C 20 \u0443\u0440\u043E\u0432\u043D\u044F", -56, -55,
				-16777216);
		this.font.drawString(ms,
				"\u0423\u0434\u0430\u0447\u0438) \u0425\u043E\u0442\u044F \u0438 \u0444\u0430\u0440\u043C\u0438\u0442\u044C \u0442\u043E \u0435\u0433\u043E \u043D\u0435 \u0441\u043B\u043E\u0436\u043D\u043E)",
				-57, -47, -16777216);
		this.font.drawString(ms,
				"\u041D\u043E \u043D\u0435 \u0437\u0430\u0431\u0443\u0434\u044C\u0442\u0435 \u0447\u0442\u043E \u0432\u044B \u0435\u0449\u0451 \u043D\u0435 \u0432\u044B\u0431\u0440\u0430\u043B\u0438\u0441\u044C \u0438\u0437 \u041C\u0438\u0440\u0430 \u041C\u0451\u0440\u0442\u0432\u044B\u0445",
				-56, -39, -16777216);
		this.font.drawString(ms,
				"\u041A\u0430\u043A \u0432\u044B \u0442\u043E\u043B\u044C\u043A\u043E \u0432\u044B\u0431\u0435\u0440\u0435\u0442\u0435\u0441\u044C \u0438\u0437 \u044D\u0442\u043E\u0433\u043E \u043C\u0438\u0440\u0430",
				-58, -30, -16777216);
		this.font.drawString(ms,
				"\u0412\u044B \u0441\u043D\u043E\u0432\u0430 \u0432\u0435\u0440\u043D\u0435\u0442\u0451\u0441\u044C \u0432 \u0442\u043E\u0442 \u043C\u0438\u0440",
				-58, -22, -16777216);
		this.font.drawString(ms,
				"\u0416\u0435\u043B\u0430\u0442\u0435\u043B\u044C\u043D\u043E \u0432\u0430\u043C \u0442\u0430\u043C \u043F\u043E\u0444\u0430\u0440\u043C\u0438\u0442\u044C\u0441\u044F)",
				-58, -14, -16777216);
		this.font.drawString(ms, "\u0412\u0430\u043C \u0434\u0430\u0441\u0442\u0441\u044F \u0434\u043E\u043F. 5 \u043E\u043F\u044B\u0442\u0430 :)",
				-57, 3, -16777216);
		this.font.drawString(ms,
				"\u041E \u0438 \u043A\u0441\u0442\u0430\u0442\u0438, \u0435\u0441\u043B\u0438 \u0443 \u0432\u0430\u0441 \u0435\u0441\u0442\u044C \u0441 \u0441\u043E\u0431\u043E\u0439 \u0432\u0435\u0434\u0440\u043E, \u0442\u043E \u0432\u0430\u043C \u043F\u043E\u0432\u0435\u0437\u043B\u043E)",
				-58, -6, -16777216);
		this.font.drawString(ms,
				"\u0410 \u0442\u0430\u043A \u0436\u0435 \u0437\u0430\u0431\u0435\u0440\u0438\u0442\u0435 \u0441 \u0441\u043E\u0431\u043E\u0439 \u0438\u0437 \u044D\u0442\u043E\u0433\u043E \u043C\u0438\u0440\u0430 \u0441\u0432\u044F\u0442\u0443\u044E \u0432\u043E\u0434\u0443",
				-57, 11, -16777216);
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
		this.addButton(new Button(this.guiLeft + -77, this.guiTop + 79, 30, 20, new StringTextComponent("<"), e -> {
			if (true) {
				HorrormodMod.PACKET_HANDLER.sendToServer(new PRdimINFOGui.ButtonPressedMessage(0, x, y, z));
				PRdimINFOGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
