package org.shane0411.worldeditgui.worldeditgui.util;

import fi.dy.masa.malilib.config.options.ConfigBoolean;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.shane0411.worldeditgui.worldeditgui.config.Configs;
import org.shane0411.worldeditgui.worldeditgui.config.commands.Common_Commands;
import org.shane0411.worldeditgui.worldeditgui.gui.GuiConfig;

public class DoCommands {
    public static void SendCommands() {
        String init_block = " " + Configs.Generic.INIT_BLOCK.getStringValue();
        String init_integer = " " + Configs.Generic.INIT_INTEGER.getIntegerValue();
        String init_player = " " + Configs.Generic.INIT_PLAYER.getStringValue();
        String init_offset = " " + Configs.Generic.INIT_OFFSET.getStringValue();
        String init_angel = " " + Configs.Generic.INIT_ANGEL.getOptionListValue();
        String init_xyz = " " + Configs.Generic.INIT_XYZ.getStringValue();

        if (Common_Commands.UNDO.getBooleanValue()) {
            GuiSet("/undo" + init_integer + init_player, Common_Commands.UNDO, "undo");
        } else if (Common_Commands.REDO.getBooleanValue()) {
            GuiSet("/redo" + init_integer + init_player, Common_Commands.REDO, "redo");
        } else if (Common_Commands.CLEAR.getBooleanValue()) {
            GuiSet("/set 0", Common_Commands.CLEAR, "clear");
        } else if (Common_Commands.SET.getBooleanValue()) {
            GuiSet("/set" + init_block, Common_Commands.SET, "set");
        } else if (Common_Commands.COPY.getBooleanValue()) {
            GuiSet("/copy", Common_Commands.COPY, "copy");
        } else if (Common_Commands.PASTE.getBooleanValue()) {
            GuiSet("/past", Common_Commands.PASTE, "paste");
        } else if (Common_Commands.MOVE.getBooleanValue()) {
            GuiSet("/move" + init_integer + init_offset + addonUse("abesm"), Common_Commands.MOVE, "move");
        } else if (Common_Commands.MOVE_REPLACE.getBooleanValue()) {
            GuiSet("/move" + init_integer + init_offset + init_block + addonUse("abesm"), Common_Commands.MOVE_REPLACE,
                    "move");
        } else if (Common_Commands.ROTATE.getBooleanValue()) {
            GuiSet("/rotate" + init_angel, Common_Commands.ROTATE, "rotate");
        } else if (Common_Commands.ROTATE_XYZ.getBooleanValue()) {
            GuiSet("/rotate" + init_xyz, Common_Commands.ROTATE_XYZ, "rotate_xyz");
        } else if (Common_Commands.STACK.getBooleanValue()) {
            GuiSet("/stack" + init_integer + init_offset + addonUse("abersm"), Common_Commands.STACK, "stack");
        } else if (Common_Commands.FLIP.getBooleanValue()) {
            GuiSet("/flip" + init_offset, Common_Commands.FLIP, "flip");
        }
    }

    /**
     * 用於執行指令，並將按鈕設為false後刷新介面
     *
     * @param Command       需要執行的指令
     * @param configBoolean 需要修改的其布林值的值
     * @param string        指令名稱(翻譯鍵)
     */
    private static void GuiSet(String Command, ConfigBoolean configBoolean, String string) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null)
            return;
        player.networkHandler.sendCommand(Command);
        configBoolean.setBooleanValue(false);
        GuiConfig.RePrintGui();
        Message.actionBar("worldeditgui.command.message." + string);
    }

    /**
     * 用於快速尋找並返回其擴展功能字串
     *
     * @param addons 擴展功能
     * @return 字串
     */
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
                        ;
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
        if (builder.isEmpty()) {
            return "";
        } else {
            return " " + builder.toString().trim();
        }
    }
}
