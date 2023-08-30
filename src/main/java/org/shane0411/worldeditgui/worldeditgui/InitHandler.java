package org.shane0411.worldeditgui.worldeditgui;

import fi.dy.masa.malilib.event.InputEventHandler;
import fi.dy.masa.malilib.interfaces.IInitializationHandler;
import net.minecraft.client.MinecraftClient;
import org.shane0411.worldeditgui.worldeditgui.config.Callbacks;
import org.shane0411.worldeditgui.worldeditgui.event.InputHandler;

public class InitHandler implements IInitializationHandler {
    @Override
    public void registerModHandlers(){
        Worldedit_GUI.LOGGER.warn("你好，你有東西寫錯了喔~");
        InputEventHandler.getKeybindManager().registerKeybindProvider(InputHandler.getInstance());
        InputEventHandler.getInputManager().registerKeyboardInputHandler(InputHandler.getInstance());
        InputEventHandler.getInputManager().registerMouseInputHandler(InputHandler.getInstance());
        Callbacks.init(MinecraftClient.getInstance());
    }
}
