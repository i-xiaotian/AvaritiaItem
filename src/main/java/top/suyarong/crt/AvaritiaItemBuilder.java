package top.suyarong.crt;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.avaritiaitem.AvaritiaItemBuilder")
@SuppressWarnings("unused")
public class AvaritiaItemBuilder {

    @ZenMethod("registerItem")
    public static ItemPrimer registerItem(String name) {
        return new ItemPrimer(name);
    }

    @ZenMethod("registerItem")
    public static ItemPrimer registerItem(String name, int maxStackSize) {
        return new ItemPrimer(name, maxStackSize);
    }

    @ZenMethod("registerItem")
    public static ItemPrimer registerItem(String name, int maxStackSize, String type) {
        return new ItemPrimer(name, maxStackSize, type);
    }

    //TODO future weapon & tools

}
