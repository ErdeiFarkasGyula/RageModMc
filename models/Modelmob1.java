// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelmob1 extends EntityModel<Entity> {
	private final ModelRenderer main;
	private final ModelRenderer frontchest;
	private final ModelRenderer head;
	private final ModelRenderer cube_r1;
	private final ModelRenderer arm;
	private final ModelRenderer cube_r2;
	private final ModelRenderer leg;

	public Modelmob1() {
		textureWidth = 128;
		textureHeight = 128;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);

		frontchest = new ModelRenderer(this);
		frontchest.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(frontchest);
		frontchest.setTextureOffset(0, 18).addBox(-6.0F, -23.0F, -4.0F, 12.0F, 11.0F, 8.0F, 0.0F, false);
		frontchest.setTextureOffset(0, 49).addBox(-2.9F, -21.0F, -2.5F, 6.0F, 7.0F, 7.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(head);
		head.setTextureOffset(0, 0).addBox(-7.0F, -32.0F, -8.0F, 14.0F, 9.0F, 9.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(8.0F, 0.0F, -9.0F);
		head.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.3927F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(38, 10).addBox(-13.0F, -22.0F, 7.0F, 10.0F, 3.0F, 8.0F, 0.0F, false);
		cube_r1.setTextureOffset(32, 21).addBox(-11.0F, -27.0F, 10.6F, 6.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(54, 40).addBox(-13.0F, -28.0F, 11.0F, 10.0F, 4.0F, 2.0F, 0.0F, false);

		arm = new ModelRenderer(this);
		arm.setRotationPoint(0.0F, 0.0F, 0.0F);
		main.addChild(arm);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(8.0F, 0.0F, -9.0F);
		arm.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.3927F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(27, 24).addBox(-2.0F, -19.0F, -10.0F, 7.0F, 3.0F, 13.0F, 0.0F, false);
		cube_r2.setTextureOffset(27, 24).addBox(-21.0F, -19.0F, -10.0F, 7.0F, 3.0F, 13.0F, 0.0F, false);

		leg = new ModelRenderer(this);
		leg.setRotationPoint(-8.0F, 16.0F, 8.0F);
		leg.setTextureOffset(26, 55).addBox(10.0F, -4.0F, -10.0F, 5.0F, 12.0F, 4.0F, 0.0F, false);
		leg.setTextureOffset(26, 55).addBox(1.0F, -4.0F, -10.0F, 5.0F, 12.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		main.render(matrixStack, buffer, packedLight, packedOverlay);
		leg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}