package org.shane0411.worldeditgui.worldeditgui.util;

import fi.dy.masa.malilib.config.IConfigOptionListEntry;
import fi.dy.masa.malilib.util.StringUtils;

public enum Offset implements IConfigOptionListEntry {
    ME("", ""),
    BACK("", ""),
    LEFT("", ""),
    RIGHT("", ""),
    UP("", ""),
    DOWN("", ""),
    NORTH("north", "worldeditgui.util.flip.north"),
    EAST("east", "worldeditgui.util.flip.east"),
    SOUTH("south", "worldeditgui.util.flip.south"),
    WEST("west", "worldeditgui.util.flip.west"),
    NORTHEAST("", ""),
    NORTHWEST("", ""),
    SOUTHEAST("", ""),
    SOUTHWEST("", "");

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
