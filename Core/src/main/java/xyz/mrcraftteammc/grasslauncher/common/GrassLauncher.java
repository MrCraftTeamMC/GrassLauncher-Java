package xyz.mrcraftteammc.grasslauncher.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.mrcraftteammc.grasslauncher.common.annotations.TestOnly;
import xyz.mrcraftteammc.grasslauncher.common.game.Launch;
import xyz.mrcraftteammc.grasslauncher.common.game.LaunchArgs;
import xyz.mrcraftteammc.grasslauncher.common.ui.GrassLauncherUI;

/**
 * The Main Class of GrassLauncher
 * @author Mr_limr267
 * @version 1.0.0-SNAPSHOT
*/
public class GrassLauncher {
    public static final String NAME = "GrassLauncher";
    public static final String VERSION = "1.0.0-SNAPSHOT";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    @TestOnly
    private static final LaunchArgs args = new LaunchArgs.ArgsBuilder()
//            .javaPath()
            .build();

    public static void main(String[] args) {
        try {
            LOGGER.info("{} is loading... Version: {}", NAME, VERSION);
            Launch.run(null);
            GrassLauncherUI.onStartup();
        } catch (Throwable t) {
            logThrowable(t);
        }
    }

    public static void logThrowable(Throwable t) {
        StringBuilder err = new StringBuilder();

        err.append(t.getLocalizedMessage()).append("\n");

        err.append("Stack Trace: ").append("\n");
        for (StackTraceElement trace : t.getStackTrace()) {
            err.append("at ").append(trace.toString()).append("\n");
        }

        err.append("Suppressed: ").append("\n");
        for (Throwable t1: t.getSuppressed()) {
            err.append(t1.getLocalizedMessage()).append("\n");

            for (StackTraceElement trace : t1.getStackTrace()) {
                err.append("at ").append(trace.toString()).append("\n");
            }
        }

//        err.append("Caused by: ").append("\n");
//        err.append(t.getCause().getLocalizedMessage()).append("\n");

        LOGGER.error(err.toString());
    }
}
