package xyz.mrcraftteammc.grasslauncher.extension.base;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ExtensionState {
    DISABLED("Disabled"),

    LOADED("Loaded"),

    ENABLED("Enabled");

    private final String id;
}
