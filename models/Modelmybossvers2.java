// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports

public static class Modelmybossvers2 extends EntityModel<Entity> {
	private final ModelRenderer bone_head;
	private final ModelRenderer bone_body;
	private final ModelRenderer bone_leaftarm;
	private final ModelRenderer bone_rightarm;
	private final ModelRenderer bone_leftleg;
	private final ModelRenderer bone_rightleg;

	public Modelmybossvers2() {
		texWidth = 128;
		texHeight = 128;

		bone_head = new ModelRenderer(this);
		bone_head.setPos(0.0F, -3.3846F, -2.4231F);
		bone_head.texOffs(0, 18).addBox(-4.0F, -3.6154F, -1.5769F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		bone_head.texOffs(24, 19).addBox(4.0F, -1.6154F, -2.5769F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		bone_head.texOffs(0, 0).addBox(-5.0F, -1.6154F, -2.5769F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		bone_head.texOffs(60, 29).addBox(-4.0F, -3.6154F, -2.5769F, 8.0F, 2.0F, 1.0F, 0.0F, false);
		bone_head.texOffs(60, 32).addBox(-4.0F, -1.6154F, -2.5769F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		bone_head.texOffs(0, 22).addBox(-1.0F, -0.6154F, -2.5769F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone_head.texOffs(64, 57).addBox(-4.0F, 2.3846F, -2.5769F, 8.0F, 2.0F, 1.0F, 0.0F, false);
		bone_head.texOffs(0, 20).addBox(-4.0F, 1.3846F, -2.5769F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		bone_head.texOffs(0, 18).addBox(1.0F, 1.3846F, -2.5769F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		bone_head.texOffs(24, 10).addBox(-4.0F, -4.6154F, -1.5769F, 8.0F, 1.0F, 8.0F, 0.0F, false);
		bone_head.texOffs(14, 63).addBox(-4.0F, -3.6154F, 6.4231F, 8.0F, 7.0F, 1.0F, 0.0F, false);
		bone_head.texOffs(48, 0).addBox(-5.0F, -3.6154F, -1.5769F, 1.0F, 7.0F, 8.0F, 0.0F, false);
		bone_head.texOffs(42, 19).addBox(4.0F, -3.6154F, -1.5769F, 1.0F, 7.0F, 8.0F, 0.0F, false);

		bone_body = new ModelRenderer(this);
		bone_body.setPos(0.0F, 7.0F, 0.0F);
		bone_body.texOffs(0, 0).addBox(-5.0F, -6.0F, -3.0F, 10.0F, 12.0F, 6.0F, 0.0F, false);
		bone_body.texOffs(58, 34).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 10.0F, 1.0F, 0.0F, false);
		bone_body.texOffs(46, 57).addBox(-4.0F, -5.0F, 3.0F, 8.0F, 10.0F, 1.0F, 0.0F, false);

		bone_leaftarm = new ModelRenderer(this);
		bone_leaftarm.setPos(7.9286F, 2.8571F, 0.0F);
		bone_leaftarm.texOffs(32, 0).addBox(-3.9286F, -2.8571F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		bone_leaftarm.texOffs(58, 0).addBox(-2.9286F, 10.1429F, -3.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);
		bone_leaftarm.texOffs(58, 62).addBox(-1.9286F, 11.1429F, -3.0F, 4.0F, 1.0F, 6.0F, 0.0F, false);
		bone_leaftarm.texOffs(26, 28).addBox(-2.9286F, -1.8571F, -3.0F, 5.0F, 12.0F, 6.0F, 0.0F, false);
		bone_leaftarm.texOffs(64, 45).addBox(-2.9286F, -1.8571F, 3.0F, 5.0F, 11.0F, 1.0F, 0.0F, false);
		bone_leaftarm.texOffs(0, 52).addBox(2.0714F, -1.8571F, -3.0F, 1.0F, 11.0F, 6.0F, 0.0F, false);
		bone_leaftarm.texOffs(46, 68).addBox(-2.9286F, -1.8571F, -4.0F, 5.0F, 11.0F, 1.0F, 0.0F, false);

		bone_rightarm = new ModelRenderer(this);
		bone_rightarm.setPos(-7.9286F, 2.8571F, 0.0F);
		bone_rightarm.texOffs(60, 22).addBox(-2.0714F, 11.1429F, -3.0F, 4.0F, 1.0F, 6.0F, 0.0F, false);
		bone_rightarm.texOffs(52, 15).addBox(-2.0714F, 10.1429F, -3.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);
		bone_rightarm.texOffs(0, 34).addBox(-2.0714F, -1.8571F, -3.0F, 5.0F, 12.0F, 6.0F, 0.0F, false);
		bone_rightarm.texOffs(0, 69).addBox(-2.0714F, -1.8571F, -4.0F, 5.0F, 11.0F, 1.0F, 0.0F, false);
		bone_rightarm.texOffs(24, 19).addBox(-2.0714F, -2.8571F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		bone_rightarm.texOffs(32, 57).addBox(-3.0714F, -1.8571F, -3.0F, 1.0F, 11.0F, 6.0F, 0.0F, false);
		bone_rightarm.texOffs(68, 7).addBox(-2.0714F, -1.8571F, 3.0F, 5.0F, 11.0F, 1.0F, 0.0F, false);

		bone_leftleg = new ModelRenderer(this);
		bone_leftleg.setPos(3.0F, 14.25F, 0.0F);
		bone_leftleg.texOffs(16, 46).addBox(-3.0F, -1.25F, -3.0F, 5.0F, 11.0F, 6.0F, 0.0F, false);
		bone_leftleg.texOffs(76, 34).addBox(-3.0F, -2.25F, -4.0F, 4.0F, 9.0F, 1.0F, 0.0F, false);
		bone_leftleg.texOffs(68, 69).addBox(2.0F, -0.25F, -2.0F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		bone_leftleg.texOffs(22, 71).addBox(-3.0F, -2.25F, 3.0F, 4.0F, 9.0F, 1.0F, 0.0F, false);

		bone_rightleg = new ModelRenderer(this);
		bone_rightleg.setPos(-3.0F, 14.25F, 0.0F);
		bone_rightleg.texOffs(42, 40).addBox(-2.0F, -1.25F, -3.0F, 5.0F, 11.0F, 6.0F, 0.0F, false);
		bone_rightleg.texOffs(12, 71).addBox(-1.0F, -2.25F, 3.0F, 4.0F, 9.0F, 1.0F, 0.0F, false);
		bone_rightleg.texOffs(58, 69).addBox(-3.0F, -0.25F, -2.0F, 1.0F, 7.0F, 4.0F, 0.0F, false);
		bone_rightleg.texOffs(32, 74).addBox(-1.0F, -2.25F, -4.0F, 4.0F, 9.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bone_head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bone_body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bone_leaftarm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bone_rightarm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bone_leftleg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bone_rightleg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.bone_leaftarm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.bone_rightarm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.bone_rightleg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.bone_leftleg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.bone_head.yRot = headPitch / (180F / (float) Math.PI);
	}
}