package de.domenik_yt1.onfire_client.mixin;


import de.domenik_yt1.onfire_client.client.utils.BlockNames;
import de.domenik_yt1.onfire_client.client.utils.ColorKey;
import de.domenik_yt1.onfire_client.config.OnFireConfig;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.ShulkerBoxScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ShulkerBoxMenu;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static de.domenik_yt1.onfire_client.Onfire_Client.MOD_ID;

@Mixin(ShulkerBoxScreen.class)
public abstract class ShulkerBoxScreenMixin extends AbstractContainerScreen<ShulkerBoxMenu> {

    @Unique
    private static final Identifier DEFAULT_TEXTURE = Identifier.withDefaultNamespace("textures/gui/container/shulker_box.png");

    public ShulkerBoxScreenMixin(ShulkerBoxMenu abstractContainerMenu, Inventory inventory, Component component) {
        super(abstractContainerMenu, inventory, component);
    }

    @Inject(method = "renderBg", at = @At("TAIL"))
    protected void renderBg(GuiGraphics guiGraphics, float f, int i, int j, CallbackInfo ci) {


        if (!OnFireConfig.ColouredShulkerInventory) { return; }
        int k = (this.width - this.imageWidth) / 2;
        int l = (this.height - this.imageHeight) / 2;


        Block block = Block.byItem(Items.SHULKER_BOX);
        if (this.minecraft.level != null && this.minecraft.hitResult != null) {
            if (this.minecraft.hitResult.getType() == HitResult.Type.BLOCK) {
                BlockPos pos = ((BlockHitResult) this.minecraft.hitResult).getBlockPos();
                block = this.minecraft.level.getBlockState(pos).getBlock();
            }
        }
        Identifier OVERLAY_TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/gui/container/shulker_box.png");

        int color = getColor2(block);

        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, OVERLAY_TEXTURE, k, l, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256, color);
    }



    @Unique
    private static int getColor2(Block block) {
        int DEFAULT = ColorKey.SHULKER_BOX;

        if (block == null) {
            return DEFAULT;
        }

        String block_name = block.getName().toString();

        if (block_name.equals(BlockNames.BLUE_SHULKER)) {
            return ColorKey.BLUE_SHULKER_BOX;
        }
        if (block_name.equals(BlockNames.RED_SHULKER)) {
            return ColorKey.RED_SHULKER_BOX;
        }
        if (block_name.equals(BlockNames.YELLOW_SHULKER)) {
            return ColorKey.YELLOW_SHULKER_BOX;
        }
        if (block_name.equals(BlockNames.GREEN_SHULKER)) {
            return ColorKey.GREEN_SHULKER_BOX;
        }
        if (block_name.equals(BlockNames.LIME_SHULKER)) {
            return ColorKey.LIME_SHULKER_BOX;
        }
        if (block_name.equals(BlockNames.ORANGE_SHULKER)) {
            return ColorKey.ORANGE_SHULKER_BOX;
        }
        if (block_name.equals(BlockNames.BLACK_SHULKER)) {
            return ColorKey.BLACK_SHULKER_BOX;
        }
        if (block_name.equals(BlockNames.GRAY_SHULKER)) {
            return ColorKey.GRAY_SHULKER_BOX;
        }
        if (block_name.equals(BlockNames.LIGHT_GRAY_SHULKER)) {
            return ColorKey.LIGHT_GRAY_SHULKER_BOX;
        }
        if (block_name.equals(BlockNames.LIGHT_BLUE_SHULKER)) {
            return ColorKey.LIGHT_BLUE_SHULKER_BOX;
        }
        if (block_name.equals(BlockNames.WHITE_SHULKER)) {
            return ColorKey.WHITE_SHULKER_BOX;
        }
        if (block_name.equals(BlockNames.CYAN_SHULKER)) {
            return ColorKey.CYAN_SHULKER_BOX;
        }
        if (block_name.equals(BlockNames.BROWN_SHULKER)) {
            return ColorKey.BROWN_SHULKER_BOX;
        }
        if (block_name.equals(BlockNames.PINK_SHULKER)) {
            return ColorKey.PINK_SHULKER_BOX;
        }
        if (block_name.equals(BlockNames.MAGENTA_SHULKER)) {
            return ColorKey.MAGENTA_SHULKER_BOX;
        }
        if (block_name.equals(BlockNames.PURPLE_SHULKER)) {
            return ColorKey.PURPLE_SHULKER_BOX;
        }
        return DEFAULT;
    }
}
