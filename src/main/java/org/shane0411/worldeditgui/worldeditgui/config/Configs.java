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
import org.shane0411.worldeditgui.worldeditgui.util.Offset;
import org.shane0411.worldeditgui.worldeditgui.util.Rotate;

import java.io.File;

public class Configs implements IConfigHandler {
    private static final String CONFIG_FILE_NAME = Reference.MOD_ID + ".json";

    public static class Generic {
        public static final ConfigInteger INIT_INTEGER = new ConfigInteger("",1,"");
        public static final ConfigInteger INIT_RANGE = new ConfigInteger("",0,0 ,100,"");
        public static final ConfigOptionList INIT_OFFSET = new ConfigOptionList("",Offset.ME,"");
        public static final ConfigOptionList INIT_ANGEL = new ConfigOptionList("",Rotate.RIGHT_ANGLE,"");
        public static final ConfigString INIT_BLOCK = new ConfigString("","","");
        public static final ConfigString INIT_PLAYER = new ConfigString("","","");
        public static final ConfigBoolean INIT_A = new  ConfigBoolean("",false,"");
        public static final ConfigBoolean INIT_B = new  ConfigBoolean("",false,"");
        public static final ConfigBoolean INIT_E = new  ConfigBoolean("",false,"");
        public static final ConfigBoolean INIT_R = new  ConfigBoolean("",false,"");
        public static final ConfigBoolean INIT_S = new  ConfigBoolean("",false,"");
        public static final ConfigString INIT_M_BLOCK = new  ConfigString("","","");

        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
                INIT_INTEGER,
                INIT_RANGE,
                INIT_OFFSET,
                INIT_ANGEL,
                INIT_BLOCK,
                INIT_PLAYER,
                INIT_A,
                INIT_B,
                INIT_E,
                INIT_R,
                INIT_S,
                INIT_M_BLOCK


        );
    }


    public static class Commands {
        // Undo
        public static final ConfigBoolean UNDO = new ConfigBoolean("worldeditgui.commands.undo", false, "worldeditgui.commands.undo.comment");
        // Redo
        public static final ConfigInteger REDO_INV = new ConfigInteger("worldeditgui.commands.redo.number", 1, "worldeditgui.commands.redo.number.comment");
        // set
        public static final ConfigString SET_BLOCK = new ConfigString("worldeditgui.commands.set.block", "", "worldeditgui.commands.set.block.comment");
        // Copy
        // Move
        public static final ConfigBoolean MOVE = new ConfigBoolean("worldeditgui.commands.move", false, "worldeditgui.commands.move.comment");
        public static final ConfigInteger MOVE_INV = new ConfigInteger("worldeditgui.commands.move.number", 1, "worldeditgui.commands.move.number.comment");
        // Rotate
        public static final ConfigBoolean ROTATE = new ConfigBoolean("worldeditgui.commands.rotate", false, "worldeditgui.commands.rotate.comment");
        public static final ConfigOptionList ROTATE_INV = new ConfigOptionList("worldeditgui.commands.rotate.number", Rotate.RIGHT_ANGLE, "worldeditgui.commands.rotate.number");
        public static final ConfigBoolean ROTATE_XYZ = new ConfigBoolean("worldeditgui.commands.rotate.xyz", false, "worldeditgui.commands.rotate.xyz.comment");
        public static final ConfigInteger ROTATE_Y_INV = new ConfigInteger("worldeditgui.commands.rotate.y", 0, "worldeditgui.commands.rotate.y.comment");
        public static final ConfigInteger ROTATE_X_INV = new ConfigInteger("worldeditgui.commands.rotate.x", 0, "worldeditgui.commands.rotate.x.comment");
        public static final ConfigInteger ROTATE_Z_INV = new ConfigInteger("worldeditgui.commands.rotate.z", 0, "worldeditgui.commands.rotate.z.comment");
        // Stack
        public static final ConfigBoolean STACK = new ConfigBoolean("worldeditgui.commands.stack", false, "worldeditgui.commands.stack.comment");
        public static final ConfigInteger STACK_INV = new ConfigInteger("worldeditgui.commands.stack.number", 1, "worldeditgui.commands.stack.number.comment");
        public static final ConfigOptionList STACK_OFFSET = new ConfigOptionList("worldeditgui.commands.stack.offset", Offset.ME, "worldeditgui.commands.stack.offset.comment");
        // Flip
        public static final ConfigBoolean FLIP = new ConfigBoolean("worldeditgui.commands.flip", false, "", "worldeditgui.commands.flip.comment");
        public static final ConfigBoolean FLIP_BOOLEAN = new ConfigBoolean("worldeditgui.commands.flip.boolean", true, "worldeditgui.commands.flip.boolean.comment");
        public static final ConfigOptionList FLIP_OFFSET = new ConfigOptionList("worldeditgui.commands.flip.offset", Offset.ME, "worldeditgui.commands.flip.offset.comment");
        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(
                UNDO,

//                REDO,
                REDO_INV,

//                CLEAR,
//                SET,
                SET_BLOCK,

//                COPY,
//                PAST,

                MOVE,
                MOVE_INV,

                STACK,
                STACK_INV,
                STACK_OFFSET,

                ROTATE,
                ROTATE_INV,
                ROTATE_XYZ,
                ROTATE_Y_INV,
                ROTATE_X_INV,
                ROTATE_Z_INV,

                FLIP,
                FLIP_BOOLEAN,
                FLIP_OFFSET

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
