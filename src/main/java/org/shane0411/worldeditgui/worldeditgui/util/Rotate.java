package org.shane0411.worldeditgui.worldeditgui.util;

import fi.dy.masa.malilib.config.IConfigOptionListEntry;
import fi.dy.masa.malilib.util.StringUtils;

public enum Rotate implements IConfigOptionListEntry {
    ANGEL_90("90", "worldeditgui.rotate.90"),
    ANGEL_180("180", "worldeditgui.rotate.180"),
    ANGEL_270("270", "worldeditgui.rotate.270");
    private final String configString;
    private final String unlocName;

    private Rotate(String configString, String unlocName) {
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
    public Rotate fromString(String name) {
        return fromStringStatic(name);
    }

    public static Rotate fromStringStatic(String name) {
        for (Rotate mode : Rotate.values()) {
            if (mode.configString.equalsIgnoreCase(name)) {
                return mode;
            }
        }
        return Rotate.ANGEL_90;
    }
}
