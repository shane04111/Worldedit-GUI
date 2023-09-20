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
        String init_offset = Configs.Generic.INIT_OFFSET.getStringValue();

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
        } else if (Common_Commands.STACK.getBooleanValue()) {
            player.networkHandler.sendCommand("/stack " + init_integer + " " + init_offset + addonUse("abersm"));
            GuiSet(Common_Commands.STACK, "stack");
        } else if (Common_Commands.MOVE.getBooleanValue()) {
            player.networkHandler.sendCommand("/move " + init_integer + " " + init_offset + addonUse("abesm"));
            GuiSet(Common_Commands.MOVE, "move");
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
                case "a":
                    if (Configs.Generic.INIT_A.getBooleanValue()) {
                        builder.append("-a ");
                    }
                    break;
                case "b":
                    if (Configs.Generic.INIT_B.getBooleanValue()) {
                        builder.append("-b ");
                        ;
                    }
                    break;
                case "e":
                    if (Configs.Generic.INIT_E.getBooleanValue()) {
                        builder.append("-e ");
                    }
                    break;
                case "r":
                    if (Configs.Generic.INIT_R.getBooleanValue()) {
                        builder.append("-r ");
                    }
                    break;
                case "s":
                    if (Configs.Generic.INIT_S.getBooleanValue()) {
                        builder.append("-s ");
                    }
                    break;
                case "m":
                    if (Configs.Generic.INIT_M.getBooleanValue()) {
                        builder.append("-m ").append(Configs.Generic.INIT_M_BLOCK.getStringValue());
                    }
                    break;
            }
        }
        if (builder.isEmpty()) {
            return "";
        }
        return " " + builder.toString().trim();
    }
}
