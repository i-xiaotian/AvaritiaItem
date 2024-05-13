package top.suyarong.crt;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import org.apache.commons.lang3.StringUtils;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import top.suyarong.items.AvaritiaItemRegisterFactory;

@ZenRegister
@ZenClass("mods.avaritiaitem.ItemPrimitive")
@SuppressWarnings("unused")
public class ItemPrimitive {

    private String name;

    private int maxStackSize;

    private boolean shouldDrawHalo;

    private String haloTextures;

    private int haloColour;

    private int haloSize;

    private boolean shouldDrawPulse;

    private String mask;

    private float maskOpacity;

    public ItemPrimitive() {
    }

    public ItemPrimitive(String name) {
        setItemName(name);
    }

    public ItemPrimitive(String name, int maxStackSize) {
        setItemName(name);
        setItemMaxStackSize(maxStackSize);
    }

    public String getName() {
        return name;
    }

    @ZenMethod("name")
    public ItemPrimitive setName(String name) {
        setItemName(name);
        return this;
    }

    public int getMaxStackSize() {
        return maxStackSize;
    }

    @ZenMethod("maxStackSize")
    public ItemPrimitive setMaxStackSize(int maxStackSize) {
        setItemMaxStackSize(maxStackSize);
        return this;
    }

    public boolean isShouldDrawHalo() {
        return shouldDrawHalo;
    }

    @ZenMethod("shouldDrawHalo")
    public ItemPrimitive setShouldDrawHalo(boolean shouldDrawHalo) {
        this.shouldDrawHalo = shouldDrawHalo;
        return this;
    }

    public String getHaloTextures() {
        return haloTextures;
    }

    @ZenMethod("haloTextures")
    public ItemPrimitive setHaloTextures(String haloTextures) {
        this.haloTextures = haloTextures;
        return this;
    }

    public int getHaloColour() {
        return haloColour;
    }

    @ZenMethod("haloColour")
    public ItemPrimitive setHaloColour(int haloColour) {
        if (haloColour < 0x000000 || haloColour > 0xFFFFFF) {
            this.maxStackSize = 0xFFFFFF;
            CraftTweakerAPI.logWarning(String.format("[AvaritiaItem] Invalid haloColour %s, it has being change to white.", haloColour));
        } else {
            this.haloColour = haloColour;
        }
        return this;
    }

    public int getHaloSize() {
        return haloSize;
    }

    @ZenMethod("haloSize")
    public ItemPrimitive setHaloSize(int haloSize) {
        if (haloSize <= 0 || haloSize > 16) {
            this.haloSize = 8;
            CraftTweakerAPI.logWarning(String.format("[AvaritiaItem] Invalid haloSize %s, range: 1-16. it has be change to 8", haloSize));
        } else {
            this.haloSize = haloSize;
        }
        return this;
    }

    public boolean isShouldDrawPulse() {
        return shouldDrawPulse;
    }

    @ZenMethod("shouldDrawPulse")
    public ItemPrimitive setShouldDrawPulse(boolean shouldDrawPulse) {
        this.shouldDrawPulse = shouldDrawPulse;
        return this;
    }

    public String getMask() {
        return mask;
    }

    @ZenMethod("mask")
    public ItemPrimitive setMask(String mask) {
        this.mask = mask;
        return this;
    }

    public float getMaskOpacity() {
        return maskOpacity;
    }

    @ZenMethod("maskOpacity")
    public ItemPrimitive setMaskOpacity(float maskOpacity) {
        this.maskOpacity = maskOpacity;
        return this;
    }

    @ZenMethod
    public void create() {
        AvaritiaItemRegisterFactory.itemPrimitiveList.add(this);
    }

    private void setItemMaxStackSize(int maxStackSize) {
        if (maxStackSize <= 0 || maxStackSize > 64) {
            this.maxStackSize = 64;
            CraftTweakerAPI.logWarning(String.format("[AvaritiaItem] Invalid maxStackSize %s, it has being change to 64.", maxStackSize));
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
}
