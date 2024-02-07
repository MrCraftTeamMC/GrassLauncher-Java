package xyz.mrcraftteammc.grasslauncher.common.game;

import lombok.Getter;
import xyz.mrcraftteammc.grasslauncher.common.base.Side;

@Getter
public abstract class LaunchArgs {
    private final Side side;

    public LaunchArgs(Side side) {
        this.side = side;
    }

    public abstract String mergeArgs();

    @Getter
    enum UserType {
        OFFLINE(""),
        MOJANG(""),
        MICROSOFT("msa");

        private final String id;

        UserType(String id) {
            this.id = id;
        }
    }
}
