// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports

public static class Modelmymob extends EntityModel<Entity> {
	private final ModelRenderer bone;

	public Modelmymob() {
		texWidth = 64;
		texHeight = 64;

		bone = new ModelRenderer(this);
		bone.setPos(0.0F, 20.0F, 0.0F);
		bone.texOffs(0, 15).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.bone.xRot = headPitch / (180F / (float) Math.PI);
	}
}