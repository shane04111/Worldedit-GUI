package org.shane0411.worldeditgui.worldeditgui.util;

import fi.dy.masa.malilib.config.IConfigOptionListEntry;
import fi.dy.masa.malilib.util.StringUtils;

public enum Offset implements IConfigOptionListEntry {
    ME("me", "worldeditgui.util.offset.me"),
    BACK("back", "worldeditgui.util.offset.back"),
    LEFT("left", "worldeditgui.util.offset.left"),
    RIGHT("right", "worldeditgui.util.offset.right"),
    UP("up", "worldeditgui.util.offset.up"),
    DOWN("down", "worldeditgui.util.offset.down"),
    NORTH("north", "worldeditgui.util.offset.north"),
    EAST("east", "worldeditgui.util.offset.east"),
    SOUTH("south", "worldeditgui.util.offset.south"),
    WEST("west", "worldeditgui.util.offset.west"),
    NORTHEAST("northeast", "worldeditgui.util.offset.northeast"),
    NORTHWEST("northwest", "worldeditgui.util.offset.northwest"),
    SOUTHEAST("southeast", "worldeditgui.util.offset.southeast"),
    SOUTHWEST("southwest", "worldeditgui.util.offset.southwest");

    private final String configString;
    private final String unlocName;

    private Offset(String configString, String unlocName) {
        this.configString = configString;
        this.unlocName = unlocName;
    }

    @Override
    public String getStringValue() {
        return this.configString;
    }

    @Override
    public String getDisplayName() {
        return StringUtils.translate(this.unlocName);
    }

    @Override
    public IConfigOptionListEntry cycle(boolean forward) {
        int id = this.ordinal();

        if (forward) {
            if (++id >= values().length) {
                id = 0;
            }
        } else {
            if (--id < 0) {
                id = values().length - 1;
            }
        }
        return values()[id % values().length];
    }

    @Override
    public Offset fromString(String name) {
        return fromStringStatic(name);
    }

    public static Offset fromStringStatic(String name) {
        for (Offset mode : Offset.values()) {
            if (mode.configString.equalsIgnoreCase(name)) {
                return mode;
            }
        }
        return Offset.ME;
    }
}
