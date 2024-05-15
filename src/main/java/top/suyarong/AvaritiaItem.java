package top.suyarong;

import codechicken.lib.CodeChickenLib;
import crafttweaker.CraftTweakerAPI;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import top.suyarong.crt.AvaritiaItemBuilder;
import top.suyarong.crt.ItemPrimer;
import top.suyarong.proxy.CommonProxy;
import top.suyarong.items.tab.AvaritiaItemTab;

@Mod(modid = AvaritiaItem.MOD_ID, name = AvaritiaItem.MOD_NAME, version = AvaritiaItem.VERSION,
        dependencies = CodeChickenLib.MOD_VERSION_DEP +
                "required-after:forge@[14.23.5.2847,);" +
                "required-after:crafttweaker@[4.0.4,);" +
                "required-after:avaritia@[3.3.0,);",
        acceptedMinecraftVersions = "[1.12, 1.13)")
public class AvaritiaItem {

    public static final String MOD_ID = "avaritiaitem";

    public static final String MOD_NAME = "AvaritiaItem(无尽物品)";

    public static final String VERSION = Tags.VERSION;

    public static Logger log;

    private static final String CLIENT_PROXY = "top.suyarong.proxy.ClientProxy";

    private static final String COMMON_PROXY = "top.suyarong.proxy.CommonProxy";

    public static CreativeTabs avaritiaItemTab;

    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = COMMON_PROXY)
    public static CommonProxy proxy = null;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        event.getModMetadata().version = VERSION;
        log = event.getModLog();
        avaritiaItemTab = new AvaritiaItemTab(MOD_ID);

        CraftTweakerAPI.registerClass(ItemPrimer.class);
        CraftTweakerAPI.registerClass(AvaritiaItemBuilder.class);

        CraftTweakerAPI.tweaker.loadScript(false, "avaritiaitem");

        proxy.preInit();
    }

    @Mod.EventHandler
    public void postInit(FMLInitializationEvent event) {
        proxy.init();
    }

}
