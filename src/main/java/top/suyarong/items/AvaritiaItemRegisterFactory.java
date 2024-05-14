package top.suyarong.items;

import top.suyarong.crt.ItemPrimer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AvaritiaItemRegisterFactory<T extends AvaritiaBasicItem> {

    public static final List<ItemPrimer> ITEM_PRIMER_LIST = new ArrayList<>();

    public static <T extends AvaritiaBasicItem> Map<String, T> createItems() {
        ITEM_PRIMER_LIST.forEach(item -> {
            final String name = item.getName();
            final boolean shouldDrawHalo = item.isShouldDrawHalo();
            final boolean shouldDrawPulse = item.isShouldDrawPulse();

            final boolean shouldDrawCosmic = item.isShouldDrawCosmic();

            if (shouldDrawHalo || shouldDrawPulse) {

            } else if (shouldDrawCosmic) {

            } else {

            }



        });
        return null;
    }

//    public static void onItemRegister(RegistryEvent.Register<Item> event) {
//        AvaritiaItemHalo copperCoil = new AvaritiaItemHalo("copper_coil");
//        event.getRegistry().register(copperCoil);
//        copperCoil.registerModels();
//    }

}
