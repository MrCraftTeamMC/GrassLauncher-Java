package xyz.mrcraftteammc.grasslauncher.i18n.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExtendedLocale {
    ZH_CN("zh", "cn"),
    ZH_TW("zh", "tw"),

    EN_US("en", "us"),
    EN_UK("en", "uk"),

    RU_RU("ru", "ru"),

    FR_FR("fr", "fr"),

    DE_DE("de", "de");

    private final String language;
    private final String country;
    private final char split_char = '_';
}
