package top.suyarong.items.render;


import morph.avaritia.util.TextUtils;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import top.suyarong.items.AvaritiaBasicItem;

import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
public class AvaritiaItemHoverTextEdit {

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onTooltip(ItemTooltipEvent event) {
        if (event.getItemStack().getItem() instanceof AvaritiaBasicItem item) {

            final List<ColorfulToolTip> colorfulToolTips = item.getColorfulToolTips();
            final boolean colorfulName = item.getColorfulName();
            if (colorfulName) {
                final String itemName = event.getToolTip().get(0);
                event.getToolTip().set(0, TextUtils.makeFabulous(itemName.substring(0, itemName.length() - 2)));
            }

            if (Objects.isNull(colorfulToolTips) || colorfulToolTips.isEmpty()) return;

            for (int i = 1; i <= colorfulToolTips.size(); i++) {
                final ColorfulToolTip colorfulToolTip = colorfulToolTips.get(i - 1);
                final String toolTip = colorfulToolTip.getToolTip();
                final boolean isColorful = colorfulToolTip.isColorfulToolTip();
                final String tooltipString = isColorful ? TextUtils.makeFabulous(toolTip) : toolTip;
                event.getToolTip().add(i, tooltipString);
            }


        }
    }



}
