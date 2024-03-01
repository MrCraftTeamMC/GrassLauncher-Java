package xyz.mrcraftteammc.grasslauncher.extension.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExtensionEnvironment {
    DEV("dev"),

    NORMAL("normal");

    private final String env;

    public static ExtensionEnvironment getByName(String id) {
        if (DEV.getEnv().equalsIgnoreCase(id)) {
            return ExtensionEnvironment.DEV;
        } else {
            return ExtensionEnvironment.NORMAL;
        }
    }
}
