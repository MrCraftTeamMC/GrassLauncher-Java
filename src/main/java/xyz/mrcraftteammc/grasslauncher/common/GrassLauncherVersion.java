package xyz.mrcraftteammc.grasslauncher.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GrassLauncherVersion {
    VERSION_1_0_0("1.0.0");

    private final String version;

    public static GrassLauncherVersion getLatest() {
        return VERSION_1_0_0;
    }
}
