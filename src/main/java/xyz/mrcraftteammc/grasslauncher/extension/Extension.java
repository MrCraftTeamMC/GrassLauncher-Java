package xyz.mrcraftteammc.grasslauncher.extension;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.mrcraftteammc.grasslauncher.common.GrassLauncher;
import xyz.mrcraftteammc.grasslauncher.extension.event.ExtensionListener;
import xyz.mrcraftteammc.grasslauncher.extension.exception.ExtensionException;

@ToString
@Getter
@AllArgsConstructor
public abstract class Extension implements ExtensionListener {
    private final ExtensionManifest manifest;

    @Override
    public abstract void onLoad() throws ExtensionException;

    @Override
    public void onEnabled() throws ExtensionException {
    }

    @Override
    public void onDisabled() throws ExtensionException {
    }

    public void onReload() throws ExtensionException {
    }

    public Logger getLogger() {
        return LoggerFactory.getLogger(String.format("GrassLauncher Extension | %s", this.manifest.getId()));
    }

    public GrassLauncher getLauncherInstance() {
        return new GrassLauncher();
    }
}
