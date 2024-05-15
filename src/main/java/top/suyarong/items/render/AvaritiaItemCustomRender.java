package top.suyarong.items.render;

import codechicken.lib.colour.Colour;
import morph.avaritia.api.IHaloRenderItem;
import morph.avaritia.client.render.item.CosmicItemRender;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.model.IModelState;

import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("unused")
public class AvaritiaItemCustomRender extends CosmicItemRender {

    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    private boolean showHalo;

    private boolean showCosmicMask;


    public AvaritiaItemCustomRender(final IModelState state, final IBakedModel model) {
        super(state, model);
    }

    public AvaritiaItemCustomRender(final IModelState state, final IWrappedModelGetter getter) {
        super(state, getter);
    }

    public AvaritiaItemCustomRender(final IModelState state, final IWrappedModelGetter getter, final boolean showHalo, final boolean showCosmicMask) {
        super(state, getter);
        this.showHalo = showHalo;
        this.showCosmicMask = showCosmicMask;
    }

    @Override
    public void renderItem(final ItemStack itemStack, final ItemCameraTransforms.TransformType transformType) {
        if (showHalo) {
            Tessellator tess = Tessellator.getInstance();
            BufferBuilder buffer = tess.getBuffer();
            if (itemStack.getItem() instanceof final IHaloRenderItem haloRenderItem && transformType == ItemCameraTransforms.TransformType.GUI) {

                GlStateManager.pushMatrix();
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
                //RenderHelper.enableGUIStandardItemLighting();

                GlStateManager.disableAlpha();
                GlStateManager.disableDepth();

                if (haloRenderItem.shouldDrawHalo(itemStack)) {
                    Colour.glColourARGB(haloRenderItem.getHaloColour(itemStack));
                    TextureAtlasSprite sprite = haloRenderItem.getHaloTexture(itemStack);

                    double spread = haloRenderItem.getHaloSize(itemStack) / 16D;
                    double min = 0D - spread;
                    double max = 1D + spread;

                    float minU = sprite.getMinU();
                    float maxU = sprite.getMaxU();
                    float minV = sprite.getMinV();
                    float maxV = sprite.getMaxV();

                    buffer.begin(0x07, DefaultVertexFormats.POSITION_TEX);

                    buffer.pos(max, max, 0).tex(maxU, minV).endVertex();
                    buffer.pos(min, max, 0).tex(minU, minV).endVertex();
                    buffer.pos(min, min, 0).tex(minU, maxV).endVertex();
                    buffer.pos(max, min, 0).tex(maxU, maxV).endVertex();

                    tess.draw();
                }

                if (haloRenderItem.shouldDrawPulse(itemStack)) {
                    GlStateManager.pushMatrix();
                    double scale = random.nextDouble() * 0.15 + 0.95;
                    double trans = (1 - scale) / 2;
                    GlStateManager.translate(trans, trans, 0);
                    GlStateManager.scale(scale, scale, 1.0001);

                    renderModel(wrapped, itemStack, 0.6F);

                    GlStateManager.popMatrix();
                }

                renderModel(wrapped, itemStack);

                GlStateManager.enableAlpha();
                GlStateManager.enableRescaleNormal();
                GlStateManager.enableDepth();

                GlStateManager.disableBlend();
                GlStateManager.popMatrix();
            } else {
                renderModel(wrapped, itemStack);
            }
        }
        if (showCosmicMask) {
            super.renderItem(itemStack, transformType);
        }
    }

}
