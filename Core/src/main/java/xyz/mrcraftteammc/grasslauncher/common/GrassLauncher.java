package xyz.mrcraftteammc.grasslauncher.common;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.mrcraftteammc.grasslauncher.common.annotations.NotRunnable;
import xyz.mrcraftteammc.grasslauncher.common.annotations.TestOnly;
import xyz.mrcraftteammc.grasslauncher.common.core.Container;
import xyz.mrcraftteammc.grasslauncher.common.game.Launch;
import xyz.mrcraftteammc.grasslauncher.common.game.ClientLaunchArgs;
import xyz.mrcraftteammc.grasslauncher.common.game.ServerLaunchArgs;
import xyz.mrcraftteammc.grasslauncher.common.ui.GrassLauncherUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

    @TestOnly
    public static void main(String[] args, Side side) {
        try {
            LOGGER.info("{} is loading at {} side... Version: {}", NAME, side.getId(), VERSION);
            LOGGER.info("Runs on: \n{}", JVM_VERSION);

//            Launch.runClient(new Container.SimpleContainer<>(new ClientLaunchArgs(
//                    "-",
//                    "-Xmx2048m -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -Djava.rmi.server.useCodebaseOnly=true -Dcom.sun.jndi.rmi.object.trustURLCodebase=false -Dcom.sun.jndi.cosnaming.object.trustURLCodebase=false -Dlog4j2.formatMsgNoLookups=true -Dlog4j.configurationFile=D:\\- -XX:+UnlockExperimentalVMOptions -XX:+UseG1GC -XX:G1NewSizePercent=20 -XX:G1ReservePercent=20 -XX:MaxGCPauseMillis=50 -XX:G1HeapRegionSize=32m -XX:-UseAdaptiveSizePolicy -XX:-OmitStackTraceInFastThrow -XX:-DontCompileHugeMethods",
//                    "-",
//                    "-",
//                    "net.minecraft.client.main.Main",
//                    "-",
//                    "D:\\-",
//                    "D:\\-",
//                    "1.8",
//                    "-",
//                    "-",
//                    ClientLaunchArgs.UserType.MICROSOFT,
//                    854,
//                    480
//            )));

//            Launch.runServer(new Container.SimpleContainer<>(new ServerLaunchArgs(
//                    "D:\\java\\zulu8.72.0.17-ca-fx-jre8.0.382-win_x64\\bin\\java.exe",
//                    "-Xmx1024M",
//                    "D:\\Github\\GrassLauncher\\run\\server\\server_1.8.9.jar",
//                    true
//            )));

//            GrassLauncherUI.onStartup();
        } catch (Throwable t) {
            logThrowable(t);
        }
    }

    public List<String> parseArgs(String[] args) {
        return new ArrayList<>();
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

    @Getter
    public enum Side {
        CLIENT("client"),
        SERVER("server");

        private final String id;

        Side(String id) {
            this.id = id;
        }
    }
}
