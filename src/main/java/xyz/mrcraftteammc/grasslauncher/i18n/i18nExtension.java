package xyz.mrcraftteammc.grasslauncher.i18n;

import xyz.mrcraftteammc.grasslauncher.extension.Extension;
import xyz.mrcraftteammc.grasslauncher.extension.annotations.ExtensionInstance;
import xyz.mrcraftteammc.grasslauncher.extension.exception.ExtensionException;

@ExtensionInstance
public class i18nExtension extends Extension {
    public i18nExtension() {
        super("grasslauncher");
    }

    @Override
    public void onLoad() throws ExtensionException {
        this.getLogger().info("Hello i18nExtension!");
    }

    @Override
    public void onEnabled() throws ExtensionException {
        super.onEnabled();
    }

    @Override
    public void onDisabled() throws ExtensionException {
        super.onDisabled();
    }
}
