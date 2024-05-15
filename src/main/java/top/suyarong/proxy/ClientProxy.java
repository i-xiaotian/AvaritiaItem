package top.suyarong.proxy;

import codechicken.lib.texture.TextureUtils;
import net.minecraftforge.common.MinecraftForge;
import top.suyarong.items.registry.RegisterModel;
import top.suyarong.render.AvaritiaItemTextures;

public class ClientProxy extends CommonProxy{

    public ClientProxy() {
    }

    @Override
    public void preInit() {
        super.preInit();
        TextureUtils.addIconRegister(new AvaritiaItemTextures());
        RegisterModel.registryItemModels();
    }



    @Override
    public void init() {
        super.init();
    }
}
