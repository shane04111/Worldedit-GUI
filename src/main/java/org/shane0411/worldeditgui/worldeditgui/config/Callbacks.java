package org.shane0411.worldeditgui.worldeditgui.config;

import fi.dy.masa.malilib.gui.GuiBase;
import fi.dy.masa.malilib.hotkeys.IHotkeyCallback;
import fi.dy.masa.malilib.hotkeys.IKeybind;
import fi.dy.masa.malilib.hotkeys.KeyAction;
import net.minecraft.client.MinecraftClient;
import org.shane0411.worldeditgui.worldeditgui.gui.GuiConfig;

public class Callbacks {
    public static void init(MinecraftClient minecraftClient) {
        IHotkeyCallback callbackGeneric = new KeyCallbackHotkeysGeneric(minecraftClient);
        Hotkey.OPEN_CONFIG.getKeybind().setCallback(callbackGeneric);
        Configs.Common_Commands.UNDO.getKeybind().setCallback(callbackGeneric);
        Configs.Common_Commands.REDO.getKeybind().setCallback(callbackGeneric);
        Configs.Common_Commands.CLEAR.getKeybind().setCallback(callbackGeneric);
        Configs.Common_Commands.SET.getKeybind().setCallback(callbackGeneric);
        Configs.Common_Commands.COPY.getKeybind().setCallback(callbackGeneric);
        Configs.Common_Commands.PASTE.getKeybind().setCallback(callbackGeneric);
    }

    public static class KeyCallbackHotkeysGeneric implements IHotkeyCallback {
        public final MinecraftClient minecraftClient;

        public KeyCallbackHotkeysGeneric(MinecraftClient mc) {
            this.minecraftClient = mc;
        }

        @Override
        public boolean onKeyAction(KeyAction action, IKeybind key) {
            if (key == Hotkey.OPEN_CONFIG.getKeybind()) {
                GuiBase.openGui(new GuiConfig());
                return true;
            } else if (key == Configs.Common_Commands.UNDO.getKeybind()) {
                Configs.Common_Commands.UNDO.setBooleanValue(true);
            } else if (key == Configs.Common_Commands.REDO.getKeybind()) {
                Configs.Common_Commands.REDO.setBooleanValue(true);
            } else if (key == Configs.Common_Commands.CLEAR.getKeybind()) {
                Configs.Common_Commands.CLEAR.setBooleanValue(true);
            } else if (key == Configs.Common_Commands.SET.getKeybind()) {
                Configs.Common_Commands.SET.setBooleanValue(true);
            } else if (key == Configs.Common_Commands.COPY.getKeybind()) {
                Configs.Common_Commands.COPY.setBooleanValue(true);
            } else if (key == Configs.Common_Commands.PASTE.getKeybind()) {
                Configs.Common_Commands.PASTE.setBooleanValue(true);
            }
            return false;
        }
    }
}
