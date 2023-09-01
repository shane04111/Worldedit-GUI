package org.shane0411.worldeditgui.worldeditgui.event;

import fi.dy.masa.malilib.interfaces.IClientTickHandler;
import net.minecraft.client.MinecraftClient;
import org.shane0411.worldeditgui.worldeditgui.util.DoCommands;

public class ClientTickHeadler implements IClientTickHandler {
    @Override
    public void onClientTick(MinecraftClient minecraftClient){
        if(minecraftClient.world!=null && minecraftClient.player != null){
            DoCommands.SendCommands();
        }
    }
}
