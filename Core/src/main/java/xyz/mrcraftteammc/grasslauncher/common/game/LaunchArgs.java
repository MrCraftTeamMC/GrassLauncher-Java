package xyz.mrcraftteammc.grasslauncher.common.game;

import lombok.Getter;
import xyz.mrcraftteammc.grasslauncher.common.GrassLauncher;
import xyz.mrcraftteammc.grasslauncher.common.core.Builder;

@SuppressWarnings("unused")
@Getter
public class LaunchArgs {
    private final String javaPath; // ${javaPath}/bin/java.exe
    private final String jvmArgs;  // -XX:XX
    private final String setupArgs; // -D:XX
    private final String natives; // -Djava.library.path=XX
    private final String classpath; // -cp XX
    private final String mainClass;
    private final String username;
    private final String gameDir;
    private final String assetsDir;
    private final String assetIndex;
    private final String uuid;
    private final String accessToken;
    private final String userProperties;
    private final UserType userType;
    private final int width;
    private final int height;

    public LaunchArgs(String javaPath, String jvmArgs, String setupArgs, String natives, String classpath,
                       String mainClass, String username, String gameDir, String assetsDir, String assetIndex,
                       String uuid, String accessToken, String userProperties, UserType userType,
                       int width, int height) {
        this.javaPath = (javaPath.isEmpty() ? System.getenv("java.home") : javaPath);
        this.jvmArgs = jvmArgs;
        this.setupArgs = setupArgs;
        this.natives = natives;
        this.classpath = classpath;
        this.mainClass = mainClass;
        this.username = username;
        this.gameDir = gameDir;
        this.assetsDir = assetsDir;
        this.assetIndex = assetIndex;
        this.uuid = uuid;
        this.accessToken = accessToken;
        this.userProperties = userProperties;
        this.userType = userType;
        this.width = width;
        this.height = height;
    }

    public String mergeArgs() {
        String ver = GrassLauncher.NAME + " " + GrassLauncher.VERSION;

        // userProperties -> {}
        // --server tcbuild.xyz
        //--port 25565

        return String.format("%s/bin/java.exe %s %s -Djava.library.path=%s -Dminecraft.launcher.brand=%s -Dminecraft.launcher.version=%s -cp %s %s --username %s --version %s --gameDir %s --assetsDir %s --assetIndex %s --uuid %s --accessToken %s --userProperties %s --userType %s --width %d --height %d",
                this.javaPath, this.jvmArgs, this.setupArgs, this.natives, GrassLauncher.NAME,
                GrassLauncher.VERSION, this.classpath, this.mainClass, this.username, ver, this.gameDir,
                this.assetsDir, this.assetIndex, this.uuid, this.accessToken, this.userProperties,
                this.userType.getId(), this.width, this.height);
    }

    public String mergeArgsWithServer(String address, int port) {
        return String.format("%s --server %s --port %d",
                this.mergeArgs(), address, port);
    }

    @Getter
    public enum UserType {
        OFFLINE(""),
        MOJANG(""),
        MICROSOFT("msa");

        private final String id;

        UserType(String id) {
            this.id = id;
        }
    }
}
