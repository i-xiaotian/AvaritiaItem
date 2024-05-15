
#loader avaritiaitem

import mods.avaritiaitem.AvaritiaItemBuilder;
import mods.avaritiaitem.ItemPrimer;

AvaritiaItemBuilder.registerItem("copper_coil", 4, "resource")
    .shouldDrawHalo(true)
    .shouldDrawPulse(true)
    .haloSize(12)
    .create();

AvaritiaItemBuilder.registerItem("eternal_singularity", 16, "singularity")
    .shouldDrawCosmic(true)
    .shouldDrawHalo(true)
    .haloSize(4)
    .mask("eternal_singularity_mask")
    .create();

