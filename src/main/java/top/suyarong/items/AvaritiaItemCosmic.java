package top.suyarong.items;

import morph.avaritia.api.ICosmicRenderItem;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class AvaritiaItemCosmic extends AvaritiaBasicItem implements ICosmicRenderItem {

    private String mask;

    private float maskOpacity;

    public AvaritiaItemCosmic(String name) {
        super(name);
    }

    @Override
    public TextureAtlasSprite getMaskTexture(ItemStack itemStack, @Nullable EntityLivingBase entityLivingBase) {
        return TEXTURE_MAP.registerSprite(new ResourceLocation(ITEM + mask));
    }

    @Override
    public float getMaskOpacity(ItemStack itemStack, @Nullable EntityLivingBase entityLivingBase) {
        return maskOpacity;
    }

    @Override
    public void registerModels() {

    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public void setMaskOpacity(float maskOpacity) {
        this.maskOpacity = maskOpacity;
    }
}
