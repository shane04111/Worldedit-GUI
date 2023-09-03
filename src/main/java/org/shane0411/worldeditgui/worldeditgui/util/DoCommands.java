package org.shane0411.worldeditgui.worldeditgui.util;

import fi.dy.masa.malilib.config.options.ConfigBoolean;
import fi.dy.masa.malilib.gui.GuiConfigsBase;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.shane0411.worldeditgui.worldeditgui.config.Configs;
import org.shane0411.worldeditgui.worldeditgui.config.commands.Common_Commands;

public class DoCommands {
    public static void SendCommands() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null) return;

        int init_integer = Configs.Generic.INIT_INTEGER.getIntegerValue();
        String init_player = Configs.Generic.INIT_PLAYER.getStringValue();
        String init_block = Configs.Generic.INIT_BLOCK.getStringValue();

        if (Common_Commands.UNDO.getBooleanValue()) {
            player.networkHandler.sendCommand("/undo " + init_integer + " " + init_player);
            GuiSet(Common_Commands.UNDO, "undo");
        } else if (Common_Commands.REDO.getBooleanValue()) {
            player.networkHandler.sendCommand("/redo " + init_integer + " " + init_player);
            GuiSet(Common_Commands.REDO, "redo");
        } else if (Common_Commands.CLEAR.getBooleanValue()) {
            player.networkHandler.sendCommand("/set 0");
            GuiSet(Common_Commands.CLEAR, "clear");
        } else if (Common_Commands.SET.getBooleanValue()) {
            player.networkHandler.sendCommand("/set " + init_block);
            GuiSet(Common_Commands.SET, "set");
        }
    }

    private static void GuiSet(ConfigBoolean configBoolean, String string) {
        configBoolean.setBooleanValue(false);
        if (MinecraftClient.getInstance().currentScreen instanceof GuiConfigsBase) {
            ((GuiConfigsBase) MinecraftClient.getInstance().currentScreen).initGui();
        }
        Message.actionBar("worldeditgui.command.message." + string);
    }

    private static String addonUse(String addons) {
        StringBuilder builder = new StringBuilder();
        for (char c : addons.toCharArray()) {
            String addon = String.valueOf(c);
            switch (addon) {
                case "a" -> {
                    if (Configs.Generic.INIT_A.getBooleanValue()) {
                        builder.append("-a ");
                    }
                }
                case "b" -> {
                    if (Configs.Generic.INIT_B.getBooleanValue()) {
                        builder.append("-b ");
                    }
                }
                case "e" -> {
                    if (Configs.Generic.INIT_E.getBooleanValue()) {
                        builder.append("-e ");
                    }
                }
                case "r" -> {
                    if (Configs.Generic.INIT_R.getBooleanValue()) {
                        builder.append("-r ");
                    }
                }
                case "s" -> {
                    if (Configs.Generic.INIT_S.getBooleanValue()) {
                        builder.append("-s ");
                    }
                }
                case "m" -> {
                    if (Configs.Generic.INIT_M.getBooleanValue()) {
                        builder.append("-m ").append(Configs.Generic.INIT_M_BLOCK.getStringValue());
                    }
                }
            }
        }
        return builder.toString().trim();
    }
}
