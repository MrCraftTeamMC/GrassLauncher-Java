package xyz.mrcraftteammc.grasslauncher.common.game;

import xyz.mrcraftteammc.grasslauncher.common.GrassLauncher;
import xyz.mrcraftteammc.grasslauncher.common.core.ProcessCallBack;
import xyz.mrcraftteammc.grasslauncher.common.core.Container;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Pre-parse args and runClient minecraft.
 * @author Mr_limr267
 * @since 1.0.0-SNAPSHOT
 */
// TODO: Fix SoundSystem
public class Launch {
    private static final String prefix = " (MC) ";
    private static final boolean WINDOWS = System.getProperty("os.name").toLowerCase(Locale.ROOT).contains("win");

    public static Container<ProcessCallBack> run(Container<? extends LaunchArgs> args) {
        // fix `\\` -> `/`
        String cmd = (WINDOWS ? args.getOrThrow().mergeArgs() : args.getOrThrow().mergeArgs().replaceAll("\\\\", "/"));
        String side = args.getOrThrow().getSide().getId();

        GrassLauncher.LOGGER.info("Launch Args:");
        GrassLauncher.LOGGER.info(cmd);

//        CompletableFuture<Void> thread = CompletableFuture.runAsync(() -> {
//            try {
//                exec.set(Runtime.getRuntime().exec(cmd));
//                BufferedReader br = new BufferedReader(new InputStreamReader(exec.get().getInputStream()));
//
//                String line;
//                while ((line = br.readLine()) != null) {
//                    GrassLauncher.LOGGER.info(getLogs(line));
//                }
//            } catch (IOException e) {
//                GrassLauncher.logThrowable(e);
//            }
//        });

        GrassLauncher.LOGGER.info("Minecraft has been launched!");

        try {
            Process exec = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(exec.getInputStream()));

            String line;
            while ((line = br.readLine()) != null) {
                GrassLauncher.LOGGER.info(getLogs(line));
            }

            return Container.of(new ProcessCallBack(exec.exitValue()));
        } catch (IOException e) {
            GrassLauncher.logThrowable(e);

            return Container.of(new ProcessCallBack(-10000));
        }
//        return new ProcessCallBack(-10000);
    }

    private static String getLogs(String msg) {
        return prefix + msg;
    }
}
