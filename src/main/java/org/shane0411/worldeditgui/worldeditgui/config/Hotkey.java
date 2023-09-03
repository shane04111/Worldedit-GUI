package org.shane0411.worldeditgui.worldeditgui.config;

import com.google.common.collect.ImmutableList;
import fi.dy.masa.malilib.config.options.ConfigHotkey;

import java.util.List;

public class Hotkey {
    public static final ConfigHotkey OPEN_CONFIG = new ConfigHotkey("worldeditgui.hotkey.open_config", "Z,C", "worldeditgui.hotkey.open_config.comment");
    public static final ConfigHotkey ADD_INIT_INTEGER = Hotkeys("add_init_integer");
    public static final ConfigHotkey DECREASE_INIT_INTEGER = Hotkeys("decrease_init_integer");
    public static final List<ConfigHotkey> HOTKEY_LIST = ImmutableList.of(
            OPEN_CONFIG,
            ADD_INIT_INTEGER,
            DECREASE_INIT_INTEGER
    );
    private static ConfigHotkey Hotkeys(String command) {
        return new ConfigHotkey("worldeditgui.hotkey." + command, "", "worldeditgui.hotkey." + command + ".comment");
    }
}
