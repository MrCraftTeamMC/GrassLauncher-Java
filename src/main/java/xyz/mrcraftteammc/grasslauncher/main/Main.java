package xyz.mrcraftteammc.grasslauncher.main;

import com.llamalad7.mixinextras.MixinExtrasBootstrap;
import org.spongepowered.asm.launch.MixinBootstrap;
import xyz.mrcraftteammc.grasslauncher.common.GrassLauncher;
import xyz.mrcraftteammc.grasslauncher.extension.ExtensionLoader;

public class Main {
    public static void main(String[] args) {
        MixinBootstrap.init();
        MixinExtrasBootstrap.init();

        ExtensionLoader loader;
        try {
            loader = new ExtensionLoader();
        } catch (Exception e) {
            loader = null;

            GrassLauncher.LOG_EXCEPTION.accept(e);
        }

        GrassLauncher.LOGGER.info("Hello GrassLauncher!");

        System.err.println("No Args!");

        if (loader != null) {
            loader.loadExtensions();
        }
    }
}
