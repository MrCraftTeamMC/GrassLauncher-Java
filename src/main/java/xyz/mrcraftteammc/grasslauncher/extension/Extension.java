package xyz.mrcraftteammc.grasslauncher.extension;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.mrcraftteammc.grasslauncher.extension.exception.ExtensionLoadingException;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class Extension {
    protected static final List<Extension> extensionList = new ArrayList<>();

    private final String id;
    private final String name;
    private final String version;
    private final String description;
    private final Class<?> mainClass; // By default, this will be `<Extension Class>.class`

    private final Logger logger;

    public Extension(String id, String name, String version, String description, Class<?> mainClass) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.description = description;
        this.mainClass = mainClass;

        this.logger = LoggerFactory.getLogger(String.format("GrassLauncher-Plugin | %s", name));

        extensionList.add(this);
    }

    public abstract void onLoaded() throws ExtensionLoadingException;

    public abstract void onEnabled() throws ExtensionLoadingException;

    public abstract void onDisabled() throws ExtensionLoadingException;
}
