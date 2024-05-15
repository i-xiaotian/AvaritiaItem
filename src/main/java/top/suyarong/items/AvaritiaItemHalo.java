package top.suyarong.items;


import morph.avaritia.api.IHaloRenderItem;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import top.suyarong.items.render.AvaritiaItemTextures;

@SuppressWarnings("unused")
public class AvaritiaItemHalo extends AvaritiaBasicItem implements IHaloRenderItem {

    private boolean shouldDrawHalo;

    private String haloTextures;

    private int haloColour;

    private int haloSize;

    private boolean shouldDrawPulse;

    public AvaritiaItemHalo(String name, int maxStackSize, String type) {
        super(name, maxStackSize, type);
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
        return haloSize ;
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

    // 以下代码只参与初始化，与渲染无关

    @Override
    protected boolean shouldShowHalo() {
        return true;
    }

    @Override
    protected boolean shouldShowCosmic() {
        return false;
    }

    public void setShouldDrawHalo(boolean shouldDrawHalo) {
        this.shouldDrawHalo = shouldDrawHalo;
    }

    public void setHaloTextures(String haloTextures) {
        this.haloTextures = haloTextures;
    }

    public String getHaloTextures() {
        return this.haloTextures;
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
