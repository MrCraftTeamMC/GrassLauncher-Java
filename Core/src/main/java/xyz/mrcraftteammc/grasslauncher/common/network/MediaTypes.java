package xyz.mrcraftteammc.grasslauncher.common.network;

import lombok.Getter;
import okhttp3.MediaType;

@Getter
public enum MediaTypes {
    ;


    private final MediaType mediaType;

    MediaTypes(String str) {
        this.mediaType = MediaType.parse(str);
    }
}
