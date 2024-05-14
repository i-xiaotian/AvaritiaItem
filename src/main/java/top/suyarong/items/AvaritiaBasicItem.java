package top.suyarong.items;

import codechicken.lib.model.ModelRegistryHelper;
import codechicken.lib.util.TransformUtils;
import morph.avaritia.api.registration.IModelRegister;
import morph.avaritia.client.render.item.CosmicItemRender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.client.model.ModelLoader;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import top.suyarong.AvaritiaItem;
import top.suyarong.render.AvaritiaItemCustomRender;

import java.io.File;

public abstract class AvaritiaBasicItem extends Item implements IModelRegister {

    public static final Logger log = AvaritiaItem.log;

    private static final String ITEM_PREFIX = AvaritiaItem.MOD_ID + '.';

    public static String texturesPath;

    public static final TextureMap TEXTURE_MAP = Minecraft.getMinecraft().getTextureMapBlocks();

    private String type;

    public AvaritiaBasicItem(String name, int maxStackSize, String type) {
        super();
        if (StringUtils.isBlank(name)) {
            log.warn(new TextComponentTranslation("message.item_register.blank_name").getFormattedText());
            return;
        }
        String lowerCaseName = name.toLowerCase();
        setRegistryName(lowerCaseName);
        setTranslationKey(ITEM_PREFIX + lowerCaseName);
        setCreativeTab(AvaritiaItem.avaritiaItemTab);
        setMaxStackSize(maxStackSize);
        setTexturesPath("items");
        this.type = type;
        log.info(new TextComponentTranslation("message.item_register.success", lowerCaseName).getFormattedText());

    }

    protected void setTexturesPath(String path) {
        texturesPath = AvaritiaItem.MOD_ID + ':' + path + '/';
    }

    @Override
    public void registerModels() {
        final ResourceLocation registryName = getRegistryName();

        assert registryName != null;
        ModelResourceLocation location = new ModelResourceLocation(registryName, "type=" + type);
        ModelLoader.registerItemVariants(this, location);

        IBakedModel wrappedModel = createWrappedModel(location, shouldShowHalo(), shouldShowCosmic(), genCosmicRenderModel(location));

        ModelRegistryHelper.register(location, wrappedModel);
        ModelLoader.setCustomMeshDefinition(this, stack -> location);

        log.info("item registryName {} with model type {} register success", registryName, type);
    }

    private IBakedModel createWrappedModel(ModelResourceLocation location, boolean shouldShowHalo, boolean shouldShowCosmic, CosmicItemRender cosmicRenderModel) {
        return new AvaritiaItemCustomRender(
                TransformUtils.DEFAULT_ITEM,
                modelRegistry -> modelRegistry.getObject(location),
                shouldShowHalo,
                shouldShowCosmic,
                cosmicRenderModel
        );
    }

    protected abstract boolean shouldShowHalo();

    protected abstract boolean shouldShowCosmic();

    protected abstract CosmicItemRender genCosmicRenderModel(ModelResourceLocation location);

}

