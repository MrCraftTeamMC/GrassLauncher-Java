package xyz.mrcraftteammc.grasslauncher.common;

import org.slf4j.Logger;
import xyz.mrcraftteammc.grasslauncher.extension.Extension;
import xyz.mrcraftteammc.grasslauncher.extension.ExtensionManifest;
import xyz.mrcraftteammc.grasslauncher.extension.annotations.ExtensionInstance;
import xyz.mrcraftteammc.grasslauncher.extension.exception.ExtensionException;
import xyz.mrcraftteammc.grasslauncher.common.core.Text;
import xyz.mrcraftteammc.grasslauncher.main.Main;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

@ExtensionInstance
public class DefaultExtension extends Extension {
    private final Logger logger = super.getLogger();
    private final Text text = Text.translatable();

    public DefaultExtension() {
        super(ExtensionManifest.defaultManifest());
    }

    @Override
    public void onLoad() throws ExtensionException {

    }

    @Override
    public void onEnabled() throws ExtensionException {
        super.onEnabled();
    }

    @Override
    public void onDisabled() throws ExtensionException {
        super.onDisabled();
    }

    public String exportConfiguration() throws URISyntaxException, IOException {
        String jarFolder = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParentFile().getPath().replace('\\', '/');
        InputStream is = Main.class.getResourceAsStream("/config.yml");
        OutputStream os = Files.newOutputStream(Paths.get(jarFolder + "/config.yml"));

        byte[] buf = new byte[4096];
        int readbytes;

        while ((readbytes = Objects.requireNonNull(is).read(buf)) > 0) {
            os.write(buf, 0, readbytes);
        }

        is.close();
        os.close();

        return jarFolder + "/config.yml";
    }
}
