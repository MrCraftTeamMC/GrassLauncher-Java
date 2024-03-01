package xyz.mrcraftteammc.grasslauncher.common;

import xyz.mrcraftteammc.grasslauncher.extension.Extension;
import xyz.mrcraftteammc.grasslauncher.extension.exception.ExtensionLoadingException;

public class DefaultExtension extends Extension {
    public DefaultExtension() {
        super("default",
                "DefaultPlugin",
                CommonConstants.VERSION,
                "The Default plugin of GrassLauncher.",
                DefaultExtension.class);
    }

    @Override
    public void onLoaded() throws ExtensionLoadingException {
    }

    @Override
    public void onEnabled() throws ExtensionLoadingException {
    }

    @Override
    public void onDisabled() throws ExtensionLoadingException {
    }
}
