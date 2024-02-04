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

    private LaunchArgs(String javaPath, String jvmArgs, String setupArgs, String natives, String classpath,
                       String mainClass, String username, String gameDir, String assetsDir, String assetIndex,
                       String uuid, String accessToken, String userProperties, UserType userType,
                       int width, int height) {
        this.javaPath = javaPath;
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

    public static final class ArgsBuilder implements Builder<LaunchArgs> {
        private String javaPath;
        private String jvmArgs;
        private String setupArgs;
        private String natives;
        private String classpath;
        private String mainClass;
        private String username;
        private String gameDir;
        private String assetsDir;
        private String assetIndex;
        private String uuid;
        private String accessToken;
        private String userProperties;
        private UserType userType;
        private int width;
        private int height;

        public ArgsBuilder() {
        }

        public ArgsBuilder javaPath(String javaPath) {
            this.javaPath = javaPath.isEmpty() ? System.getenv("java.home") : javaPath ;
            return this;
        }

        public ArgsBuilder jvmArgs(String jvmArgs) {
            this.jvmArgs = jvmArgs;
            return this;
        }

        public ArgsBuilder setupArgs(String setupArgs) {
            this.setupArgs = setupArgs;
            return this;
        }

        public ArgsBuilder natives(String natives) {
            this.natives = natives;
            return this;
        }

        public ArgsBuilder classpath(String classpath) {
            this.classpath = classpath;
            return this;
        }

        public ArgsBuilder mainClass(String mainClass) {
            this.mainClass = mainClass;
            return this;
        }

        public ArgsBuilder username(String username) {
            this.username = username;
            return this;
        }

        public ArgsBuilder gameDir(String gameDir) {
            this.gameDir = gameDir;
            return this;
        }

        public ArgsBuilder assetsDir(String assetsDir) {
            this.assetsDir = assetsDir;
            return this;
        }

        public ArgsBuilder assetIndex(String assetIndex) {
            this.assetIndex = assetIndex;
            return this;
        }

        public ArgsBuilder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public ArgsBuilder accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public ArgsBuilder userProperties(String userProperties) {
            this.userProperties = userProperties;
            return this;
        }

        public ArgsBuilder userType(UserType userType) {
            this.userType = userType;
            return this;
        }

        public ArgsBuilder width(int width) {
            this.width = width;
            return this;
        }

        public ArgsBuilder height(int height) {
            this.height = height;
            return this;
        }

        @Override
        public LaunchArgs build() {
            return new LaunchArgs(this.javaPath, this.jvmArgs, this.setupArgs, this.natives, this.classpath, this.mainClass, this.username, this.gameDir, this.assetsDir, this.assetIndex, this.uuid, this.accessToken, this.userProperties, this.userType, this.width, this.height);
        }

        @Override
        @Deprecated
        public LaunchArgs build(Object... objects) {
            return null;
        }
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
