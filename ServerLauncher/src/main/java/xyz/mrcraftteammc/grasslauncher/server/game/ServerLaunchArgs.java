package xyz.mrcraftteammc.grasslauncher.server.game;

import lombok.Getter;
import xyz.mrcraftteammc.grasslauncher.common.base.Side;
import xyz.mrcraftteammc.grasslauncher.common.game.LaunchArgs;

@Getter
public class ServerLaunchArgs extends LaunchArgs {
    private final String javaPath;
    private final String jvmArgs;
    private final String jarName;
    private final boolean nogui;

    public ServerLaunchArgs(String javaPath, String jvmArgs, String jarName, boolean nogui) {
        super(Side.SERVER);

        this.javaPath = javaPath;
        this.jvmArgs = jvmArgs;
        this.jarName = jarName;
        this.nogui = nogui;
    }

    @Override
    public String mergeArgs() {
        return String.format("%s\\bin\\java.exe %s -jar %s",
                this.javaPath, this.jvmArgs, this.jarName) + (this.nogui ? " nogui" : "");
    }
}
