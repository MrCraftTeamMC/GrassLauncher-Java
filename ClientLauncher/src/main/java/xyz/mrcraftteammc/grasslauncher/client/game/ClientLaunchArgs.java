package xyz.mrcraftteammc.grasslauncher.client.game;

import lombok.Getter;
import xyz.mrcraftteammc.grasslauncher.common.GrassLauncher;
import xyz.mrcraftteammc.grasslauncher.common.base.Side;
import xyz.mrcraftteammc.grasslauncher.common.game.LaunchArgs;

@SuppressWarnings("unused")
@Getter
public class ClientLaunchArgs extends LaunchArgs {
    private final String javaPath; // ${javaPath}/bin/java.exe
    private final String jvmArgs;  // -XX:XX
    private final String natives; // -Djava.library.path=XX
    private final String classpath; // -cp XX
    private final String mainClass;
    private final String username;
    private final String gameDir;
    private final String assetsDir;
    private final String assetIndexFileName;
    private final String uuid;
    private final String accessToken;
    private final UserType userType;
    private final int width;
    private final int height;

    // TODO: Fix SoundSystem
    public ClientLaunchArgs(String javaPath, String jvmArgs, String natives, String classpath,
                            String mainClass, String username, String gameDir, String assetsDir, String assetIndexFileName,
                            String uuid, String accessToken, UserType userType,
                            int width, int height) {
        super(Side.CLIENT);

        this.javaPath = (javaPath.isEmpty() ? System.getenv("java.home") : javaPath);
        this.jvmArgs = jvmArgs;
        this.natives = natives;
        this.classpath = classpath;
        this.mainClass = mainClass;
        this.username = username;
        this.gameDir = gameDir;
        this.assetsDir = assetsDir;
        this.assetIndexFileName = assetIndexFileName;
        this.uuid = uuid;
        this.accessToken = accessToken;
        this.userType = userType;
        this.width = width;
        this.height = height;
    }

    @Override
    public String mergeArgs() {
        String ver = GrassLauncher.NAME + " " + GrassLauncher.VERSION;

        // userProperties -> {}
        // --server tcbuild.xyz
        //--port 25565

        return String.format("%s\\bin\\java.exe %s -Djava.library.path=%s -Dminecraft.launcher.brand=%s -Dminecraft.launcher.version=%s -cp %s %s --username %s --version %s --gameDir %s --assetsDir %s --assetIndexFileName %s --uuid %s --accessToken %s --userProperties {} --userType %s --width %d --height %d",
                this.javaPath, this.jvmArgs, this.natives, GrassLauncher.NAME,
                GrassLauncher.VERSION, this.classpath, this.mainClass, this.username, ver, this.gameDir,
                this.assetsDir, this.assetIndexFileName, this.uuid, this.accessToken, this.userType.getId(),
                this.width, this.height);
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
