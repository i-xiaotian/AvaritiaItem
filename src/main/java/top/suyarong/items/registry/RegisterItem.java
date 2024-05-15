package top.suyarong.items.registry;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import top.suyarong.AvaritiaItem;
import top.suyarong.items.AvaritiaBasicItem;

import java.util.ArrayList;
import java.util.List;

public class RegisterItem {

    public static final List<AvaritiaBasicItem> HALO_ITEM_REG_LIST = new ArrayList<>();
    public static final List<AvaritiaBasicItem> COSMIC_ITEM_REG_LIST = new ArrayList<>();
    public static final List<AvaritiaBasicItem> HALO_COSMIC_ITEM_REG_LIST = new ArrayList<>();

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        HALO_ITEM_REG_LIST.forEach(RegisterItem::prepareRegModel);
        COSMIC_ITEM_REG_LIST.forEach(RegisterItem::prepareRegModel);
        HALO_COSMIC_ITEM_REG_LIST.forEach(RegisterItem::prepareRegModel);

        registerAvaritiaItems(event);
    }

    private static void prepareRegModel(AvaritiaBasicItem item) {
        RegisterModel.ITEM_MODEL_REG_LIST.add(item);
    }

    private static void registerAvaritiaItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(HALO_ITEM_REG_LIST.toArray(new AvaritiaBasicItem[0]));
        event.getRegistry().registerAll(COSMIC_ITEM_REG_LIST.toArray(new AvaritiaBasicItem[0]));
        event.getRegistry().registerAll(HALO_COSMIC_ITEM_REG_LIST.toArray(new AvaritiaBasicItem[0]));
    }

    public static void clearCache() {
        HALO_ITEM_REG_LIST.clear();
        COSMIC_ITEM_REG_LIST.clear();
        HALO_COSMIC_ITEM_REG_LIST.clear();
    }


}
