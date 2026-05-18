package de.domenik_yt1.onfire_client.mixin;

import de.domenik_yt1.onfire_client.config.OnFireConfig;
import de.domenik_yt1.onfire_client.utils.MapTooltipData;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(Item.class)
public abstract class MapInTooltip {
    @Inject(method = "getTooltipImage", at = @At("HEAD"), cancellable = true)
    private void onfire_client$getTooltipImage(ItemStack stack, CallbackInfoReturnable<Optional<TooltipComponent>> callbackInfo) {
        if (stack.is(Items.FILLED_MAP) && stack.get(DataComponents.MAP_ID) != null) {
            if (!OnFireConfig.MapInTooltipEnabled) { return; }
            callbackInfo.setReturnValue(Optional.of(new MapTooltipData(stack.copy())));
            callbackInfo.cancel();
        }
    }
}
