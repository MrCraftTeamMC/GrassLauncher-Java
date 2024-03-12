package xyz.mrcraftteammc.grasslauncher.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class Configuration {
    // base info
    private String version;

    // i18n
    private String language;
    private String country;
}
