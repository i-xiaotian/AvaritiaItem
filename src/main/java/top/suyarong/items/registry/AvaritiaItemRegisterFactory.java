package top.suyarong.items.registry;

import org.apache.commons.lang3.StringUtils;
import top.suyarong.crt.ItemPrimer;
import top.suyarong.items.AvaritiaBasicItem;
import top.suyarong.items.AvaritiaItemCosmic;
import top.suyarong.items.AvaritiaItemHalo;
import top.suyarong.items.AvaritiaItemHaloCosmic;
import top.suyarong.items.render.ColorfulToolTip;

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

            AvaritiaBasicItem avaritiaBasicItem = null;

            if (shouldDrawCosmic && !shouldDrawHalo && !shouldDrawPulse) {
                avaritiaBasicItem = registerCosmicItem(item, name, maxStackSize, type);
            } else if (shouldDrawHalo || shouldDrawPulse) {
                if (shouldDrawCosmic) {
                    avaritiaBasicItem = registerHaloCosmicItem(item, name, maxStackSize, type, shouldDrawHalo, shouldDrawPulse);
                } else {
                    avaritiaBasicItem = registerHaloItem(item, name, maxStackSize, type, shouldDrawHalo, shouldDrawPulse);
                }
            }
            if (!shouldDrawCosmic && !shouldDrawHalo && !shouldDrawPulse) {
                avaritiaBasicItem = registerHaloItem(item, name, maxStackSize, type, false, false);
            }

            RegisterModel.ITEM_MODEL_REG_LIST.add(avaritiaBasicItem);
        });
        ITEM_PRIMER_LIST.clear();
    }

    private static AvaritiaBasicItem registerHaloItem(ItemPrimer item, String name, int maxStackSize, String type, boolean shouldDrawHalo, boolean shouldDrawPulse) {

        final String haloColour = item.getHaloColour();
        final int haloOpacity = item.getHaloOpacity();
        final boolean colorfulName = item.getColorfulName();
        final List<ColorfulToolTip> colorfulToolTips = item.getColorfulToolTips();

        AvaritiaItemHalo avaritiaItemHalo = new AvaritiaItemHalo(name, maxStackSize, type);
        avaritiaItemHalo.setHaloColour(getHexColor(haloOpacity, haloColour));
        avaritiaItemHalo.setHaloSize(item.getHaloSize());
        avaritiaItemHalo.setHaloTextures(item.getHaloTextures());
        avaritiaItemHalo.setShouldDrawHalo(shouldDrawHalo);
        avaritiaItemHalo.setShouldDrawPulse(shouldDrawPulse);
        avaritiaItemHalo.setColorfulName(colorfulName);
        avaritiaItemHalo.setColorfulToolTips(colorfulToolTips);

        RegisterItem.HALO_ITEM_REG_LIST.add(avaritiaItemHalo);
        return avaritiaItemHalo;
    }

    private static AvaritiaBasicItem registerCosmicItem(ItemPrimer item, String name, int maxStackSize, String type) {

        final boolean colorfulName = item.getColorfulName();
        final List<ColorfulToolTip> colorfulToolTips = item.getColorfulToolTips();

        AvaritiaItemCosmic avaritiaItemCosmic = new AvaritiaItemCosmic(name, maxStackSize, type);
        avaritiaItemCosmic.setMask(item.getMask());
        avaritiaItemCosmic.setMaskOpacity(item.getMaskOpacity());
        avaritiaItemCosmic.setColorfulName(colorfulName);
        avaritiaItemCosmic.setColorfulToolTips(colorfulToolTips);

        RegisterItem.COSMIC_ITEM_REG_LIST.add(avaritiaItemCosmic);
        RegisterModel.ITEM_MODEL_REG_LIST.add(avaritiaItemCosmic);
        return avaritiaItemCosmic;
    }

    private static AvaritiaBasicItem registerHaloCosmicItem(ItemPrimer item, String name, int maxStackSize, String type, boolean shouldDrawHalo, boolean shouldDrawPulse) {
        final String haloColour = item.getHaloColour();
        final int haloOpacity = item.getHaloOpacity();

        final boolean colorfulName = item.getColorfulName();
        final List<ColorfulToolTip> colorfulToolTips = item.getColorfulToolTips();

        AvaritiaItemHaloCosmic avaritiaItemHaloCosmic = new AvaritiaItemHaloCosmic(name, maxStackSize, type);
        avaritiaItemHaloCosmic.setHaloColour(getHexColor(haloOpacity, haloColour));
        avaritiaItemHaloCosmic.setHaloSize(item.getHaloSize());
        avaritiaItemHaloCosmic.setHaloTextures(item.getHaloTextures());
        avaritiaItemHaloCosmic.setShouldDrawHalo(shouldDrawHalo);
        avaritiaItemHaloCosmic.setShouldDrawPulse(shouldDrawPulse);
        avaritiaItemHaloCosmic.setMask(item.getMask());
        avaritiaItemHaloCosmic.setMaskOpacity(item.getMaskOpacity());
        avaritiaItemHaloCosmic.setColorfulName(colorfulName);
        avaritiaItemHaloCosmic.setColorfulToolTips(colorfulToolTips);

        RegisterItem.HALO_COSMIC_ITEM_REG_LIST.add(avaritiaItemHaloCosmic);
        RegisterModel.ITEM_MODEL_REG_LIST.add(avaritiaItemHaloCosmic);
        return avaritiaItemHaloCosmic;
    }

    private static int getHexColor(int haloOpacity, String colorString) {
        if (haloOpacity == 0) haloOpacity = 100;
        if (StringUtils.isBlank(colorString)) colorString = "FFFFFF";
        int alpha = (int) (haloOpacity / 100.0 * 255);
        return alpha << 24 | Integer.parseInt(colorString, 16);
    }
}

