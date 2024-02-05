package xyz.mrcraftteammc.grasslauncher.common.game;

import lombok.Getter;

@Getter
public class ServerLaunchArgs {
    private final String javaPath;
    private final String jvmArgs;
    private final String jarName;
    private final boolean nogui;

    public ServerLaunchArgs(String javaPath, String jvmArgs, String jarName, boolean nogui) {
        this.javaPath = javaPath;
        this.jvmArgs = jvmArgs;
        this.jarName = jarName;
        this.nogui = nogui;
    }

    public String mergeArgs() {
        return String.format("%s/bin/java.exe %s -jar %s",
                this.javaPath, this.jvmArgs, this.jarName) + (this.nogui ? "nogui" : "");
    }
}
