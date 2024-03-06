package xyz.mrcraftteammc.grasslauncher.extension;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.mrcraftteammc.grasslauncher.common.GrassLauncher;
import xyz.mrcraftteammc.grasslauncher.extension.exception.ExtensionException;

@Getter
@AllArgsConstructor
public abstract class Extension {
    private final ExtensionManifest manifest;

    public abstract void onLoad() throws ExtensionException;

    public void onEnabled() throws ExtensionException {
    }

    public void onDisabled() throws ExtensionException {
    }

    public Logger getLogger() {
        return LoggerFactory.getLogger(String.format("GrassLauncher Extension | %s", this.manifest.getId()));
    }

    public GrassLauncher getLauncherInstance() {
        return new GrassLauncher();
    }
}
