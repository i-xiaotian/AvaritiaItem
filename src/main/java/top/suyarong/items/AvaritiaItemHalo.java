package top.suyarong.items;


import codechicken.lib.model.ModelRegistryHelper;
import codechicken.lib.util.TransformUtils;
import morph.avaritia.api.IHaloRenderItem;
import morph.avaritia.client.render.item.HaloRenderItem;
import morph.avaritia.init.AvaritiaTextures;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.StringUtils;


public class AvaritiaItemHalo extends AvaritiaBasicItem implements IHaloRenderItem {

    private boolean shouldDrawHalo;

    private String haloTextures;

    private int haloColour;

    private int haloSize;

    private boolean shouldDrawPulse;

    public AvaritiaItemHalo(String name) {
        super(name);
    }

    @Override
    public boolean shouldDrawHalo(ItemStack itemStack) {
        return this.shouldDrawHalo;
    }

    @Override
    public TextureAtlasSprite getHaloTexture(ItemStack itemStack) {
        return StringUtils.isBlank(haloTextures)
                ? AvaritiaTextures.HALO
                : TEXTURE_MAP.registerSprite(new ResourceLocation(ITEM + haloTextures));
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
    @SideOnly(Side.CLIENT)
    public void registerModels() {
        log.info("xiaotian the registryName is " + getRegistryName());
        ModelResourceLocation location = new ModelResourceLocation(getRegistryName(), "type=resource");
        ModelLoader.registerItemVariants(this, location);
        IBakedModel wrappedModel = new HaloRenderItem(TransformUtils.DEFAULT_ITEM, modelRegistry -> modelRegistry.getObject(location));
        ModelRegistryHelper.register(location, wrappedModel);
        ModelLoader.setCustomMeshDefinition(this, stack -> location);

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
