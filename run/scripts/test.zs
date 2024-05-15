
#loader avaritiaitem

import mods.avaritiaitem.AvaritiaItemBuilder;
import mods.avaritiaitem.ItemPrimer;

AvaritiaItemBuilder.registerItem("copper_coil", 4, "resource")
    .shouldDrawHalo(true)
    .shouldDrawPulse(true)
    .haloSize(12)
    .create();

AvaritiaItemBuilder.registerItem("eternal_singularity", 1, "singularity")
    .shouldDrawCosmic(true)
    .mask("eternal_singularity_mask")
    .maskOpacity(1.0f)
    .create();

AvaritiaItemBuilder.registerItem("eternal_singularity", 1, "singularity")
    .shouldDrawCosmic(true)
    .mask("eternal_singularity_mask")
    .maskOpacity(1.0f)
    .create();
