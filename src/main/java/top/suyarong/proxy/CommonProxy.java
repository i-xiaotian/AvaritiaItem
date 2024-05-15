package top.suyarong.proxy;


import top.suyarong.items.registry.AvaritiaItemRegisterFactory;
import top.suyarong.items.registry.RegisterItem;

public class CommonProxy {

    public CommonProxy() {

    }

    public void preInit() {
        AvaritiaItemRegisterFactory.createItems();
        RegisterItem.registerItems();
    }

    public void init() {

    }

}
