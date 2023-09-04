package org.shane0411.worldeditgui.worldeditgui.config;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import fi.dy.masa.malilib.config.ConfigUtils;
import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.config.IConfigHandler;
import fi.dy.masa.malilib.config.IConfigOptionListEntry;
import fi.dy.masa.malilib.config.options.ConfigBoolean;
import fi.dy.masa.malilib.config.options.ConfigInteger;
import fi.dy.masa.malilib.config.options.ConfigOptionList;
import fi.dy.masa.malilib.config.options.ConfigString;
import fi.dy.masa.malilib.util.FileUtils;
import fi.dy.masa.malilib.util.JsonUtils;
import org.shane0411.worldeditgui.worldeditgui.Reference;
import org.shane0411.worldeditgui.worldeditgui.config.commands.Commands;
import org.shane0411.worldeditgui.worldeditgui.config.commands.Common_Commands;
import org.shane0411.worldeditgui.worldeditgui.util.Offset;
import org.shane0411.worldeditgui.worldeditgui.util.Rotate;

import java.io.File;

public class Configs implements IConfigHandler {
    private static final String CONFIG_FILE_NAME = Reference.MOD_ID + ".json";

    public static class Generic {
        public static final ConfigInteger INIT_INTEGER = InitialInteger("init_integer", 1, 1, 100000);
        public static final ConfigInteger INIT_CHANGE = InitialInteger("init_change", 1, 1, 10000);
        public static final ConfigInteger INIT_RANGE = InitialInteger("init_range", 0, 0, 100);
        public static final ConfigOptionList INIT_OFFSET = InitialOption("init_offset", Offset.ME);
        public static final ConfigOptionList INIT_ANGEL = InitialOption("init_angel", Rotate.RIGHT_ANGLE);
        public static final ConfigString INIT_BLOCK = InitialString("init_block", "hand");
        public static final ConfigString INIT_PLAYER = InitialString("init_player", "");
        public static final ConfigBoolean INIT_A = InitialBoolean("init_a");
        public static final ConfigBoolean INIT_B = InitialBoolean("init_b");
        public static final ConfigBoolean INIT_E = InitialBoolean("init_e");
        public static final ConfigBoolean INIT_R = InitialBoolean("init_r");
        public static final ConfigBoolean INIT_S = InitialBoolean("init_s");
        public static final ConfigBoolean INIT_M = InitialBoolean("init_m");
        public static final ConfigString INIT_M_BLOCK = InitialString("init_mask", "hand");

        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
                INIT_INTEGER,
                INIT_CHANGE,
                INIT_OFFSET,
                INIT_BLOCK,
                INIT_ANGEL,
                INIT_PLAYER,
                INIT_RANGE,
                INIT_A,
                INIT_B,
                INIT_E,
                INIT_R,
                INIT_S,
                INIT_M,
                INIT_M_BLOCK
        );
    }

    private static ConfigBoolean InitialBoolean(String name) {
        return new ConfigBoolean("worldeditgui.generic." + name, false, "worldeditgui.generic." + name + ".comment");
    }

    private static ConfigString InitialString(String name, String defaultValue) {
        return new ConfigString("worldeditgui.generic." + name, defaultValue, "worldeditgui.generic." + name + ".comment");
    }

    private static ConfigOptionList InitialOption(String name, IConfigOptionListEntry optionListEntry) {
        return new ConfigOptionList("worldeditgui.generic." + name, optionListEntry, "worldeditgui.generic." + name + ".comment");
    }

    private static ConfigInteger InitialInteger(String name, Integer defaultValue) {
        return new ConfigInteger("worldeditgui.generic." + name, defaultValue, "worldeditgui.generic." + name + ".comment");
    }

    private static ConfigInteger InitialInteger(String name, Integer defaultValue, Integer minValue, Integer maxValue) {
        return new ConfigInteger("worldeditgui.generic." + name, defaultValue, minValue, maxValue, "worldeditgui.generic." + name + ".comment");
    }

    public static void saveToFile() {
        File dir = FileUtils.getConfigDirectory();

        if ((dir.exists() && dir.isDirectory()) || dir.mkdirs()) {
            JsonObject root = new JsonObject();

            ConfigUtils.writeConfigBase(root, "Generic", Configs.Generic.OPTIONS);
            ConfigUtils.writeHotkeyToggleOptions(root, "Common_Commands", "Common_Commands", Common_Commands.COMMANDS_HOTKEY);
            ConfigUtils.writeHotkeyToggleOptions(root, "Commands", "Commands", Commands.COMMANDS_HOTKEY);
            ConfigUtils.writeHotkeys(root, "Hotkey", Hotkey.HOTKEY_LIST);
            JsonUtils.writeJsonToFile(root, new File(dir, CONFIG_FILE_NAME));
        }
    }

    public static void loadFromFile() {
        File configFile = new File(FileUtils.getConfigDirectory(), CONFIG_FILE_NAME);

        if (configFile.exists() && configFile.isFile() && configFile.canRead()) {
            JsonElement element = JsonUtils.parseJsonFile(configFile);

            if (element != null && element.isJsonObject()) {
                JsonObject root = element.getAsJsonObject();

                ConfigUtils.readConfigBase(root, "Generic", Configs.Generic.OPTIONS);
                ConfigUtils.readHotkeyToggleOptions(root, "Common_Commands", "Common_Commands", Common_Commands.COMMANDS_HOTKEY);
                ConfigUtils.readHotkeyToggleOptions(root, "Commands", "Commands", Commands.COMMANDS_HOTKEY);
                ConfigUtils.readHotkeys(root, "Hotkey", Hotkey.HOTKEY_LIST);
            }
        }
    }

    @Override
    public void load() {
        loadFromFile();
    }

    @Override
    public void save() {
        saveToFile();
    }
}
