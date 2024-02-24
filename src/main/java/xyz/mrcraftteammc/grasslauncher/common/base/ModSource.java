package xyz.mrcraftteammc.grasslauncher.common.base;

import lombok.Getter;

@Getter
public enum ModSource {
    CURSEFORGE,
    MODRINTH,
    REPLAYMOD,
    OPTIFINE,
    GITHUB;

    ModSource() {

    }
}
