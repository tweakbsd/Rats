package com.github.alexthe666.rats.client.model;

import com.github.alexthe666.citadel.client.model.AdvancedEntityModel;
import com.github.alexthe666.citadel.client.model.AdvancedRendererModel;
import com.github.alexthe666.rats.server.entity.EntityRatGolemMount;
import net.minecraft.client.Minecraft;

public class ModelRatGolemMount<T extends EntityRatGolemMount> extends AdvancedEntityModel<T> {
    public AdvancedRendererModel chest;
    public AdvancedRendererModel waist;
    public AdvancedRendererModel leftArm;
    public AdvancedRendererModel rightArm;
    public AdvancedRendererModel rightLeg;
    public AdvancedRendererModel leftLeg;
    public AdvancedRendererModel dome;

    public ModelRatGolemMount() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.leftLeg = new AdvancedRendererModel(this, 60, 0);
        this.leftLeg.mirror = true;
        this.leftLeg.setRotationPoint(5.0F, 11.0F, 0.0F);
        this.leftLeg.addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, 0.0F);
        this.leftArm = new AdvancedRendererModel(this, 60, 58);
        this.leftArm.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.leftArm.addBox(9.0F, -2.5F, -3.0F, 4, 30, 6, 0.0F);
        this.chest = new AdvancedRendererModel(this, 0, 40);
        this.chest.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.chest.addBox(-9.0F, -2.0F, -6.0F, 18, 12, 11, 0.0F);
        this.rightArm = new AdvancedRendererModel(this, 60, 21);
        this.rightArm.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.rightArm.addBox(-13.0F, -2.5F, -3.0F, 4, 30, 6, 0.0F);
        this.rightLeg = new AdvancedRendererModel(this, 37, 0);
        this.rightLeg.setRotationPoint(-4.0F, 11.0F, 0.0F);
        this.rightLeg.addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, 0.0F);
        this.dome = new AdvancedRendererModel(this, 0, 82);
        this.dome.setRotationPoint(0.0F, -9.0F, 0.0F);
        this.dome.addBox(-5.0F, -14.0F, -5.0F, 10, 14, 10, 0.0F);
        this.waist = new AdvancedRendererModel(this, 0, 70);
        this.waist.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.waist.addBox(-4.5F, 10.0F, -3.0F, 9, 5, 6, 0.5F);
        this.updateDefaultPose();
    }

    @Override
    public void render(EntityRatGolemMount entity, float f, float f1, float f2, float f3, float f4, float f5) {
        animate(entity, f, f1, f2, f3, f4, f5);
        this.leftLeg.render(f5);
        this.chest.render(f5);
        this.rightArm.render(f5);
        this.leftArm.render(f5);
        this.rightLeg.render(f5);
        this.dome.render(f5);
        this.waist.render(f5);
    }

    public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {

    }

    private float triangleWave(float p_78172_1_, float p_78172_2_) {
        return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
    }

    public void animate(EntityRatGolemMount entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.resetToDefaultPose();
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, EntityRatGolemMount mount) {
        this.leftLeg.rotateAngleX = -1.5F * this.triangleWave(f, 13.0F) * f1;
        this.rightLeg.rotateAngleX = 1.5F * this.triangleWave(f, 13.0F) * f1;
        this.leftLeg.rotateAngleY = 0.0F;
        this.rightLeg.rotateAngleY = 0.0F;
        int i = mount.getAttackTimer();
        if (i > 0) {
            float partialTicks = Minecraft.getInstance().getRenderPartialTicks();
            this.leftArm.rotateAngleX = -2.0F + 1.5F * this.triangleWave((float)i - partialTicks, 10.0F);
            this.rightArm.rotateAngleX = -2.0F + 1.5F * this.triangleWave((float)i - partialTicks, 10.0F);
        } else {
            this.leftArm.rotateAngleX = (-0.2F + 1.5F * this.triangleWave(f, 13.0F)) * f1;
            this.rightArm.rotateAngleX = (-0.2F - 1.5F * this.triangleWave(f, 13.0F)) * f1;
        }
    }

    public void setRotateAngle(AdvancedRendererModel AdvancedRendererModel, float x, float y, float z) {
        AdvancedRendererModel.rotateAngleX = x;
        AdvancedRendererModel.rotateAngleY = y;
        AdvancedRendererModel.rotateAngleZ = z;
    }
}
