package de.domenik_yt1.onfire_client.client;

import de.domenik_yt1.onfire_client.client.utils.MapTooltipComponent;
import de.domenik_yt1.onfire_client.config.OnFireConfig;
import de.domenik_yt1.onfire_client.utils.MapTooltipData;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.TooltipComponentCallback;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.world.item.ItemStack;

public class Onfire_ClientClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        OnFireConfig.read();
        TooltipComponentCallback.EVENT.register(data -> data instanceof MapTooltipData mapTooltipData ? Onfire_ClientClient.createTooltipComponent(mapTooltipData) : null);
    }

    public static ClientTooltipComponent createTooltipComponent(MapTooltipData data) {
        return new MapTooltipComponent(data.stack());
    }
}
