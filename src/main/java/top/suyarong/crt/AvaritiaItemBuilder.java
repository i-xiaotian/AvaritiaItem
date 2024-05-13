package top.suyarong.crt;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("mods.avaritiaitem.AvaritiaItemBuilder")
public class AvaritiaItemBuilder {

    @ZenMethod("registerItem")
    public ItemPrimitive registerItem(String name) {
        return new ItemPrimitive(name);
    }

    @ZenMethod("registerItem")
    public ItemPrimitive registerItem(String name, int maxStackSize) {
        return new ItemPrimitive(name, maxStackSize);
    }

    //TODO future weapon & tools

}
