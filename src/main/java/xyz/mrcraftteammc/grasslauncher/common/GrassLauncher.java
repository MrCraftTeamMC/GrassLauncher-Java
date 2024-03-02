package xyz.mrcraftteammc.grasslauncher.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.mrcraftteammc.grasslauncher.common.annotation.NotRunnable;
import xyz.mrcraftteammc.grasslauncher.common.annotation.TestOnly;
import xyz.mrcraftteammc.grasslauncher.common.base.Side;
//import xyz.mrcraftteammc.grasslauncher.common.game.Launch;
//import xyz.mrcraftteammc.grasslauncher.common.game.ServerLaunchArgs;
//import xyz.mrcraftteammc.grasslauncher.common.ui.GrassLauncherUI;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * The Main Class of GrassLauncher
 * @author Mr_limr267
 * @version 1.0.0-SNAPSHOT
*/
@NotRunnable
public class GrassLauncher {
    public static final String NAME = "GrassLauncher";
    public static final String VERSION = "1.0.0-SNAPSHOT";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
    public static final String JVM_VERSION = System.getProperty("java.version");
    public static final Consumer<Throwable> LOG_EXCEPTION = t -> {
        LOGGER.error("Exception occurred: " + t.getMessage());
        t.printStackTrace();
    };

    @TestOnly
    public static void main(String[] args, Side side) {
        try {
            LOGGER.info("{} is loading at {} side... Version: {}", NAME, side.getId(), VERSION);
            LOGGER.info("Runs on: \n{}", JVM_VERSION);
        } catch (Throwable t) {
            LOG_EXCEPTION.  accept(t);
        }
    }

    public List<String> parseArgs(String[] args) {
        return new ArrayList<>();
    }

    @Deprecated
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

    public GrassLauncher() {
    }
}
