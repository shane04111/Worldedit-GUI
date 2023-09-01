package org.shane0411.worldeditgui.worldeditgui.util;

import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.gui.GuiBase;
import fi.dy.masa.malilib.gui.GuiConfigsBase;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.shane0411.worldeditgui.worldeditgui.config.Configs;
import org.shane0411.worldeditgui.worldeditgui.gui.GuiConfig;

import java.util.List;

public class DoCommands {
    public static void SendCommands() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null) return;
        if (Configs.Commands.UNDO.getBooleanValue()) {
            player.networkHandler.sendCommand("/undoe " + Configs.Generic.INIT_INTEGER.getIntegerValue() + " " + Configs.Generic.INIT_PLAYER.getStringValue());
            Configs.Commands.UNDO.setBooleanValue(false);
            Message.actionBar("worldeditgui.execution.undo");
        }
    }
}
