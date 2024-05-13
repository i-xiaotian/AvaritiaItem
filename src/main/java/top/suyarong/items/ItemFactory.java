package top.suyarong.items;

import net.minecraft.item.Item;

public interface ItemFactory<T extends Item> {

    public T createItem();

}
