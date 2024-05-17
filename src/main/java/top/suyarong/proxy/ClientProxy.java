package top.suyarong.proxy;

import codechicken.lib.texture.TextureUtils;
import net.minecraftforge.common.MinecraftForge;
import top.suyarong.items.registry.RegisterModel;
import top.suyarong.items.render.AvaritiaItemHoverTextEdit;
import top.suyarong.items.render.AvaritiaItemTextures;
import top.suyarong.utils.ResourceGenerator;

@SuppressWarnings("unused")
public class ClientProxy extends CommonProxy{

    @Override
    public void preInit() {
        super.preInit();
        TextureUtils.addIconRegister(new AvaritiaItemTextures());
        ResourceGenerator.generateItemModel(RegisterModel.ITEM_MODEL_REG_LIST);
        RegisterModel.registryItemModels();
        MinecraftForge.EVENT_BUS.register(new AvaritiaItemHoverTextEdit());
    }



    @Override
    public void init() {
        super.init();
    }
}
