package org.shane0411.worldeditgui.worldeditgui.config;

import com.google.common.collect.ImmutableList;
import fi.dy.masa.malilib.config.options.ConfigHotkey;
import fi.dy.masa.malilib.hotkeys.KeybindSettings;

import java.util.List;

public class Hotkey {
    public static final ConfigHotkey OPEN_CONFIG = new ConfigHotkey("worldeditgui.hotkey.open_config", "Z,C", KeybindSettings.PRESS_ALLOWEXTRA, "worldeditgui.hotkey.open_config.comment");
    public static final List<ConfigHotkey> HOTKEY_LIST = ImmutableList.of(
            OPEN_CONFIG
    );
}
