package org.shane0411.worldeditgui.worldeditgui.config;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import fi.dy.masa.malilib.config.ConfigUtils;
import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.config.IConfigHandler;
import fi.dy.masa.malilib.config.IHotkeyTogglable;
import fi.dy.masa.malilib.config.options.*;
import fi.dy.masa.malilib.hotkeys.KeybindSettings;
import fi.dy.masa.malilib.util.FileUtils;
import fi.dy.masa.malilib.util.InventoryUtils;
import fi.dy.masa.malilib.util.JsonUtils;
import fi.dy.masa.malilib.util.restrictions.UsageRestriction;
import net.minecraft.client.MinecraftClient;
import org.shane0411.worldeditgui.worldeditgui.Reference;
import org.shane0411.worldeditgui.worldeditgui.util.Offset;

import java.io.File;

public class Configs implements IConfigHandler {
    private static final String CONFIG_FILE_NAME = Reference.MOD_ID + ".json";

    public static class Generic {
        public static final ConfigHotkey OPEN_CONFIG = new ConfigHotkey("worldeditgui.generic.open.config.gui", "Z,C", KeybindSettings.PRESS_ALLOWEXTRA, "worldeditgui.generic.open.config.gui.comment");
        public static final ImmutableList<ConfigHotkey> OPTIONS = ImmutableList.of(
                OPEN_CONFIG
        );
    }


    public static class Commands {
        // Undo
        public static final ConfigInteger UNDO_INV = new ConfigInteger("worldeditgui.commands.undo.number", 1, "worldeditgui.commands.undo.number.comment");
        public static final ConfigString UNDO_PLAYER = new ConfigString("worldeditgui.commands.undo.player", "", "worldeditgui.commands.undo.player.comment");
        // Redo
        public static final ConfigInteger REDO_INV = new ConfigInteger("worldeditgui.commands.redo.number", 1, "worldeditgui.commands.redo.number.comment");
        public static final ConfigString REDO_PLAYER = new ConfigString("worldeditgui.commands.redo.player", "", "worldeditgui.commands.redo.player.comment");
        // set
        public static final ConfigString SET_BLOCK = new ConfigString("worldeditgui.commands.set.block", "", "worldeditgui.commands.set.block.comment");
        // Copy
        // Move
//        public static final ConfigBooleanHotkeyed MOVE = new ConfigBooleanHotkeyed("");
        public static final ConfigInteger MOVE_INV = new ConfigInteger("Move Integer", 1, "Move block");
        public static final ConfigBoolean FLIP_BOOLEAN = new ConfigBoolean("worldedutgui.util.flip.boolean", true, "worldedutgui.util.flip.boolean.comment");
        public static final ConfigOptionList FLIP_FACE = new ConfigOptionList("worldedutgui.util.flip.face", Offset.ME, "worldedutgui.util.flip.face.comment");
        // Stack
//        public static final ConfigInteger STACK_INV = new ConfigInteger();
//        // Rotate
//        public static final ConfigBooleanHotkeyed ROTATE = new ConfigBooleanHotkeyed();
//        public static final ConfigOptionList ROTATE_INV = new ConfigInteger();
//        public static final ConfigBooleanHotkeyed ROTATE_XYZ = new ConfigBooleanHotkeyed();
//        public static final ConfigInteger ROTATE_XYZ_INV = new ConfigInteger();
        // Flip
//        public static final ConfigBooleanHotkeyed STACK = new ConfigBooleanHotkeyed();
        public static final ConfigBooleanHotkeyed FLIP = new ConfigBooleanHotkeyed("worldedutgui.util.flip", false, "", "worldedutgui.util.flip.comment");
        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
//                UNDO,
                UNDO_INV,
                UNDO_PLAYER,

//                REDO,
                REDO_INV,
                REDO_PLAYER,

//                CLEAR,
//                SET,
                SET_BLOCK,

//                COPY,
//                PAST,

//                MOVE,
                MOVE_INV,

//                STACK,
//                STACK_INV,
//
//                ROTATE,
//                ROTATE_INV,
//                ROTATE_XYZ,
//                ROTATE_XYZ_INV,

                FLIP,
                FLIP_BOOLEAN,
                FLIP_FACE

        );
    }

    public static class Commands_Boolean {
        public static final ConfigBooleanHotkeyed UNDO = new ConfigBooleanHotkeyed("worldeditgui.commands.undo", false, "", "worldeditgui.commands.undo.comment");
        public static final ConfigBooleanHotkeyed REDO = new ConfigBooleanHotkeyed("worldeditgui.commands.redo", false, "", "worldeditgui.commands.redo.comment");
        public static final ConfigBooleanHotkeyed SET = new ConfigBooleanHotkeyed("worldeditgui.commands.set", false, "", "worldeditgui.commands.set.comment");
        public static final ConfigBooleanHotkeyed CLEAR = new ConfigBooleanHotkeyed("worldeditgui.commands.clear", false, "", "worldeditgui.commands.clear.comment");
        public static final ConfigBooleanHotkeyed COPY = new ConfigBooleanHotkeyed("worldeditgui.commands.copy", false, "", "worldeditgui.commands.copy.comment");
        public static final ConfigBooleanHotkeyed PAST = new ConfigBooleanHotkeyed("worldeditgui.commands.past", false, "", "worldeditgui.commands.past.comment");
        public static final ImmutableList<IHotkeyTogglable> HOTKEY_LIST = ImmutableList.of(
                UNDO, REDO, SET, CLEAR, COPY, PAST
        );
    }

    public static void saveToFile() {
        File dir = FileUtils.getConfigDirectory();

        if ((dir.exists() && dir.isDirectory()) || dir.mkdirs()) {
            JsonObject root = new JsonObject();

            ConfigUtils.writeConfigBase(root, "Generic", Configs.Generic.OPTIONS);
            ConfigUtils.writeConfigBase(root, "Commands", Configs.Commands.OPTIONS);
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
                ConfigUtils.readConfigBase(root, "Commands", Commands.OPTIONS);
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
