package xyz.mrcraftteammc.grasslauncher.i18n;

import okhttp3.OkHttpClient;
import xyz.mrcraftteammc.grasslauncher.extension.Extension;
import xyz.mrcraftteammc.grasslauncher.extension.ExtensionManifest;
import xyz.mrcraftteammc.grasslauncher.extension.annotations.ExtensionInstance;
import xyz.mrcraftteammc.grasslauncher.extension.exception.ExtensionException;

import java.util.Locale;

@ExtensionInstance
public class i18nExtension extends Extension {
    private final OkHttpClient client = new OkHttpClient();
    private final String url = "https://github.com/MrCraftTeamMC/GrassLauncher.i18n";
    private final Locale locale = Locale.getDefault();  // Now support Russian, English. ZH_CN. ZH_TW

    public i18nExtension() {
        super(ExtensionManifest.defaultManifest());
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
