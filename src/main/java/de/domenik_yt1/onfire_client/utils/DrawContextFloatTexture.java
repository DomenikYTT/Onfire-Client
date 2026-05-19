package de.domenik_yt1.onfire_client.utils;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import net.minecraft.resources.Identifier;

public interface DrawContextFloatTexture {
    default void onfire_client$drawGuiTexture(RenderPipeline pipeline, Identifier texture, float x, float y, int width, int height) {}
}
