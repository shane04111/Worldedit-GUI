package org.shane0411.worldeditgui.worldeditgui.config;

import fi.dy.masa.malilib.gui.GuiBase;
import fi.dy.masa.malilib.hotkeys.IHotkeyCallback;
import fi.dy.masa.malilib.hotkeys.IKeybind;
import fi.dy.masa.malilib.hotkeys.KeyAction;
import net.minecraft.client.MinecraftClient;
import org.shane0411.worldeditgui.worldeditgui.Worldedit_GUI;
import org.shane0411.worldeditgui.worldeditgui.gui.GuiConfig;

public class Callbacks {
    public static void init(MinecraftClient minecraftClient) {
        IHotkeyCallback callbackGeneric = new KeyCallbackHotkeysGeneric(minecraftClient);
        Hotkey.OPEN_CONFIG.getKeybind().setCallback(callbackGeneric);
    }

    public static class KeyCallbackHotkeysGeneric implements IHotkeyCallback {
        public final MinecraftClient minecraftClient;

        public KeyCallbackHotkeysGeneric(MinecraftClient mc) {
            this.minecraftClient = mc;
        }

        @Override
        public boolean onKeyAction(KeyAction action, IKeybind key) {
            if(key == Hotkey.OPEN_CONFIG.getKeybind()){
                GuiBase.openGui(new GuiConfig());
                return true;
            }
            return false;
        }
    }
}
