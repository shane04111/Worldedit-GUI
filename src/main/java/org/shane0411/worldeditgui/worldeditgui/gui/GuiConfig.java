package org.shane0411.worldeditgui.worldeditgui.gui;

import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.config.options.BooleanHotkeyGuiWrapper;
import fi.dy.masa.malilib.gui.GuiConfigsBase;
import fi.dy.masa.malilib.gui.button.ButtonBase;
import fi.dy.masa.malilib.gui.button.ButtonGeneric;
import fi.dy.masa.malilib.gui.button.IButtonActionListener;
import fi.dy.masa.malilib.util.StringUtils;
import org.shane0411.worldeditgui.worldeditgui.Reference;
import org.shane0411.worldeditgui.worldeditgui.config.Configs;
import org.shane0411.worldeditgui.worldeditgui.config.Hotkey;

import java.util.Collections;
import java.util.List;

public class GuiConfig extends GuiConfigsBase {
    private static ConfigGuiTab tab = ConfigGuiTab.GENERIC;

    public GuiConfig() {
        super(10, 50, Reference.MOD_ID, null, "worldeditgui.gui.title.config", String.format("%s", Reference.MOD_VERSION));
    }

    @Override
    protected boolean useKeybindSearch() {
        return GuiConfig.tab == ConfigGuiTab.GENERIC ||
                GuiConfig.tab == ConfigGuiTab.COMMANDS;
    }

    @Override
    protected int getConfigWidth() {
        ConfigGuiTab tab = GuiConfig.tab;

        if (tab == ConfigGuiTab.GENERIC) {
            return 200;
        } else if (tab == ConfigGuiTab.COMMANDS) {
            return 120;
        }

        return 150;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.clearOptions();
        int x = 10;
        int y = 26;
        for (ConfigGuiTab tab : ConfigGuiTab.values()) {
            x += this.createButton(x, y, -1, tab);
        }
    }

    private int createButton(int x, int y, int width, ConfigGuiTab tab) {
        ButtonGeneric button = new ButtonGeneric(x, y, width, 20, tab.getDisplayName());
        button.setEnabled(GuiConfig.tab != tab);
        this.addButton(button, new ButtonListener(tab, this));

        return button.getWidth() + 2;
    }

    @Override
    public List<ConfigOptionWrapper> getConfigs() {
        List<? extends IConfigBase> configs;
        ConfigGuiTab tab = GuiConfig.tab;
        if (tab == ConfigGuiTab.GENERIC) {
            configs = Configs.Generic.OPTIONS;
        } else if (tab == ConfigGuiTab.COMMANDS) {
            configs = Configs.Commands.OPTIONS;
        } else if (tab == ConfigGuiTab.HOTKEY) {
            configs = Hotkey.HOTKEY_LIST;
        } else {
            return Collections.emptyList();
        }

        return ConfigOptionWrapper.createFor(configs);
    }

    private static class ButtonListener implements IButtonActionListener {
        private final GuiConfig parent;
        private final ConfigGuiTab tab;

        public ButtonListener(ConfigGuiTab tab, GuiConfig parent) {
            this.tab = tab;
            this.parent = parent;
        }

        @Override
        public void actionPerformedWithButton(ButtonBase button, int mouseButton) {
            GuiConfig.tab = this.tab;
            this.parent.reCreateListWidget(); // apply the new config width
            this.parent.getListWidget().resetScrollbarPosition();
            this.parent.initGui();
        }
    }

    public enum ConfigGuiTab {
        GENERIC("worldeditgui.gui.button.generic"),
        COMMANDS("worldeditgui.gui.button.commands"),
        HOTKEY("worldeditgui.gui.button.hotkey");

        private final String translationKey;

        ConfigGuiTab(String translationKey) {
            this.translationKey = translationKey;
        }

        public String getDisplayName() {
            return StringUtils.translate(this.translationKey);
        }
    }
}


