package top.suyarong.crt;

import crafttweaker.CraftTweakerAPI;
import org.apache.commons.lang3.StringUtils;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import top.suyarong.items.registry.AvaritiaItemRegisterFactory;
import top.suyarong.items.render.ColorfulToolTip;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ZenClass("mods.avaritiaitem.ItemPrimer")
@SuppressWarnings("unused")
public class ItemPrimer {

    private String name;

    private int maxStackSize;

    private String type;

    private boolean shouldDrawHalo;

    private String haloTextures;

    private String haloColour;

    private int haloSize;

    private boolean shouldDrawPulse;

    private String mask;

    private float maskOpacity;

    private boolean shouldDrawCosmic;

    private boolean colorfulName;

    private List<ColorfulToolTip> colorfulToolTips;

    public ItemPrimer() {
        this.colorfulToolTips = new ArrayList<>();
    }

    public ItemPrimer(String name) {
        setItemName(name);
    }

    public ItemPrimer(String name, int maxStackSize) {
        setItemName(name);
        setItemMaxStackSize(maxStackSize);
    }

    public ItemPrimer(String name, int maxStackSize, String type) {
        setItemName(name);
        setItemMaxStackSize(maxStackSize);
        setType(type);
    }

    public String getName() {
        return name;
    }

    @ZenMethod("name")
    public ItemPrimer setName(String name) {
        setItemName(name);
        return this;
    }

    public int getMaxStackSize() {
        return maxStackSize;
    }

    @ZenMethod("maxStackSize")
    public ItemPrimer setMaxStackSize(int maxStackSize) {
        setItemMaxStackSize(maxStackSize);
        return this;
    }

    public boolean isShouldDrawHalo() {
        return shouldDrawHalo;
    }

    @ZenMethod("shouldDrawHalo")
    public ItemPrimer setShouldDrawHalo(boolean shouldDrawHalo) {
        this.shouldDrawHalo = shouldDrawHalo;
        return this;
    }

    public String getHaloTextures() {
        return haloTextures;
    }

    @ZenMethod("haloTextures")
    public ItemPrimer setHaloTextures(String haloTextures) {
        this.haloTextures = haloTextures;
        return this;
    }

    public String getHaloColour() {
        return haloColour;
    }

    @ZenMethod("haloColour")
    public ItemPrimer setHaloColour(String haloColour) {
        this.haloColour = isValidHexColor(haloColour).toUpperCase();
        return this;
    }

    private String isValidHexColor(String hexColor) {
        if (hexColor.length() != 6) {
            CraftTweakerAPI.logWarning(String.format("[AvaritiaItem] Invalid haloColour %s, it has been changed to white(FFFFFF).", hexColor));
            hexColor = "FFFFFF";
        }
        for (char c : hexColor.toCharArray()) {
            if (!((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f'))) {
                CraftTweakerAPI.logWarning(String.format("[AvaritiaItem] Invalid haloColour %s, it has been changed to white(FFFFFF).", hexColor));
                hexColor = "FFFFFF";
                break;
            }
        }
        return hexColor;
    }

    public int getHaloSize() {
        return haloSize;
    }

    @ZenMethod("haloSize")
    public ItemPrimer setHaloSize(int haloSize) {
        if (haloSize <= 0 || haloSize > 16) {
            this.haloSize = 8;
            CraftTweakerAPI.logWarning(String.format("[AvaritiaItem] Invalid haloSize %s, range: 1-16. it has been changed to 8", haloSize));
        } else {
            this.haloSize = haloSize;
        }
        return this;
    }

    public boolean isShouldDrawPulse() {
        return shouldDrawPulse;
    }

    @ZenMethod("shouldDrawPulse")
    public ItemPrimer setShouldDrawPulse(boolean shouldDrawPulse) {
        this.shouldDrawPulse = shouldDrawPulse;
        return this;
    }

    public String getMask() {
        return mask;
    }

    @ZenMethod("shouldDrawCosmic")
    public ItemPrimer setShouldDrawCosmic(boolean shouldDrawCosmic) {
        this.shouldDrawCosmic = shouldDrawCosmic;
        return this;
    }

    public boolean isShouldDrawCosmic() {
        return shouldDrawCosmic;
    }

    @ZenMethod("mask")
    public ItemPrimer setMask(String mask) {
        this.mask = mask;
        return this;
    }

    public float getMaskOpacity() {
        return maskOpacity;
    }

    @ZenMethod("maskOpacity")
    public ItemPrimer setMaskOpacity(float maskOpacity) {
        this.maskOpacity = maskOpacity;
        return this;
    }

    private void setItemMaxStackSize(int maxStackSize) {
        if (maxStackSize <= 0 || maxStackSize > 64) {
            this.maxStackSize = 64;
            CraftTweakerAPI.logWarning(String.format("[AvaritiaItem] Invalid maxStackSize %s, it has been changed to 64.", maxStackSize));
        } else {
            this.maxStackSize = maxStackSize;
        }
    }

    private void setItemName(String name) {
        if (StringUtils.isBlank(name)) {
            CraftTweakerAPI.logError("[AvaritiaItem] item name can not be null or blank ");
            throw new IllegalArgumentException("[AvaritiaItem] item name can not be null or blank");
        }
        String lowerCase = name.toLowerCase();
        if (!StringUtils.equals(name, lowerCase)) {
            CraftTweakerAPI.logWarning(String.format("[AvaritiaItem] unsafe item name %s, suggest using lowercase letters.", name));
        }
        if (Character.isDigit(name.charAt(0))) {
            CraftTweakerAPI.logWarning(String.format("[AvaritiaItem] unsafe item name %s, suggest starting with a word.", name));
        }

        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @ZenMethod
    public void create() {
        final String itemName = this.getName();
        final ItemPrimer itemPrimer = AvaritiaItemRegisterFactory.ITEM_PRIMER_LIST.stream()
                .filter(item -> item.getName().equals(itemName))
                .findFirst()
                .orElse(null);
        if (Objects.nonNull(itemPrimer)) {
            CraftTweakerAPI.logError(String.format("[AvaritiaItem] duplicate itemName Error, %s already exist", itemName));
            throw new IllegalArgumentException(String.format("[AvaritiaItem] duplicate itemName Error, %s already exist", itemName));
        }
        if (shouldDrawCosmic) {
            if (StringUtils.isBlank(mask)) {
                CraftTweakerAPI.logError("[AvaritiaItem] if shouldDrawCosmic is true, mask can not be null or empty");
                throw new IllegalArgumentException("[AvaritiaItem] if shouldDrawCosmic is true, mask can not be null or empty");
            }
        }
        AvaritiaItemRegisterFactory.ITEM_PRIMER_LIST.add(this);
    }

    @ZenMethod("colorfulName")
    public ItemPrimer setColorfulName(boolean colorfulName) {
        this.colorfulName = colorfulName;
        return this;
    }

    @ZenMethod
    public ItemPrimer addTooltip(String tooltip) {
        this.colorfulToolTips.add(new ColorfulToolTip(tooltip));
        return this;
    }

    @ZenMethod
    public ItemPrimer addTooltip(String tooltip, boolean colorfulTooltip) {
        this.colorfulToolTips.add(new ColorfulToolTip(tooltip, colorfulTooltip));
        return this;
    }

    public boolean getColorfulName() {
        return this.colorfulName;
    }

    public List<ColorfulToolTip> getColorfulToolTips() {
        return this.colorfulToolTips;
    }
}
