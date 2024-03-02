package xyz.mrcraftteammc.grasslauncher.extension;

import java.util.List;

// TODO: Complete Loader
public final class ExtensionLoader {
    /*
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
     */

    public List<Class<? extends Extension>> getExtensions() {
        return null;
    }

    public void loadExtensions() {
    }

    public void enableExtensions() {
    }

    public void disableExtensions() {
    }
}
