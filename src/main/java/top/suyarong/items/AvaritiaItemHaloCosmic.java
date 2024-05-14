package top.suyarong.items;

import codechicken.lib.util.TransformUtils;
import morph.avaritia.api.ICosmicRenderItem;
import morph.avaritia.api.IHaloRenderItem;
import morph.avaritia.client.render.item.CosmicItemRender;
import morph.avaritia.init.AvaritiaTextures;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class AvaritiaItemHaloCosmic extends AvaritiaBasicItem implements IHaloRenderItem, ICosmicRenderItem {
    private String mask;

    private float maskOpacity;

    private boolean shouldDrawHalo;

    private String haloTextures;

    private int haloColour;

    private int haloSize;

    private boolean shouldDrawPulse;

    public AvaritiaItemHaloCosmic(String name, int maxStackSize, String type) {
        super(name, maxStackSize, type);
    }

    @Override
    public TextureAtlasSprite getMaskTexture(ItemStack itemStack, @Nullable EntityLivingBase entityLivingBase) {
        return TEXTURE_MAP.registerSprite(new ResourceLocation(texturesPath + mask));
    }

    @Override
    public float getMaskOpacity(ItemStack itemStack, @Nullable EntityLivingBase entityLivingBase) {
        return maskOpacity;
    }

    @Override
    public boolean shouldDrawHalo(ItemStack itemStack) {
        return this.shouldDrawHalo;
    }

    @Override
    public TextureAtlasSprite getHaloTexture(ItemStack itemStack) {
        return StringUtils.isBlank(haloTextures)
                ? AvaritiaTextures.HALO
                : TEXTURE_MAP.registerSprite(new ResourceLocation(texturesPath + haloTextures));
    }

    @Override
    public int getHaloColour(ItemStack itemStack) {
        return haloColour;
    }

    @Override
    public int getHaloSize(ItemStack itemStack) {
        return haloSize;
    }

    @Override
    public boolean shouldDrawPulse(ItemStack itemStack) {
        return shouldDrawPulse;
    }

    @Override
    public void registerModels() {
        super.registerModels();
    }

    @Override
    protected boolean shouldShowHalo() {
        return false;
    }

    @Override
    protected boolean shouldShowCosmic() {
        return false;
    }

    @Override
    protected CosmicItemRender genCosmicRenderModel(final ModelResourceLocation location) {
        return new CosmicItemRender(TransformUtils.DEFAULT_ITEM, modelRegistry -> modelRegistry.getObject(location));
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public void setMaskOpacity(float maskOpacity) {
        this.maskOpacity = maskOpacity;
    }

    public void setShouldDrawHalo(boolean shouldDrawHalo) {
        this.shouldDrawHalo = shouldDrawHalo;
    }

    public void setHaloTextures(String haloTextures) {
        this.haloTextures = haloTextures;
    }

    public void setHaloColour(int haloColour) {
        this.haloColour = haloColour;
    }

    public void setHaloSize(int haloSize) {
        this.haloSize = haloSize;
    }

    public void setShouldDrawPulse(boolean shouldDrawPulse) {
        this.shouldDrawPulse = shouldDrawPulse;
    }
}
