package org.shane0411.worldeditgui.worldeditgui.util;

import fi.dy.masa.malilib.config.IConfigOptionListEntry;
import fi.dy.masa.malilib.util.StringUtils;

public class Abers{
    public enum Abers_five implements IConfigOptionListEntry {
        NA  ("na", "worldeditgui.util.abers_5.na"),
        A   ("a", "worldeditgui.util.abers_5.a"),
        B   ("b", "worldeditgui.util.abers_5.b"),
        E   ("e", "worldeditgui.util.abers_5.e"),
        R   ("r", "worldeditgui.util.abers_5.r"),
        S   ("s", "worldeditgui.util.abers_5.s");

        private final String configString;
        private final String unlocName;

        private Abers_five(String configString, String unlocName) {
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
        public Abers_five fromString(String name) {
            return fromStringStatic(name);
        }

        public static Abers_five fromStringStatic(String name) {
            for (Abers_five mode : Abers_five.values()) {
                if (mode.configString.equalsIgnoreCase(name)) {
                    return mode;
                }
            }
            return Abers_five.NA;
        }
    }
}
