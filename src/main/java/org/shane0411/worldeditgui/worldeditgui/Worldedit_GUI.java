package org.shane0411.worldeditgui.worldeditgui;

import fi.dy.masa.malilib.event.InitializationHandler;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Worldedit_GUI implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger(Reference.MOD_NAME);
    @Override
    public void onInitialize() {
        InitializationHandler.getInstance().registerInitializationHandler(new InitHandler());
    }
}
