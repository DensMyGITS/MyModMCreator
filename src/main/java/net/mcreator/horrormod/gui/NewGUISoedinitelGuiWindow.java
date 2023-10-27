
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
public class NewGUISoedinitelGuiWindow extends ContainerScreen<NewGUISoedinitelGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = NewGUISoedinitelGui.guistate;

	public NewGUISoedinitelGuiWindow(NewGUISoedinitelGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("horrormod:textures/screens/new_gui_soedinitel.png");

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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/stick.png"));
		this.blit(ms, this.guiLeft + 65, this.guiTop + 57, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/nostsword.png"));
		this.blit(ms, this.guiLeft + 97, this.guiTop + 17, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/nostaxe.png"));
		this.blit(ms, this.guiLeft + 105, this.guiTop + 17, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/nostpickaxe.png"));
		this.blit(ms, this.guiLeft + 97, this.guiTop + 25, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/nostshovel.png"));
		this.blit(ms, this.guiLeft + 105, this.guiTop + 25, 0, 0, 8, 8, 8, 8);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("horrormod:textures/screens/nosthoe.png"));
		this.blit(ms, this.guiLeft + 101, this.guiTop + 21, 0, 0, 8, 8, 8, 8);

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
				"\u0421\u043E\u0435\u0434\u0438\u043D\u0438\u0442\u0435\u043B\u044C (\u041D\u043E\u0440\u043C\u0430\u043B\u0438\u0437\u0430\u0442\u043E\u0440)",
				24, 7, -12829636);
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
		this.addButton(new Button(this.guiLeft + 96, this.guiTop + 61, 72, 20, new StringTextComponent("Соединить"), e -> {
			if (true) {
				HorrormodMod.PACKET_HANDLER.sendToServer(new NewGUISoedinitelGui.ButtonPressedMessage(0, x, y, z));
				NewGUISoedinitelGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
