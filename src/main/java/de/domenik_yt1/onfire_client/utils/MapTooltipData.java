package de.domenik_yt1.onfire_client.utils;

import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;

public record MapTooltipData(ItemStack stack) implements TooltipComponent {
}
