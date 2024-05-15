package top.suyarong.items.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.Objects;

public class AvaritiaItemTab extends CreativeTabs {

    public AvaritiaItemTab(String tabName) {
        super(tabName);
    }

    @Override
    @SuppressWarnings("all")
    public ItemStack createIcon() {
        Item value = ForgeRegistries.ITEMS.getValue(new ResourceLocation("avaritia", "extreme_crafting_table"));
        if (Objects.isNull(value)) return new ItemStack(Blocks.ANVIL);
        return new ItemStack(value);
    }
}
