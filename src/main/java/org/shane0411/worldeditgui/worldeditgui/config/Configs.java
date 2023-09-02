package org.shane0411.worldeditgui.worldeditgui.config;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import fi.dy.masa.malilib.config.ConfigUtils;
import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.config.IConfigHandler;
import fi.dy.masa.malilib.config.options.*;
import fi.dy.masa.malilib.util.FileUtils;
import fi.dy.masa.malilib.util.JsonUtils;
import org.shane0411.worldeditgui.worldeditgui.Reference;
import org.shane0411.worldeditgui.worldeditgui.config.commands.Navigation_Commands;
import org.shane0411.worldeditgui.worldeditgui.config.commands.Selection_Commands;
import org.shane0411.worldeditgui.worldeditgui.util.Offset;
import org.shane0411.worldeditgui.worldeditgui.util.Rotate;

import java.io.File;

public class Configs implements IConfigHandler {
    private static final String CONFIG_FILE_NAME = Reference.MOD_ID + ".json";

    public static class Generic {
        public static final ConfigInteger INIT_INTEGER = new ConfigInteger("", 1, "");
        public static final ConfigInteger INIT_RANGE = new ConfigInteger("", 0, 0, 100, "");
        public static final ConfigOptionList INIT_OFFSET = new ConfigOptionList("", Offset.ME, "");
        public static final ConfigOptionList INIT_ANGEL = new ConfigOptionList("", Rotate.RIGHT_ANGLE, "");
        public static final ConfigString INIT_BLOCK = new ConfigString("", "hand", "");
        public static final ConfigString INIT_PLAYER = new ConfigString("", "", "");
        public static final ConfigBoolean INIT_A = new ConfigBoolean("A", false, "");
        public static final ConfigBoolean INIT_B = new ConfigBoolean("B", false, "");
        public static final ConfigBoolean INIT_E = new ConfigBoolean("E", false, "");
        public static final ConfigBoolean INIT_R = new ConfigBoolean("R", false, "");
        public static final ConfigBoolean INIT_S = new ConfigBoolean("S", false, "");
        public static final ConfigBoolean INIT_M = new ConfigBoolean("M", false, "");
        public static final ConfigString INIT_M_BLOCK = new ConfigString("M_BK", "hand", "");

        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
                INIT_INTEGER,
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


    public static class Common_Commands {
        public static final ConfigBooleanHotkeyed UNDO = BooleanHotkey("undo");
        public static final ConfigBooleanHotkeyed REDO = BooleanHotkey("redo");
        public static final ConfigBooleanHotkeyed CLEAR = BooleanHotkey("clear");
        public static final ConfigBooleanHotkeyed SET = BooleanHotkey("set");
        public static final ConfigBooleanHotkeyed COPY = BooleanHotkey("copy");
        public static final ConfigBooleanHotkeyed PASTE = BooleanHotkey("paste");
        public static final ConfigBooleanHotkeyed MOVE = BooleanHotkey("move");
        public static final ConfigBooleanHotkeyed ROTATE = BooleanHotkey("rotate");
        public static final ConfigBooleanHotkeyed ROTATE_XYZ = BooleanHotkey("rotate.xyz");
        public static final ConfigBooleanHotkeyed STACK = BooleanHotkey("stack");
        public static final ConfigBooleanHotkeyed FLIP = BooleanHotkey("flip");
        public static final ImmutableList<ConfigBooleanHotkeyed> COMMANDS_HOTKEY = ImmutableList.of(
                UNDO,
                REDO,
                CLEAR,
                SET,
                COPY,
                PASTE,
                MOVE,
                STACK,
                ROTATE,
                ROTATE_XYZ,
                FLIP
        );
    }

    private static ConfigBooleanHotkeyed BooleanHotkey(String command) {
        return new ConfigBooleanHotkeyed("worldeditgui.commands." + command, false, "", "worldeditgui.commands." + command + ".comment");
    }

    public static void saveToFile() {
        File dir = FileUtils.getConfigDirectory();

        if ((dir.exists() && dir.isDirectory()) || dir.mkdirs()) {
            JsonObject root = new JsonObject();
            ConfigUtils.writeConfigBase(root, "Generic", Configs.Generic.OPTIONS);
            ConfigUtils.writeConfigBase(root, "Common_Commands", Common_Commands.COMMANDS_HOTKEY);
            ConfigUtils.writeConfigBase(root, "Navigation Commands", Navigation_Commands.COMMANDS_HOTKEY);
            ConfigUtils.writeConfigBase(root, "Selection Commands", Selection_Commands.COMMANDS_HOTKEY);
            ConfigUtils.writeConfigBase(root, "Hotkey", Hotkey.HOTKEY_LIST);
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
                ConfigUtils.readConfigBase(root, "Common_Commands", Common_Commands.COMMANDS_HOTKEY);
                ConfigUtils.readConfigBase(root, "Hotkey", Hotkey.HOTKEY_LIST);
            }
        }
//        if (MinecraftClient.getInstance().world == null) {
//            // Turn off after loading the configs, just in case it was enabled in the config somehow.
//            // But only if we are currently not in a world, since changing configs also re-loads them when closing the menu.
//            FeatureToggle.TWEAK_FREE_CAMERA.setBooleanValue(false);
//        }
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
