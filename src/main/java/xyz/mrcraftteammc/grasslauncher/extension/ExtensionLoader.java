package xyz.mrcraftteammc.grasslauncher.extension;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.mrcraftteammc.grasslauncher.common.CommonConstants;
import xyz.mrcraftteammc.grasslauncher.extension.exception.ExtensionException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// TODO: Complete Loader
public final class ExtensionLoader {
    private final Logger logger = LoggerFactory.getLogger("GrassLauncher Extension Loader");
    private final File file = new File(CommonConstants.EXTENSIONS_DIR);
    private final ObjectMapper mapper = new JsonMapper();
    private final List<Extension> extensionList;

    public ExtensionLoader() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.extensionList = this.getExtensions();
    }

    public List<Extension> getExtensions() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (!file.exists()) throw new IOException("The extension path does not exist.");

        if (!file.isDirectory()) throw new IOException("The extension path is not a directory.");

        List<Extension> extensions = new ArrayList<>();

        for (File f : Objects.requireNonNull(file.listFiles())) {
            if (f.getName().endsWith(".jar")) {
                URLClassLoader loader = new URLClassLoader(new URL[]{f.toURI().toURL()}, Thread.currentThread().getContextClassLoader());

                InputStream is = loader.getResourceAsStream("grasslauncher.extension.yml");

                ExtensionManifest manifest = mapper.readValue(is, ExtensionManifest.class);
                List<String> mainClasses = manifest.getMainClasses();

                for (String clazz : mainClasses) {
                    Class<?> cls = loader.loadClass(clazz);

                    Object o = cls.newInstance();
                    if (o instanceof Extension) {
                        if (Objects.equals(((Extension) o).getId(), manifest.getId())) {
                            extensions.add((Extension) o);
                        } else {
                            throw new ExtensionException(String.format("An error occurred in loading Plugin `%s` : The id in the extension constructor is not same as the manifest file!", manifest.getId()));
                        }
                    }
                }

                if (is != null) {
                    is.close();
                }
                loader.close();
            }
        }

        return extensions;
    }

    public void loadExtensions() {
        logger.info("Loading Extensions...");

        this.extensionList.forEach(Extension::onLoad);
    }

    public void enableExtensions() {
        this.extensionList.forEach(Extension::onEnabled);
    }

    public void disableExtensions() {
        logger.info("Disabling Extensions...");

        this.extensionList.forEach(Extension::onDisabled);
    }
}
