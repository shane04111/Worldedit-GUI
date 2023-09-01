package org.shane0411.worldeditgui.worldeditgui.util;

import fi.dy.masa.malilib.gui.GuiConfigsBase;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.shane0411.worldeditgui.worldeditgui.config.Configs;

public class DoCommands {
    public static void SendCommands() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null) return;
        if (Configs.Commands.UNDO.getBooleanValue()) {
            player.networkHandler.sendCommand("/undo " + Configs.Generic.INIT_INTEGER.getIntegerValue() + " " + Configs.Generic.INIT_PLAYER.getStringValue());
            Configs.Commands.UNDO.setBooleanValue(false);
            Message.actionBar("worldeditgui.execution.undo");
        } else if (Configs.Commands.REDO.getBooleanValue()) {
            player.networkHandler.sendCommand("/redo " + Configs.Generic.INIT_INTEGER.getIntegerValue() + Configs.Generic.INIT_PLAYER.getStringValue());
            Configs.Commands.REDO.setBooleanValue(false);
            Message.actionBar("worldeditgui.execution.redo");
        } else if (Configs.Commands.CLEAR.getBooleanValue()) {
            player.networkHandler.sendCommand("/set 0");
            Configs.Commands.CLEAR.setBooleanValue(false);
            Message.actionBar("worldeditgui.execution.clear");
        } else if (Configs.Commands.SET.getBooleanValue()) {

        }
    }
}
