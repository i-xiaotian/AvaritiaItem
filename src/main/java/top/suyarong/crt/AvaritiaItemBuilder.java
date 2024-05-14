package top.suyarong.crt;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("mods.avaritiaitem.AvaritiaItemBuilder")
public class AvaritiaItemBuilder {

    @ZenMethod("registerItem")
    public static ItemPrimer registerItem(String name) {
        return new ItemPrimer(name);
    }

    @ZenMethod("registerItem")
    public static ItemPrimer registerItem(String name, int maxStackSize) {
        return new ItemPrimer(name, maxStackSize);
    }

    //TODO future weapon & tools

}
