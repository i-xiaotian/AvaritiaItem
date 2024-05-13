package top.suyarong.items;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class AvaritiaItemRegisterFactory<T extends Item> implements ItemFactory<T> {
    @Override
    public T createItem() {
        return null;
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        AvaritiaItemHalo copperCoil = new AvaritiaItemHalo("copper_coil");
        event.getRegistry().register(copperCoil);
        copperCoil.registerModels();
    }

}
