package org.shane0411.worldeditgui.worldeditgui.config;

import fi.dy.masa.malilib.config.options.ConfigBooleanHotkeyed;
import fi.dy.masa.malilib.config.options.ConfigInteger;
import fi.dy.masa.malilib.gui.GuiBase;
import fi.dy.masa.malilib.hotkeys.IHotkeyCallback;
import fi.dy.masa.malilib.hotkeys.IKeybind;
import fi.dy.masa.malilib.hotkeys.KeyAction;
import fi.dy.masa.malilib.util.StringUtils;
import net.minecraft.client.MinecraftClient;
import org.shane0411.worldeditgui.worldeditgui.config.commands.Common_Commands;
import org.shane0411.worldeditgui.worldeditgui.gui.GuiConfig;
import org.shane0411.worldeditgui.worldeditgui.util.Message;

public class Callbacks {
    public static void init(MinecraftClient minecraftClient) {
        IHotkeyCallback callbackGeneric = new KeyCallbackHotkeysGeneric(minecraftClient);
        Hotkey.OPEN_CONFIG.getKeybind().setCallback(callbackGeneric);
        Hotkey.ADD_INIT_INTEGER.getKeybind().setCallback(callbackGeneric);
        Hotkey.DECREASE_INIT_INTEGER.getKeybind().setCallback(callbackGeneric);
        Common_Commands.UNDO.getKeybind().setCallback(callbackGeneric);
        Common_Commands.REDO.getKeybind().setCallback(callbackGeneric);
        Common_Commands.CLEAR.getKeybind().setCallback(callbackGeneric);
        Common_Commands.SET.getKeybind().setCallback(callbackGeneric);
        Common_Commands.COPY.getKeybind().setCallback(callbackGeneric);
        Common_Commands.PASTE.getKeybind().setCallback(callbackGeneric);
        Common_Commands.MOVE.getKeybind().setCallback(callbackGeneric);
        Common_Commands.ROTATE.getKeybind().setCallback(callbackGeneric);
        Common_Commands.ROTATE_XYZ.getKeybind().setCallback(callbackGeneric);
        Common_Commands.STACK.getKeybind().setCallback(callbackGeneric);
        Common_Commands.FLIP.getKeybind().setCallback(callbackGeneric);
    }

    public static class KeyCallbackHotkeysGeneric implements IHotkeyCallback {
        public final MinecraftClient minecraftClient;

        public KeyCallbackHotkeysGeneric(MinecraftClient mc) {
            this.minecraftClient = mc;
        }

        public ConfigInteger integer = Configs.Generic.INIT_INTEGER;

        @Override
        public boolean onKeyAction(KeyAction action, IKeybind key) {
            if (key == Hotkey.OPEN_CONFIG.getKeybind()) {
                GuiBase.openGui(new GuiConfig());
                return true;
            } else if (key == Hotkey.ADD_INIT_INTEGER.getKeybind()) {
                integer.setIntegerValue(integer.getIntegerValue() + Configs.Generic.INIT_CHANGE.getIntegerValue());
                Message.actionBar(StringUtils.translate("worldeditgui.hotkey.message.add") + integer.getIntegerValue());
                return true;
            } else if (key == Hotkey.DECREASE_INIT_INTEGER.getKeybind()) {
                integer.setIntegerValue(integer.getIntegerValue() - Configs.Generic.INIT_CHANGE.getIntegerValue());
                Message.actionBar(StringUtils.translate("worldeditgui.hotkey.message.decrease") + integer.getIntegerValue());
                return true;
            }
            if (key == Common_Commands.UNDO.getKeybind()) {
                setTrue(Common_Commands.UNDO);
                return true;
            } else if (key == Common_Commands.REDO.getKeybind()) {
                setTrue(Common_Commands.REDO);
                return true;
            } else if (key == Common_Commands.CLEAR.getKeybind()) {
                setTrue(Common_Commands.CLEAR);
                return true;
            } else if (key == Common_Commands.SET.getKeybind()) {
                setTrue(Common_Commands.SET);
                return true;
            } else if (key == Common_Commands.COPY.getKeybind()) {
                setTrue(Common_Commands.COPY);
                return true;
            } else if (key == Common_Commands.PASTE.getKeybind()) {
                setTrue(Common_Commands.PASTE);
                return true;
            }else if (key == Common_Commands.MOVE.getKeybind()) {
                setTrue(Common_Commands.MOVE);
                return true;
            } else if (key == Common_Commands.ROTATE.getKeybind()) {
                setTrue(Common_Commands.ROTATE);
                return true;
            } else if (key == Common_Commands.ROTATE_XYZ.getKeybind()) {
                setTrue(Common_Commands.ROTATE_XYZ);
                return true;
            } else if (key == Common_Commands.STACK.getKeybind()) {
                setTrue(Common_Commands.STACK);
                return true;
            } else if (key == Common_Commands.FLIP.getKeybind()) {
                setTrue(Common_Commands.FLIP);
                return true;
            }
            return false;
        }
        private static void setTrue(ConfigBooleanHotkeyed config){
            config.setBooleanValue(true);
        }
    }
}
