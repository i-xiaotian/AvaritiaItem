package top.suyarong.items.registry;

import org.apache.commons.lang3.StringUtils;
import top.suyarong.crt.ItemPrimer;
import top.suyarong.items.AvaritiaItemCosmic;
import top.suyarong.items.AvaritiaItemHalo;
import top.suyarong.items.AvaritiaItemHaloCosmic;

import java.util.ArrayList;
import java.util.List;

public class AvaritiaItemRegisterFactory {

    public static final List<ItemPrimer> ITEM_PRIMER_LIST = new ArrayList<>();

    public static void createItems() {
        ITEM_PRIMER_LIST.forEach(item -> {

            final boolean shouldDrawHalo = item.isShouldDrawHalo();
            final boolean shouldDrawPulse = item.isShouldDrawPulse();
            final boolean shouldDrawCosmic = item.isShouldDrawCosmic();

            final String name = item.getName();
            final int maxStackSize = item.getMaxStackSize();
            final String type = item.getType();

            if (shouldDrawCosmic && !shouldDrawHalo && !shouldDrawPulse) {
                registerCosmicItem(item, name, maxStackSize, type);
            } else if (shouldDrawHalo || shouldDrawPulse) {
                if (shouldDrawCosmic) {
                    registerHaloCosmicItem(item, name, maxStackSize, type, shouldDrawHalo, shouldDrawPulse);
                } else {
                    registerHaloItem(item, name, maxStackSize, type, shouldDrawHalo, shouldDrawPulse);
                }
            }
        });
    }

    private static void registerHaloItem(ItemPrimer item, String name, int maxStackSize, String type, boolean shouldDrawHalo, boolean shouldDrawPulse) {
        AvaritiaItemHalo avaritiaItemHalo = new AvaritiaItemHalo(name, maxStackSize, type);
        avaritiaItemHalo.setHaloColour(item.getHaloColour());
        avaritiaItemHalo.setHaloSize(item.getHaloSize());
        avaritiaItemHalo.setHaloTextures(item.getHaloTextures());
        avaritiaItemHalo.setShouldDrawHalo(shouldDrawHalo);
        avaritiaItemHalo.setShouldDrawPulse(shouldDrawPulse);

        RegisterItem.HALO_ITEM_REG_LIST.add(avaritiaItemHalo);
        RegisterModel.ITEM_MODEL_REG_LIST.add(avaritiaItemHalo);
    }

    private static void registerCosmicItem(ItemPrimer item, String name, int maxStackSize, String type) {
        AvaritiaItemCosmic avaritiaItemCosmic = new AvaritiaItemCosmic(name, maxStackSize, type);
        avaritiaItemCosmic.setMask(item.getMask());
        avaritiaItemCosmic.setMaskOpacity(item.getMaskOpacity());

        RegisterItem.COSMIC_ITEM_REG_LIST.add(avaritiaItemCosmic);
        RegisterModel.ITEM_MODEL_REG_LIST.add(avaritiaItemCosmic);
    }

    private static void registerHaloCosmicItem(ItemPrimer item, String name, int maxStackSize, String type, boolean shouldDrawHalo, boolean shouldDrawPulse) {
        AvaritiaItemHaloCosmic avaritiaItemHaloCosmic = new AvaritiaItemHaloCosmic(name, type);
        avaritiaItemHaloCosmic.setHaloColour(item.getHaloColour());
        avaritiaItemHaloCosmic.setHaloSize(item.getHaloSize());
        avaritiaItemHaloCosmic.setHaloTextures(item.getHaloTextures());
        avaritiaItemHaloCosmic.setShouldDrawHalo(shouldDrawHalo);
        avaritiaItemHaloCosmic.setShouldDrawPulse(shouldDrawPulse);
        avaritiaItemHaloCosmic.setMask(item.getMask());
        avaritiaItemHaloCosmic.setMaskOpacity(item.getMaskOpacity());

        RegisterItem.HALO_COSMIC_ITEM_REG_LIST.add(avaritiaItemHaloCosmic);
        RegisterModel.ITEM_MODEL_REG_LIST.add(avaritiaItemHaloCosmic);
    }
}

