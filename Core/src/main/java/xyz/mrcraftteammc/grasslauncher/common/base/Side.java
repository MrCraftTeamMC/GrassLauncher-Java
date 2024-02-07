package xyz.mrcraftteammc.grasslauncher.common.base;

import lombok.Getter;

@Getter
public enum Side {
    CLIENT("client"),
    SERVER("server");

    private final String id;

    Side(String id) {
        this.id = id;
    }
}