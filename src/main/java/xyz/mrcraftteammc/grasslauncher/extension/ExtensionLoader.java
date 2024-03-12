package xyz.mrcraftteammc.grasslauncher.extension;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.mrcraftteammc.grasslauncher.common.CommonConstants;
import xyz.mrcraftteammc.grasslauncher.common.DefaultExtension;
import xyz.mrcraftteammc.grasslauncher.extension.annotations.ExtensionInstance;

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
    private static boolean Initialized = false;
    private final Logger logger = LoggerFactory.getLogger("GrassLauncher Extension Loader");
    private final File file = new File(CommonConstants.EXTENSIONS_DIR);
    private final List<Extension> extensionList = new ArrayList<>();
    private final List<ExtensionManifest> extensionManifestList = new ArrayList<>();

    public ExtensionLoader() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (!Initialized) {
            Initialized = true;

            if (!file.exists()) throw new IOException("The extension path does not exist.");
            if (!file.isDirectory()) throw new IOException("The extension path is not a directory.");

            List<File> files = new ArrayList<>();

            this.extensionList.add(new DefaultExtension());

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
                        URLClassLoader loader = new URLClassLoader(new URL[]{f.toURI().toURL()},
                                Thread.currentThread().getContextClassLoader());
                        Class<?> clazz = loader.loadClass(clz);

                        if (clazz.getAnnotation(ExtensionInstance.class) != null) {
                            Object o = clazz.newInstance();

                            if (o instanceof Extension) {
                                extensionList.add((Extension) o);
                                ExtensionManifest manifest = ((Extension) o).getManifest();

                                this.extensionManifestList.add(manifest);
                            }
                        }
                    }
                }
            }
        } else {
            logger.error("Cannot create `ExtensionLoader` instance again!");
        }
    }

    public void loadExtensions() {
        if (this.extensionList.isEmpty()) {
            logger.warn("No Extensions!");
        }

        logger.info("Loading Extensions...");

        this.extensionList.forEach(Extension::onLoad);

        this.extensionManifestList.forEach(System.err::println);
    }

    public void enableExtensions() {
        if (this.extensionList.isEmpty()) {
            logger.warn("No Extensions!");
        }

        this.extensionList.forEach(Extension::onEnabled);
    }

    public void disableExtensions() {
        if (this.extensionList.isEmpty()) {
            logger.warn("No Extensions!");
        }

        logger.info("Disabling Extensions...");

        this.extensionList.forEach(Extension::onDisabled);
    }
}
