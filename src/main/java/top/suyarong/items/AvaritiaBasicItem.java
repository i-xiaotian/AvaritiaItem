package top.suyarong.items;

import morph.avaritia.api.registration.IModelRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextComponentTranslation;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import top.suyarong.AvaritiaItem;

public abstract class AvaritiaBasicItem extends Item implements IModelRegister {

    public static final Logger log = AvaritiaItem.log;

    private static final String ITEM_PREFIX = AvaritiaItem.MOD_ID + '.';

    public static final String ITEM = AvaritiaItem.MOD_ID + ":items/";

    public static final TextureMap TEXTURE_MAP = Minecraft.getMinecraft().getTextureMapBlocks();

    public AvaritiaBasicItem(String name) {
        super();
        if (StringUtils.isBlank(name)) {
            log.warn(new TextComponentTranslation("message.item_register.blank_name").getFormattedText());
            return;
        }
        String lowerCaseName = name.toLowerCase();
        setRegistryName(lowerCaseName);
        setTranslationKey(ITEM_PREFIX + lowerCaseName);
        setCreativeTab(AvaritiaItem.avaritiaItemTab);
        log.info(new TextComponentTranslation("message.item_register.success", lowerCaseName).getFormattedText());

    }

}

