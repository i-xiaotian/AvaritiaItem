
#loader avaritiaitem reloadable

import mods.avaritiaitem.AvaritiaItemBuilder;
import mods.avaritiaitem.ItemPrimer;

AvaritiaItemBuilder.registerItem("copper_coil", 4, "resource")
    .shouldDrawHalo(true)
    .shouldDrawPulse(true)
    .haloColour("0000FF")
    .haloSize(8)
    .create();

AvaritiaItemBuilder.registerItem("eternal_singularity", 64, "singularity")
    .shouldDrawCosmic(true)
    .shouldDrawHalo(true)
    .haloColour("B22222")
    .haloSize(12)
    .mask("eternal_singularity_mask")
    .maskOpacity(1.0f)
    .create();

AvaritiaItemBuilder.registerItem("uu_data_card", 16, "uu_data_card")
    .shouldDrawHalo(true)
    .shouldDrawPulse(true)
    .haloSize(16)
    .haloColour("15EF3E")
    .shouldDrawCosmic(true)
    .mask("uu_data_card_mask")
    .maskOpacity(10.0f)
    .create();
