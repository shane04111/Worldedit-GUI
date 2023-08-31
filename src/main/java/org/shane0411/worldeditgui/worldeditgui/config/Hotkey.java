package org.shane0411.worldeditgui.worldeditgui.config;

import com.google.common.collect.ImmutableList;
import fi.dy.masa.malilib.config.options.ConfigHotkey;
import fi.dy.masa.malilib.hotkeys.KeybindSettings;

import java.util.List;

public class Hotkey {
    public static final ConfigHotkey OPEN_CONFIG = new ConfigHotkey("worldeditgui.generic.open.config.gui", "Z,C", KeybindSettings.PRESS_ALLOWEXTRA, "worldeditgui.generic.open.config.gui.comment");
    public static final ConfigHotkey UNDO_HOTKEY = new ConfigHotkey("worldeditgui.commands.undo", "", "worldeditgui.commands.undo.comment");
    public static final ConfigHotkey REDO_HOTKEY = new ConfigHotkey("worldeditgui.commands.redo", "", "worldeditgui.commands.redo.comment");
    public static final ConfigHotkey SET_HOTKEY = new ConfigHotkey("worldeditgui.commands.set", "", "worldeditgui.commands.set.comment");
    public static final ConfigHotkey CLEAR_HOTKEY = new ConfigHotkey("worldeditgui.commands.clear", "", "worldeditgui.commands.clear.comment");
    public static final ConfigHotkey COPY_HOTKEY = new ConfigHotkey("worldeditgui.commands.copy", "", "worldeditgui.commands.copy.comment");
    public static final ConfigHotkey PAST_HOTKEY = new ConfigHotkey("worldeditgui.commands.past", "", "worldeditgui.commands.past.comment");
    public static final List<ConfigHotkey> HOTKEY_LIST = ImmutableList.of(
            OPEN_CONFIG,
            UNDO_HOTKEY,
            REDO_HOTKEY,
            SET_HOTKEY,
            CLEAR_HOTKEY,
            COPY_HOTKEY,
            PAST_HOTKEY
    );
}
