package top.suyarong.render;

import codechicken.lib.texture.TextureUtils;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.StringUtils;
import top.suyarong.items.AvaritiaItemCosmic;
import top.suyarong.items.AvaritiaItemHalo;
import top.suyarong.items.AvaritiaItemHaloCosmic;
import top.suyarong.items.registry.RegisterItem;

import java.util.HashMap;
import java.util.Map;


public class AvaritiaItemTextures implements TextureUtils.IIconRegister {

    public static final Map<String, TextureAtlasSprite> itemHaloTexturesMap = new HashMap<>();
    public static final Map<String, TextureAtlasSprite> itemCosmicTexturesMap = new HashMap<>();

    public static TextureAtlasSprite haloTexture;

    @Override
    public void registerIcons(final TextureMap textureMap) {

        haloTexture = textureMap.registerSprite(new ResourceLocation(AvaritiaItemHalo.texturesPath + "halo"));

        RegisterItem.HALO_ITEM_REG_LIST.forEach(item -> {
            if (item instanceof AvaritiaItemHalo itemHalo) {
                final String texturesPath = AvaritiaItemHalo.texturesPath;
                final String haloTextures = itemHalo.getHaloTextures();
                TextureAtlasSprite textureAtlasSprite = StringUtils.isBlank(haloTextures)
                        ? haloTexture
                        : textureMap.registerSprite(new ResourceLocation(texturesPath + haloTextures));
                final ResourceLocation registryName = item.getRegistryName();
                assert registryName != null;
                itemHaloTexturesMap.put(registryName.toString(), textureAtlasSprite);
            }
        });

        RegisterItem.HALO_COSMIC_ITEM_REG_LIST.forEach(item -> {
            if (item instanceof AvaritiaItemHaloCosmic itemHaloCosmic) {
                final String texturesPath = AvaritiaItemHaloCosmic.texturesPath;
                final String haloTextures = itemHaloCosmic.getHaloTextures();
                final ResourceLocation registryName = item.getRegistryName();
                assert registryName != null;
                final String nameString = registryName.toString();

                TextureAtlasSprite textureAtlasSprite = StringUtils.isBlank(haloTextures)
                        ? haloTexture
                        : textureMap.registerSprite(new ResourceLocation(texturesPath + haloTextures));

                itemHaloTexturesMap.put(nameString, textureAtlasSprite);
                final String mask = itemHaloCosmic.getMask();
                final TextureAtlasSprite cosmicTextureAtlasSprite = textureMap.registerSprite(new ResourceLocation(texturesPath + mask));
                itemCosmicTexturesMap.put(nameString, cosmicTextureAtlasSprite);
            }
        });

        RegisterItem.COSMIC_ITEM_REG_LIST.forEach(item -> {
            if (item instanceof AvaritiaItemCosmic itemCosmic) {
                final String texturesPath = AvaritiaItemHaloCosmic.texturesPath;

                final String mask = itemCosmic.getMask();
                final ResourceLocation registryName = item.getRegistryName();
                assert registryName != null;
                final String nameString = registryName.toString();

                final TextureAtlasSprite textureAtlasSpriteMask =textureMap.registerSprite(new ResourceLocation(texturesPath + mask));
                itemCosmicTexturesMap.put(nameString, textureAtlasSpriteMask);
            }
        });
        RegisterItem.clearCache();
    }

}
