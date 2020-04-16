package com.github.alexthe666.rats.client.render.entity;

import com.github.alexthe666.rats.client.model.ModelFlyingDutchrat;
import com.github.alexthe666.rats.server.entity.EntityDutchrat;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GLX;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class LayerDutchratGlow extends LayerRenderer<EntityDutchrat, ModelFlyingDutchrat<EntityDutchrat>> {
    private static final ResourceLocation GLOW_1 = new ResourceLocation("rats:textures/entity/ratlantis/dutchrat_glow_1.png");
    private static final ResourceLocation GLOW_2 = new ResourceLocation("rats:textures/entity/ratlantis/dutchrat_glow_2.png");
    private final IEntityRenderer<EntityDutchrat, ModelFlyingDutchrat<EntityDutchrat>> ratRenderer;

    public LayerDutchratGlow(IEntityRenderer<EntityDutchrat, ModelFlyingDutchrat<EntityDutchrat>> ratRendererIn) {
        super(ratRendererIn);
        this.ratRenderer = ratRendererIn;
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, EntityDutchrat entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEyes(GLOW_1));
        this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        IVertexBuilder ivertexbuilder2 = bufferIn.getBuffer(RenderType.getEyes(GLOW_2));
        this.getEntityModel().render(matrixStackIn, ivertexbuilder2, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

    }

    public boolean shouldCombineTextures() {
        return true;
    }

}
