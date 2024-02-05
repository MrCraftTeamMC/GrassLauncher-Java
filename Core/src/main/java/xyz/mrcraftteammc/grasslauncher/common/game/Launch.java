package xyz.mrcraftteammc.grasslauncher.common.game;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import xyz.mrcraftteammc.grasslauncher.common.GrassLauncher;
import xyz.mrcraftteammc.grasslauncher.common.core.ProcessCallBack;
import xyz.mrcraftteammc.grasslauncher.common.core.Container;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * Pre-parse args and runClient minecraft.
 * @author Mr_limr267
 * @since 1.0.0-SNAPSHOT
 */
// TODO: Fix SoundSystem
public class Launch {
    private static final String prefix = " (MC) ";
    private static final boolean WINDOWS = System.getProperty("os.name").toLowerCase(Locale.ROOT).contains("win");

    public static ProcessCallBack runClient(Container<ClientLaunchArgs> args) {
        // fix `\\` -> `/`
        String cmd = (WINDOWS ? args.getOrThrow().mergeArgs() : args.getOrThrow().mergeArgs().replaceAll("\\\\", "/"));

        GrassLauncher.LOGGER.info("Launch Args:");
        GrassLauncher.LOGGER.info(cmd);

         try {
             Process exec = Runtime.getRuntime().exec(cmd);
             synchronized (exec) {
                 BufferedReader br = new BufferedReader(new InputStreamReader(exec.getInputStream()));

                 String line;
                 while ((line = br.readLine()) != null) {
                     GrassLauncher.LOGGER.info(getLogs(line));
                 }
             }

             GrassLauncher.LOGGER.info("Minecraft has been launched!");

            return new ProcessCallBack(exec.exitValue());
         } catch (NullPointerException | IOException e) {
             GrassLauncher.LOGGER.error(e.getLocalizedMessage());
             return new ProcessCallBack(-10000);
         }

//        return new ProcessCallBack(-10000);
    }

    public static ProcessCallBack runServer(Container<ServerLaunchArgs> args) {
        // fix `\\` -> `/`
        String cmd = (WINDOWS ? args.getOrThrow().mergeArgs() : args.getOrThrow().mergeArgs().replaceAll("\\\\", "/"));

        GrassLauncher.LOGGER.info("Launch Args:");
        GrassLauncher.LOGGER.info(cmd);

        try {
            Process exec = Runtime.getRuntime().exec(cmd);
            synchronized (exec) {
                BufferedReader br = new BufferedReader(new InputStreamReader(exec.getInputStream()));

                String line;
                while ((line = br.readLine()) != null) {
                    GrassLauncher.LOGGER.info(getLogs(line));
                }
            }

            GrassLauncher.LOGGER.info("Minecraft has been launched!");

            return new ProcessCallBack(exec.exitValue());
        } catch (NullPointerException | IOException e) {
            GrassLauncher.LOGGER.error(e.getLocalizedMessage());
            return new ProcessCallBack(-10000);
        }

//        return new ProcessCallBack(-10000);
    }

    @Contract(pure = true)
    @NotNull
    private static String getLogs(String msg) {
        return prefix + msg;
    }
}
