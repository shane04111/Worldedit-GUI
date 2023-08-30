package org.shane0411.worldeditgui.worldeditgui.compat.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import org.shane0411.worldeditgui.worldeditgui.gui.GuiConfig;

public class ModMenuImpl implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory()
    {
        return (screen) ->{
          GuiConfig gui = new GuiConfig();
          gui.setParent(screen);
          return gui;
        };
    }
}
