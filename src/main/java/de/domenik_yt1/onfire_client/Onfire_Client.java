package de.domenik_yt1.onfire_client;

import com.mojang.blaze3d.platform.InputConstants;
import de.domenik_yt1.onfire_client.config.OnFireConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;

public class Onfire_Client implements ModInitializer {

    public static final String MOD_ID = "onfire_client";

    @Override
    public void onInitialize() {
        KeyMapping.Category MAIN = KeyMapping.Category.register(
                Identifier.fromNamespaceAndPath(MOD_ID, "main")
        );

        KeyMapping CONFIG = KeyBindingHelper.registerKeyBinding(
                new KeyMapping(
                        "key." + MOD_ID + ".config",
                        InputConstants.Type.KEYSYM,
                        GLFW.GLFW_KEY_RIGHT_SHIFT,
                        MAIN
                ));


        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (CONFIG.consumeClick()) {
                if (client.player != null) {
                    Minecraft mc = Minecraft.getInstance();

                    mc.setScreen(OnFireConfig.createScreen(null));
                }
            }
        });
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}