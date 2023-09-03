package org.shane0411.worldeditgui.worldeditgui.config.commands;

import com.google.common.collect.ImmutableList;
import fi.dy.masa.malilib.config.options.ConfigBooleanHotkeyed;

public class Common_Commands {
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
    private static ConfigBooleanHotkeyed BooleanHotkey(String command) {
        return new ConfigBooleanHotkeyed("worldeditgui.commands." + command, false, "", "worldeditgui.commands." + command + ".comment");
    }
}


