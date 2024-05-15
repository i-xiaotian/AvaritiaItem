package top.suyarong.items;

import morph.avaritia.api.ICosmicRenderItem;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.Nullable;
import top.suyarong.render.AvaritiaItemTextures;

@SuppressWarnings("unused")
public class AvaritiaItemCosmic extends AvaritiaBasicItem implements ICosmicRenderItem {

    private String mask;

    private float maskOpacity;

    public AvaritiaItemCosmic(String name, int maxStackSize, String type) {
        super(name, maxStackSize, type);
    }

    @Override
    public TextureAtlasSprite getMaskTexture(ItemStack itemStack, @Nullable EntityLivingBase entityLivingBase) {
        final ResourceLocation registryName = this.getRegistryName();
        assert registryName != null;
        return AvaritiaItemTextures.itemCosmicTexturesMap.get(registryName.toString());
    }

    @Override
    public float getMaskOpacity(ItemStack itemStack, @Nullable EntityLivingBase entityLivingBase) {
        return maskOpacity;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerModels() {
        super.registerModels();
    }

    // 以下代码只参与初始化，与渲染无关

    @Override
    protected boolean shouldShowHalo() {
        return false;
    }

    @Override
    protected boolean shouldShowCosmic() {
        return true;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getMask() {
        return mask;
    }

    public void setMaskOpacity(float maskOpacity) {
        this.maskOpacity = maskOpacity;
    }
}
