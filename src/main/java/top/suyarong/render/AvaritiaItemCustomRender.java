package top.suyarong.render;

import morph.avaritia.client.render.item.CosmicItemRender;
import morph.avaritia.client.render.item.HaloRenderItem;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.model.IModelState;

public class AvaritiaItemCustomRender extends HaloRenderItem {

    private boolean showHalo;

    private boolean showCosmicMask;

    private CosmicItemRender cosmicItemRender;

    public AvaritiaItemCustomRender(final IModelState state, final IBakedModel model) {
        super(state, model);
    }

    public AvaritiaItemCustomRender(final IModelState state, final IWrappedModelGetter getter) {
        super(state, getter);
    }

    public AvaritiaItemCustomRender(final IModelState state, final IWrappedModelGetter getter, final boolean showHalo, final boolean showCosmicMask, final CosmicItemRender cosmicItemRender) {
        super(state, getter);
        this.showHalo = showHalo;
        this.showCosmicMask = showCosmicMask;
        this.cosmicItemRender = cosmicItemRender;
    }

    @Override
    public void renderItem(final ItemStack itemStack, final ItemCameraTransforms.TransformType transformType) {
        if (showHalo) {
            super.renderItem(itemStack, transformType);
        }
        if (showCosmicMask) {
            cosmicItemRender.renderItem(itemStack, transformType);
        }
    }

}
