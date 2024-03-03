package xyz.mrcraftteammc.grasslauncher.extension;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiStatus.NonExtendable
public final class ExtensionManifest {
    private String id;
    private String name;
    private String version;
    private String description;
    private List<String> mainClasses;
}
