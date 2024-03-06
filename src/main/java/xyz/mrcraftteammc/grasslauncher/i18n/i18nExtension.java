package xyz.mrcraftteammc.grasslauncher.i18n;

import okhttp3.OkHttpClient;
import xyz.mrcraftteammc.grasslauncher.extension.Extension;
import xyz.mrcraftteammc.grasslauncher.extension.ExtensionManifest;
import xyz.mrcraftteammc.grasslauncher.extension.annotations.ExtensionInstance;
import xyz.mrcraftteammc.grasslauncher.extension.exception.ExtensionException;

@ExtensionInstance
public class i18nExtension extends Extension {
    private final OkHttpClient client = new OkHttpClient();
    private final String url = "https://github.com/MrCraftTeamMC/GrassLauncher.i18n";
    private final Text text = Text.translatable();

    public i18nExtension() {
        super(ExtensionManifest.defaultManifest());
    }

    @Override
    public void onLoad() throws ExtensionException {
        this.getLogger().info("Loading Language files...");

        try {
            this.getLogger().info(this.text.getText("helloworld"));
        } catch (Exception e) {
            this.getLogger().warn("Fail to get Language. Cause: ", e);
        }
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
