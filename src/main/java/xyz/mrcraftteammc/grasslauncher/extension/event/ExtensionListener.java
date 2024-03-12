package xyz.mrcraftteammc.grasslauncher.extension.event;

import xyz.mrcraftteammc.grasslauncher.extension.exception.ExtensionException;

public interface ExtensionListener extends LifeCycleEvent {
    @Override
    void onLoad() throws ExtensionException;

    void onEnabled() throws ExtensionException;

    void onDisabled() throws ExtensionException;
}
