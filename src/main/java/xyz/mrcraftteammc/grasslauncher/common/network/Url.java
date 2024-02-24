package xyz.mrcraftteammc.grasslauncher.common.network;

import lombok.Getter;

@Deprecated
@Getter
public final class Url {
    private final String url;

    public Url(String url) {
        this.url = url;
    }
}
