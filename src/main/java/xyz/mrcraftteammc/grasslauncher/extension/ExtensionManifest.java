package xyz.mrcraftteammc.grasslauncher.extension;

import lombok.*;
import org.jetbrains.annotations.ApiStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ApiStatus.NonExtendable
public final class ExtensionManifest {
    private String id;
    private String name;
    private String version;
    private String description;

    public static ExtensionManifest defaultManifest() {
        return new ExtensionManifest("example", "Example Extension", "1.0.0", "This is an example extension.");
    }
}
