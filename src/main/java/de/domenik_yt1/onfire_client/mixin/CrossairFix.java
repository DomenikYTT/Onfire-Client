package de.domenik_yt1.onfire_client.mixin;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Gui.class)
public class CrossairFix {
    @Redirect(
            method = "renderCrosshair",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lcom/mojang/blaze3d/pipeline/RenderPipeline;Lnet/minecraft/resources/Identifier;IIII)V"
            )
    )
    private void drawTextureRedirect(
            GuiGraphics instance, RenderPipeline renderPipeline, Identifier identifier, int x, int y, int width, int height
    ) {
        Minecraft mc = Minecraft.getInstance();

        float centerX = mc.getWindow().getGuiScaledWidth() / 2f;
        float centerY = mc.getWindow().getGuiScaledHeight() / 2f;

        instance.blitSprite(
                renderPipeline,
                identifier,
                (int) (Math.round((centerX - 7.5f) * 4) / 4f),
                (int) (Math.round((centerY - 7.5f) * 4f) / 4f),
                15,
                15
        );
    }
}
