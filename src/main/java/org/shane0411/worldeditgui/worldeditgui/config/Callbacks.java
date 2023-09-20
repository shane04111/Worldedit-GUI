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
    private static final IKeybind openConfig = Hotkey.OPEN_CONFIG.getKeybind();
    private static final IKeybind addInitInteger = Hotkey.ADD_INIT_INTEGER.getKeybind();
    private static final IKeybind decreaseInitInteger = Hotkey.DECREASE_INIT_INTEGER.getKeybind();
    private static final IKeybind offsetMe = Hotkey.OFFSET_ME.getKeybind();
    private static final IKeybind offsetBack = Hotkey.OFFSET_BACK.getKeybind();
    private static final IKeybind offsetLeft = Hotkey.OFFSET_LEFT.getKeybind();
    private static final IKeybind offsetRight = Hotkey.OFFSET_RIGHT.getKeybind();
    private static final IKeybind offsetUp = Hotkey.OFFSET_UP.getKeybind();
    private static final IKeybind offsetDown = Hotkey.OFFSET_DOWN.getKeybind();
    private static final IKeybind offsetNorth = Hotkey.OFFSET_NORTH.getKeybind();
    private static final IKeybind offsetEast = Hotkey.OFFSET_EAST.getKeybind();
    private static final IKeybind offsetSouth = Hotkey.OFFSET_SOUTH.getKeybind();
    private static final IKeybind offsetWest = Hotkey.OFFSET_WEST.getKeybind();
    private static final IKeybind offsetNortheast = Hotkey.OFFSET_NORTHEAST.getKeybind();
    private static final IKeybind offsetNorthwest = Hotkey.OFFSET_NORTHWEST.getKeybind();
    private static final IKeybind offsetSoutheast = Hotkey.OFFSET_SOUTHEAST.getKeybind();
    private static final IKeybind offsetSouthwest = Hotkey.OFFSET_SOUTHWEST.getKeybind();
    private static final IKeybind commandsUNDO = Common_Commands.UNDO.getKeybind();
    private static final IKeybind commandsREDO = Common_Commands.REDO.getKeybind();
    private static final IKeybind commandsCLEAR = Common_Commands.CLEAR.getKeybind();
    private static final IKeybind commandsSET = Common_Commands.SET.getKeybind();
    private static final IKeybind commandsCOPY = Common_Commands.COPY.getKeybind();
    private static final IKeybind commandsPASTE = Common_Commands.PASTE.getKeybind();
    private static final IKeybind commandsMOVE = Common_Commands.MOVE.getKeybind();
    private static final IKeybind commandsROTATE = Common_Commands.ROTATE.getKeybind();
    private static final IKeybind commandsROTATE_XYZ = Common_Commands.ROTATE_XYZ.getKeybind();
    private static final IKeybind commandsSTACK = Common_Commands.STACK.getKeybind();
    private static final IKeybind commandsFLIP = Common_Commands.FLIP.getKeybind();

    public static void init(MinecraftClient minecraftClient) {
        IHotkeyCallback callbackGeneric = new KeyCallbackHotkeysGeneric(minecraftClient);
        openConfig.setCallback(callbackGeneric);
        addInitInteger.setCallback(callbackGeneric);
        decreaseInitInteger.setCallback(callbackGeneric);
        offsetMe.setCallback(callbackGeneric);
        offsetBack.setCallback(callbackGeneric);
        offsetLeft.setCallback(callbackGeneric);
        offsetRight.setCallback(callbackGeneric);
        offsetUp.setCallback(callbackGeneric);
        offsetDown.setCallback(callbackGeneric);
        offsetNorth.setCallback(callbackGeneric);
        offsetEast.setCallback(callbackGeneric);
        offsetSouth.setCallback(callbackGeneric);
        offsetWest.setCallback(callbackGeneric);
        offsetNortheast.setCallback(callbackGeneric);
        offsetNorthwest.setCallback(callbackGeneric);
        offsetSoutheast.setCallback(callbackGeneric);
        offsetSouthwest.setCallback(callbackGeneric);

        commandsUNDO.setCallback(callbackGeneric);
        commandsREDO.setCallback(callbackGeneric);
        commandsCLEAR.setCallback(callbackGeneric);
        commandsSET.setCallback(callbackGeneric);
        commandsCOPY.setCallback(callbackGeneric);
        commandsPASTE.setCallback(callbackGeneric);
        commandsMOVE.setCallback(callbackGeneric);
        commandsROTATE.setCallback(callbackGeneric);
        commandsROTATE_XYZ.setCallback(callbackGeneric);
        commandsSTACK.setCallback(callbackGeneric);
        commandsFLIP.setCallback(callbackGeneric);
    }

    public static class KeyCallbackHotkeysGeneric implements IHotkeyCallback {
        public final MinecraftClient minecraftClient;

        public KeyCallbackHotkeysGeneric(MinecraftClient mc) {
            this.minecraftClient = mc;
        }

        private final ConfigInteger init_int = Configs.Generic.INIT_INTEGER;

        @Override
        public boolean onKeyAction(KeyAction action, IKeybind key) {
            if (key == openConfig) {
                GuiBase.openGui(new GuiConfig());
                return true;
            } else if (key == addInitInteger) {
                init_int.setIntegerValue(init_int.getIntegerValue() + Configs.Generic.INIT_CHANGE.getIntegerValue());
                message_hk("add", init_int.getIntegerValue());
                return true;
            } else if (key == decreaseInitInteger) {
                init_int.setIntegerValue(init_int.getIntegerValue() - Configs.Generic.INIT_CHANGE.getIntegerValue());
                message_hk("decrease", init_int.getIntegerValue());
                return true;
            } else if (key == offsetMe) {
            } else if (key == offsetBack) {
            } else if (key == offsetLeft) {
            } else if (key == offsetRight) {
            } else if (key == offsetUp) {
            } else if (key == offsetDown) {
            } else if (key == offsetNorth) {
            } else if (key == offsetEast) {
            } else if (key == offsetSouth) {
            } else if (key == offsetWest) {
            } else if (key == offsetNortheast) {
            } else if (key == offsetNorthwest) {
            } else if (key == offsetSoutheast) {
            } else if (key == offsetSouthwest) {
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
            } else if (key == Common_Commands.MOVE.getKeybind()) {
                setTrue(Common_Commands.MOVE);
                return true;
            } else if (key == Common_Commands.MOVE_REPLACE.getKeybind()) {
                setTrue(Common_Commands.MOVE_REPLACE);
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

        private static void setTrue(ConfigBooleanHotkeyed config) {
            config.setBooleanValue(true);
        }

        private void message_hk(String string, String value) {
            Message.actionBar(StringUtils.translate("worldeditgui.hotkey.message." + string) + value);
        }

        private void message_hk(String string, int value) {
            Message.actionBar(StringUtils.translate("worldeditgui.hotkey.message." + string) + value);
        }
    }
}
