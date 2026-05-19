package de.domenik_yt1.onfire_client.mixin;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import de.domenik_yt1.onfire_client.utils.DrawContextFloatTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(GuiGraphics.class)
public class DrawContextMixin implements DrawContextFloatTexture {
    @Unique
    @Final
    Minecraft client;

    @Unique
    public void onfire_client$drawGuiTexture(RenderPipeline pipeline, Identifier texture, float x, float y, int width, int height) {

        if (width == 0 || height == 0) { return; }

        GuiGraphics self = (GuiGraphics) (Object) this;

        self.blitSprite(
                pipeline,
                texture,
                (int) x,
                (int) y,
                width,
                height
        );
    }
}
