package org.shane0411.worldeditgui.worldeditgui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class Message {
    public static void actionBar(String message){
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        minecraftClient.inGameHud.setOverlayMessage(Text.translatable(message),false);
    }
    public static void rawactionBar(String message){
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        Text text = Text.literal(message);
        minecraftClient.inGameHud.setOverlayMessage(text,false);
    }

    public static void chat(String message){
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        minecraftClient.inGameHud.getChatHud().addMessage(Text.translatable(message));
    }

    public static void rawchat(String message){
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        Text text = Text.literal(message);
        minecraftClient.inGameHud.getChatHud().addMessage(text);
    }
}
