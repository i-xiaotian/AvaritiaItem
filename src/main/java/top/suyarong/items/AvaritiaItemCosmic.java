package top.suyarong.items;

import codechicken.lib.util.TransformUtils;
import morph.avaritia.api.ICosmicRenderItem;
import morph.avaritia.client.render.item.CosmicItemRender;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class AvaritiaItemCosmic extends AvaritiaBasicItem implements ICosmicRenderItem {

    private String mask;

    private float maskOpacity;

    public AvaritiaItemCosmic(String name, int maxStackSize, String type) {
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
    public void registerModels() {
        super.registerModels();
    }

    @Override
    protected boolean shouldShowHalo() {
        return false;
    }

    @Override
    protected boolean shouldShowCosmic() {
        return true;
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
}
