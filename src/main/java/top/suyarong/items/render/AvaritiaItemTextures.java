package top.suyarong.items.render;

import codechicken.lib.texture.TextureUtils;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.StringUtils;
import top.suyarong.items.AvaritiaBasicItem;
import top.suyarong.items.AvaritiaItemCosmic;
import top.suyarong.items.AvaritiaItemHalo;
import top.suyarong.items.AvaritiaItemHaloCosmic;
import top.suyarong.items.registry.RegisterItem;

import java.util.HashMap;
import java.util.Map;


public class AvaritiaItemTextures implements TextureUtils.IIconRegister {

    public static final Map<String, TextureAtlasSprite> ITEM_HALO_TEXTURES_MAP = new HashMap<>();
    public static final Map<String, TextureAtlasSprite> ITEM_COSMIC_TEXTURES_MAP = new HashMap<>();
    private static final String texturesPath = AvaritiaBasicItem.texturesPath;

    public static TextureAtlasSprite haloTexture;

    @Override
    public void registerIcons(final TextureMap textureMap) {

        haloTexture = textureMap.registerSprite(new ResourceLocation(texturesPath + "halo"));

        RegisterItem.HALO_ITEM_REG_LIST.forEach(avaritiaBasicItem -> {
            if (avaritiaBasicItem instanceof AvaritiaItemHalo itemHalo) {
                final String haloTextures = itemHalo.getHaloTextures();
                TextureAtlasSprite textureAtlasSprite = StringUtils.isBlank(haloTextures)
                        ? haloTexture
                        : textureMap.registerSprite(new ResourceLocation(texturesPath + haloTextures));
                final ResourceLocation registryName = avaritiaBasicItem.getRegistryName();
                assert registryName != null;
                ITEM_HALO_TEXTURES_MAP.put(registryName.toString(), textureAtlasSprite);
            }
        });

        RegisterItem.COSMIC_ITEM_REG_LIST.forEach(avaritiaBasicItem -> {
            if (avaritiaBasicItem instanceof AvaritiaItemCosmic itemCosmic) {

                final String mask = itemCosmic.getMask();
                final ResourceLocation registryName = avaritiaBasicItem.getRegistryName();
                assert registryName != null;
                final String nameString = registryName.toString();

                final TextureAtlasSprite textureAtlasSpriteMask = textureMap.registerSprite(new ResourceLocation(texturesPath + mask));
                ITEM_COSMIC_TEXTURES_MAP.put(nameString, textureAtlasSpriteMask);
            }
        });

        RegisterItem.HALO_COSMIC_ITEM_REG_LIST.forEach(avaritiaBasicItem -> {
            if (avaritiaBasicItem instanceof AvaritiaItemHaloCosmic itemHaloCosmic) {

                final String haloTextures = itemHaloCosmic.getHaloTextures();
                final ResourceLocation registryName = avaritiaBasicItem.getRegistryName();
                assert registryName != null;
                final String nameString = registryName.toString();

                TextureAtlasSprite textureAtlasSprite = StringUtils.isBlank(haloTextures)
                        ? haloTexture
                        : textureMap.registerSprite(new ResourceLocation(texturesPath + haloTextures));

                ITEM_HALO_TEXTURES_MAP.put(nameString, textureAtlasSprite);
                final String mask = itemHaloCosmic.getMask();
                final TextureAtlasSprite cosmicTextureAtlasSprite = textureMap.registerSprite(new ResourceLocation(texturesPath + mask));
                ITEM_COSMIC_TEXTURES_MAP.put(nameString, cosmicTextureAtlasSprite);
            }
        });

        RegisterItem.clearCache();
    }

}
