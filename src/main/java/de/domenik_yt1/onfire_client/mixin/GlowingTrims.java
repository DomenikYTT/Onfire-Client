package de.domenik_yt1.onfire_client.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import de.domenik_yt1.onfire_client.config.OnFireConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.layers.EquipmentLayerRenderer;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Environment(EnvType.CLIENT)
@Mixin(EquipmentLayerRenderer.class)
public class GlowingTrims {

    @ModifyVariable(method = "renderLayers(Lnet/minecraft/client/resources/model/EquipmentClientInfo$LayerType;Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/client/model/Model;Ljava/lang/Object;Lnet/minecraft/world/item/ItemStack;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;II)V",
    at = @At("HEAD"),
    ordinal = 0,
    argsOnly = true
    )
    private int modifyLight(int originalLight, @Local(argsOnly = true) ItemStack stack) {
        if (!OnFireConfig.GlowingArmortrims) { return originalLight; }

        if (stack != null && stack.has(DataComponents.TRIM)) {
            return 15728880;
        }
        return originalLight;
    }
}
