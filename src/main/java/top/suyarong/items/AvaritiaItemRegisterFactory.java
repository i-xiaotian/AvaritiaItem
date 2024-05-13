package top.suyarong.items;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import top.suyarong.crt.ItemPrimitive;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AvaritiaItemRegisterFactory<T extends AvaritiaBasicItem> {

    public static final List<ItemPrimitive> itemPrimitiveList = new ArrayList<>();

    public static <T extends AvaritiaBasicItem> Map<String, T> createItems() {
        return null;
    }

//    public static void onItemRegister(RegistryEvent.Register<Item> event) {
//        AvaritiaItemHalo copperCoil = new AvaritiaItemHalo("copper_coil");
//        event.getRegistry().register(copperCoil);
//        copperCoil.registerModels();
//    }

}
