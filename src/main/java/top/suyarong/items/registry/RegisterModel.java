package top.suyarong.items.registry;

import top.suyarong.items.AvaritiaBasicItem;

import java.util.ArrayList;
import java.util.List;

public class RegisterModel {
    public static final List<AvaritiaBasicItem> ITEM_MODEL_REG_LIST = new ArrayList<>();

    public static void registryItemModels() {
        ITEM_MODEL_REG_LIST.forEach(AvaritiaBasicItem::registerModels);
        ITEM_MODEL_REG_LIST.clear();
    }

}
