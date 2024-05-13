package top.suyarong;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = AvaritiaItem.MOD_ID, name = AvaritiaItem.MOD_NAME, version = AvaritiaItem.VERSION,
        dependencies = "required-after:forge@[14.23.5.2847,);" +
                "required-after:crafttweaker@[4.0.4,);" +
                "required-after:avaritia@[3.3.0,);",
        acceptedMinecraftVersions = "[1.12, 1.13)")
public class AvaritiaItem {

    public static final String MOD_ID = "avaritia_item";

    public static final String MOD_NAME = "AvaritiaItem(无尽物品)";

    public static final String VERSION = Tags.VERSION;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        event.getModMetadata().version = VERSION;
    }

}
