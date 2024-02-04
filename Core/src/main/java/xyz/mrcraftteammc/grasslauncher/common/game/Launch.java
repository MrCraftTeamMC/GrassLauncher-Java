package xyz.mrcraftteammc.grasslauncher.common.game;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import xyz.mrcraftteammc.grasslauncher.common.GrassLauncher;
import xyz.mrcraftteammc.grasslauncher.common.core.ProcessCallBack;
import xyz.mrcraftteammc.grasslauncher.common.core.Container;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Pre-parse args and run minecraft.
 * @author Mr_limr267
 * @since 1.0.0-SNAPSHOT
 */
public class Launch {
    private static final String prefix = " (MC) ";

    public static ProcessCallBack run(Container<LaunchArgs> args) {
        String cmd = args.getOrThrow().mergeArgs();
         try {
             Process exec = Runtime.getRuntime().exec(cmd);
             GrassLauncher.LOGGER.info("Minecraft has been launched!");

             BufferedReader br = new BufferedReader(new InputStreamReader(exec.getInputStream()));

             String line;
            while ((line = br.readLine()) != null) {
                GrassLauncher.LOGGER.info(getLogs(line));
            }

            return new ProcessCallBack(exec.exitValue());
         } catch (IOException e) {
             GrassLauncher.LOGGER.error(e.getLocalizedMessage());
             return new ProcessCallBack(-10000);
         }
    }

    @Contract(pure = true)
    @NotNull
    private static String getLogs(String msg) {
        return prefix + msg;
    }
}
