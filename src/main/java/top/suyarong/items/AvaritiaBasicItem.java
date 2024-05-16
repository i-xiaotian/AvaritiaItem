package top.suyarong.items;

import codechicken.lib.model.ModelRegistryHelper;
import codechicken.lib.util.TransformUtils;
import morph.avaritia.api.registration.IModelRegister;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import top.suyarong.AvaritiaItem;
import top.suyarong.items.render.AvaritiaItemCustomRender;
import top.suyarong.items.render.ColorfulToolTip;

import java.util.List;

public abstract class AvaritiaBasicItem extends Item implements IModelRegister {

    public static final Logger log = AvaritiaItem.log;

    private static final String ITEM_PREFIX = AvaritiaItem.MOD_ID + '.';

    public static String texturesPath;

    private String type;

    private boolean colorfulName;

    private List<ColorfulToolTip> colorfulToolTips;

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
        texturesPath = AvaritiaItem.MOD_ID + ":items/";
        setType(type);
        log.info(new TextComponentTranslation("message.item_register.success", lowerCaseName).getFormattedText());
    }

    protected void setType(String type) {
        this.type = type;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerModels() {
        final ResourceLocation registryName = getRegistryName();

        assert registryName != null;
        ModelResourceLocation location = new ModelResourceLocation(registryName, "type=" + type);
        ModelLoader.registerItemVariants(this, location);

        IBakedModel wrappedModel = new AvaritiaItemCustomRender(
                TransformUtils.DEFAULT_ITEM,
                modelRegistry -> modelRegistry.getObject(location),
                shouldShowHalo(),
                shouldShowCosmic()
        );

        ModelRegistryHelper.register(location, wrappedModel);
        ModelLoader.setCustomMeshDefinition(this, stack -> location);

        log.info("item registryName {} with model type {} register success", registryName, type);
    }

    public String getType() {
        return this.type;
    }

    public boolean getColorfulName() {
        return colorfulName;
    }

    public void setColorfulName(final boolean colorfulName) {
        this.colorfulName = colorfulName;
    }

    public List<ColorfulToolTip> getColorfulToolTips() {
        return colorfulToolTips;
    }

    public void setColorfulToolTips(final List<ColorfulToolTip> colorfulToolTips) {
        this.colorfulToolTips = colorfulToolTips;
    }

    protected abstract boolean shouldShowHalo();

    protected abstract boolean shouldShowCosmic();


}

