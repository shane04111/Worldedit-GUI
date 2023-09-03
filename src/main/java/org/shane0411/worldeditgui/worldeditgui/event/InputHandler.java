package org.shane0411.worldeditgui.worldeditgui.event;

import fi.dy.masa.malilib.hotkeys.*;
import fi.dy.masa.malilib.util.GuiUtils;
import net.minecraft.client.MinecraftClient;
import org.shane0411.worldeditgui.worldeditgui.Reference;
import org.shane0411.worldeditgui.worldeditgui.config.Hotkey;
import org.shane0411.worldeditgui.worldeditgui.config.commands.Commands;
import org.shane0411.worldeditgui.worldeditgui.config.commands.Common_Commands;

public class InputHandler implements IKeybindProvider, IKeyboardInputHandler, IMouseInputHandler {
    private static final InputHandler INSTANCE = new InputHandler();
    private LeftRight lastSidewaysInput = LeftRight.NONE;
    private ForwardBack lastForwardInput = ForwardBack.NONE;
    private InputHandler()
    {
        super();
    }
    public LeftRight getLastSidewaysInput()
    {
        return this.lastSidewaysInput;
    }

    public ForwardBack getLastForwardInput()
    {
        return this.lastForwardInput;
    }

    public static InputHandler getInstance()
    {
        return INSTANCE;
    }
    @Override
    public void addKeysToMap(IKeybindManager manager)
    {
        for (IHotkey hotkey : Hotkey.HOTKEY_LIST)
        {
            manager.addKeybindToMap(hotkey.getKeybind());
        }

        for (IHotkey hotkey : Common_Commands.COMMANDS_HOTKEY){
            manager.addKeybindToMap(hotkey.getKeybind());
        }

        for (IHotkey hotkey : Commands.COMMANDS_HOTKEY){
            manager.addKeybindToMap(hotkey.getKeybind());
        }
    }
    @Override
    public void addHotkeys(IKeybindManager manager)
    {
        manager.addHotkeysForCategory(Reference.MOD_NAME,"worldeditgui.hotkey.command", Common_Commands.COMMANDS_HOTKEY);
        manager.addHotkeysForCategory(Reference.MOD_NAME,"worldeditgui.hotkey.navigation_commands", Commands.COMMANDS_HOTKEY);
        manager.addHotkeysForCategory(Reference.MOD_NAME, "worldeditgui.hotkey.hotkey", Hotkey.HOTKEY_LIST);
    }
    @Override
    public boolean onKeyInput(int keyCode, int scanCode, int modifiers, boolean eventKeyState)
    {
        MinecraftClient mc = MinecraftClient.getInstance();

        // Not in a GUI
        if (GuiUtils.getCurrentScreen() == null && eventKeyState)
        {
            this.storeLastMovementDirection(keyCode, scanCode, mc);
        }
        return false;
    }
    private void storeLastMovementDirection(int eventKey, int scanCode, MinecraftClient mc)
    {
        if (mc.options.forwardKey.matchesKey(eventKey, scanCode))
        {
            this.lastForwardInput = ForwardBack.FORWARD;
        }
        else if (mc.options.backKey.matchesKey(eventKey, scanCode))
        {
            this.lastForwardInput = ForwardBack.BACK;
        }
        else if (mc.options.leftKey.matchesKey(eventKey, scanCode))
        {
            this.lastSidewaysInput = LeftRight.LEFT;
        }
        else if (mc.options.rightKey.matchesKey(eventKey, scanCode))
        {
            this.lastSidewaysInput = LeftRight.RIGHT;
        }
    }
    public enum LeftRight
    {
        NONE,
        LEFT,
        RIGHT
    }

    public enum ForwardBack
    {
        NONE,
        FORWARD,
        BACK
    }
}
