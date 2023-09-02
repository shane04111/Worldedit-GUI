package org.shane0411.worldeditgui.worldeditgui.config.commands;

import com.google.common.collect.ImmutableList;
import fi.dy.masa.malilib.config.options.ConfigBooleanHotkeyed;

public class Selection_Commands {
    public static final ConfigBooleanHotkeyed POS1 = BooleanHotkey("pos1");
    public static final ConfigBooleanHotkeyed POS2 = BooleanHotkey("pos2");
    public static final ConfigBooleanHotkeyed HPOS1 = BooleanHotkey("hpos1");
    public static final ConfigBooleanHotkeyed HPOS2 = BooleanHotkey("hpos2");
    public static final ConfigBooleanHotkeyed CHUNK = BooleanHotkey("chunk");
    public static final ConfigBooleanHotkeyed WAND = BooleanHotkey("wand");
    public static final ConfigBooleanHotkeyed TOGGLEEDITWAND = BooleanHotkey("toggleeditwand");
    public static final ConfigBooleanHotkeyed CONTRACT = BooleanHotkey("contract");
    public static final ConfigBooleanHotkeyed SHIFT = BooleanHotkey("shift");
    public static final ConfigBooleanHotkeyed OUTSET = BooleanHotkey("outset");
    public static final ConfigBooleanHotkeyed INSET = BooleanHotkey("inset");
    public static final ConfigBooleanHotkeyed SIZE = BooleanHotkey("size");
    public static final ConfigBooleanHotkeyed COUNT = BooleanHotkey("count");
    public static final ConfigBooleanHotkeyed DISTR = BooleanHotkey("distr");
    public static final ConfigBooleanHotkeyed SEL = BooleanHotkey("sel");
    public static final ConfigBooleanHotkeyed EXPAND = BooleanHotkey("expand");
    public static final ConfigBooleanHotkeyed EXPAND_VERT = BooleanHotkey("expand_vert");

    public static final ImmutableList<ConfigBooleanHotkeyed> COMMANDS_HOTKEY = ImmutableList.of(
            POS1,
            POS2,
            HPOS1,
            HPOS2,
            CHUNK,
            WAND,
            TOGGLEEDITWAND,
            CONTRACT,
            SHIFT,
            OUTSET,
            INSET,
            SIZE,
            COUNT,
            DISTR,
            SEL,
            EXPAND,
            EXPAND_VERT
    );

    private static ConfigBooleanHotkeyed BooleanHotkey(String command) {
        return new ConfigBooleanHotkeyed("worldeditgui.selection_commands." + command, false, "", "worldeditgui.selection_commands." + command + ".comment");
    }
}
