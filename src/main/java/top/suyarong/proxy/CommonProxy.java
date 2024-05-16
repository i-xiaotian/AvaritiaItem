package top.suyarong.proxy;


import crafttweaker.CraftTweakerAPI;
import top.suyarong.crt.AvaritiaItemBuilder;
import top.suyarong.crt.ItemPrimer;
import top.suyarong.items.registry.AvaritiaItemRegisterFactory;
import top.suyarong.items.registry.RegisterItem;

public class CommonProxy {

    public CommonProxy() {

    }

    public void preInit() {
        CraftTweakerAPI.registerClass(ItemPrimer.class);
        CraftTweakerAPI.registerClass(AvaritiaItemBuilder.class);
        CraftTweakerAPI.tweaker.loadScript(false, "avaritiaitem");
        AvaritiaItemRegisterFactory.createItems();
        RegisterItem.registerItems();
    }
    public void init() {

    }

}
