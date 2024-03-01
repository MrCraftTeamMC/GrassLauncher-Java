package xyz.mrcraftteammc.grasslauncher.extension;

import xyz.mrcraftteammc.grasslauncher.common.CommonConstants;
import xyz.mrcraftteammc.grasslauncher.common.GrassLauncher;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

// TODO: Complete Loader
public final class ExtensionLoader {
    private URLClassLoader loader;

    public void load() {
        try {
            File file = new File(CommonConstants.EXTENSIONS_DIR);
            File[] files = file.listFiles();
            URL[] urls;

            if (files != null) {
                 urls = new URL[files.length];

                for (int i = 0; i < files.length; i++) {
                    urls[i] = files[i].isDirectory() ? null : files[i].toURI().toURL();
                }

                this.loader = new URLClassLoader(urls);
            }
        } catch (Exception e) {
            GrassLauncher.LOG_EXCEPTION.accept(e);
        }
    }
}
