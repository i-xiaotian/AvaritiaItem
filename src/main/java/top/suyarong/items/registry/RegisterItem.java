package top.suyarong.items.registry;

import net.minecraftforge.fml.common.registry.ForgeRegistries;
import top.suyarong.items.AvaritiaBasicItem;

import java.util.ArrayList;
import java.util.List;

public class RegisterItem {

    public static final List<AvaritiaBasicItem> HALO_ITEM_REG_LIST = new ArrayList<>();
    public static final List<AvaritiaBasicItem> COSMIC_ITEM_REG_LIST = new ArrayList<>();
    public static final List<AvaritiaBasicItem> HALO_COSMIC_ITEM_REG_LIST = new ArrayList<>();

    public static void registerItems() {
        prepareRegModel();
        registerAvaritiaItems();
    }

    private static void prepareRegModel() {
        RegisterModel.ITEM_MODEL_REG_LIST.addAll(HALO_ITEM_REG_LIST);
        RegisterModel.ITEM_MODEL_REG_LIST.addAll(COSMIC_ITEM_REG_LIST);
        RegisterModel.ITEM_MODEL_REG_LIST.addAll(HALO_COSMIC_ITEM_REG_LIST);
    }

    private static void registerAvaritiaItems() {
        ForgeRegistries.ITEMS.registerAll(HALO_ITEM_REG_LIST.toArray(new AvaritiaBasicItem[0]));
        ForgeRegistries.ITEMS.registerAll(COSMIC_ITEM_REG_LIST.toArray(new AvaritiaBasicItem[0]));
        ForgeRegistries.ITEMS.registerAll(HALO_COSMIC_ITEM_REG_LIST.toArray(new AvaritiaBasicItem[0]));
    }

    public static void clearCache() {
        HALO_ITEM_REG_LIST.clear();
        COSMIC_ITEM_REG_LIST.clear();
        HALO_COSMIC_ITEM_REG_LIST.clear();
    }


}
