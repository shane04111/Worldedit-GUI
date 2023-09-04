package org.shane0411.worldeditgui.worldeditgui.config;

import com.google.common.collect.ImmutableList;
import fi.dy.masa.malilib.config.options.ConfigHotkey;

import java.util.List;

public class Hotkey {
    public static final ConfigHotkey OPEN_CONFIG = new ConfigHotkey("worldeditgui.hotkey.open_config", "Z,C", "worldeditgui.hotkey.open_config.comment");
    public static final ConfigHotkey ADD_INIT_INTEGER = Hotkeys("add_init_integer");
    public static final ConfigHotkey DECREASE_INIT_INTEGER = Hotkeys("decrease_init_integer");
    public static final ConfigHotkey OFFSET_ME = Hotkeys("offset_me");
    public static final ConfigHotkey OFFSET_BACK = Hotkeys("offset_back");
    public static final ConfigHotkey OFFSET_LEFT = Hotkeys("offset_left");
    public static final ConfigHotkey OFFSET_RIGHT = Hotkeys("offset_right");
    public static final ConfigHotkey OFFSET_UP = Hotkeys("offset_up");
    public static final ConfigHotkey OFFSET_DOWN = Hotkeys("offset_down");
    public static final ConfigHotkey OFFSET_NORTH = Hotkeys("offset_north");
    public static final ConfigHotkey OFFSET_EAST = Hotkeys("offset_east");
    public static final ConfigHotkey OFFSET_SOUTH = Hotkeys("offset_south");
    public static final ConfigHotkey OFFSET_WEST = Hotkeys("offset_west");
    public static final ConfigHotkey OFFSET_NORTHEAST = Hotkeys("offset_northeast");
    public static final ConfigHotkey OFFSET_NORTHWEST = Hotkeys("offset_northwest");
    public static final ConfigHotkey OFFSET_SOUTHEAST = Hotkeys("offset_southeast");
    public static final List<ConfigHotkey> HOTKEY_LIST = ImmutableList.of(
            // generic
            OPEN_CONFIG, ADD_INIT_INTEGER, DECREASE_INIT_INTEGER,
            // offset
            OFFSET_ME, OFFSET_BACK, OFFSET_LEFT, OFFSET_RIGHT, OFFSET_UP, OFFSET_DOWN, OFFSET_NORTH, OFFSET_EAST, OFFSET_SOUTH, OFFSET_WEST, OFFSET_NORTHEAST, OFFSET_NORTHWEST, OFFSET_SOUTHEAST);

    private static ConfigHotkey Hotkeys(String command) {
        return new ConfigHotkey("worldeditgui.hotkey." + command, "", "worldeditgui.hotkey." + command + ".comment");
    }
}
