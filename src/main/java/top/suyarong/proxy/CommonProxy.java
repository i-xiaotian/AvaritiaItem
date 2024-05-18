package top.suyarong.proxy;


import crafttweaker.CraftTweakerAPI;
import top.suyarong.crt.AvaritiaItemBuilder;
import top.suyarong.crt.ItemPrimer;
import top.suyarong.items.registry.AvaritiaItemRegisterFactory;
import top.suyarong.items.registry.RegisterItem;
import top.suyarong.items.render.ColorfulToolTip;

public class CommonProxy {

    public static boolean itemIsRegister;

    public void preInit() {
        CraftTweakerAPI.registerClass(ItemPrimer.class);
        CraftTweakerAPI.registerClass(AvaritiaItemBuilder.class);
        CraftTweakerAPI.registerClass(ColorfulToolTip.class);
        CraftTweakerAPI.tweaker.loadScript(false, "avaritiaitem");
        AvaritiaItemRegisterFactory.createItems();
        itemIsRegister = true;
        RegisterItem.registerItems();
    }
    public void init() {

    }

}
