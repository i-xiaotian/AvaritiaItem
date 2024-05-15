package top.suyarong.items;

import morph.avaritia.api.ICosmicRenderItem;
import morph.avaritia.api.IHaloRenderItem;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.Nullable;
import top.suyarong.items.render.AvaritiaItemTextures;

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
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getMaskTexture(ItemStack itemStack, @Nullable EntityLivingBase entityLivingBase) {
        final ResourceLocation registryName = this.getRegistryName();
        assert registryName != null;
        return AvaritiaItemTextures.ITEM_COSMIC_TEXTURES_MAP.get(registryName.toString());
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getMaskOpacity(ItemStack itemStack, @Nullable EntityLivingBase entityLivingBase) {
        return maskOpacity;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldDrawHalo(ItemStack itemStack) {
        return this.shouldDrawHalo;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getHaloTexture(ItemStack itemStack) {
        final ResourceLocation registryName = this.getRegistryName();
        assert registryName != null;
        return AvaritiaItemTextures.ITEM_HALO_TEXTURES_MAP.get(registryName.toString());
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getHaloColour(ItemStack itemStack) {
        return this.haloColour;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getHaloSize(ItemStack itemStack) {
        return haloSize <= 0 || haloSize > 16 ? 8 : haloSize;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldDrawPulse(ItemStack itemStack) {
        return shouldDrawPulse;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerModels() {
        super.registerModels();
    }

    @Override
    protected boolean shouldShowHalo() {
        return true;
    }

    @Override
    protected boolean shouldShowCosmic() {
        return true;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getMask() {
        return this.mask;
    }

    public String getHaloTextures() {
        return this.haloTextures;
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
