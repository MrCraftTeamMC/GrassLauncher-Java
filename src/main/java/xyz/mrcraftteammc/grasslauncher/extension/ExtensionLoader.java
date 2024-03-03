package xyz.mrcraftteammc.grasslauncher.extension;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.mrcraftteammc.grasslauncher.common.CommonConstants;
import xyz.mrcraftteammc.grasslauncher.common.DefaultExtension;
import xyz.mrcraftteammc.grasslauncher.extension.annotations.ExtensionInstance;
import xyz.mrcraftteammc.grasslauncher.i18n.i18nExtension;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

// TODO: Complete Loader
public final class ExtensionLoader {
    private final Logger logger = LoggerFactory.getLogger("GrassLauncher Extension Loader");
    private final File file = new File(CommonConstants.EXTENSIONS_DIR);
    private final YAMLMapper mapper = new YAMLMapper();
    private final List<Extension> extensionList;

    public ExtensionLoader() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.extensionList = this.getExtensions();
    }

    public List<Extension> getExtensions() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (!file.exists()) throw new IOException("The extension path does not exist.");

        if (!file.isDirectory()) throw new IOException("The extension path is not a directory.");

        List<File> files = new ArrayList<>();
        List<Extension> extensions = new ArrayList<>();

        extensions.add(new DefaultExtension());
        extensions.add(new i18nExtension());

        for (File f : Objects.requireNonNull(file.listFiles())) {
            if (f.getName().endsWith(".jar")) {
                files.add(f);
            }
        }

        for (File f : files) {
            try (JarFile jar = new JarFile(f)) {
                Enumeration<JarEntry> entries = jar.entries();

                while (entries.hasMoreElements()) {
                    JarEntry entry = entries.nextElement();

                    if (entry.isDirectory() || !entry.getName().endsWith(".class")) {
                        continue;
                    }
                    String clz = entry.getName()
                            .substring(0, entry.getName().length() - 6)
                            .replace('/', '.');
                    URLClassLoader loader =  new URLClassLoader(new URL[]{f.toURI().toURL()},
                            Thread.currentThread().getContextClassLoader());
                    Class<?> clazz = loader.loadClass(clz);

                    if (clazz.getAnnotation(ExtensionInstance.class) != null) {
                        Object o = clazz.newInstance();

                        if (o instanceof Extension) {
                            extensions.add((Extension) o);
                        }
                    }
                }
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
