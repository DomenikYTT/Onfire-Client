package de.domenik_yt1.onfire_client.client.utils;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class BlockNames {

    public static String RED_SHULKER = getBlockName(Blocks.RED_SHULKER_BOX),
    BLUE_SHULKER = getBlockName(Blocks.BLUE_SHULKER_BOX),
    LIGHT_BLUE_SHULKER = getBlockName(Blocks.LIGHT_BLUE_SHULKER_BOX),
    GRAY_SHULKER = getBlockName(Blocks.GRAY_SHULKER_BOX),
    LIGHT_GRAY_SHULKER = getBlockName(Blocks.LIGHT_GRAY_SHULKER_BOX),
    YELLOW_SHULKER = getBlockName(Blocks.YELLOW_SHULKER_BOX),
    ORANGE_SHULKER = getBlockName(Blocks.ORANGE_SHULKER_BOX),
    PINK_SHULKER = getBlockName(Blocks.PINK_SHULKER_BOX),
    MAGENTA_SHULKER = getBlockName(Blocks.MAGENTA_SHULKER_BOX),
    PURPLE_SHULKER = getBlockName(Blocks.PURPLE_SHULKER_BOX),
    BLACK_SHULKER = getBlockName(Blocks.BLACK_SHULKER_BOX),
    SHULKER = getBlockName(Blocks.SHULKER_BOX),
    CYAN_SHULKER = getBlockName(Blocks.CYAN_SHULKER_BOX),
    GREEN_SHULKER = getBlockName(Blocks.GREEN_SHULKER_BOX),
    LIME_SHULKER = getBlockName(Blocks.LIME_SHULKER_BOX),
    WHITE_SHULKER = getBlockName(Blocks.WHITE_SHULKER_BOX),
    BROWN_SHULKER = getBlockName(Blocks.BROWN_SHULKER_BOX);

    public static String getBlockName(Block block) {
        return block.getName().toString();
    }
}
