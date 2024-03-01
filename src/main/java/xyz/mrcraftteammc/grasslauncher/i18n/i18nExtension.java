package xyz.mrcraftteammc.grasslauncher.i18n;

import xyz.mrcraftteammc.grasslauncher.common.CommonConstants;
import xyz.mrcraftteammc.grasslauncher.extension.Extension;
import xyz.mrcraftteammc.grasslauncher.extension.exception.ExtensionLoadingException;

public class i18nExtension extends Extension {
    public i18nExtension() {
        super("i18n",
                "i18nExtension",
                CommonConstants.VERSION,
                "The Lauguage provider plugin of GrassLauncher.",
                i18nExtension.class);
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
