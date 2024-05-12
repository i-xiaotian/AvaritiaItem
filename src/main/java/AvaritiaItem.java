import net.minecraftforge.fml.common.Mod;
import top.suyarong.Tags;

@Mod(modid = AvaritiaItem.modId, name = AvaritiaItem.modName, version = AvaritiaItem.version,
        dependencies = "required-after:forge@[14.23.5.2847,);" +
                "required-after:avaritia@[3.3.0,);",
        acceptedMinecraftVersions = "[1.12, 1.13)")
public class AvaritiaItem {

    public static final String modId = "avaritia_item";

    public static final String modName = "AvaritiaItem(无尽物品)";

    public static final String version = Tags.VERSION;

}
