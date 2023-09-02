package org.shane0411.worldeditgui.worldeditgui.util;

import fi.dy.masa.malilib.config.options.ConfigBoolean;
import fi.dy.masa.malilib.gui.GuiConfigsBase;
import net.minecraft.block.enums.WallShape;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.shane0411.worldeditgui.worldeditgui.Worldedit_GUI;
import org.shane0411.worldeditgui.worldeditgui.config.Configs;

public class DoCommands {
    public static void SendCommands() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null) return;

        if (Configs.Common_Commands.UNDO.getBooleanValue()) {
            player.networkHandler.sendCommand("/undo " + Configs.Generic.INIT_INTEGER.getIntegerValue() + " " + Configs.Generic.INIT_PLAYER.getStringValue());
            GuiSet(Configs.Common_Commands.UNDO, "undo");
        } else if (Configs.Common_Commands.REDO.getBooleanValue()) {
            player.networkHandler.sendCommand("/redo " + Configs.Generic.INIT_INTEGER.getIntegerValue() + Configs.Generic.INIT_PLAYER.getStringValue());
            GuiSet(Configs.Common_Commands.REDO, "redo");
        } else if (Configs.Common_Commands.CLEAR.getBooleanValue()) {
            player.networkHandler.sendCommand("/set 0");
            GuiSet(Configs.Common_Commands.CLEAR, "clear");
        } else if (Configs.Common_Commands.SET.getBooleanValue()) {
            player.networkHandler.sendCommand("/set " + Configs.Generic.INIT_BLOCK.getStringValue());
            GuiSet(Configs.Common_Commands.SET, "set");
        }
    }

    private static void GuiSet(ConfigBoolean configBoolean, String string) {
        configBoolean.setBooleanValue(false);
        if (MinecraftClient.getInstance().currentScreen instanceof GuiConfigsBase) {
            ((GuiConfigsBase) MinecraftClient.getInstance().currentScreen).initGui();
        }
        Message.actionBar("worldeditgui.execution." + string);
    }

    private static String addonUse(String addons) {
        StringBuilder builder = new StringBuilder();
        for (char c : addons.toCharArray()) {
            String addon = String.valueOf(c);
            switch (addon) {
                case "a":
                    if (Configs.Generic.INIT_A.getBooleanValue()) {
                        builder.append("-a ");
                    }
                    break;
                case "b":
                    if (Configs.Generic.INIT_B.getBooleanValue()) {
                        builder.append("-b ");;
                    }
                    break;
                case "e":
                    if (Configs.Generic.INIT_E.getBooleanValue()){
                        builder.append("-e ");
                    }
                    break;
                case "r":
                    if(Configs.Generic.INIT_R.getBooleanValue()){
                        builder.append("-r ");
                    }
                    break;
                case "s":
                    if(Configs.Generic.INIT_S.getBooleanValue()){
                        builder.append("-s ");
                    }
                    break;
                case "m":
                    if(Configs.Generic.INIT_M.getBooleanValue()){
                        builder.append("-m ").append(Configs.Generic.INIT_M_BLOCK.getStringValue());
                    }
                    break;
            }
        }
        return builder.toString().trim();
    }
}
