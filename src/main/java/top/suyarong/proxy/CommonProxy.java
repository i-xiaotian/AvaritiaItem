package top.suyarong.proxy;


import codechicken.lib.texture.TextureUtils;
import net.minecraftforge.common.MinecraftForge;
import top.suyarong.items.AvaritiaItemRegisterFactory;
import top.suyarong.items.registry.RegisterItem;

public class CommonProxy {

    public CommonProxy() {

    }

    public void preInit() {
        AvaritiaItemRegisterFactory.createItems();
        MinecraftForge.EVENT_BUS.register(new RegisterItem());
    }

    public void init() {

    }

}
