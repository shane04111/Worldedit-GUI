package org.shane0411.worldeditgui.worldeditgui.config.commands;

import com.google.common.collect.ImmutableList;
import fi.dy.masa.malilib.config.options.ConfigBooleanHotkeyed;

public class Navigation_Commands {
    public static final ConfigBooleanHotkeyed UNSTUCK = BooleanHotkey("unstuck");
    public static final ConfigBooleanHotkeyed ASCEND = BooleanHotkey("ascend");
    public static final ConfigBooleanHotkeyed DESCEND = BooleanHotkey("descend");
    public static final ConfigBooleanHotkeyed CEIL = BooleanHotkey("ceil");
    public static final ConfigBooleanHotkeyed THRU = BooleanHotkey("thru");
    public static final ConfigBooleanHotkeyed JUMPTO = BooleanHotkey("jumpto");
    public static final ConfigBooleanHotkeyed UP = BooleanHotkey("up");
    public static final ImmutableList<ConfigBooleanHotkeyed> COMMANDS_HOTKEY = ImmutableList.of(
            UNSTUCK,
            ASCEND,
            DESCEND,
            CEIL,
            THRU,
            JUMPTO,
            UP
    );

    private static ConfigBooleanHotkeyed BooleanHotkey(String command) {
        return new ConfigBooleanHotkeyed("worldeditgui.navigation_commands." + command, false, "", "worldeditgui.navigation_commands." + command + ".comment");
    }
}
