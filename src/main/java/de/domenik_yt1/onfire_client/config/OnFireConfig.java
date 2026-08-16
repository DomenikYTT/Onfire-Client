package de.domenik_yt1.onfire_client.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import de.domenik_yt1.onfire_client.client.utils.ColorKey;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.BooleanControllerBuilder;
import dev.isxander.yacl3.api.controller.IntegerSliderControllerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class OnFireConfig {

    public static final Path configDir = FabricLoader.getInstance().getConfigDir().resolve("onfire_client");
    public static final Path configFile = configDir.resolve("config.json");

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    public static boolean MapInSlotEnabled = true;
    public static boolean MapInTooltipEnabled = true;

    public static boolean ColouredShulkerInventory = true;


    public static boolean GlowingArmortrims = true;

    public static int GlowingArmorTrimsStrength = 255;

    public static Screen createScreen(Screen parent) {
        read();
        return YetAnotherConfigLib.createBuilder()
                .title(Component.translatable("onfire_client.config.title"))
                .category(ConfigCategory.createBuilder()
                        .name(Component.translatable("onfire_client.config.title"))
                        .tooltip(Component.translatable("onfire_client.config.tooltip"))
                        .group(OptionGroup.createBuilder()
                                .name(Component.translatable("onfire_client.config_group.name.maps"))
                                .description(OptionDescription.of(Component.translatable("onfire_client.config_group.tooltip.maps")))

                                .option(Option.<Boolean>createBuilder()
                                        .name(Component.translatable("onfire_client.config.name.MapInSlotEnabled"))
                                        .description(OptionDescription.of(Component.translatable("onfire_client.config.tooltip.MapInSlotEnabled")))
                                        .binding(true, () -> MapInSlotEnabled, newVal -> MapInSlotEnabled = newVal)
                                        .controller(opt -> BooleanControllerBuilder.create(opt)
                                                .formatValue(val -> val ? Component.translatable("onfire_client.config.option.yes") : Component.translatable("onfire_client.config.option.no"))
                                        )
                                        .build())

                                .option(Option.<Boolean>createBuilder()
                                        .name(Component.translatable("onfire_client.config.name.MapInTooltipEnabled"))
                                        .description(OptionDescription.of(Component.translatable("onfire_client.config.tooltip.MapInTooltipEnabled")))
                                        .binding(true, () -> MapInTooltipEnabled, newVal -> MapInTooltipEnabled = newVal)
                                        .controller(opt -> BooleanControllerBuilder.create(opt)
                                                .formatValue(val -> val ? Component.translatable("onfire_client.config.option.yes") : Component.translatable("onfire_client.config.option.no"))
                                        )
                                        .build())


                                .build())


                        .group(OptionGroup.createBuilder()
                                .name(Component.translatable("onfire_client.config_group.name.shulker"))
                                .description(OptionDescription.of(Component.translatable("onfire_client.config_group.tooltip.shulker")))

                                .option(Option.<Boolean>createBuilder()
                                        .name(Component.translatable("onfire_client.config.name.shulker_inventory"))
                                        .description(OptionDescription.of(Component.translatable("onfire_client.config.tooltip.shulker_inventory")))
                                        .binding(true, () -> ColouredShulkerInventory, newVal -> ColouredShulkerInventory = newVal)
                                        .controller(opt -> BooleanControllerBuilder.create(opt)
                                                .formatValue(val -> val ? Component.translatable("onfire_client.config.option.yes") : Component.translatable("onfire_client.config.option.no"))
                                        )
                                        .build())


                                .build())

                        .group(OptionGroup.createBuilder()
                                .name(Component.translatable("onfire_client.config_group.name.miscellaneous"))
                                .description(OptionDescription.of(Component.translatable("onfire_client.config_group.tooltip.miscellaneous")))
                                .option(Option.<Boolean>createBuilder()
                                        .name(Component.translatable("onfire_client.config.name.glowing_armor-trims"))
                                        .description(OptionDescription.of(Component.translatable("onfire_client.config.tooltip.glowing_armor-trims")))
                                        .binding(true, () -> GlowingArmortrims, newVal -> GlowingArmortrims = newVal)
                                        .controller(opt -> BooleanControllerBuilder.create(opt)
                                                .formatValue(val -> val ? Component.translatable("onfire_client.config.option.yes") : Component.translatable("onfire_client.config.option.no"))
                                        )
                                        .build())

                                .option(Option.<Integer>createBuilder()
                                        .name(Component.translatable("onfire_client.config.name.glowing_armor-trims-slider"))
                                        .description(OptionDescription.of(Component.translatable("onfire_client.config.tooltip.glowing_armor-trims-slider")))
                                        .binding(255, () -> GlowingArmorTrimsStrength, newVal -> GlowingArmorTrimsStrength = newVal)
                                        .controller(opt -> IntegerSliderControllerBuilder.create(opt)
                                                .range(0, 255)
                                                .step(1)
                                                .valueFormatter(val -> Component.literal((Math.round((val / 255.0) * 100) + "%")))
                                        )



                                        .build())

                                .build())



                        .build()
                ).save(OnFireConfig::write)
                .build()
                .generateScreen(parent);
    }


    public static void write() {
        try {
            if (Files.notExists(configDir)) {
                Files.createDirectory(configDir);
            }
            Files.deleteIfExists(configFile);
            JsonObject json = new JsonObject();
            json.addProperty("map_in_slot_enabled", MapInSlotEnabled);
            json.addProperty("map_in_tooltip", MapInTooltipEnabled);
            json.addProperty("coloured_shulker_inventory", ColouredShulkerInventory);



            Files.writeString(configFile, GSON.toJson(json));
        } catch (Exception e) {

        }
    }


    public static void read() {
        try {
            if (Files.notExists(configDir)) {
                write();
            }

            JsonObject json = GSON.fromJson(Files.readString(configFile), JsonObject.class);

            if (json.has("map_in_slot_enabled")) {
                MapInSlotEnabled = json.get("map_in_slot_enabled").getAsBoolean();
            }
            if (json.has("map_in_tooltip")) {
                MapInTooltipEnabled = json.get("map_in_tooltip").getAsBoolean();
            }
            if (json.has("coloured_shulker_inventory")) {
                ColouredShulkerInventory = json.get("coloured_shulker_inventory").getAsBoolean();
            }

        } catch (Exception e) {

        }
    }


}
