package xyz.mrcraftteammc.grasslauncher.common.network;

import lombok.Getter;

@Deprecated
@Getter
public final class Form {
    private final String name;
    private final String value;

    public Form(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
